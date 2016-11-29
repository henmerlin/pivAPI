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
                <div class="list-group">
                    <label v-model="aba.titulo" v-bind:contenteditable="{true: aba == editedAba, false: aba != editedAba}" @blur="doneEditAba(aba)" @dblclick="editAba(aba)" v-for="aba in abas" class="list-group-item">
                        {{aba.titulo}}
                    </label>
                </div>
            </div>
            <div class="col-md-5">

                <h4>SubAbas</h4>
                <div id="editorSubAbas" class="list-group">
                    <a href="#" class="list-group-item">Dapibus ac facilisis in</a>
                    <a href="#" class="list-group-item">Morbi leo risus</a>
                    <a href="#" class="list-group-item">Porta ac consectetur ac</a>
                    <a href="#" class="list-group-item">Vestibulum at eros</a>
                </div>
            </div>

            <div class="col-md-2"></div>
        </div>
        <button class="btn btn-success btn-xs" @click="adicionarAba">Adicionar</button>
    </div>



    <script>

        apiURL = "${pageContext.request.contextPath}/comunicacao/aba/";

        new Vue({
            el: '#editor',
            data: {
                abas: null,
                editedAba: null,
            },
            created: function() {
                this.fetchData()
            },
            methods: {
                fetchData: function() {
                    var self = this;
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
