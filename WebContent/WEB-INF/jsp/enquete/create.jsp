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

    <div id="enquete" v-cloak>

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
                                    <button type="button" class="btn btn-primary glyphicon glyphicon-edit btn-sm" data-toggle="modal" data-target="#modEnquete" @click="editarEnquete(enquete)" data-backdrop="static"></button>
                                    <button type="button" class="btn btn-danger glyphicon glyphicon-trash btn-sm" @click="excluiEnquete(enquete)" data-toggle="modal" data-target="#excluiEnquete"></button>
                                    <a class="btn btn-default glyphicon glyphicon-stats btn-sm" :href="'http://localhost:8080/comunicacao/enquete/infoEnq/' + enquete.id" role="button"></a>
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
                    <div class="modal-dialog modal-lg" role="document">
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
                                            <th>Tipo Pergunta</th>
                                            <th>Ativo</th>
                                            <th>Ação</th>
                                        </tr>
                                    </thead>

                                    <tbody>

                                        <tr v-for="pergunta in perguntasEnquetes" :key="pergunta.id">

                                            <td>

                                                <label>{{pergunta.titulo}}</label>

                                            </td>

                                            <td>

                                                <label>{{pergunta.tipoPergunta}}</label>

                                            </td>

                                            <td>

                                                <label v-if="pergunta.ativo == true" >Ativo</label>
                                                <label v-if="pergunta.ativo == false" >Inativo</label>

                                            </td>

                                            <td>

                                                <button type="button" class="btn btn-primary glyphicon glyphicon-edit glyphicon glyphicon-edit btn-sm" data-toggle="modal" data-target="#escolhaPergunta" @click="editarPerguntaEnquete(pergunta)" data-backdrop="static"></button>

                                            </td>

                                        </tr>

                                    </tbody>

                                </table>

                                <button class="btn btn-success btn-xs" data-toggle="modal" data-target="#criaPerguntaEnquete" data-backdrop="static">Adicionar Pergunta</button>

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

                        <select class="form-control" v-model="addPerguntaEnquete.pergunta.tipoPergunta">

                            <option>Pergunta</option>
                            <option>Múltipla Escolha</option>

                        </select>

                        <br/>

                        <label>Título</label>
                        <input class="form-control" placeholder="Título" type="text" v-model="addPerguntaEnquete.pergunta.titulo"/>

                        <br/>

                        <label>Ativo</label>
                        <input type="checkbox" v-model="addPerguntaEnquete.pergunta.ativo"/>

                        <br/>                       

                    </div>
                    <div class="modal-footer">                        
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                        <button type="button" class="btn btn-primary" @click="adicionaPerguntaEnquete(addPerguntaEnquete)">Criar pergunta</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal Add/Mod Escolha Perguntas-->
        <div class="modal fade" id="escolhaPergunta" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Modificar Pergunta</h4>
                    </div>
                    <div class="modal-body">

                        <label>Titulo</label>
                        <input class="form-control" type="text" v-model="editPerguntaEnquete.titulo"/>

                        <br/>

                        <label>Ativo</label>
                        <input type="checkbox" v-model="editPerguntaEnquete.ativo"/>

                        <hr/>

                        <div v-if="editPerguntaEnquete.tipoPergunta == 'Múltipla Escolha'">

                            Escolhas:

                            <br/>

                            <table class="table table-bordered small">

                                <thead>

                                    <tr>

                                        <th>Titulo</th>
                                        <th>Ativo</th>
                                        <th>Ações</th>

                                    </tr>

                                </thead>

                                <tbody>

                                    <tr v-for="escolha in escolhaPerguntas" :key="escolha.id">

                                        <td>{{escolha.titulo}}</td>
                                        <td>
                                            <label v-if="escolha.ativo == true" >Ativo</label>
                                            <label v-if="escolha.ativo == false" >Inativo</label>
                                        </td>
                                        <td>

                                            <button type="button" class="btn btn-primary glyphicon glyphicon-edit glyphicon glyphicon-edit btn-sm" data-toggle="modal" data-target="#editaEscolhaPergunta" data-backdrop="static" @click="editarEscolhaPergunta(escolha)"></button>

                                        </td>

                                    </tr>

                                </tbody>

                            </table>

                            <br/>

                            <button type="button" class="btn btn-success btn-xs" data-toggle="modal" data-target="#criaEscolhaPergunta" data-backdrop="static">Adicionar Pergunta</button>

                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                        <button type="button" class="btn btn-primary" @click="doneEditaPergunta(editPerguntaEnquete)" >Modificar</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal cria EscolhaPerguntas-->
        <div class="modal fade" id="criaEscolhaPergunta" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Criar Escolhas</h4>
                    </div>
                    <div class="modal-body">

                        <label>Titulo</label>
                        <input class="form-control" type="text" v-model="addEscolhaPergunta.escolhaPergunta.titulo"/>

                        <br/>

                        <label>Ativo</label>
                        <input type="checkbox" v-model="addEscolhaPergunta.escolhaPergunta.ativo"/>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                        <button type="button" class="btn btn-primary" @click="adicionaEscolhaPergunta(addEscolhaPergunta)">Cadastrar</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="editaEscolhaPergunta" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Modifica Escolha</h4>
                    </div>
                    <div class="modal-body">

                        <label>Nome</label>
                        <input class="form-control" type="text" v-model="editEscolhaPergunta.titulo"/>

                        <br/>

                        <label>Ativo</label>
                        <input type="checkbox" v-model="editEscolhaPergunta.ativo"/>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                        <button type="button" class="btn btn-primary" @click="doneEditaEscolhaPergunta(editEscolhaPergunta)">Modificar</button>
                    </div>
                </div>
            </div>
        </div>

        <button class="btn btn-success btn-sm" data-toggle="modal" data-target="#criaEnquete" data-backdrop="static">Adicionar</button>

    </div>

    <script src="${pageContext.request.contextPath}/resources/vue-components/enquete.js"></script>

</div>