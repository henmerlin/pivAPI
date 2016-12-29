<%--
    Document   : create
    Created on : 08/12/2016, 17:50:36
    Author     : G0034481
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator"%>
<div class="container">

    <div class="page-header">
        <h1>Simulador PIV</h1>
    </div>

    <div id="piv" v-cloak>
        <simulador-form></simulador-form>
    </div>

    <script src="${pageContext.request.contextPath}/resources/vue-components/simuladorpiv/simulador.js"></script>

</div>