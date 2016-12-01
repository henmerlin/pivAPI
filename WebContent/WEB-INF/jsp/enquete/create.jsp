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

                            </tr>

                        </thead>

                        <tbody>

                            <tr v-for="enquete in enquetes" :key="enquete.id">

                                <td>

                                    <label>{{enquete.titulo}}</label>

                                </td>

                                <td>

                                    <label>{{enquete.dataInicio}}</label>

                                </td>

                                <td>

                                    <label>{{enquete.dataFim}}</label>

                                </td>

                                <td>

                                    <label v-if="enquete.ativo == true" >Ativo</label>
                                    <label v-if="enquete.ativo == false" >Inativo</label>

                                </td>

                            </tr>

                        </tbody>

                    </table>                                   

                </div>

                <!-- Modal -->
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

            </div>

        </div>

    </div>

    <script>

        var enqURL = "${pageContext.request.contextPath}/comunicacao/enquete/";

        new Vue({
            el: '#enquete',
            data: {
                enquetes: null,
                addEnquetes: {"enquete":
                            {
                                "dataInicio": null,
                                "dataFim": null, 
                                "id": null, 
                                "titulo": null,
                                "ativo": false}}
            },
            created: function () {
                this.getEnquetes()
            },
            methods: {
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
                        data: JSON.stringify(self.addEnquetes),
                        dataType: "json",
                        beforeSend: function (xhrObj) {
                            xhrObj.setRequestHeader("Content-Type", "application/json");
                        }
                    });

                    self.fetchData()

                },
                fetchData: function () {
                    var self = this;

                    setTimeout(function () {
                        self.getEnquetes()
                    }, 600)
                }

            }
        });

    </script>

</div>