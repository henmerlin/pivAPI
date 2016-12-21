<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator"%>
<style>
    body{
        background-color: rgb(236,231,225);
    }
</style>

<div id="allBanners" style="margin-top: -20px;">
    <div id="bannerGrande">        
        <ul id="lsgra">
            <li v-for="gbanner in bannersGrandes">
                <img :src="gbanner.imagem.base64" style="width: 100%;">                
            </li>            
        </ul>
    </div>
    <div id="bannerPequeno">
        <ul id="lspeq">
            <li v-for="pbanner in bannersPequenos">
                <img :src="pbanner.imagem.base64" style="width: 350px; height: 350px;"/>
            </li>
        </ul>
    </div>
    <br>
    <br>
    <div class="row">
        <div class="col-md-6">
            <img style="width: 100%;" src="${pageContext.request.contextPath}/resources/images/aniversariantes.png"/>
        </div>
        <div class="col-md-6">
            <img style="width: 100%;" src="${pageContext.request.contextPath}/resources/images/mensagem_super.png"/>
        </div>
    </div>
</div>
<br>
<br>
<div class="footer">Portal Efika - Centro de Operações</div>

<script src="${pageContext.request.contextPath}/resources/vue-components/templateBanner.js"></script>