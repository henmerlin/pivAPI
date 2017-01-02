<%-- 
    Document   : infoEnq
    Created on : 30/12/2016, 16:41:25
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

    <input id="enq" type="hidden" value="${enquete}"/>

    <div id="enquete" v-cloak>
        <div v-for="p in perguntasEnquetes">
            <label>{{p.titulo}}</label>
            <div style="margin-left: 35px;">
                <div v-if="p.tipoPergunta === 'Múltipla Escolha' ">
                    <div v-for="escolha in valores">
                        <div v-if="escolha.pergunta === p.titulo">
                            {{escolha.titulo}}: {{escolha.cont}}
                        </div>
                    </div> 
                </div>
                <div v-else>
                    <div v-for="(resposta, index) in respostas">
                        <div v-if="resposta.pergunta.titulo === p.titulo">
                            {{resposta.resposta}}                                     
                        </div>                                             
                    </div>
                </div>
            </div>
        </div>                
    </div>

    <script src="${pageContext.request.contextPath}/resources/vue-components/infoEnq.js"></script>

</div>