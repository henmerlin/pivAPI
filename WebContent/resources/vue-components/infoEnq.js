/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var respEnq = "/comunicacao/respostaEnquete/";

new Vue({

    el: "#enquete",
    //Inicia as variaveis
    data: {
        respostas: null
    },
    //Execulta os metodos ao iniciar
    create: {},
    //Metodos
    methods: {

        //Métodos Get
        buscaRespotas: function (h) {
            var self = this;
            $.get(respEnq + "listaTodos/" + h.id, function (data) {
                self.respostas = data.list;
            });
        }

    }
});