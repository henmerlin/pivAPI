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
        <h1>Notificação</h1>
    </div>

    <div id="notificacao" v-cloak>

        <table class="table table-bordered small" style="text-align: center">
            <thead>
                <tr>
                    <th>Titulo</th>
                    <th>Mensagem</th>
                    <th>Conteúdo</th>
                    <th>Ativo</th>
                    <th>Data Inicio</th>
                    <th>Data Fim</th>
                    <th>Usuário</th>
                    <th>Ações</th>
                </tr>                
            </thead>
            <tbody>
                <tr v-for="n in notificacoes" :key="n.id">
                    <td>
                        <label>{{n.titulo}}</label>
                    </td>
                    <td>
                        <label>{{n.mensagem}}</label>
                    </td>
                    <td>
                        <label>{{n.conteudo.titulo}}</label>
                    </td>
                    <td>
                        <label v-if="n.ativo == true" >Ativo</label>
                        <label v-else>Inativo</label>
                    </td>
                    <td>
                        <label>{{dateFormat(n.dataInicio)}}</label>                       
                    </td>
                    <td>
                        <label>{{dateFormat(n.dataFim)}}</label> 
                    </td>
                    <td>
                        <label>{{n.usuario}}</label>
                    </td>
                    <td style="width: 100px;">
                        <button type="button" class="btn btn-primary glyphicon glyphicon-edit btn-sm" data-toggle="modal" data-target="#updateNotify" data-backdrop="static" @click="fetchUpdateNotification(n)"></button>
                        <button type="button" class="btn btn-danger glyphicon glyphicon-trash btn-sm" data-toggle="modal" data-target="#delNotify" data-backdrop="static" @click="fetchExcluirNotification(n)"></button>

                    </td>
                </tr>                
            </tbody>
        </table>

        <button type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#cadastraNotify" data-backdrop="static">Cadastrar Notificação</button>

        <!-- Modal -->
        <div class="modal fade" id="cadastraNotify" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Cadastrar Notificação</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label>Titulo</label>
                            <input type="text" class="form-control" placeholder="titulo" v-model="notificacaoC.titulo">
                        </div>                        
                        <div class="form-group">
                            <label>Mensagem</label>
                            <textarea class="form-control" placeholder="Mensagem" v-model="notificacaoC.mensagem" maxlength="150"></textarea>
                        </div>
                        <div class="form-group">
                            <label>Conteúdo</label>
                            <select class="form-control" v-model="notificacaoC.conteudo.id">
                                <option v-for="c in conteudos" v-bind:value="c.id">{{c.titulo}}</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Ativo?</label>
                            <input type="checkbox" v-model="notificacaoC.ativo"/>
                        </div>
                        <div class="form-group">
                            <label>Data Inicio</label>
                            <input class="form-control" type="date" v-model="notificacaoC.dataInicio" />
                        </div>
                        <div class="form-group">
                            <label>Data Fim</label>
                            <input class="form-control" type="date" v-model="notificacaoC.dataFim" />
                        </div>                        

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                        <button type="button" class="btn btn-primary" @click="adcNotificacao()">Cadastrar</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal -->
        <div class="modal fade" id="updateNotify" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Modifica Notificação</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label>Titulo</label>
                            <input type="text" class="form-control" placeholder="titulo" v-model="notificacaoU.titulo">
                        </div>                        
                        <div class="form-group">
                            <label>Mensagem</label>
                            <textarea class="form-control" placeholder="Mensagem" v-model="notificacaoU.mensagem" maxlength="150"></textarea>
                        </div>
                        <div class="form-group">
                            <label>Conteúdo</label>
                            <select class="form-control" v-model="notificacaoU.conteudo.id">
                                <option v-for="c in conteudos" v-bind:value="c.id">{{c.titulo}}</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Ativo?</label>
                            <input type="checkbox" v-model="notificacaoU.ativo"/>
                        </div>
                        <div class="form-group">
                            <label>Data Inicio</label>
                            <input class="form-control" type="date" v-model="notificacaoU.dataInicio" />
                        </div>
                        <div class="form-group">
                            <label>Data Fim</label>
                            <input class="form-control" type="date" v-model="notificacaoU.dataFim" />
                        </div>  
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                        <button type="button" class="btn btn-primary" @click="modNotificacao()">Modificar</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="delNotify" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Excluir Notificação</h4>
                    </div>
                    <div class="modal-body">
                        Você realmente deseja excluir a Notificação <b>{{notificacaoE.titulo}}</b>?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                        <button type="button" class="btn btn-danger" @click="exNotificacao()">Excluir</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/resources/vue-components/notification.js"></script>

</div>