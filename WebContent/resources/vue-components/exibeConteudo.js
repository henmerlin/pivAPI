/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var conteudoURL = "/comunicacao/conteudo/";

new Vue({
    el: "#conteudo",
    data: {
        conteudos: null
    },
    created: function () {
        var self = this;
        self.getCont();
    },
    methods: {
        dateFormat: function (h) {
            return  moment(h).format('DD/MM/YYYY');
        },
        getCont: function () {
            var self = this;
            $.get(conteudoURL + "lista", function (data) {
                self.conteudos = data.list;
            });            
        }
    }
});
