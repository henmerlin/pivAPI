<%-- 
    Document   : create
    Created on : 09/12/2016, 10:11:55
    Author     : G0034481
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator"%>

<div class="container">

    <div class="page-header">
        <h1>Conteudo categoria</h1>
    </div>

    <div id="conteduocategoria">

        <table class="table table-bordered">

            <thead>                
                <tr>                    
                    <th>Nome</th>
                    <th>Ativo</th>
                    <th>Ações</th>                    
                </tr>                
            </thead>
            <tbody>
                <tr v-for="categoria in categorias" :key="categoria.id">
                    <td>{{categoria.titulo}}</td>
                    <td>
                        <label v-if="categoria.ativo == true" >Ativo</label>
                        <label v-if="categoria.ativo == false" >Inativo</label>
                    </td>
                    <td>                        
                        <button type="button" class="btn btn-primary glyphicon glyphicon-edit btn-sm" data-toggle="modal" data-target="#modConteudo" @click="updateModConteudo(categoria)"></button>
                        <button type="button" class="btn btn-danger glyphicon glyphicon-trash btn-sm" data-toggle="modal" data-target="#excluiConteudo" @click="updateDelConteudo(categoria)"></button>                        
                    </td>
                </tr>
            </tbody>            
        </table>

        <br />

        <button type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#criaConteudo">Cadastrar categoria</button>

        <!-- Modal Cria Conteudo-->
        <div class="modal fade" id="criaConteudo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Cadastrar Categoria</h4>
                    </div>
                    <div class="modal-body">

                        <div class="form-group">
                            <label>Titulo</label>
                            <input type="text" class="form-control" placeholder="Titulo" v-model="addcategoria.categoria.titulo">
                        </div>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" v-model="addcategoria.categoria.ativo"> Ativo
                            </label>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                        <button type="button" class="btn btn-primary" @click="adicionaCategoria()">Cadastrar</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal Excluir Categoria-->
        <div class="modal fade" id="excluiConteudo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Excluir</h4>
                    </div>
                    <div class="modal-body">

                        Você realmente deseja excluir <strong v-html="delcategoria.categoria.titulo"></strong>?

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                        <button type="button" class="btn btn-danger" @click="excluiConteudo()">Excluir</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="modConteudo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Modificar Categoria</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label>Titulo</label>
                            <input type="text" class="form-control" placeholder="Titulo" v-model="modcategoria.categoria.titulo">
                        </div>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" v-model="modcategoria.categoria.ativo"> Ativo
                            </label>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                        <button type="button" class="btn btn-primary" @click="modificaConteudo()">Modificar</button>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <script src="${pageContext.request.contextPath}/resources/vue-components/conteudocategoria.js"></script>

</div>