/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

notifyURL = "/comunicacao/notificacao/";

new Vue({

    data: {
        notificacoes: null
    },
    created: function () {
        var self = this;
        self.intervals();
    },
    methods: {
        intervals: function () {
            var self = this;
            setInterval(function () {
                self.buscaNotificacao();
            }, 600000);
            setTimeout(function () {
                self.buscaNotificacao();
            }, 1000);
        },
        buscaNotificacao: function () {
            var self = this;
            $.get(notifyURL + "listarEsp", function (data) {
                self.notificacoes = data.list;
                self.notifyP();
            });
        },
        notifyP: function () {
            var self = this;
            //Validação se o navegador tem suporte para Notification
            if (!("Notification" in window)) {
                alert("Este navegador não possui suporte para Notificações do Portal Efika");
            }
            // Let's check whether notification permissions have already been granted
            // Verifica se a já possui permissão para notificação
            else if (Notification.permission === "granted") {
                // Se permitido monta notificação              
                self.montaNotify();
            }
            // Otherwise, we need to ask the user for permission
            //Pergunta se o usuário da permissão
            else if (Notification.permission !== 'denied') {
                Notification.requestPermission(function (permission) {
                    // Se ele aceitar monta notificação
                    if (permission === "granted") {
                        self.montaNotify();
                    }
                });
            }
        },
        //Monta a notificação
        montaNotify: function () {
            var self = this;
            var i = 0; // inicia valor do contador
            loopa(); // Inicia Loop com Time Out 
            function loopa() {
                setTimeout(function () { //Tempo de espera para a proxima Notification
                    if (i < self.notificacoes.length) { // Validação: enquanto for menor que a lista
                        var titulo = self.notificacoes[i].titulo; // Titulo da notificação
                        var link = "http://localhost:8080/comunicacao/conteudo/list/" + self.notificacoes[i].conteudo.id; // Link para o conteudo
                        var mensagem = {
                            body: self.notificacoes[i].mensagem, // Corpo da mensagem
                            dir: "ltr", //Posição na tela, pode retirar que ficará auto
                            requireInteraction: false, //Respectivo a tela
                            tag: "notify", //ID da tag para nao abrir mais de duas ao mesmo tempo
                            icon: "http://efika/web/img/efikalogo.png" //Imagem do icone que fica do lado esquerdo
                        };
                        var n = new Notification(titulo, mensagem); // Monta notificação
                        n.onclick = function () {
                            window.open(link); // Link da notificação ira abrir o conteudo
                        };
                        i++; //Incrementa contador
                        loopa(); // Chama function novamente para mostrar o proximo da lista.
                    }
                }, 15000); // Espera 15 segundos
            }
        }
    }
});