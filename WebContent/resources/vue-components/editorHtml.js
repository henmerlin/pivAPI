$(function() {

    // tinymce directive
    Vue.directive('tinymce-editor', {
        twoWay: true,
        bind: function() {
            var self = this;
            tinymce.init({
                selector: '#editor',
                menubar: false,
                plugins: [
                    'advlist autolink lists link image charmap print preview anchor',
                    'searchreplace visualblocks code fullscreen',
                    'insertdatetime media table contextmenu paste code'
                ],
                setup: function(editor) {

                    // init tinymce
                    editor.on('init', function() {
                        tinymce.get('editor').setContent(self.value);
                    });

                    // when typing keyup event
                    editor.on('keyup', function() {

                        // get new value
                        var new_value = tinymce.get('editor').getContent(self.value);

                        // set model value
                        self.set(new_value)
                    });
                }
            });
        },
        update: function(newVal, oldVal) {
            // set val and trigger event
            $(this.el).val(newVal).trigger('keyup');
        }

    })

    new Vue({
        el: '#tinymce-form',
        data: {
            content: 'hello world'
        }
    })


})