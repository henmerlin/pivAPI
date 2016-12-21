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
                loop: true
            });
        },
        lsgra: function () {
            $("#lsgra").lightSlider({
                adaptiveHeight: true,
                item: 1,
                slideMargin: 0,
                loop: true
            });
        }
    }
});