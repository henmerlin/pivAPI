<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator"%>


<div class="container">

    <div class="page-header">
        <h1>Editor</h1>
    </div>

    <div id="editor">

        <div class="row">

            <div class="col-md-5">
                <h4>Aba</h4>
                <div id="editorAbas" class="list-group">
                    <a href="#" class="list-group-item">Dapibus ac facilisis in</a>
                    <a href="#" class="list-group-item">Morbi leo risus</a>
                    <a href="#" class="list-group-item">Porta ac consectetur ac</a>
                    <a href="#" class="list-group-item">Vestibulum at eros</a>
                </div>
            </div>
            <div class="col-md-5">
                <h4>SubAbas</h4>
                <div id="editorSubAbas" class="list-group">
                    <a href="#" class="list-group-item">Dapibus ac facilisis in</a>
                    <a href="#" class="list-group-item">Morbi leo risus</a>
                    <a href="#" class="list-group-item">Porta ac consectetur ac</a>
                    <a href="#" class="list-group-item">Vestibulum at eros</a>
                </div>
            </div>

            <div class="col-md-2"></div>

        </div>


    </div>


    <script>
        var editorAbas = new Vue({
            el: '#editorAbas',
            data: {
                abas: [
                    {imagem: '1_350x.jpg', alt: '1_350x'},
                    {imagem: '2_350x.jpg', alt: '2_350x'},
                    {imagem: '3_350x.jpg', alt: '3_350x'}
                ]
            },
            methods: {
                vai: function(h) {
                    alert(h.alt)
                }
            }
        })
    </script>


</div>

