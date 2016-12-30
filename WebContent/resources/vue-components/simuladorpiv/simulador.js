/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var pivURL = "http://localhost:8080/pivAPI/operador/simulador/";
var sessionURL = "/session/";
var data =
        {usuario: {piv: {op: {"loginOperador": null,
                        "avaya": null,
                        "nome": "",
                        "nomeSupervisor": "",
                        "equipe": null,
                        "faltas": 0,
                        "diasTrabalhados": 0,
                        "totalIn": 0,
                        "sched": 0,
                        "chamadasAtendidas": 0,
                        "tempoFalado": 0,
                        "chamadasFCR": 0,
                        "rechamadasFCR": 0
                    }
                    , "indicadores": [
                        {"realizado": 0.95, "peso": 0.2, "atingimento": 2.0, "pontos": 0.4, "nome": "FCR"},
                        {"realizado": 346.0, "peso": 0.3, "atingimento": 2.0, "pontos": 0.6, "nome": "TMA"}],
                    "pontos": 1.0, "pesos": 0.5, "target": 0.0}},
            vm: {
                fcr: 0,
                tma: 0,
                gps: 0,
                monitoria: 0,
                adr: 0,
                piv: {op: {"loginOperador": null,
                        "avaya": null,
                        "nome": "",
                        "nomeSupervisor": "",
                        "equipe": "",
                        "faltas": 0,
                        "diasTrabalhados": 0,
                        "totalIn": 0,
                        "sched": 0,
                        "chamadasAtendidas": 0,
                        "tempoFalado": 0,
                        "chamadasFCR": 0,
                        "rechamadasFCR": 0
                    }
                    , "indicadores": [
                        {"realizado": 0.95, "peso": 0.2, "atingimento": 2.0, "pontos": 0.4, "nome": "FCR"},
                        {"realizado": 346.0, "peso": 0.3, "atingimento": 2.0, "pontos": 0.6, "nome": "TMA"}],
                    "pontos": 1.0, "pesos": 0.5, "target": 0.0}
            }
        }

var Form = {
    template:
            '<div class=\"row\">\n\
                <div class=\"col-xs-3\">\n\
                    <div class=\"form-group\">\n\
                        <label for=\"fcr\">FCR<\/label>\n\
                        <div class=\"input-group\">\n\
                            <input id=\"fcr\" type=\"number\" v-model=\"vm.fcr\" min=\"0\" max=\"100\" class=\"form-control\" placeholder=\"FCR\" aria-describedby=\"fcr-addon1\">\r\n                <span class=\"input-group-addon\" id=\"fcr-addon1\">%<\/span>\r\n            <\/div>\r\n        <\/div>\r\n    <\/div>\r\n\r\n\r\n    <div class=\"col-xs-3\">\r\n        <div class=\"form-group\">\r\n            <label for=\"adr\">Ader\u00EAncia<\/label>\r\n            <div class=\"input-group\">\r\n                <input id=\"adr\" v-model=\"vm.adr\" type=\"number\"  min=\"0\" max=\"100\" class=\"form-control\" placeholder=\"Ader\u00EAncia\" aria-describedby=\"adr-addon1\">\r\n                <span class=\"input-group-addon\" id=\"adr-addon1\">%<\/span>\r\n            <\/div>\r\n        <\/div>\r\n    <\/div>\r\n\r\n    <div class=\"col-xs-3\">\r\n        <div class=\"form-group\">\r\n            <label for=\"monitoria\">Monitoria<\/label>\r\n            <div class=\"input-group\">\r\n                <input v-model=\"vm.monitoria\"  id=\"monitoria\" type=\"number\" min=\"0\" max=\"100\" class=\"form-control\" placeholder=\"Monitoria\" aria-describedby=\"fcr-addon1\">\r\n                <span class=\"input-group-addon\" id=\"monitoria-addon1\"><span class=\"glyphicon glyphicon-headphones\" aria-hidden=\"true\"><\/span><\/span>\r\n            <\/div>\r\n        <\/div>\r\n    <\/div>\r\n\r\n    <div class=\"col-xs-3\">\r\n        <div class=\"form-group\">\r\n            <label for=\"tma\">TMA<\/label>\r\n            <div class=\"input-group\">\r\n                <input v-model=\"vm.tma\" id=\"tma\" type=\"time\" class=\"form-control\" placeholder=\"TMA\" aria-describedby=\"tma-addon1\">\r\n                <span class=\"input-group-addon\" id=\"basic-tma\"><span class=\"glyphicon glyphicon-dashboard\" aria-hidden=\"true\"><\/span><\/span>\r\n            <\/div>\r\n        <\/div>\r\n    <\/div>\r\n\r\n\r\n\r\n    <div class=\"col-xs-3\">\r\n        <div class=\"form-group\">\r\n            <label for=\"tma\">GPS<\/label>\r\n            <div class=\"input-group\">\r\n                <input v-model=\"vm.gps\" id=\"gps\" type=\"number\" min=\"0\" max=\"100\" class=\"form-control\" placeholder=\"GPS\" aria-describedby=\"tma-addon1\">\r\n                <span class=\"input-group-addon\" id=\"basic-tma\">%<\/span>\r\n            <\/div>\r\n        <\/div>\r\n    <\/div>\r\n\r\n\r\n    <div class=\"col-xs-6\">\r\n        <div class=\"panel panel-default\">\r\n            <div class=\"panel-heading\">\r\n                <span>Target<\/span>\r\n            <\/div>\r\n            <div class=\"panel-body\">\r\n                <h2 class=\"text-center\"><span v-text=\"vm.piv.target\"><\/span>%<\/h2>\r\n            <\/div>\r\n        <\/div>\r\n    <\/div>\r\n\r\n\r\n    <div class=\"col-xs-3\">\r\n        <button type=\"button\" class=\"btn btn-warning\">Limpar<\/button>\r\n    <\/div>\r\n\r\n<\/div>'
    , data: function() {
        return data
    }
}

var DadosUsuario = {
    template:
            '<table class=\"table small table-bordered table-condensed\">\r\n    <tbody>\r\n        <tr>\r\n            <th><label for=\"nome\">Nome:<\/label><\/th>\r\n            <td><span id=\"nome\" v-text=\"vm.piv.op.nome\"><\/span><\/td>\r\n        <\/tr>\r\n        <tr>\r\n            <th><label for=\"super\">Supervis\u00E3o:<\/label><\/th>\r\n            <td><span id=\"super\" v-text=\"vm.piv.op.nomeSupervisor\"><\/span><\/td>\r\n        <\/tr>\r\n\r\n        <tr>\r\n            <th><label for=\"equipe\">Equipe:<\/label><\/th>\r\n            <td><span id=\"equipe\" v-text=\"vm.piv.op.equipe\"><\/span><\/td>\r\n        <\/tr>\r\n    <\/tbody>\r\n<\/table>',
    data: function() {
        return data
    }
}

new Vue({
    el: '#piv',
    data: data,
    mounted: function() {
        var self = this;
        self.loadSession();
    },
    components: {
        'simulador-form': Form,
        'dados-user': DadosUsuario
    },
    methods: {
        getIndicadorPorNome: function(nome) {
            var self = this;
            var inds = self.usuario.piv.indicadores;
            for (i = 0; i < inds.length; i++) {
                if (inds[i].nome == nome) {
                    return inds[i];
                }
            }
        },
        loadSession: function() {
            var self = this;
            $.ajax({
                type: "GET",
                dataType: "json",
                url: sessionURL,
                success: function(data) {
                    self.usuario = data.usuario;
                }, complete: function(jqXHR, textStatus) {
                    self.loadIndicadores();
                }
            });
        },
        loadIndicadores: function() {
            var self = this;
            $.get(pivURL + self.usuario.login, function(data) {
                self.usuario.piv = data.calculoPivFacade;
                self.vm.piv = data.calculoPivFacade;
                var _fcr = self.getIndicadorPorNome("FCR").realizado * 100;
                if (_fcr) {
                    self.vm.fcr = _fcr;
                }

                var _tma = moment("1900-01-01 00:00:00").add(self.getIndicadorPorNome("TMA").realizado, 'seconds').format("HH:mm:ss");
                if (_tma) {
                    self.vm.tma = _tma;
                }

            });
        }
    }
})