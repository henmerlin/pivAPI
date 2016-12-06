/**
 * Componente do Editor
 * @author G0042204
 * @example jsp/editor/create.jsp
 */


// URL - REST
var abaURL = "/comunicacao/aba/";
var subAbaURL = "/comunicacao/subAba/";

$(function() {

    // Instancia
    new Vue({
        el: '#editor',
        data: {
            abas: null,
            // aba
            editedAba: null,
            activedAba: null,
            deletedAba: null,
            // subAbas
            editedSubAba: null,
            activedSubAba: null,
            deletedSubAba: null,
        },
        created: function() {
            this.getAbas()
        },
        methods: {
            clearVars: function() {
                var self = this;
                self.editedAba = null;
                self.activedAba = null;
                self.deletedAba = null;
                self.editedSubAba = null;
                self.activedSubAba = null;
                self.deletedSubAba = null;
            },
            getAbas: function() {
                var self = this;
                $.get(abaURL, function(data) {
                    self.abas = data.list;
                })
            },
            fetchData: function() {
                var self = this;

                setTimeout(function() {
                    self.getAbas()
                }, 600)
            },
            // Aba:
            novaAba: function() {
                var self = this;

                var _novaAba = h = {"abaPortal": {"titulo": "Nova Aba", "ativo": false}};
                self.adicionarAba(_novaAba);

            },
            editAba: function(h) {
                var self = this
                self.editedAba = h
            },
            clickDeleteAba: function(h) {
                var self = this
                self.deletedAba = h
            },
            doneDeleteAba: function() {
                var self = this

                if (!self.deletedAba) {
                    return;
                }

                $.ajax({
                    type: "POST",
                    url: abaURL + "delete",
                    data: JSON.stringify(self.deletedAba),
                    dataType: "json",
                    beforeSend: function(xhrObj) {
                        xhrObj.setRequestHeader("Content-Type", "application/json");
                    },
                    success: function(json) {
                        $('#modalAba').modal('hide');
                    }
                });

                self.clearVars()
                self.fetchData()

            },
            selectAba: function(h) {
                var self = this
                self.activedAba = h
                self.buscaAbaPorId(h)
            },
            doneEditAba: function(h) {
                var self = this;

                if (!h.titulo) {
                    self.fetchData()
                    return;
                }

                self.updateAba(h)
                self.clearVars()
            },
            // Aba
            adicionarAba: function(h) {
                var self = this;

                $.ajax({
                    type: "POST",
                    url: abaURL,
                    data: JSON.stringify(h),
                    dataType: "json",
                    beforeSend: function(xhrObj) {
                        xhrObj.setRequestHeader("Content-Type", "application/json");
                    }
                });

                self.fetchData()
            },
            updateAba: function(h) {
                var self = this

                if (!h.titulo) {
                    self.fetchData()
                    return;
                }

                $.ajax({
                    type: "POST",
                    url: abaURL + "update",
                    data: JSON.stringify(h),
                    dataType: "json",
                    beforeSend: function(xhrObj) {
                        xhrObj.setRequestHeader("Content-Type", "application/json");
                    },
                    success: function(json) {
                        self.fetchData()
                    }
                });
            },
            // SubAba:
            novaSubAba: function() {
                var self = this;
                var _novaSubAba = {"subAbaPortal": {"titulo": "Nova SubAba", "ativo": false}};
                self.adicionarSubAba(_novaSubAba);
            },
            editSubAba: function(h) {
                var self = this
                self.editedSubAba = h;
            },
            doneEditSubAba: function(h) {
                var self = this;

                if (!h.titulo) {
                    self.fetchData()
                    return;
                }
                self.updateSubAba(h)

                self.fetchData()

                setTimeout(function() {
                    self.selectAba(h.abaPortal);
                }, 400)

            },
            clickDeleteSubAba: function(h) {
                var self = this
                self.deletedSubAba = h;
            },
            doneDeleteSubAba: function() {
                var self = this

                if (!self.deletedSubAba) {
                    return;
                }

                var aba = self.activedAba;

                self.deleteSubAba(self.deletedSubAba)

                self.fetchData()

                setTimeout(function() {
                    self.selectAba(aba);
                }, 400)
            },
            selectSubAba: function(h) {
                var self = this
                self.activedSubAba = h
            },
            // SubAba
            adicionarSubAba: function(h) {
                var self = this;

                h.subAbaPortal.abaPortal = self.activedAba;

                $.ajax({
                    type: "POST",
                    url: subAbaURL,
                    data: JSON.stringify(h),
                    dataType: "json",
                    beforeSend: function(xhrObj) {
                        xhrObj.setRequestHeader("Content-Type", "application/json");
                    },
                    success: function(data) {
                        self.activedSubAba = data;
                        self.activedAba.subAbas.push(data.subAbaPortal)
                        self.fetchData()
                    }
                });
            },
            deleteSubAba: function(h) {

                $.ajax({
                    type: "POST",
                    url: subAbaURL + "delete",
                    data: JSON.stringify(h),
                    dataType: "json",
                    beforeSend: function(xhrObj) {
                        xhrObj.setRequestHeader("Content-Type", "application/json");
                    },
                    success: function(json) {
                        $('#modalAba').modal('hide');
                        self.activedAba.subAbas.pop(h)
                        self.fetchData()
                    }
                });
            },
            updateSubAba: function(h) {
                var self = this

                // Resolver Circularidade nos Objetos
                self.activedAba.subAbas = null
                h.abaPortal = self.activedAba

                if (!h.titulo) {
                    return;
                }

                $.ajax({
                    type: "POST",
                    url: subAbaURL + "update",
                    data: JSON.stringify(h),
                    dataType: "json",
                    beforeSend: function(xhrObj) {
                        xhrObj.setRequestHeader("Content-Type", "application/json");
                    },
                    success: function(json) {
                        self.fetchData()
                    }
                });
            },
            // Util
            buscaAbaPorId: function(h) {
                var self = this;
                $.get(abaURL + h.id, function(data) {
                    self.activedAba = data.abaPortal;
                })
            },
            buscaSubAbaPorId: function(h) {
                var self = this;
                $.get(subAbaURL + h.id, function(data) {
                    self.activedSubAba = data.subAbaPortal;
                })
            }
        }
    })

})
