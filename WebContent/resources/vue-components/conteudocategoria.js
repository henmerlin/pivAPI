/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global xhrObj */

var conteudoURL = "/comunicacao/conteudocategoria/";
new Vue({

    el: '#conteduocategoria',
    data: {

        categorias: null,
        addcategoria: {
            "categoria": {
                "id": null,
                "titulo": null,
                "ativo": false
            }
        },
        modcategoria: {
            "categoria": {
                "id": null,
                "titulo": null,
                "ativo": false
            }
        },
        delcategoria: {
            "categoria": {
                "id": null,
                "titulo": null,
                "ativo": false
            }
        }

    },
    created: function () {

        this.getConteudoCategoria();
        this.resetObjects();

    },
    methods: {

        //Comando lista
        getConteudoCategoria: function () {
            var self = this;
            $.get(conteudoURL + "listar", function (data) {
                self.categorias = data.list;
            });
        },

        //Comando cadastra
        adicionaCategoria: function () {

            var self = this;
            $.ajax({
                type: "POST",
                url: conteudoURL + "cadastrar",
                data: JSON.stringify(self.addcategoria.categoria),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: function () {
                    $('#criaConteudo').modal('hide');
                    self.resetObjects();
                    self.fetchConteudo();
                }
            });
        },

        //Update variaveis
        updateModConteudo: function (h) {
            var self = this;
            self.modcategoria.categoria = h;
        },
        updateDelConteudo: function (h) {
            var self = this;
            self.delcategoria.categoria = h;
        },
        //Comando modifica
        modificaConteudo: function () {
            var self = this;
            $.ajax({
                type: "POST",
                url: conteudoURL + "modificar",
                data: JSON.stringify(self.modcategoria.categoria),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: function () {
                    self.resetObjects();
                    self.fetchConteudo();
                    $('#modConteudo').modal('hide');
                }
            });
        },
        //Comando exclui
        excluiConteudo: function () {
            var self = this;
            $.ajax({
                type: "POST",
                url: conteudoURL + "excluir",
                data: JSON.stringify(self.delcategoria.categoria),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: function () {
                    self.resetObjects();
                    self.fetchConteudo();

                    $('#excluiConteudo').modal('hide');

                }
            });
        },
        //Fetch
        fetchConteudo: function () {
            var self = this;
            setTimeout(function () {

                self.getConteudoCategoria();

            }, 600);
        },
        //Resets
        resetObjects: function () {
            var self = this;
            self.addcategoria = {
                "categoria": {
                    "id": null,
                    "titulo": null,
                    "ativo": false
                }

            };
            self.modcategoria = {
                "categoria": {
                    "id": null,
                    "titulo": null,
                    "ativo": false
                }
            };
            self.delcategoria = {
                "categoria": {
                    "id": null,
                    "titulo": null,
                    "ativo": false
                }
            };
        }
    }
});