<%-- 
    Document   : list
    Created on : 22/12/2016, 10:06:46
    Author     : G0034481
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator"%>
<div class="container">

    <div class="page-header">
        <h1>${conteudo.titulo}</h1>
        <h3>${conteudo.categoria.titulo}</h3>
    </div>
    <div id="conteudo">
        <div style="width: 100%;">
            <img align="left" src="${conteudo.imagem.base64}" class="img-rounded" style="width: 40%; margin-right: 20px; margin-bottom: 0.5px;"/>

            <div class="text-justify">${conteudo.texto}</div>
        </div>       
    </div>
</div>