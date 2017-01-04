

var pivURL = "http://localhost:8080/pivAPI/operador/simulador/";
var pivURL2 = "http://localhost:8080/pivAPI/operador/simulador/change/";
var equipeURL = "http://localhost:8080/pivAPI/operador/simulador/equipes/";
var pivManualURL = "http://localhost:8080/pivAPI/operador/simulador/manual/";
var sessionURL = "/session/";

var data =
        {
            equipes: {},
            currentViewForm: 'dados-form',
            "fcr": {"nome": "FCR"},
            "adr": {"nome": "ADERENCIA"},
            "monitoria": {"nome": "MONITORIA"},
            "tma": {"nome": "TMA"},
            "gps": {"nome": "GPS"},
            show: false,
            usuario: {
                piv: {op: {"loginOperador": "",
                        "avaya": "",
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
                    },
                    "indicadores": [
                        {"realizado": 0.95, "peso": 0.2, "atingimento": 2.0, "pontos": 0.4, "nome": "FCR"},
                        {"realizado": 346.0, "peso": 0.3, "atingimento": 2.0, "pontos": 0.6, "nome": "TMA"}],
                    "pontos": 0, "pesos": 0.0, "target": 0.}},
            vm: {
                fcr: 0,
                tma: 0,
                gps: 0,
                monitoria: 0,
                adr: 0,
                piv: {
                    op: {
                        "loginOperador": "",
                        "avaya": "",
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
                    },
                    "indicadores": [
                        {"realizado": 0.95, "peso": 0.2, "atingimento": 2.0, "pontos": 0.4, "nome": "FCR"},
                        {"realizado": 346.0, "peso": 0.3, "atingimento": 2.0, "pontos": 0.6, "nome": "TMA"}],
                    "pontos": 0.0,
                    "pesos": 0.0,
                    "target": 0}
            }
        }


var Alert = {
    props: {
        target: {
            type: String,
            default: function() {
                return "Erro!"
            }
        }
    },
    template: '#alert'
}

var SimuladorForm = {
    props: {
        target: {
            type: Number,
            default: function() {
                return 0
            }
        }
    },
    computed: {
        normalizedTarget: function() {
            var _target = this.target * 100;
            _target = _target.toFixed(1);
            return _target;
        }
    },
    template: '#simulator',
    methods: {
        getTarget:
                _.debounce(function() {
                    var self = this;
                    var simulator =
                            {"s": {
                                    "fcr": {realizado: (self.vm.fcr / 100)},
                                    "adr": {realizado: (self.vm.adr / 100)},
                                    "tma": {realizado: moment.duration(self.vm.tma, "HH:mm:ss").asSeconds()},
                                    "monitoria": {realizado: (self.vm.monitoria / 100)},
                                    "gps": {realizado: (self.vm.gps / 100)},
                                    op: self.vm.piv.op}
                            };

                    $.ajax({
                        type: "POST",
                        data: JSON.stringify(simulator),
                        url: pivURL2,
                        dataType: "json",
                        beforeSend: function(xhr) {
                            xhr.setRequestHeader("Content-Type", "application/json");
                        },
                        success: function(data) {
                            self.vm.piv = data.calculoPivFacade;
                        }
                    });
                }, 1000)
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
    template: '#dados-form',
    data: function() {
        return data
    }
}



new Vue({
    el: '#piv',
    data: data,
    created: function() {
        var self = this;
        self.loadSession();
    },
    components: {
        'simulador-form': SimuladorForm,
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
        getEquipes: function() {
            var self = this;

            $.ajax({
                type: "GET",
                dataType: "json",
                url: equipeURL,
                success: function(data) {
                    self.equipes = data.list;
                }
            });
        },
        setIndicadores: function(piv) {
            var self = this;

            self.usuario.piv = piv
            self.vm.piv = piv
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
        },
        loadIndicadores: function() {
            var self = this;

            $.get(pivURL + self.usuario.login, function(data) {

                var _piv = data.calculoPivFacade;

                if (_piv && _piv.indicadores.length == 4 ) {
                    self.setIndicadores(_piv)
                } else {

                    self.currentViewForm = 'celula-form';
                    self.getEquipes();
                    self.vm.tma = moment("1900-01-01 00:00:00").add(100, 'seconds').format("HH:mm:ss");

                }

                // Exibe componentes
                self.show = true;
            });
        }
    }
})