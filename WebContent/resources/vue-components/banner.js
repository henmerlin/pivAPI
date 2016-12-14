/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var bannerURL = "/comunicacao/banner/";
var conteudoURL = "/comunicacao/conteudo/";

new Vue({
    el: '#banner',
    data: {
        banners: null,
        bannerLocalList: null,
        conteudos: null,
        checkedconteudo: false,
        seconteudo: null,
        addBanner: {
            "banner": {
                "id": null,
                "titulo": null,
                "ativo": false,
                "dataInicio": null,
                "dataFim": null,
                "dataCriacao": null,
                "local": null,
                "conteudo": {
                    "id": null
                }
            }
        },
        modiBanner: {
            "banner": {
                "id": null,
                "titulo": null,
                "ativo": false,
                "dataInicio": null,
                "dataFim": null,
                "dataCriacao": null,
                "local": null,
                "conteudo": {
                    "id": null
                }
            }
        },
        delBanner: {
            "banner": {
                "id": null,
                "titulo": null,
                "ativo": false,
                "dataInicio": null,
                "dataFim": null,
                "dataCriacao": null,
                "local": null,
                "conteudo": {
                    "id": null
                }
            }
        }
    },
    created: function () {
        var self = this;
        self.fetchbanner();
        self.getenumbannerlocal();
        self.getconteudo();
    },
    methods: {
        //Comando Format
        dateFormat: function (h) {
            return  moment(h).format('DD/MM/YYYY');
        },
        dateInput: function (h) {
            return moment(h).format("YYYY-MM-DD");
        },
        //Comando Lista
        getbanner: function () {
            var self = this;
            $.get(bannerURL + "lista", function (data) {
                self.banners = data.list;
            });
        },
        getenumbannerlocal: function () {
            var self = this;
            $.get(bannerURL + "listaBannerLocal", function (data) {
                self.bannerLocalList = data.bannerLocalList;
            });
        },
        getconteudo: function () {
            var self = this;
            $.get(conteudoURL + "lista", function (data) {
                self.conteudos = data.list;
            });
        },

        //Comando Cadastra
        addbanner: function () {
            var self = this;

            $.ajax({
                type: "POST",
                url: bannerURL + "cadastrar",
                data: JSON.stringify(self.addBanner.banner),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: function () {
                    $('#addbanner').modal('hide');
                    self.resetobjects();
                    self.fetchbanner();
                }
            });
        },
        //Update Variaveis
        updatemodbanner: function (h) {
            var self = this;
            self.modiBanner.banner = h;
        },
        updatedelbanner: function (h) {
            var self = this;
            self.delBanner.banner = h;

        },
        //Comando Modifica
        modbanner: function () {
            var self = this;

            self.modiBanner.banner.conteudo = self.seconteudo;

            $.ajax({
                type: "POST",
                url: bannerURL + "modificar",
                data: JSON.stringify(self.modiBanner.banner),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: function () {
                    $('#modBanner').modal('hide');
                    self.resetobjects();
                    self.fetchbanner();
                }
            });
        },
        //Comando Deleta
        delbanner: function () {
            var self = this;
            $.ajax({
                type: "POST",
                url: bannerURL + "excluir",
                data: JSON.stringify(self.delBanner.banner),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: function () {
                    $('#delBanner').modal('hide');
                    self.resetobjects();
                    self.fetchbanner();
                }
            });
        },
        //Fetch
        fetchbanner: function () {
            var self = this;
            setTimeout(function () {
                self.getbanner();
            }, 600);
        },
        //Reset
        resetobjects: function () {

            var self = this;
            self.addBanner = {
                "banner": {
                    "id": null,
                    "titulo": null,
                    "ativo": false,
                    "dataInicio": null,
                    "dataFim": null,
                    "dataCriacao": null,
                    "conteudo": {
                        "id": null,
                        "titulo": null,
                        "ativo": false,
                        "texto": null,
                        "dataCriacao": null
                    }
                }
            };
            self.modiBanner = {
                "banner": {
                    "id": null,
                    "titulo": null,
                    "ativo": false,
                    "dataInicio": null,
                    "dataFim": null,
                    "dataCriacao": null,
                    "conteudo": {
                        "id": null,
                        "titulo": null,
                        "ativo": false,
                        "texto": null,
                        "dataCriacao": null
                    }
                }
            };
            self.delBanner = {
                "banner": {
                    "id": null,
                    "titulo": null,
                    "ativo": false,
                    "dataInicio": null,
                    "dataFim": null,
                    "dataCriacao": null,
                    "conteudo": {
                        "id": null,
                        "titulo": null,
                        "ativo": false,
                        "texto": null,
                        "dataCriacao": null
                    }
                }
            };
        }
    }

});
