<%--
    Document   : create
    Created on : 30/11/2016, 12:53:55
    Author     : G0034481
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator"%>

<div class="container">

    <div class="page-header">
        <h1>Enquete</h1>
    </div>

    <div id="enquete">

        <div class="row">
            <div class="col-md-12">
                <div>
                    <table class="table table-bordered small">

                        <thead>
                            <tr>
                                <th>Titulo</th>
                                <th>Data Inicio</th>
                                <th>Data Fim</th>
                                <th>Status</th>
                                <th>Ações</th>
                            </tr>
                        </thead>

                        <tbody>

                            <tr v-for="enquete in enquetes" :key="enquete.id">

                                <td>

                                    <label>{{enquete.titulo}}</label>

                                </td>

                                <td>

                                    <label>{{dateFormat(enquete.dataInicio)}}</label>

                                </td>

                                <td>

                                    <label>{{dateFormat(enquete.dataFim)}}</label>

                                </td>

                                <td>

                                    <label v-if="enquete.ativo == true" >Ativo</label>
                                    <label v-if="enquete.ativo == false" >Inativo</label>

                                </td>

                                <td style="width: 20%;">
                                    <button type="button" class="btn btn-primary glyphicon glyphicon-edit
                                            glyphicon glyphicon-edit btn-sm" data-toggle="modal" data-target="#modEnquete" @click="editarEnquete(enquete)"></button>
                                    <button class="btn btn-danger glyphicon glyphicon-trash btn-sm" @click="excluiEnquete(enquete)" data-toggle="modal" data-target="#excluiEnquete"></button>
                                </td>

                            </tr>

                        </tbody>

                    </table>

                </div>

                <!-- Modal CRIAR -->
                <div class="modal fade" id="criaEnquete" tabindex="-1" role="dialog" aria-labelledby="criaEnqueteLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel">Criar Enquete</h4>
                            </div>
                            <div class="modal-body">

                                <label>Título</label>
                                <input class="form-control" placeholder="Título" type="text" v-model="addEnquete.enquete.titulo"/>

                                <br/>

                                <label>Ativo</label>
                                <input type="checkbox" v-model="addEnquete.enquete.ativo"/>

                                <br/>

                                <label>Data inicio</label>
                                <input class="form-control" type="date" v-model="addEnquete.enquete.dataInicio" />

                                <br/>

                                <label>Data fim</label>
                                <input class="form-control" type="date" v-model="addEnquete.enquete.dataFim"/>

                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                                <button type="button" class="btn btn-success" @click="adicionaEnquete(addEnquete)" data-dismiss="modal">Inserir</button>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Modal Modificar -->
                <div class="modal fade" id="modEnquete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel">Modifica Enquete</h4>
                            </div>
                            <div class="modal-body">

                                <label>Titulo</label>
                                <input class="form-control" type="text" v-model="editEnquete.titulo"/>

                                <br/>

                                <label>Ativo</label>
                                <input type="checkbox" v-model="editEnquete.ativo"/>

                                <br/>

                                <label>Data inicio</label>
                                <input class="form-control" type="date" v-model="dateInput(editEnquete.dataInicio)"/>

                                <br/>

                                <label>Data fim</label>
                                <input class="form-control" type="date" v-model="dateInput(editEnquete.dataFim)"/>

                                <br/>

                                <table class="table table-bordered small">

                                    <thead>
                                        <tr>
                                            <th>Pergunta</th>
                                            <th>Ativo</th>
                                            <th>Tipo pergunta</th>
                                        </tr>
                                    </thead>

                                    <tbody>

                                        <tr v-for="pergunta in perguntasEnquetes" :key="pergunta.id">

                                            <td>

                                                <label>{{pergunta.titulo}}</label>

                                            </td>

                                            <td>

                                                <label v-if="pergunta.ativo == true" >Ativo</label>
                                                <label v-if="pergunta.ativo == false" >Inativo</label>

                                            </td>

                                            <td>

                                                <label v-if="pergunta.tipoPergunta == true" >Escolha</label>
                                                <label v-if="pergunta.tipoPergunta == false" >Descritivo</label>

                                            </td>

                                        </tr>

                                    </tbody>

                                </table>

                                <button class="btn btn-success btn-xs" data-toggle="modal" data-dismiss="modal" data-target="#criaPerguntaEnquete">Adicionar Pergunta</button>

                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                                <button type="button" class="btn btn-primary" data-dismiss="modal" @click="doneEditaEnquete(editEnquete)">Alterar</button>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Modal Excluir-->
                <div class="modal fade" id="excluiEnquete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel">Excluir</h4>
                            </div>
                            <div class="modal-body">
                                Deseja excluir a Enquete  <strong v-html="delEnquete.titulo"></strong> e seus respectivos conteúdos?
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                                <button type="button" class="btn btn-danger" @click="doneExcluiEnquete(delEnquete)">Excluir</button>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <!-- Modal Pergunta-->
        <div class="modal fade" id="criaPerguntaEnquete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Pergunta Enquete</h4>
                    </div>
                    <div class="modal-body">

                        <label>Título</label>
                        <input class="form-control" placeholder="Título" type="text" v-model="addPerguntaEnquete.pergunta.titulo"/>

                        <br/>

                        <label>Ativo</label>
                        <input type="checkbox" v-model="addPerguntaEnquete.pergunta.ativo"/>

                        <br/>

                        <label>Tipo pergunta</label>
                        <input type="checkbox" v-model="addPerguntaEnquete.pergunta.tipoPergunta"/>

                        <br/>

                        <button type="button" class="btn btn-primary" @click="adicionaPerguntaEnquete(addPerguntaEnquete)">Adiiconar</button>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                    </div>
                </div>
            </div>
        </div>

        <button class="btn btn-success btn-xs" data-toggle="modal" data-target="#criaEnquete">Adicionar</button>

    </div>

    <script>

        var enqURL = "${pageContext.request.contextPath}/comunicacao/enquete/";
        var enqPerguntaURL = "${pageContext.request.contextPath}/comunicacao/pergunta/";

        new Vue({
            el: '#enquete',
            data: {
                enquetes: null,
                perguntasEnquetes: null,
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

                    var self = this
                    self.editEnquete = h
                    self.getPerguntasEnquetes(h)

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

                        self.getEnquetes()

                    }, 600)

                },
                getPerguntasEnquetes: function (h) {
                    var self = this;
                    $.get(enqPerguntaURL + "lista/" + h.id, function (data) {
                        self.enquetes = data.list;
                    })

                },
                adicionaPerguntaEnquete: function (h) {

                    var self = this;

                    self.addPerguntaEnquete = h;

                    self.addPerguntaEnquete.enquete = self.editEnquete;

                    $.ajax({
                        type: "POST",
                        url: enqPerguntaURL + "cadastrar",
                        data: JSON.stringify(h.addPerguntaEnquete),
                        dataType: "json",
                        beforeSend: function (xhrObj) {

                            xhrObj.setRequestHeader("Content-Type", "application/json");

                        }

                    });
                }

            }
        });

    </script>

</div>