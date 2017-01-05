/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var notifyURL = "/comunicacao/notificacao/";
var conteudoURL = "/comunicacao/conteudo/";

new Vue({
    el: "#notificacao",
    data: {
        notificacaoC: {
            id: null,
            ativo: false,
            titulo: null,
            dataInicio: null,
            dataFim: null,
            usuario: null,
            mensagem: null,
            conteudo: {
                id: null
            }
        },
        notificacaoU: {
            id: null,
            ativo: false,
            titulo: null,
            dataInicio: null,
            dataFim: null,
            usuario: null,
            mensagem: null,
            conteudo: {
                id: null,
                titulo: null
            }
        },
        notificacaoE: {
            id: null,
            ativo: false,
            titulo: null,
            dataInicio: null,
            dataFim: null,
            usuario: null,
            mensagem: null,
            conteudo: {
                id: null
            }
        },
        notificacoes: null,
        message: null,
        conteudos: null
    },
    created: function () {
        var self = this;
        self.buscaNotificacao();
        self.buscaConteudo();
    },
    methods: {
        // Formatar data
        dateInput: function (h) {
            return moment(h).format("YYYY-MM-DD");
        },
        dateFormat: function (h) {
            return  moment(h).format('DD/MM/YYYY');
        },
        //Açoes:
        buscaNotificacao: function () {
            var self = this;
            $.get(notifyURL + "listar", function (data) {
                self.notificacoes = data.list;
            });
        },
        buscaConteudo: function () {
            var self = this;
            $.get(conteudoURL + "lista", function (data) {
                self.conteudos = data.list;
            });
        },
        adcNotificacao: function () {
            var self = this;
            $.ajax({
                type: "POST",
                url: notifyURL + "cadastrar",
                data: JSON.stringify(self.notificacaoC),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: function () {
                    self.resetObjects();
                    $("#cadastraNotify").modal("hide");
                    self.buscaNotificacao();
                }
            });
        },
        modNotificacao: function () {
            var self = this;
            $.ajax({
                type: "POST",
                url: notifyURL + "modificar",
                data: JSON.stringify(self.notificacaoU),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: function () {
                    self.resetObjects();
                    $("#updateNotify").modal("hide");
                    self.buscaNotificacao();
                }
            });
        },
        exNotificacao: function () {
            var self = this;
            $.ajax({
                type: "POST",
                url: notifyURL + "excluir",
                data: JSON.stringify(self.notificacaoE),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: function () {
                    self.resetObjects();
                    $("#delNotify").modal("hide");
                    self.buscaNotificacao();
                }
            });
        },
        fetchUpdateNotification: function (h) {
            var self = this;
            self.notificacaoU = h;
            self.notificacaoU.dataInicio = self.dateInput(self.notificacaoU.dataInicio);
            self.notificacaoU.dataFim = self.dateInput(self.notificacaoU.dataFim);
        },
        fetchExcluirNotification: function (h) {
            var self = this;
            self.notificacaoE = h;
        },
        resetObjects: function () {
            var self = this;
            self.notificacaoC = {
                id: null,
                ativo: false,
                titulo: null,
                dataInicio: null,
                dataFim: null,
                usuario: null,
                mensagem: null,
                conteudo: {
                    id: null
                }
            };
            self.notificacaoU = {
                id: null,
                ativo: false,
                titulo: null,
                dataInicio: null,
                dataFim: null,
                usuario: null,
                mensagem: null,
                conteudo: {
                    id: null
                }
            };
            self.notificacaoE = {
                id: null,
                ativo: false,
                titulo: null,
                dataInicio: null,
                dataFim: null,
                usuario: null,
                mensagem: null,
                conteudo: {
                    id: null
                }
            };
        }
    }

});