<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator"%>


<div class="container">

    <div class="page-header">
        <h1>Editor</h1>
    </div>

    <div id="editor">

        <div class="row">
            <div class="col-md-12">
                <h4>Abas</h4>
                <div>
                    <table class="table table-bordered small">
                        <thead>
                            <tr>
                                <th>Título</th>
                                <th>Ativa</th>
                                <th>Ações</th>
                            </tr>
                        </thead>
                        <tbody>

                            <tr v-for="aba in abas" v-bind:class="{ active: activedAba == aba}" :key="aba.id">

                                <td class="view" v-if="aba != editedAba" @dblclick="editAba(aba)">
                                    <label>{{ aba.titulo }}</label>
                                </td>

                                <td v-if="aba == editedAba">
                                    <input class="form-control" type="text"
                                           v-model="aba.titulo"
                                           @blur="doneEditAba(aba)">
                                </td>

                                <td>
                                    <input type="checkbox" v-model="aba.ativo" @change="doneEditAba(aba)"></input>
                                </td>

                                <td>
                                    <button class="btn btn-primary glyphicon glyphicon-th-list btn-sm" @click="selectAba(aba)"></button>
                                    <button class="btn btn-danger glyphicon glyphicon-trash btn-sm" @click="deleteAba(aba)" data-toggle="modal" data-target="#modalAba"></button>
                                </td>

                            </tr>
                        </tbody>
                    </table>
                    <button class="btn btn-success btn-xs" @click="novaAba">Adicionar</button>
                    <br>
                </div>
            </div>
            <div class="col-md-12"><p></p></div>
            <div class="col-md-12">
                <div v-if="activedAba">
                    <h4>SubAbas <span v-text="activedAba.titulo"></span></h4>
                    <table class="table table-bordered small">
                        <thead>
                            <tr>
                                <th>Título</th>
                                <th>Ativa</th>
                                <th>Ações</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="subAba in activedAba.subAbas" v-bind:class="{ active: activedSubAba == subAba}" :key="subAba.id">

                                <td class="view" v-if="subAba != editedSubAba" @dblclick="editSubAba(subAba)" @click="selectSubAba(subAba)">
                                    <label>{{ subAba.titulo }}</label>
                                </td>

                                <td v-if="subAba == editedSubAba">
                                    <input class="form-control" type="text"
                                           v-model="subAba.titulo"
                                           @blur="doneEditSubAba()">
                                </td>

                                <td>
                                    <input type="checkbox" v-model="subAba.ativo" @change="doneEditSubAba(subAba)"></input>
                                </td>

                                <td>
                                    <button class="btn btn-danger glyphicon glyphicon-trash btn-sm" @click="clickDeleteSubAba(subAba)" data-toggle="modal" data-target="#modalSubAba"></button>
                                </td>

                            </tr>
                        </tbody>
                    </table>
                    <button class="btn btn-success btn-xs" @click="novaSubAba">Adicionar</button>
                    <br>
                </div>
            </div>

            <div class="col-md-12">

            </div>
        </div>


        <!-- Modal -->
        <div class="modal fade" id="modalAba" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"  v-if="deletedAba">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Excluir </h4>
                    </div>
                    <div class="modal-body">
                        Deseja excluir a Aba  <strong v-html="deletedAba.titulo"></strong> e suas respectivas SubAbas?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                        <button type="button" class="btn btn-danger" @click="doneDeleteAba" data-dismiss="modal">Excluir</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal SubAba -->
        <div class="modal fade" id="modalSubAba" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"  v-if="deletedSubAba">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Excluir </h4>
                    </div>
                    <div class="modal-body">
                        Deseja excluir a SubAba  <strong v-html="deletedSubAba.titulo"></strong> e seus respectivos conteúdos?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                        <button type="button" class="btn btn-danger" @click="doneDeleteSubAba" data-dismiss="modal">Excluir</button>
                    </div>
                </div>
            </div>
        </div>


    </div>


    <script>


        // URL - REST
        var abaURL = "${pageContext.request.contextPath}/comunicacao/aba/";
        var subAbaURL = "${pageContext.request.contextPath}/comunicacao/subAba/";

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
                adicionarAba: function(abaPortal) {
                    var self = this;

                    $.ajax({
                        type: "POST",
                        url: abaURL,
                        data: JSON.stringify(abaPortal),
                        dataType: "json",
                        beforeSend: function(xhrObj) {
                            xhrObj.setRequestHeader("Content-Type", "application/json");
                        }
                    });

                    self.fetchData()
                },
                editAba: function(h) {
                    var self = this
                    self.editedAba = h
                },
                deleteAba: function(h) {
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
                doneEditAba: function(h) {
                    var self = this;

                    if (!h.titulo) {
                        self.fetchData()
                        return;
                    }
                    console.log("doneEditAba")
                    console.log(h)

                    self.updateAba(h)
                    self.clearVars()

                },
                // SubAba:
                novaSubAba: function() {
                    var self = this;
                    var _novaSubAba = {"subAbaPortal": {"titulo": "Nova SubAba", "ativo": false}};
                    self.adicionarSubAba(_novaSubAba);
                },
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
                        }
                    });
                },
                editSubAba: function(h) {
                    var self = this
                    self.editedSubAba = h;
                },
                doneEditSubAba: function(h) {
                    var self = this;

                    if (!self.editedSubAba.titulo) {
                        self.fetchData()
                        return;
                    }

                    self.updateSubAba()
                    self.clearVars()

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
                    self.clearVars()
                    self.fetchData()

                    self.selectAba(aba);
                },
                selectSubAba: function(h) {
                    var self = this
                    self.activedSubAba = h
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
                        }
                    });
                },
                updateSubAba: function() {
                    var self = this

                    if (!self.editedSubAba.titulo) {
                        return;
                    }

                    $.ajax({
                        type: "POST",
                        url: subAbaURL + "update",
                        data: JSON.stringify(self.editedSubAba),
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

    </script>
