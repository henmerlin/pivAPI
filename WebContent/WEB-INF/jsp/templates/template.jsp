<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title><decorator:title default="Portal Efika"/></title>
        <meta charset="utf-8">

        <!-- import CSS -->
        <link
            href="${pageContext.request.contextPath}/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css"
            rel="stylesheet" />
        <link
            href="${pageContext.request.contextPath}/resources/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css"
            rel="stylesheet" />
        <link
            href="${pageContext.request.contextPath}/resources/custom/custom.css" rel="stylesheet" />

        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/node_modules/element-ui/lib/theme-default/index.css">


        <!-- import JavaScript -->
        <script
        src="${pageContext.request.contextPath}/resources/node_modules/vue/dist/vue.js"></script>
        <script
        src="${pageContext.request.contextPath}/resources/custom/components.js"></script>
        <script src="${pageContext.request.contextPath}/resources/node_modules/element-ui/lib/index.js"></script>
        <script
        src="${pageContext.request.contextPath}/resources/jquery-3.1.1/jquery-3.1.1.min.js"></script>
        <script
        src="${pageContext.request.contextPath}/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

        <style>

            .navbar-telefonica{

                width: 100% !important;
                height: 100% !important;
                background-image:url('${pageContext.request.contextPath}/resources/images/header.jpg');

            }

        </style>

        <decorator:head/>
    </head>
    <body>



        <nav class="navbar-telefonica">
            <img class="telefonicaLogo" src="${pageContext.request.contextPath}/resources/images/logo.png"/>
        </nav>

        <c:if test="${sessionUsuarioEfika.logado}">

            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li><a href="#">Link <span class="sr-only">(current)</span></a></li>
                            <li><a href="#">Link</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                                <ul class="dropdown-menu">

                                    <li><a href="#">Action</a></li>
                                    <li><a href="#">Another action</a></li>
                                    <li><a href="#">Something else here</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#">Separated link</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#">One more separated link</a></li>

                                </ul>
                            </li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">


                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                    <span class="glyphicon glyphicon-cog " aria-hidden="true"></span> Administração <span class="caret"></span></a>
                                <ul class="dropdown-menu">

                                    <li><a href="${linkTo[UsuarioController].logout()}">${sessionUsuarioEfika.usuario.login}, Sair</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="${linkTo[EditorController].create()}">Editor</a></li>
                                    <li><a href="#">Another action</a></li>
                                    <li><a href="#">Something else here</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#">Separated link</a></li>

                                </ul>
                            </li>


                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>

        </c:if>

        <div>
            <decorator:body/>
        </div>
        <!-- /container -->

    </body>
</html>