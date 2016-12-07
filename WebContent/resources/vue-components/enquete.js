/**
 * Componente do Editor
 * @author G0034481
 * @example jsp/enquete/create.jsp
 */

var enqURL = "/comunicacao/enquete/";
var enqPerguntaURL = "/comunicacao/pergunta/";
var escolhaPerguntaURL = "/comunicacao/escolhapergunta/";

new Vue({
    el: '#enquete',
    data: {
        tipoPergutna: null,
        enquetes: null,
        perguntasEnquetes: null,
        escolhaPerguntas: null,
        editEnquete: {
            "enquete": {
                "dataInicio": null,
                "dataFim": null,
                "id": null,
                "titulo": null,
                "ativo": false
            }
        },
        addEnquete: {
            "enquete": {
                "dataInicio": null,
                "dataFim": null,
                "id": null,
                "titulo": null,
                "ativo": false
            }
        },
        delEnquete: {
            "enquete": {
                "dataInicio": null,
                "dataFim": null,
                "id": null,
                "titulo": null,
                "ativo": false
            }
        },
        addPerguntaEnquete: {
            "pergunta": {
                "id": null,
                "titulo": null,
                "ativo": false,
                "tipoPergunta": null,
                "enquete": {
                    "dataInicio": null,
                    "dataFim": null,
                    "id": null,
                    "titulo": null,
                    "ativo": false
                }
            }
        },
        editPerguntaEnquete: {
            "pergunta": {
                "id": null,
                "titulo": null,
                "ativo": false,
                "tipoPergunta": null,
                "enquete": {
                    "dataInicio": null,
                    "dataFim": null,
                    "id": null,
                    "titulo": null,
                    "ativo": false
                }
            }
        },
        addEscolhaPergunta: {
            "escolhaPergunta": {
                "id": null,
                "titulo": null,
                "ativo": false,
                "pergunta": {
                    "id": null,
                    "titulo": null,
                    "ativo": false,
                    "tipoPergunta": null,
                    "enquete": {
                        "dataInicio": null,
                        "dataFim": null,
                        "id": null,
                        "titulo": null,
                        "ativo": false
                    }
                }

            }
        },
        editEscolhaPergunta: {
            "escolhaPergunta": {
                "id": null,
                "titulo": null,
                "ativo": false,
                "pergunta": {
                    "id": null,
                    "titulo": null,
                    "ativo": false,
                    "tipoPergunta": null,
                    "enquete": {
                        "dataInicio": null,
                        "dataFim": null,
                        "id": null,
                        "titulo": null,
                        "ativo": false
                    }
                }

            }
        }
    },
    created: function () {
        this.getEnquetes();
        this.resetObjects();
    },
    methods: {        
                
        //Comandos Formatação   
        dateInput: function (h) {
            return moment(h).format("YYYY-MM-DD");
        },
        dateFormat: function (h) {
            return  moment(h).format('DD/MM/YYYY');
        },
        
        //Comandos Criação
        adicionaEnquete: function () {
            var self = this;
            $.ajax({
                type: "POST",
                url: enqURL + "cadastrar",
                data: JSON.stringify(self.addEnquete.enquete),
                dataType: "json",
                beforeSend: function (xhrObj) {
                    xhrObj.setRequestHeader("Content-Type", "application/json");
                },
                success: function () {
                    self.resetObjects()
                }
            });
            self.fetchData()
        },
        adicionaPerguntaEnquete: function (h) {

            var self = this;

            h.pergunta.enquete = self.editEnquete;

            $.ajax({
                type: "POST",
                url: enqPerguntaURL + "cadastrar",
                data: JSON.stringify(h),
                dataType: "json",
                beforeSend: function (xhrObj) {

                    xhrObj.setRequestHeader("Content-Type", "application/json");

                },
                success: function () {

                    $('#criaPerguntaEnquete').modal('hide');
                    $('#modEnquete').modal('show');
                    self.resetObjects();
                }
            });
            self.fetchDataPergunta(self.editEnquete);
        },
        adicionaEscolhaPergunta: function () {

            var self = this;

            self.addEscolhaPergunta.escolhaPergunta.pergunta = self.editPerguntaEnquete;

            $.ajax({
                type: "POST",
                url: escolhaPerguntaURL + "cadastrar",
                data: JSON.stringify(self.addEscolhaPergunta.escolhaPergunta),
                dataType: "json",
                beforeSend: function (xhrObj) {

                    xhrObj.setRequestHeader("Content-Type", "application/json");

                },
                success: function () {

                    $('#criaEscolhaPergunta').modal('hide');
                    $('#escolhaPergunta').modal('show');
                    self.resetObjects();
                }
            });
            self.fetchDataEscolhaPerguntas(self.editPerguntaEnquete);
        },
        
        //Comandos Lista
        getEnquetes: function () {
            var self = this;
            $.get(enqURL + "listar", function (data) {
                self.enquetes = data.list;
            })

        },
        getPerguntasEnquetes: function (h) {
            var self = this;
            $.get(enqPerguntaURL + "lista/" + h.id, function (data) {
                self.perguntasEnquetes = data.list;
            });

        },
        getEscolhaPerguntas: function (h) {

            var self = this;
            $.get(escolhaPerguntaURL + "lista/" + h.id, function (data) {
                self.escolhaPerguntas = data.list;
            });
        },
        
        //Comandos Modifica
        editarEnquete: function (h) {

            var self = this;
            self.editEnquete = h;
            self.getPerguntasEnquetes(self.editEnquete);

        },
        editarPerguntaEnquete: function (h) {

            var self = this;
            self.editPerguntaEnquete = h;
            self.getEscolhaPerguntas(h);

        },
        editarEscolhaPergunta: function (h) {

            var self = this;
            self.editEscolhaPergunta = h;

        },                
        doneEditaEnquete: function (h) {

            $.ajax({
                type: "POST",
                url: enqURL + "modificar",
                data: JSON.stringify(h),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: function () {
                    $('#modEnquete').modal('hide');
                }
            });
        },
        doneEditaPergunta: function () {

            var self = this;

            self.editPerguntaEnquete.enquete = self.editEnquete;

            $.ajax({
                type: "POST",
                url: enqPerguntaURL + "modificar",
                data: JSON.stringify(self.editPerguntaEnquete),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: function () {
                    $('#escolhaPergunta').modal('hide');
                }
            });
        },
        doneEditaEscolhaPergunta: function (h) {
            
            var self = this;
            
            self.editEscolhaPergunta.pergunta = self.editPerguntaEnquete;
            self.editEscolhaPergunta.pergunta.enquete = self.editEnquete;
            
            $.ajax({
                type: "POST",
                url: escolhaPerguntaURL + "modificar",
                data: JSON.stringify(h),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: function () {
                    $('#editaEscolhaPergunta').modal('hide');
                }
            });
        },
        
        //Comandos Delete
        excluiEnquete: function (h) {

            var self = this;

            self.delEnquete = h;
            
        },
        doneExcluiEnquete: function (h) {

            var self = this

            $.ajax({
                type: "POST",
                url: enqURL + "exclui",
                data: JSON.stringify(h),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: function () {

                    $('#excluiEnquete').modal('hide');

                }
            });
            self.fetchData();
        },
        
        //Comandos Fetch
        fetchData: function () {

            var self = this;
            setTimeout(function () {

                self.getEnquetes();

            }, 600);

        },
        fetchDataPergunta: function (h) {

            var self = this;
            setTimeout(function () {

                self.getPerguntasEnquetes(h);

            }, 600);

        },
        fetchDataEscolhaPerguntas: function (h) {

            var self = this;
            setTimeout(function () {

                self.getEscolhaPerguntas(h);

            }, 600);

        },
        
        //Comandos Reset Objects
        resetObjects: function () {
            var self = this;
            self.addEnquete = {
                "enquete": {
                    "dataInicio": null,
                    "dataFim": null,
                    "id": null,
                    "titulo": null,
                    "ativo": false
                }
            };
            self.addPerguntaEnquete = {
                "pergunta": {
                    "id": null,
                    "titulo": null,
                    "ativo": false,
                    "tipoPergunta": null,
                    "enquete": {
                        "dataInicio": null,
                        "dataFim": null,
                        "id": null,
                        "titulo": null,
                        "ativo": false
                    }
                }
            };
            self.addEscolhaPergunta = {
                "escolhaPergunta": {
                    "id": null,
                    "titulo": null,
                    "ativo": false,
                    "pergunta": {
                        "id": null,
                        "titulo": null,
                        "ativo": false,
                        "tipoPergunta": null,
                        "enquete": {
                            "dataInicio": null,
                            "dataFim": null,
                            "id": null,
                            "titulo": null,
                            "ativo": false
                        }
                    }
                }
            };
        }
    }
});