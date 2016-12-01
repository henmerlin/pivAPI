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

                <h4>Abas</h4>
                <div>

                    <table class="table table-bordered small">

                        <thead>

                            <tr>

                                <th>Titulo</th>
                                <th>Data Inicio</th>
                                <th>Data Fim</th>

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

                            </tr>

                        </tbody>

                    </table>

                </div>


            </div>

        </div>

    </div>

    <script>

        var enqURL = "${pageContext.request.contextPath}/comunicacao/enquete/";

        new Vue({

            el: '#enquete',

            data: {

                enquetes: null

            },
            methods: {

                getEnquetes: function () {

                    var self = this;

                    $.get(enqURL + "listar", function (data) {

                        self.enquetes = data.list;

                    })

                },
                adicionaEnquete: function (enquete) {

                    var self = this;

                    $.ajax({

                        type: "POST",
                        url: enqURL + "cadastrar",
                        data: JSON.stringify(enquete),
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