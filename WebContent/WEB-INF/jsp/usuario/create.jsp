<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator"%>
<style>

    body {

        background: url('${pageContext.request.contextPath}/resources/images/Fundo.jpg') center center no-repeat fixed ;

        -webkit-background-size: 100% 100% !important;
        -moz-background-size: 100% 100% !important;
        -o-background-size: 100% 100% !important;
        background-size: 100% 100% !important;

    }

    #formAuth {

        margin-top: 10% !important;
        margin-left: 5% !important;
        height: 40% !important;
        width: 40% !important;
        background: url('${pageContext.request.contextPath}/resources/images/FundoAuth.png') center center no-repeat fixed;
        -webkit-background-size: cover !important;
        -moz-background-size: cover !important;
        -o-background-size: cover !important;
        background-size: cover !important;
        display: table !important;
        opacity: 0.80;      

    }    

</style>

<div id="formAuth">

    <form action="${linkTo[UsuarioController].login}" method="post" style="margin-top: 20px; margin-left: 20px;">

        <div>

            <h1 style="color: #003245;">Bem-Vindo ao Portal Efika</h1>

            <p style="color: white;">Lorem ipsum dolor sit amet, 
                consectetur adipiscing elit. Aliquam suscipit quis libero in placerat.</p>

            <h2 style="color: #003245;">Acesso: </h2>

        </div>        

        <div>

            <div style="float: left; width: 65%;">

                <div class="form-group">
                    <label for="login" style="color: white;">Usuário</label> <input
                        type="text" class="form-control" id="login" name="u.login"
                        placeholder="Login">
                </div>
                <div class="form-group">
                    <label for="senha" style="color: white;">Senha</label> <input
                        type="password" class="form-control" id="senha" name="u.senha"
                        placeholder="Senha">
                </div>

            </div>

            <div style="float: right; width: 30%;">

                <button type="submit" class="btn btn-primary" style="width: 90%;">Entrar</button>
                <br/>
                <!--<a href="#" style="color: white;">Esqueceu sua senha?</a>-->

            </div>

            <div class="container" style="float: left; width: 65%; height: 40px;">

                <c:if test="${not empty mensagem}">
                    <span class="alert alert-success" role="alert"> <span
                            class="glyphicon glyphicon glyphicon-ok" aria-hidden="true"></span>
                        ${mensagem}
                    </span>
                </c:if>
                <c:if test="${not empty mensagemFalha}">
                    <span class="alert alert-danger" role="alert">
                        <span class="glyphicon glyphicon glyphicon-remove" aria-hidden="true"></span> 
                        ${mensagemFalha}
                    </span>
                </c:if>  

            </div>

        </div>       

    </form>   

</div>

</div>
