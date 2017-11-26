define(function(require) {
    var Backbone = require('backbone'),
        dust = require('dust');
    var TemplatedView = Backbone.View.extend({
    });

    TemplatedView.prototype.render = function(){
        var self = this;
        var compiled = dust.compile(this.template, 'template');
        dust.loadSource(compiled);
        dust.render('template', this.data, function(err, out) {
            self.$el.html(out);
        });
        return this;
    };
    return TemplatedView;
});