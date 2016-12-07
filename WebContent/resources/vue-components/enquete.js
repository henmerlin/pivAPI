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
                }

            }
        }
    },
    created: function () {
        this.getEnquetes()
        this.resetObjects()
    },
    methods: {
        resetObjects: function () {
            var self = this;
            self.addEnquete = {
                "enquete":
                        {
                            "dataInicio": null,
                            "dataFim": null,
                            "id": null,
                            "titulo": null,
                            "ativo": false
                        }};

        },
        dateInput: function (h) {
            return moment(h).format("YYYY-MM-DD");
        },
        dateFormat: function (h) {
            return  moment(h).format('DD/MM/YYYY');
        },
        getEnquetes: function () {
            var self = this;
            $.get(enqURL + "listar", function (data) {
                self.enquetes = data.list;
            })

        },
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
        editarEnquete: function (h) {

            var self = this;
            self.editEnquete = h;
            self.getPerguntasEnquetes(self.editEnquete);

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
        excluiEnquete: function (h) {

            var self = this

            self.delEnquete = h

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
            self.fetchData()
        },
        fetchData: function () {

            var self = this;
            setTimeout(function () {

                self.getEnquetes();

            }, 600);

        },
        getPerguntasEnquetes: function (h) {
            var self = this;
            $.get(enqPerguntaURL + "lista/" + h.id, function (data) {
                self.perguntasEnquetes = data.list;
            });

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
                    self.resetObjectsPergunta();
                }
            });
            self.fetchDataPergunta(self.editEnquete);
        },
        editarPerguntaEnquete: function (h) {

            var self = this;
            self.editPerguntaEnquete = h;

        },
        fetchDataPergunta: function (h) {

            var self = this;
            setTimeout(function () {

                self.getPerguntasEnquetes(h);

            }, 600);

        },
        resetObjectsPergunta: function () {
            var self = this;

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
            }
        },
        getEscolhaPerguntas: function (h) {
            var self = this;
            $.get(escolhaPerguntaURL + "lista/" + h.id, function (data) {
                self.escolhaPerguntas = data.list;
            });
        },
        adicionaEscolhaPergunta: function (h) {

            var self = this;

            h.addEscolhaPergunta.pergunta = self.editPerguntaEnquete;

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
                    self.resetObjectsPergunta();
                }
            });
            self.fetchDataPergunta(self.editEnquete);
        }
    }
});