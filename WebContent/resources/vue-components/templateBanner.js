/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var bannerURL = "/comunicacao/banner/";
new Vue({
    el: '#allBanners',
    data: {
        bannersPequenos: null,
        bannersGrandes: null,
        sizeBannersPequenos: null,
        url: null
    },
    created: function () {
        var self = this;
        self.getbannersGrandes();
        self.getbannersPequenos();
    },
    methods: {
        //Comando Lista
        getbannersGrandes: function () {
            var self = this;
            $.get(bannerURL + "listarBannerGrande", function (data) {
                self.bannersGrandes = data.list;
                self.lsgra();
            });
        },
        getbannersPequenos: function () {
            var self = this;
            $.get(bannerURL + "listarBannerPequeno", function (data) {
                self.bannersPequenos = data.list;
                self.sizeBannersPequenos = self.bannersPequenos.lengt;
                self.lspeq();
            });
        },
        //Monta Carousels                
        lspeq: function () {
            $("#lspeq").lightSlider({
                autoWidth: true,
                loop: true,
                enableDrag: false
            });
        },
        lsgra: function () {
            $("#lsgra").lightSlider({
                adaptiveHeight: true,
                item: 1,
                slideMargin: 0,
                loop: true,
                enableDrag: false,
            });
        },
        
        //redirecHref
        conteudoimg: function (h) {            
            var self = this;
            self.url = "http://localhost:8080/comunicacao/conteudo/list/" + h.id;            
            window.location = self.url;        
        }
        
    }
});