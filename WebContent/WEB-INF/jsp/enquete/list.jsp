<%-- 
    Document   : list
    Created on : 23/12/2016, 10:12:18
    Author     : G0034481
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator"%>

<div class="container">

    <div class="page-header">
        <h1>Enquetes</h1>
    </div>

    <div id="enquete" v-cloak>

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
                            <button type="button" class="btn btn-primary glyphicon glyphicon-edit btn-sm" data-toggle="modal" data-target="#resEnq" data-backdrop="static" @click="updateResp(enquete)"></button>                            
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="resEnq" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close" @click="clear()"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Responder Enquete</h4>
                    </div>
                    <div class="modal-body">
                        <h4>{{titulo}}</h4>
                        <div v-for="(enqR, index) in enqresp">
                            <div v-if=""></div>
                            <label>{{enqR.pergunta.titulo}}</label>
                            <div v-if="enqR.pergunta.tipoPergunta === 'Múltipla Escolha' " style="margin-left: 20px;">                                
                                <div v-for="escolha in escolhaPerguntas">
                                    <div v-if="escolha.pergunta.id == enqR.pergunta.id">
                                        <input type="radio" :name="index" v-bind:value="escolha.titulo" v-model="enqR.resposta"/>
                                        <label>{{escolha.titulo}}</label>
                                    </div>

                                </div>                                
                            </div>
                            <div v-else style="margin-left: 20px;">
                                <textarea class="form-control" rows="5" style="resize: none" v-model="enqR.resposta"></textarea>                              
                            </div>
                        </div>                        
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal" @click="clear()">Fechar</button>
                        <button type="button" class="btn btn-success" @click="salvaResposta()">Responder</button>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <script src="${pageContext.request.contextPath}/resources/vue-components/respEnquete.js"></script>

</div>