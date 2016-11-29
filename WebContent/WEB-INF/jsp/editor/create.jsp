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
            <div class="col-md-5">
                <h4>Abas</h4>
                <div>


                    <table class="table table-bordered">
                        <tr v-for="aba in abas" class="list-group-item" v-bind:class="{ active: activedAba == aba}"
                            :key="aba.id">
                            <td class="view" v-if="aba != editedAba" @dblclick="editAba(aba)" @click="selectAba(aba)">
                                <label>{{ aba.titulo }}</label>
                            </td>
                            <td>
                                <input type="checkbox" v-model="aba.ativo" @change="doneEditAba(aba)"></input>
                            </td>
                            <td>
                                <input class="form-control" type="text" v-if="aba == editedAba"
                                       v-model="aba.titulo"
                                       @blur="doneEditAba(aba)"
                                       @keyup.enter="doneEditAba(aba)">
                            </td>
                    </table>

                </div>
            </div>
            <div class="col-md-5">

                <h4>SubAbas</h4>





            </div>

            <div class="col-md-2"></div>
        </div>
        <button class="btn btn-success btn-xs" @click="adicionarAba">Adicionar</button>
    </div>

    <script>

        var apiURL = "${pageContext.request.contextPath}/comunicacao/aba/";

        new Vue({
            el: '#editor',
            data: {
                abas: null,
                editedAba: null,
                activedAba: null
            },
            created: function() {
                this.fetchData()
            },
            methods: {
                fetchData: function() {
                    var self = this;

                    self.editedAba = null;
                    self.activedAba = null;

                    $.get(apiURL, function(data) {
                        self.abas = data.list;
                    })
                },
                adicionarAba: function() {
                    var self = this;
                    $.post("${pageContext.request.contextPath}/abaPortal/adiciona")

                    setTimeout(function() {
                        self.fetchData()
                    }, 600)
                },
                editAba: function(h) {
                    var self = this
                    self.editedAba = h;
                    console.log(h);
                },
                selectAba: function(h) {
                    var self = this
                    self.activedAba = h
                },
                doneEditAba: function(h) {
                    var self = this;

                    $.ajax({
                        type: "POST",
                        url: "${pageContext.request.contextPath}/abaPortal/atualiza",
                        data: JSON.stringify({"abaPortal":
                                    {
                                        "id": h.id,
                                        "titulo": h.titulo,
                                        "ativo": h.ativo
                                    }
                        }),
                        dataType: "json",
                        beforeSend: function(xhrObj) {
                            xhrObj.setRequestHeader("Content-Type", "application/json");
                        },
                        success: function(json) {
                            setTimeout(function() {
                                self.fetchData()
                            }, 600)
                        }
                    });

                    self.editedAba = null;
                }
            }
        })

    </script>
