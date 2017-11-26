/**
 * Created by I on 11.06.2015.
 */
define(function (require) {
    var MainView = require('main/templated.view'),
        template = require('text!config/template.config.dust'),
        UsersCollection = require('config/collection.users');
    var ConfigView = MainView.extend({
        template: template,
        collection: new UsersCollection,
        className: 'container'
    });
    ConfigView.prototype.render = function() {
        var self = this;
        this.collection.fetch({async: false}).done(function(){
            self.data = {
                users: self.collection.toJSON()
            };
        });

        return MainView.prototype.render.apply(self);
    };
    return ConfigView;
});