/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var conteudoURL = "/comunicacao/conteudo/";
var conteudoCategoriaURL = "/comunicacao/conteudocategoria/";

new Vue({

    el: '#conteudo',
    data: {

        conteudos: null,
        categorias: null,
        categoriaselec: null,
        categoria: null,
        addconteudo: {
            "conteudo": {
                "id": null,
                "titulo": null,
                "ativo": false,
                "texto": null,
                "dataCriacao": null,
                "categoria": {
                    "id": null,
                    "titulo": null,
                    "ativo": false
                }
            }
        },
        modconteudo: {
            "conteudo": {
                "id": null,
                "titulo": null,
                "ativo": false,
                "texto": null,
                "tipo": null,
                "dataCriacao": null,
                "categoria": {
                    "id": null,
                    "titulo": null,
                    "ativo": false
                }
            }
        },
        delconteudo: {
            "conteudo": {
                "id": null,
                "titulo": null,
                "ativo": false,
                "texto": null,
                "tipo": null,
                "dataCriacao": null,
                "categoria": {
                    "id": null,
                    "titulo": null,
                    "ativo": false
                }
            }
        }
    },
    created: function () {
        this.getconteudo();
        this.getcategoria();
    },
    methods: {
        //Comando Format
        dateFormat: function (h) {
            return  moment(h).format('DD/MM/YYYY');
        },
        //Comando lista
        getconteudo: function () {
            var self = this;
            $.get(conteudoURL + "lista", function (data) {
                self.conteudos = data.list;
            });
        },
        getcategoria: function () {
            var self = this;
            $.get(conteudoCategoriaURL + "listar", function (data) {
                self.categorias = data.list;
            });

        },

        //Comando cadastra
        addConteudo: function () {
            var self = this;

            self.addconteudo.conteudo.categoria = self.categoriaselec;

            $.ajax({
                type: "POST",
                url: conteudoURL + "cadastrar",
                data: JSON.stringify(self.addconteudo.conteudo),
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
            self.modconteudo.conteudo = h;
        },
        updateDelConteudo: function (h) {
            var self = this;
            self.delconteudo.conteudo = h;
        },
        //Comando modifica
        updateConteudo: function () {
            var self = this;
            $.ajax({
                type: "POST",
                url: conteudoURL + "modificar",
                data: JSON.stringify(self.modconteudo.conteudo),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: function () {
                    $('modConteudo').modal('hide');
                    self.resetObjects();
                    self.fetchConteudo();
                }
            });
        },

        //Comando exclui

        //Fetch
        fetchConteudo: function () {
            var self = this;
            setTimeout(function () {
                self.getconteudo();
            }, 600);
        },
        fetchCategoria: function () {
            var self = this;
            setTimeout(function () {
                self.getcategoria();
            }, 600);
        },

        //Resets
        resetObjects: function () {

            var self = this;

            self.addconteudo = {
                "conteudo": {
                    "id": null,
                    "titulo": null,
                    "ativo": false,
                    "texto": null,
                    "tipo": null,
                    "dataCriacao": null,
                    "categoria": {
                        "id": null,
                        "titulo": null,
                        "ativo": false
                    }
                }
            };
            self.modconteudo = {
                "conteudo": {
                    "id": null,
                    "titulo": null,
                    "ativo": false,
                    "texto": null,
                    "tipo": null,
                    "dataCriacao": null,
                    "categoria": {
                        "id": null,
                        "titulo": null,
                        "ativo": false
                    }
                }
            };
            self.delconteudo = {
                "conteudo": {
                    "id": null,
                    "titulo": null,
                    "ativo": false,
                    "texto": null,
                    "tipo": null,
                    "dataCriacao": null,
                    "categoria": {
                        "id": null,
                        "titulo": null,
                        "ativo": false
                    }
                }
            };

        }
    }
});