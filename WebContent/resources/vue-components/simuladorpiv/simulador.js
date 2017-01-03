

var pivURL = "http://localhost:8080/pivAPI/operador/simulador/";
var pivURL2 = "http://localhost:8080/pivAPI/operador/simuladorChange/";
var sessionURL = "/session/";
var data =
        {
            currentViewForm: 'dados-form',
            "fcr": {"nome": "FCR"},
            "adr": {"nome": "ADERENCIA"},
            "monitoria": {"nome": "MONITORIA"},
            "tma": {"nome": "TMA"},
            "gps": {"nome": "GPS"},
            show: false,
            usuario: {
                piv:
                        {
                            op: {
                                "loginOperador": null,
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
                            ,
                            "indicadores": [
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
    template: '#simulator',
    methods: {
        getTarget: function() {
            var self = this;

            var simulator =
                    {"s": {op: self.vm.piv.op},
                        "fcr": {nome: "FCR", "realizado": (self.vm.fcr / 100)},
                        "adr": {nome: "ADERENCIA", "realizado": (self.vm.adr / 100)},
                        "tma": {nome: "TMA", "realizado": moment.duration(self.vm.tma, "HH:mm:ss").asSeconds()},
                        "monitoria": {nome: "MONITORIA", "realizado": (self.vm.monitoria / 100)},
                        "gps": {nome: "GPS", "realizado": (self.vm.gps / 100)},
                    };

            $.ajax({
                type: "POST",
                data: JSON.stringify(simulator),
                url: pivURL2,
                dataType: "application/json",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: function(data) {
                    console.log(data)
                },
                complete: function(jqXHR, textStatus) {
                    console.log(jqXHR)
                }
            });
        }
    },
    data: function() {
        return data
    }
}

var FormCelula = {
    template: '#celula-form',
    data: function() {
        return data
    }
}

var DadosUsuario = {
    template: '#usuario-form',
    data: function() {
        return data
    }
}

var vm = new Vue({
    el: '#piv',
    data: data,
    created: function() {
        var self = this;
        self.loadSession();
    },
    components: {
        'simulador-form': Form,
        'celula-form': FormCelula,
        'dados-form': DadosUsuario
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
                },
                complete: function(jqXHR, textStatus) {
                    self.loadIndicadores();
                }
            });
        },
        loadIndicadores: function() {
            var self = this;

            $.get(pivURL + self.usuario.login, function(data) {
                self.usuario.piv = data.calculoPivFacade;
                self.vm.piv = data.calculoPivFacade;
                // FCR
                var _fcr = self.getIndicadorPorNome("FCR").realizado * 100;
                if (_fcr) {
                    self.vm.fcr = _fcr.toFixed(2);
                }

                // TMA
                var _tma = moment("1900-01-01 00:00:00").add(self.getIndicadorPorNome("TMA").realizado, 'seconds').format("HH:mm:ss");
                if (_tma) {
                    self.vm.tma = _tma;
                }

                // ADERENCIA
                var _adr = (self.getIndicadorPorNome("ADERENCIA").realizado * 100);
                if (_adr) {
                    self.vm.adr = _adr.toFixed(2);
                }

                // Exibe componentes
                self.show = true;
            });
        }
    }
})