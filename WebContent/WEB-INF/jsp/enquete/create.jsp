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

                    <button class="btn btn-success btn-xs" data-toggle="modal" data-target="#criaEnquete">Criar enquete</button>
                    <br />

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

                                    <div class="btn-group" role="group">

                                        <button type="button" class="btn btn-info" data-toggle="modal" data-target="#modEnquete" @click="editarEnquete(enquete)">Modificar</button>
                                        <button type="button" class="btn btn-danger">Excluir</button>

                                    </div>

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

                                <label>Titulo</label>
                                <input class="form-control" type="text" v-model="addEnquetes.enquete.titulo"/>

                                <br/>

                                <label>Ativo</label>
                                <input type="checkbox" v-model="addEnquetes.enquete.ativo"/>

                                <br/>

                                <label>Data inicio</label>
                                <input class="form-control" type="date" v-model="addEnquetes.enquete.dataInicio"/>

                                <br/>

                                <label>Data fim</label>
                                <input class="form-control" type="date" v-model="addEnquetes.enquete.dataFim"/>

                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary" @click="adicionaEnquete(addEnquetes)" data-dismiss="modal">Save changes</button>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Modal -->
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

                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary">Save changes</button>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>

    <script>

        var enqURL = "${pageContext.request.contextPath}/comunicacao/enquete/";

        new Vue({
            el: '#enquete',
            data: {

                enquetes: null,
                editEnquete: {
                    "enquete":
                            {
                                "dataInicio": null,
                                "dataFim": null,
                                "id": null,
                                "titulo": null,
                                "ativo": false
                            }
                },
                addEnquetes: {
                    "enquete":
                            {
                                "dataInicio": null,
                                "dataFim": null,
                                "id": null,
                                "titulo": null,
                                "ativo": false
                            }
                }

            },
            created: function() {
                this.getEnquetes()
            },
            methods: {
                dateInput: function(h) {
                    return moment(h).format("YYYY-MM-DD");
                },
                dateFormat: function(h) {
                    return  moment(h).format('L');
                },
                getEnquetes: function() {

                    var self = this;

                    $.get(enqURL + "listar", function(data) {

                        self.enquetes = data.list;

                    })

                },
                adicionaEnquete: function() {
                    var self = this;


                    var enqt = self.addEnquetes.enquete;

                    enqt.dataInicio = moment(enqt.dataInicio);
                    enqt.dataFim = enqt.dataFim;


                    $.ajax({
                        type: "POST",
                        url: enqURL + "cadastrar",
                        data: JSON.stringify(self.addEnquetes.enquete),
                        dataType: "json",
                        beforeSend: function(xhrObj) {
                            xhrObj.setRequestHeader("Content-Type", "application/json");
                        },
                        success: function() {
                            self.addEnquetes.enquete = null;
                        }
                    });
                    self.fetchData()

                },
                editarEnquete: function(enquets) {

                    var self = this
                    self.editEnquete = enquets

                },
                fetchData: function() {

                    var self = this;
                    setTimeout(function() {

                        self.getEnquetes()

                    }, 600)

                }

            }
        });

    </script>

</div>