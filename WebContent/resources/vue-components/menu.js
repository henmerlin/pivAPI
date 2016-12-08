

var menuURL = "/comunicacao/enquete/";
var data = {counter: 0}

Vue.component('uploader', {
    template: '<input type="file" @change="onFileChange">',
    data: function() {
        return data
    }
})

new Vue({
    el: '#uploader',
    data: {
        image: ''
    },
    methods: {
        onFileChange(e) {
            var files = e.target.files || e.dataTransfer.files;
            if (!files.length)
                return;
            this.createImage(files[0]);
        },
        createImage(file) {
            var image = new Image();
            var reader = new FileReader();
            var vm = this;

            reader.onload = (e) => {
                vm.image = e.target.result;
            };
            reader.readAsDataURL(file);
        },
        removeImage: function(e) {
            this.image = '';
        }
    }
})
