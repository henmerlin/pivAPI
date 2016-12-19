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

            <table class="table table-bordered" style="text-align: center;">

                <thead>
                    <tr>
                        <th>Titulo</th>
                        <th>Ativo</th>
                        <th>Data Início</th>
                        <th>Data Fim</th>
                        <th>Data cricação</th>
                        <th>Conteudo</th>                        
                        <th>Local</th>
                        <th>Imagem</th>
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
                            <img :src="banner.imagem.base64" style="width: 50px;"/>
                        </td>
                        <td>
                            <button type="button" class="btn btn-primary glyphicon glyphicon-edit btn-sm" @click="updatemodbanner(banner)" data-toggle="modal" data-target="#modBanner" data-backdrop="static"></button>
                            <button type="button" class="btn btn-danger glyphicon glyphicon-trash btn-sm" @click="updatedelbanner(banner)" data-toggle="modal" data-target="#delbanner" data-backdrop="static"></button> 
                        </td>
                    </tr>
                </tbody>
            </table>

        </div>

        <button type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#addbanner" data-backdrop="static" @click="resetObjects()">Cadastrar Banner</button>

        <!-- Modal Cadastra Banner-->
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
                            <input type="text" class="form-control" placeholder="Titulo" v-model="addbanner.titulo">
                        </div>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" v-model="addbanner.ativo"> Ativo
                            </label>
                        </div>
                        <div class="form-group">
                            <label>Data Início</label>
                            <input id="datainicio" type="date" class="form-control" placeholder="Data início" v-model="addbanner.dataInicio">
                        </div>
                        <div class="form-group">
                            <label>Data Fim</label>
                            <input id="datafim" type="date" class="form-control" placeholder="Data Fim" v-model="addbanner.dataFim">
                        </div>
                        <div class="form-group">
                            <label>Local Banner</label>
                            <select class="form-control" v-model="addbanner.local">
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
                            <select class="form-control" v-model="addbanner.conteudo.id">
                                <option v-for="conteudo in conteudos" v-bind:value="conteudo.id">
                                    {{conteudo.titulo}}
                                </option>
                            </select>
                        </div>
                        <div v-if="!image">
                            <h4>Selecione uma imagem</h4>
                            <span class="btn btn-default">
                                <input type="file" @change="onFileChange">
                            </span>
                        </div>
                        <div v-else>
                            <img :src="image" style="width: 450px"/>
                            <br>
                            <br>
                            <button type="button" class="btn btn-default" type="file" @click="removeImage">
                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                            </button>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                        <button type="button" class="btn btn-primary" @click="adcbanner()">Cadastrar</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal Modifica Banner-->
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
                            <input type="text" class="form-control" placeholder="Titulo" v-model="modbanner.titulo">
                        </div>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" v-model="modbanner.ativo"> Ativo
                            </label>
                        </div>
                        <div class="form-group">
                            <label>Data Início</label>
                            <input id="datainicio" type="date" class="form-control" placeholder="Data início" v-model="dateInput(modbanner.dataInicio)">
                        </div>
                        <div class="form-group">
                            <label>Data Fim</label>
                            <input id="datafim" type="date" class="form-control" placeholder="Data Fim" v-model="dateInput(modbanner.dataFim)">
                        </div>
                        <div class="form-group">
                            <label>Local Banner</label>
                            <select class="form-control" v-model="modbanner.local">
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
                            <select class="form-control" v-model="seconteudo.conteudo.id">
                                <option v-for="conteudo in conteudos" v-bind:value="conteudo.id">
                                    {{conteudo.titulo}}
                                </option>
                            </select>
                        </div>
                        <div v-if="!image">
                            <h4>Selecione uma imagem</h4>
                            <span class="btn btn-default">
                                <input type="file" @change="onFileChange">
                            </span>
                        </div>
                        <div v-else>
                            <img :src="image" style="width: 450px"/>
                            <br>
                            <br>
                            <button type="button" class="btn btn-default" type="file" @click="removeImage">
                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                            </button>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                        <button type="button" class="btn btn-primary" @click="modibanner()">Modificar</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="delbanner" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Excluir banner</h4>
                    </div>
                    <div class="modal-body">
                        Deseja excluir o banner?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                        <button type="button" class="btn btn-danger" @click="deletbanner()">Excluir</button>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <script src="${pageContext.request.contextPath}/resources/vue-components/banner.js"></script>

</div>