<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator"%>
<style>

    body {
        background: url('${pageContext.request.contextPath}/resources/images/Fundo.jpg') center center no-repeat fixed ;
        width: 100%;
        -webkit-background-size: 100% 100% !important;
        -moz-background-size: 100% 100% !important;
        -o-background-size: 100% 100% !important;
        background-size: 100% 100% !important;
    }

    #formAuth {
        margin-top: 10% !important;
        margin-left: 5% !important;
        background-color: #999999;
        opacity: 0.7;
        display: inline-block;
    }

    .azul{
        color: #003245;
    }

</style>

<div id="formAuth" style="padding: 3%;">

    <form action="${linkTo[UsuarioController].login}" method="post">

        <div class="row azul">
            <div class="col-md-12"><h1>Bem-Vindo ao Portal Efika</h1></div>
            <div class="col-md-12">
                <p style="color: white;">Lorem ipsum dolor sit amet,
                    consectetur adipiscing elit. Aliquam suscipit quis libero in placerat.</p>
            </div>
        </div>


        <div class="row azul">
            <div class="col-md-12 azul">
                <h2 style="color: #003245;">Acesso: </h2>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <div class="form-group">
                    <label for="login" style="color: white;">Usuário</label>
                    <input
                        type="text" class="form-control" id="login" name="u.login"
                        placeholder="Login">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <div class="form-group">
                    <label for="senha" style="color: white;">Senha</label>
                    <input
                        type="password" class="form-control" id="senha" name="u.senha"
                        placeholder="Senha">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <button type="submit" class="btn btn-primary">Entrar</button>
            </div>
        </div>

        <br>
        <div>
            <c:if test="${not empty mensagemFalha}">
                <span class="alert alert-danger" role="alert">
                    <label class="glyphicon glyphicon glyphicon-remove" aria-hidden="true"></label>
                    ${mensagemFalha}
                </span>
            </c:if>
        </div>
    </form>
</div>
