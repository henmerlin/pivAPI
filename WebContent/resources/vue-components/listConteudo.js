/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var conteudoURL = "/comunicacao/conteudo/";

new Vue({
    
    el: '#conteudo',
    data: {
        conteudo: null        
    },
    create: function () {
        
    },
    methods: {
        listaCont: function (h) {
            var self = this;
            $.get(conteudoURL + h, function (data) {
                self.conteudo = data;
            });
        }        
    }
    
});