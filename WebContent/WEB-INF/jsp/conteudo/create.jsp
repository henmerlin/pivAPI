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
        <h1>Conteudo</h1>
    </div>

    <div id="conteudo">

        <div class="row">

            <div class="col-md-12">

                <form>                    

                    <div class="form-group">
                        <label >Le Titulo</label>
                        <input type="text" class="form-control" placeholder="Le Titulo">
                    </div>
                    <div class="form-group">
                        <label>Aqtive</label>
                        <input type="checkbox" />
                    </div>
                    <div class="form-group">
                        <label >?Notifiqé?</label>
                        <input type="text" class="form-control" placeholder="?Notifiqé?">
                    </div>
                    <div class="form-group">
                        <label >?Tipe Conteude?</label>
                        <select class="form-control">
                            <option disabled="true" selected="true" >Selecione</option>
                            <option>Opcione uno</option>
                            <option>Opcione doise</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label >?Conteude de La Catigoria?</label>
                        <select class="form-control">
                            <option disabled="true" selected="true" >Selecione</option>
                            <option>Opcione uno</option>
                            <option>Opcione doise</option>
                        </select>
                    </div>

                </form>

            </div>

        </div>

    </div>

</div>