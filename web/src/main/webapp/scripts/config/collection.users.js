define(function(require) {
    var Backbone = require('backbone'),
        UserModel = require('config/model.user');
    return Backbone.Collection.extend({
        model: UserModel,
        url: '/users'
    });
});