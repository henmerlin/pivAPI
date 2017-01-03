/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var enqURL = "/comunicacao/enquete/";
var enqPerguntaURL = "/comunicacao/pergunta/";
var respEnq = "/comunicacao/respostaEnquete/";
var escolhaPerguntaURL = "/comunicacao/escolhapergunta/";

new Vue({

    el: "#enquete",
    //Inicia as variaveis
    data: {
        enquete: {
            id: null
        },
        perguntasEnquetes: null,
        escolhasPerguntasInfo: [],
        respostas: [],
        valores: [],
        escolhasInfo: [],
    },
    //Execulta os metodos ao iniciar
    created: function () {
        var self = this;
        self.enquete.id = $("#enq").val();
        self.getPerguntas(self.enquete);
        self.buscaRespotas(self.enquete);
    },
    //Metodos
    methods: {
        buscaRespotas: function (h) {
            var self = this;
            $.get(respEnq + "listaTodos/" + h.id, function (data) {
                self.respostas = data.list;
            });
        },
        getPerguntas: function (h) {
            var self = this;
            $.get(enqPerguntaURL + "lista/" + h.id, function (data) {
                self.perguntasEnquetes = data.list;
                self.contagem = self.perguntasEnquetes.length;
                for (var i = 0; i < self.perguntasEnquetes.length; i++) {
                    if (self.perguntasEnquetes[i].tipoPergunta === 'Múltipla Escolha') {
                        self.getEscolhas(self.perguntasEnquetes[i]);
                    }
                }
                setTimeout(function () {
                    self.uniqValores();
                }, 250);
            });
        },
        getEscolhas: function (h) {
            var self = this;
            $.get(escolhaPerguntaURL + "lista/" + h.id, function (data) {
                for (var i = 0; i < data.list.length; i++) {
                    self.escolhasPerguntasInfo.push(data.list[i]);
                }
            });
        },

        uniqValores: function () {
            var self = this;
            var trimmedArray = [];
            var values = [];
            var value;

            //alert(self.escolhasPerguntasInfo.length)

            for (var i = 0; i < self.escolhasPerguntasInfo.length; i++) {
                value = self.escolhasPerguntasInfo[i]["titulo"];

                if (values.indexOf(value) === -1) {
                    trimmedArray.push(self.escolhasPerguntasInfo[i]);
                    values.push(value);
                }
            }

            var soma = 0;
            for (var i = 0; i < trimmedArray.length; i++) {
                for (var a = 0; a < self.respostas.length; a++) {
                    if (trimmedArray[i].titulo === self.respostas[a].resposta) {
                        soma++;
                    }
                }
                self.valores.push({titulo: trimmedArray[i].titulo, cont: soma, pergunta: trimmedArray[i].pergunta.titulo});
                soma = 0;
            }            
        }
    }
});