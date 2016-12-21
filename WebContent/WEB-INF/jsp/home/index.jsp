<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator"%>
<style>
    body{
        background-color: rgb(236,231,225);
    }
</style>

<div id="allBanners">
    <div id="bannerGrande">
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox">              
                <div class="item" :class="{active: index == 0}" v-for="(gbanner, index) of bannersGrandes">
                    <img :src="gbanner.imagem.base64" style="width: 100%; height: 500px;">
                </div>
            </div>
            <!-- Controls -->
            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>    
    <br>
    <br>
    <div id="bannerPequeno">
        <ul id="idbanPeq" onload="ls();">
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