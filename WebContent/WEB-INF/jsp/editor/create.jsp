<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator"%>

<div class="container">
    <div class="page-header">
        <h1>Editor</h1>
    </div>
    <div id="editor">
        <div class="row">
            <div class="col-md-12">
                <h4>Abas</h4>
                <div>
                    <table class="table table-bordered small">
                        <thead>
                            <tr>
                                <th>Título</th>
                                <th>Ativa</th>
                                <th>Ações</th>
                            </tr>
                        </thead>
                        <tbody>

                            <tr v-for="aba in abas" v-bind:class="{ active: activedAba == aba}" :key="aba.id">

                                <td class="view" v-if="aba != editedAba" @dblclick="editAba(aba)">
                                    <label>{{ aba.titulo }}</label>
                                </td>

                                <td v-if="aba == editedAba">
                                    <input class="form-control" type="text"
                                           v-model="aba.titulo"
                                           @blur="doneEditAba(aba)">
                                </td>

                                <td>
                                    <input type="checkbox" v-model="aba.ativo" @change="doneEditAba(aba)"></input>
                                </td>

                                <td>
                                    <button class="btn btn-primary glyphicon glyphicon-th-list btn-sm" @click="selectAba(aba)"></button>
                                    <button class="btn btn-danger glyphicon glyphicon-trash btn-sm" @click="clickDeleteAba(aba)" data-toggle="modal" data-target="#modalAba"></button>
                                </td>

                            </tr>
                        </tbody>
                    </table>
                    <button class="btn btn-success btn-xs" @click="novaAba">Adicionar</button>
                    <br>
                </div>
            </div>
            <div class="col-md-12"><p></p></div>
            <div class="col-md-12">
                <div v-if="activedAba">
                    <hr>
                    <h4>SubAbas <span v-text="activedAba.titulo"></span></h4>
                    <table class="table table-bordered small">
                        <thead>
                            <tr>
                                <th>Título</th>
                                <th>Ativa</th>
                                <th>Ações</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="subAba in activedAba.subAbas" v-bind:class="{ active: activedSubAba == subAba}" :key="subAba.id">

                                <td class="view" v-if="subAba != editedSubAba" @dblclick="editSubAba(subAba)" @click="selectSubAba(subAba)">
                                    <label>{{ subAba.titulo }}</label>
                                </td>

                                <td v-if="subAba == editedSubAba">
                                    <input class="form-control" type="text"
                                           v-model="subAba.titulo"
                                           @blur="doneEditSubAba(subAba)">
                                </td>

                                <td>
                                    <input type="checkbox" v-model="subAba.ativo" @change="doneEditSubAba(subAba)"></input>
                                </td>

                                <td>
                                    <button class="btn btn-primary glyphicon glyphicon-th-list btn-sm" @click="selectSubAba(subAba)"></button>
                                    <button class="btn btn-danger glyphicon glyphicon-trash btn-sm" @click="clickDeleteSubAba(subAba)" data-toggle="modal" data-target="#modalSubAba"></button>
                                </td>

                            </tr>
                        </tbody>
                    </table>
                    <button class="btn btn-success btn-xs" @click="novaSubAba">Adicionar</button>
                    <br>
                </div>
            </div>

            <! -- CONTEUDO -->
            <div class="col-md-12">
                <div v-if="activedSubAba">
                    <hr>
                    <h4>Conteúdos <span v-text="activedConteudo.titulo"></span></h4>
                    <table class="table table-bordered small">
                        <thead>
                            <tr>
                                <th>Título</th>
                                <th>Ativo</th>
                                <th>Ações</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="conteudo in activedSubAbas.conteudos" v-bind:class="{ active: activedConteudo == conteudo}" :key="conteudo.id">

                                <td class="view" v-if="conteudo != editedConteudo" @dblclick="editConteudo(conteudo)" @click="selectConteudo(conteudo)">
                                    <label>{{ conteudo.titulo }}</label>
                                </td>

                                <td v-if="conteudo == editedConteudo">
                                    <input class="form-control" type="text"
                                           v-model="conteudo.titulo"
                                           @blur="doneEditConteudo(conteudo)">
                                </td>

                                <td>
                                    <input type="checkbox" v-model="conteudo.ativo" @change="doneEditConteudo(conteudo)"></input>
                                </td>

                                <td>
                                    <button class="btn btn-primary glyphicon glyphicon-th-list btn-sm" @click="selectConteudo(conteudo)"></button>
                                    <button class="btn btn-danger glyphicon glyphicon-trash btn-sm" @click="clickDeleteConteudo(conteudo)" data-toggle="modal" data-target="#modalSubAba"></button>
                                </td>

                            </tr>
                        </tbody>
                    </table>
                    <button class="btn btn-success btn-xs" @click="novoConteudo">Adicionar</button>
                    <br>
                </div>
            </div>
        </div>


        <!-- Modal -->
        <div class="modal fade" id="modalAba" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"  v-if="deletedAba">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Excluir </h4>
                    </div>
                    <div class="modal-body">
                        Deseja excluir a Aba  <strong v-html="deletedAba.titulo"></strong> e suas respectivas SubAbas?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                        <button type="button" class="btn btn-danger" @click="doneDeleteAba" data-dismiss="modal">Excluir</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal SubAba -->
        <div class="modal fade" id="modalSubAba" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"  v-if="deletedSubAba">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Excluir </h4>
                    </div>
                    <div class="modal-body">
                        Deseja excluir a SubAba  <strong v-html="deletedSubAba.titulo"></strong> e seus respectivos conteúdos?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                        <button type="button" class="btn btn-danger" @click="doneDeleteSubAba" data-dismiss="modal">Excluir</button>
                    </div>
                </div>
            </div>
        </div>



        <!-- Modal SubAba -->
        <div class="modal fade" id="modalConteudo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"  v-if="deletedConteudo">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Excluir </h4>
                    </div>
                    <div class="modal-body">
                        Deseja excluir o Conteúdo <strong v-html="deletedConteudo.titulo"></strong>?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                        <button type="button" class="btn btn-danger" @click="doneDeleteConteudo" data-dismiss="modal">Excluir</button>
                    </div>
                </div>
            </div>
        </div>


    </div>
    <script src="${pageContext.request.contextPath}/resources/vue-components/editor.js"></script>
