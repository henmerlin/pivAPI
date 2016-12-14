<%-- 
    Document   : create
    Created on : 13/12/2016, 11:34:31
    Author     : G0034481
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator"%>

<div class="container">

    <div class="page-header">
        <h1>Banner</h1>
    </div>

    <div id="banner" v-cloak>

        <div>

            <table class="table table-bordered">

                <thead>
                    <tr>
                        <th>Titulo</th>
                        <th>Ativo</th>
                        <th>Data Início</th>
                        <th>Data Fim</th>
                        <th>Data cricação</th>
                        <th>Conteudo</th>                        
                        <th>Local</th>
                        <th>Ações</th>
                    </tr>

                </thead>
                <tbody>
                    <tr v-for="banner in banners" :key="banner.id">
                        <td>{{banner.titulo}}</td>
                        <td>
                            <label v-if="banner.ativo == true" >Ativo</label>
                            <label v-if="banner.ativo == false" >Inativo</label>
                        </td>
                        <td>{{dateFormat(banner.dataInicio)}}</td>
                        <td>{{dateFormat(banner.dataFim)}}</td>
                        <td>{{dateFormat(banner.dataCriacao)}}</td>
                        <td>                            
                            <span v-if="banner.conteudo">

                                {{banner.conteudo.titulo}}

                            </span>
                        </td>
                        <td>{{banner.local}}</td>
                        <td>
                            <button type="button" class="btn btn-primary glyphicon glyphicon-edit btn-sm" data-toggle="modal" data-target="#modBanner" @click="updatemodbanner(banner)"></button>
                            <button type="button" class="btn btn-danger glyphicon glyphicon-trash btn-sm" data-toggle="modal" data-target="#delBanner" @click="updatedelbanner(banner)"></button>                            
                        </td>
                    </tr>
                </tbody>
            </table>

        </div>

        <button type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#addbanner" data-backdrop="static">Cadastrar Banner</button>

        <!-- Modal Cria Banner-->
        <div class="modal fade" id="addbanner" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Cadastrar Banner</h4>
                    </div>
                    <div class="modal-body">

                        <div class="form-group">
                            <label>Titulo</label>
                            <input type="text" class="form-control" placeholder="Titulo" v-model="addBanner.banner.titulo">
                        </div>
                        <div class="form-group">
                            <label>Ativo</label>
                            <input type="checkbox" v-model="addBanner.banner.ativo"/>
                        </div>
                        <div class="form-group">
                            <label>Data Início</label>
                            <input type="date" class="form-control" v-model="addBanner.banner.dataInicio"/>
                        </div>
                        <div class="form-group">
                            <label>Data Fim</label>
                            <input type="date" class="form-control" v-model="addBanner.banner.dataFim"/>
                        </div>

                        <div class="form-group">
                            <label>Local Banner</label>
                            <select class="form-control" v-model="addBanner.banner.local">
                                <option v-for="bannerlocal in bannerLocalList" v-bind:value="bannerlocal">
                                    {{bannerlocal}}
                                </option>
                            </select>
                        </div>

                        <div class="form-group">                            
                            <input id="linkconteudo" type="checkbox" v-model="checkedconteudo"/>
                            <label for="linkconteudo">Linkar Conteudo</label>
                        </div>

                        <div class="form-group" v-if="checkedconteudo">
                            <label>Conteudo</label>
                            <select class="form-control" v-model="addBanner.banner.conteudo.id">
                                <option v-for="conteudo in conteudos" v-bind:value="conteudo.id">
                                    {{conteudo.titulo}}
                                </option>
                            </select>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                        <button type="button" class="btn btn-primary" @click="addbanner()">Cadastrar</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal modifica banner-->
        <div class="modal fade" id="modBanner" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Modifica Banner</h4>
                    </div>
                    <div class="modal-body">

                        <div class="form-group">
                            <label>Titulo</label>
                            <input type="text" class="form-control" placeholder="Titulo" v-model="modiBanner.banner.titulo">
                        </div>
                        <div class="form-group">
                            <label>Ativo</label>
                            <input type="checkbox" v-model="modiBanner.banner.ativo"/>
                        </div>
                        <div class="form-group">
                            <label>Data Início</label>
                            <input type="date" class="form-control" v-model="dateInput(modiBanner.banner.dataInicio)"/>
                        </div>
                        <div class="form-group">
                            <label>Data Fim</label>
                            <input type="date" class="form-control" v-model="dateInput(modiBanner.banner.dataFim)"/>
                        </div>
                        <div class="form-group">
                            <label>Local Banner</label>
                            <select class="form-control" v-model="modiBanner.banner.local">
                                <option v-for="bannerlocal in bannerLocalList" v-bind:value="bannerlocal">
                                    {{bannerlocal}}
                                </option>
                            </select>
                        </div>

                        <div class="form-group">                            
                            <input id="linkconteudo" type="checkbox" v-model="checkedconteudo"/>
                            <label for="linkconteudo">Linkar Conteudo</label>
                        </div>

                        <div class="form-group" v-if="checkedconteudo">
                            <label>Conteudo</label>
                            <select class="form-control" v-model="seconteudo">
                                <option v-for="conteudo in conteudos" v-bind:value="conteudo">
                                    {{conteudo.titulo}}
                                </option>
                            </select>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                        <button type="button" class="btn btn-primary" @click="modbanner()">Modificar</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal exclui banner-->
        <div class="modal fade" id="delBanner" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Excluir Banner</h4>
                    </div>
                    <div class="modal-body">

                        Você deseja excluir <label>{{delBanner.banner.titulo}}</label>?

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                        <button type="button" class="btn btn-danger" @click="delbanner()">Excluir</button>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <script src="${pageContext.request.contextPath}/resources/vue-components/banner.js"></script>

</div>