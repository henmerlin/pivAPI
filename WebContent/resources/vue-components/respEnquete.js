/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var enqURL = "/comunicacao/enquete/";
var enqPerguntaURL = "/comunicacao/pergunta/";
var escolhaPerguntaURL = "/comunicacao/escolhapergunta/";
var respostaEnq = "/comunicacao/respostaEnquete/";

new Vue({
    el: '#enquete',
    data: {
        titulo: null,
        enquetes: null,
        perguntasEnquetes: null,
        escolhaPerguntas: [
            {
                id: null,
                ativo: null,
                titulo: null,
                pergunta: {
                    id: null
                }
            }
        ],
        enqresp: [],
        resposta: {
            id: null,
            resposta: null,
            usuario: null,
            pergunta: {
                id: null,
                titulo: null,
                ativo: null,
                tipoPergunta: null,
                enquete: {
                    usuario: null,
                    dataInicio: null,
                    dataFim: null,
                    id: null,
                    titulo: null,
                    ativo: false
                }
            }
        }
    },
    created: function () {
        this.getEnq();
    },
    methods: {
        //Comandos Formatação   
        dateInput: function (h) {
            return moment(h).format("YYYY-MM-DD");
        },
        dateFormat: function (h) {
            return  moment(h).format('DD/MM/YYYY');
        },
        //Comandos Lista
        getEnq: function () {
            var self = this;
            $.get(enqURL + "listar", function (data) {
                self.enquetes = data.list;
            });
        },
        getPerguntasEnquetes: function (h) {
            var self = this;
            $.get(enqPerguntaURL + "lista/" + h.id, function (data) {
                self.perguntasEnquetes = data.list;
                var list = new Array(self.perguntasEnquetes.length);
                for (var i = 0; i < self.perguntasEnquetes.length; i++) {
                    list[i] = {
                        id: null,
                        resposta: null,
                        usuario: null,
                        pergunta: {
                            id: self.perguntasEnquetes[i].id,
                            titulo: self.perguntasEnquetes[i].titulo,
                            ativo: self.perguntasEnquetes[i].ativo,
                            tipoPergunta: self.perguntasEnquetes[i].tipoPergunta,
                            enquete: {h}
                        }
                    };
                    if (self.perguntasEnquetes[i].tipoPergunta === 'Múltipla Escolha') {
                        self.getEscolhaPerguntas(self.perguntasEnquetes[i]);
                    }
                }
                self.enqresp = list;
            });
        },
        getEscolhaPerguntas: function (h) {
            var self = this;
            $.get(escolhaPerguntaURL + "lista/" + h.id, function (data) {
                for (var i = 0; i < data.list.length; i++) {
                    self.escolhaPerguntas.push(data.list[i]);
                }
            });
        },
        //Update resp
        updateResp: function (h) {
            var self = this;
            self.titulo = h.titulo;
            self.getPerguntasEnquetes(h);
        },
        //Salva respostas
        salvaResposta: function () {
            var self = this;
            $.ajax({
                type: "POST",
                url: respostaEnq + "cadastrar",
                data: JSON.stringify(self.enqresp),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: function () {
                    $('#resEnq').modal('hide');
                    self.clear();
                }
            });
        },
        // Limpa variaveis
        clear: function () {
            var self = this;
            self.titulo = null;
            self.perguntasEnquetes = null;
            self.escolhaPerguntas = [
                {
                    id: null,
                    ativo: null,
                    titulo: null,
                    pergunta: {
                        id: null
                    }
                }
            ];
            self.enqresp = [];
        }
    }
});