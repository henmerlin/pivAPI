<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator"%>

<div class="container">
    <div class="page-header">
        <h1>Editor</h1>
    </div>

    <div id="tinymce-form" v-cloak>
        <fieldset class="form-group">
            <textarea
                class="form-control"
                id="editor"
                rows="10"
                placeholder="Content"
                v-tinymce-editor="content">
            </textarea>
        </fieldset>
        <div v-html="content"></div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/vue1/vue1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/node_modules/tinymce/tinymce.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/vue-components/editorHtml.js"></script>