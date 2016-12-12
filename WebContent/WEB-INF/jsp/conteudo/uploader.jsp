<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator"%>

<div class="container">
    <div class="page-header">
        <h1>Uploader</h1>
    </div>

    <div id="app">
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
        {{image}}
    </div>

</div>
<script src="${pageContext.request.contextPath}/resources/vue-components/uploader.js"></script>
