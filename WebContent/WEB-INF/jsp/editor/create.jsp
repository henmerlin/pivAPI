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
            <div class="col-md-5">
                <h4>Abas</h4>
                <div>
                    <table class="table table-bordered small">
                        <thead>
                            <tr>
                                <th>Titulo</th>
                                <th>Ativa</th>
                                <th>Excluir</th>
                            </tr>
                        </thead>
                        <tbody>

                            <tr v-for="aba in abas" v-bind:class="{ active: activedAba == aba}" :key="aba.id">

                                <td class="view" v-if="aba != editedAba" @dblclick="editAba(aba)" @click="selectAba(aba)">
                                    <label>{{ aba.titulo }}</label>
                                </td>

                                <td v-if="aba == editedAba">
                                    <input class="form-control" type="text"
                                           v-model="aba.titulo"
                                           @blur="doneEditAba(aba)"
                                           @keyup.enter="doneEditAba(aba)">
                                </td>

                                <td>
                                    <input type="checkbox" v-model="aba.ativo" @change="doneEditAba(aba)"></input>
                                </td>

                                <td>
                                    <button class="btn btn-danger glyphicon glyphicon-trash btn-sm" @click="deleteAba(aba)" data-toggle="modal" data-target="#modalAba"></button>
                                </td>

                            </tr>
                        </tbody>
                    </table>

                </div>
            </div>
            <div class="col-md-5">

                <h4>SubAbas</h4>





            </div>

            <div class="col-md-2"></div>
        </div>
        <button class="btn btn-success btn-xs" @click="adicionarAba">Adicionar</button>


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
    </div>


    <script>

        var apiURL = "${pageContext.request.contextPath}/comunicacao/aba/";

        new Vue({
            el: '#editor',
            data: {
                abas: null,
                editedAba: null,
                activedAba: null,
                deletedAba: null
            },
            created: function() {
                this.fetchData()
            },
            methods: {
                fetchData: function() {
                    var self = this;

                    self.editedAba = null;
                    self.activedAba = null;

                    $.get(apiURL, function(data) {
                        self.abas = data.list;
                    })
                },
                adicionarAba: function() {
                    var self = this;
                    $.post(apiURL)

                    setTimeout(function() {
                        self.fetchData()
                    }, 600)
                },
                editAba: function(h) {
                    var self = this
                    self.editedAba = h;
                },
                deleteAba: function(h) {
                    var self = this
                    self.deletedAba = h;
                },
                doneDeleteAba: function() {
                    var self = this

                    if (!self.deletedAba) {
                        return;
                    }

                    $.ajax({
                        type: "POST",
                        url: apiURL + "delete",
                        data: JSON.stringify(self.deletedAba),
                        dataType: "json",
                        beforeSend: function(xhrObj) {
                            xhrObj.setRequestHeader("Content-Type", "application/json");
                        },
                        success: function(json) {

                            $('#modalAba').modal('hide');
                        }
                    });

                    self.deletedAba = null;

                    setTimeout(function() {
                        self.fetchData()
                    }, 1500)

                },
                selectAba: function(h) {
                    var self = this
                    self.activedAba = h
                },
                doneEditAba: function(h) {
                    var self = this;

                    if (!h.titulo) {
                        setTimeout(function() {
                            self.fetchData()
                        }, 600)
                        return;
                    }

                    $.ajax({
                        type: "POST",
                        url: apiURL + "update",
                        data: JSON.stringify({"abaPortal":
                                    {
                                        "id": h.id,
                                        "titulo": h.titulo,
                                        "ativo": h.ativo
                                    }
                        }),
                        dataType: "json",
                        beforeSend: function(xhrObj) {
                            xhrObj.setRequestHeader("Content-Type", "application/json");
                        },
                        success: function(json) {
                            setTimeout(function() {
                                self.fetchData()
                            }, 600)
                        }
                    });

                    self.editedAba = null;
                }
            }
        })

    </script>
