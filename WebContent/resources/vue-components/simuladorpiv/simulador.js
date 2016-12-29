/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var pivURL = "http://localhost:8080/pivAPI/operador/simulador/";
var sessionURL = "/session/";

var data = {}

var Form = {
    template:
            '<div class=\"row\">\r\n\r\n    <div class=\"col-xs-3\">\r\n        <div class=\"form-group\">\r\n            <label for=\"fcr\">FCR<\/label>\r\n            <div class=\"input-group\">\r\n                <input id=\"fcr\" type=\"number\" min=\"0\" max=\"100\" class=\"form-control\" placeholder=\"FCR\" aria-describedby=\"fcr-addon1\">\r\n                <span class=\"input-group-addon\" id=\"fcr-addon1\">%<\/span>\r\n            <\/div>\r\n        <\/div>\r\n    <\/div>\r\n\r\n\r\n    <div class=\"col-xs-3\">\r\n        <div class=\"form-group\">\r\n            <label for=\"adr\">Ader\u00EAncia<\/label>\r\n            <div class=\"input-group\">\r\n                <input id=\"adr\" type=\"number\" min=\"0\" max=\"100\" class=\"form-control\" placeholder=\"Ader\u00EAncia\" aria-describedby=\"adr-addon1\">\r\n                <span class=\"input-group-addon\" id=\"adr-addon1\">%<\/span>\r\n            <\/div>\r\n        <\/div>\r\n    <\/div>\r\n\r\n    <div class=\"col-xs-3\">\r\n        <div class=\"form-group\">\r\n            <label for=\"monitoria\">Monitoria<\/label>\r\n            <div class=\"input-group\">\r\n                <input id=\"monitoria\" type=\"number\" min=\"0\" max=\"100\" class=\"form-control\" placeholder=\"Monitoria\" aria-describedby=\"fcr-addon1\">\r\n                <span class=\"input-group-addon\" id=\"monitoria-addon1\"><span class=\"glyphicon glyphicon-headphones\" aria-hidden=\"true\"><\/span><\/span>\r\n            <\/div>\r\n        <\/div>\r\n    <\/div>\r\n\r\n    <div class=\"col-xs-3\">\r\n        <div class=\"form-group\">\r\n            <label for=\"tma\">TMA<\/label>\r\n            <div class=\"input-group\">\r\n                <input id=\"tma\" type=\"time\" class=\"form-control\" placeholder=\"TMA\" aria-describedby=\"tma-addon1\">\r\n                <span class=\"input-group-addon\" id=\"basic-tma\"><span class=\"glyphicon glyphicon-dashboard\" aria-hidden=\"true\"><\/span><\/span>\r\n            <\/div>\r\n        <\/div>\r\n    <\/div>\r\n\r\n\r\n    <div class=\"col-xs-3\">\r\n        <div class=\"form-group\">\r\n            <label for=\"tma\">GPS<\/label>\r\n            <div class=\"input-group\">\r\n                <input id=\"gps\" type=\"time\" class=\"form-control\" placeholder=\"GPS\" aria-describedby=\"tma-addon1\">\r\n                <span class=\"input-group-addon\" id=\"basic-tma\"><span class=\"glyphicon glyphicon-list-alt\" aria-hidden=\"true\"><\/span><\/span>\r\n            <\/div>\r\n        <\/div>\r\n    <\/div>\r\n\r\n\r\n    <div class=\"col-xs-6\">\r\n        <div class=\"panel panel-default\">\r\n            <div class=\"panel-heading\">\r\n                <span class=\"panel-title\">Atingimento<\/span>\r\n            <\/div>\r\n            <div class=\"panel-body\">\r\n                <h2 class=\"text-center\">78%<\/h2>\r\n            <\/div>\r\n        <\/div>\r\n    <\/div>\r\n\r\n    <div class=\"col-xs-3\">\r\n        <button type=\"button\" class=\"btn btn-warning\">Limpar<\/button>\r\n    <\/div>\r\n\r\n<\/div>'

}

new Vue({
el: '#piv',
        data: {
        usuario: {piv:
        },
                mounted: function() {
                var self = this;
                        self.loadSession();
                        setTimeout(function() {
                        console.log(self.usuario.login)
                                self.loadIndicadores();
                        }, 200)
                },
                components: {
                'simulador-form': Form
                },
                methods: {
                loadSession: function() {
                var self = this;
                        $.get(sessionURL, function(data) {
                        self.usuario = data.usuario;
                        });
                },
                        loadIndicadores: function() {
                        var self = this;
                                $.get(pivURL + self.usuario.login, function(data) {
                                self.usuario.piv = data.calculoPivFacade;
                                        console.log(self.usuario)
                                });
                        }
                }
        })