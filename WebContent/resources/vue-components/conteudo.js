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
        image: null,
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
                },
                "imagem": {
                    "id": null,
                    "base64": null,
                    "dataUpload": null
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
                },
                "imagem": {
                    "id": null,
                    "base64": null,
                    "dataUpload": null
                }
            }
        },
        delconteudo: null
    },
    created: function () {
        this.getconteudo();
        this.getcategoria();
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
            var image = new Image();
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
        dateInput: function (h) {
            return moment(h).format("YYYY-MM-DD");
        },
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
            $.get(conteudoCategoriaURL + "listarAtivo", function (data) {
                self.categorias = data.list;
                self.categorias = _.orderBy(self.categorias, ['titulo'], ['asc']);
            });

        },
        //Comando cadastra
        addConteudo: function () {
            var self = this;
            self.addconteudo.conteudo.categoria = self.categoriaselec;
            self.addconteudo.conteudo.imagem.base64 = self.image;
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
                    self.image = null;
                }
            });
        },
        //Update variaveis
        updateModConteudo: function (h) {
            var self = this;
            self.modconteudo.conteudo = h;
            self.image = self.modconteudo.conteudo.imagem.base64;
        },
        updateDelConteudo: function (h) {
            var self = this;
            self.delconteudo = h;
        },
        //Comando modifica
        updateConteudo: function () {
            var self = this;
            self.modconteudo.conteudo.imagem.base64 = self.image;
            $.ajax({
                type: "POST",
                url: conteudoURL + "modificar",
                data: JSON.stringify(self.modconteudo.conteudo),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: function () {
                    $('#modConteudo').modal('hide');
                    self.resetObjects();
                    self.fetchConteudo();
                }
            });
        },
        //Comando exclui
        delConteudo: function () {
            var self = this;
            $.ajax({
                type: "POST",
                url: conteudoURL + "excluir",
                data: JSON.stringify(self.delconteudo),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: function () {
                    $('#delConteudo').modal('hide');
                    self.resetObjects();
                    self.fetchConteudo();
                }
            });
        },
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
            self.image = null;
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
                    },
                    "imagem": {
                        "id": null,
                        "base64": null,
                        "dataUpload": null
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
                    },
                    "imagem": {
                        "id": null,
                        "base64": null,
                        "dataUpload": null
                    }
                }
            };
            self.delconteudo = null;
            self.categoriaselec = null;
        }
    }
});