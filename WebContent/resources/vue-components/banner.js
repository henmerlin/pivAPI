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
        addbanner: {
            "id": null,
            "ativo": false,
            "dataInicio": null,
            "dataFim": null,
            "dataCriacao": null,
            "local": null,
            "conteudo": {
                "id": null
            },
            "imagem": {
                "id": null,
                "base64": null,
                "dataUpload": null
            }
        },
        modbanner: {
            "id": null,
            "ativo": false,
            "dataInicio": null,
            "dataFim": null,
            "dataCriacao": null,
            "local": null,
            "conteudo": {
                "id": null
            },
            "imagem": {
                "id": null,
                "base64": null,
                "dataUpload": null
            }
        },
        delbanner: null,
        bannerLocalList: null,
        conteudos: null,
        image: null,
        seconteudo: {
            "conteudo": {
                "id": null
            }
        },
        checkedconteudo: false

    },
    created: function () {
        this.getbanner();
        this.getenumbannerlocal();
        this.getconteudo();
    },
    methods: {
        //Uploader
        onFileChange(e) {
            var files = e.target.files || e.dataTransfer.files;
            if (!files.length)
                return;
            this.createImage(files[0]);
        },
        createImage(file) {
            var reader = new FileReader();
            var self = this;
            reader.onload = (e) => {
                self.image = e.target.result;
            };
            reader.readAsDataURL(file);
        },
        removeImage: function (e) {
            var self = this;
            self.image = '';
        },
        //Comando Format
        dateFormat: function (h) {
            return moment(h).format('DD/MM/YYYY');
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
        adcbanner: function () {
            var self = this;
            self.addbanner.imagem.base64 = self.image;
            $.ajax({
                type: "POST",
                url: bannerURL + "cadastrar",
                data: JSON.stringify(self.addbanner),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: function () {
                    $('#addbanner').modal('hide');
                    self.fetchbanner();
                    self.resetObjects();
                }
            });
        },
        //Update Variaveis
        updatemodbanner: function (h) {
            var self = this;
            self.modbanner = h;
            self.image = self.modbanner.imagem.base64;
            self.modbanner.dataInicio = self.dateInput(self.modbanner.dataInicio);
            self.modbanner.dataFim = self.dateInput(self.modbanner.dataFim);
        },
        updatedelbanner: function (h) {
            var self = this;
            self.delbanner = h;
        },
        //Comando Modifica
        modibanner: function () {
            var self = this;
            if (self.checkedconteudo) {
                self.modbanner.conteudo = {};
                self.modbanner.conteudo = self.seconteudo.conteudo;
            }
            self.modbanner.imagem.base64 = self.image;
            $.ajax({
                type: "POST",
                url: bannerURL + "modificar",
                data: JSON.stringify(self.modbanner),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: function () {
                    $('#modBanner').modal('hide');
                    self.fetchbanner();
                    self.resetObjects();
                }
            });
        },
        //Comando Deleta
        deletbanner: function () {
            var self = this;
            $.ajax({
                type: "POST",
                url: bannerURL + "excluir",
                data: JSON.stringify(self.delbanner),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: function () {
                    $('#delbanner').modal('hide');
                    self.fetchbanner();
                    self.resetObjects();
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
        resetObjects: function () {
            var self = this;
            self.addbanner = {
                "id": null,
                "ativo": false,
                "dataInicio": null,
                "dataFim": null,
                "dataCriacao": null,
                "local": null,
                "conteudo": {
                    "id": null
                },
                "imagem": {
                    "id": null,
                    "base64": null,
                    "dataUpload": null
                }
            };
            self.modbanner = {
                "id": null,
                "ativo": false,
                "dataInicio": null,
                "dataFim": null,
                "dataCriacao": null,
                "local": null,
                "conteudo": {
                    "id": null
                },
                "imagem": {
                    "id": null,
                    "base64": null,
                    "dataUpload": null
                }
            };
            self.delbanner = null;
            self.image = null;
            self.seconteudo = {
                "conteudo": {
                    "id": null
                }
            };
            self.checkedconteudo = false;
        },
        minimundate: function (h) {
            $(".datainiciofrm").attr("min", h);
        }
    }
});
