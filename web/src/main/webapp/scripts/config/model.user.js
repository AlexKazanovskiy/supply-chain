define(function(require) {
    var Backbone = require('backbone');
    return Backbone.Model.extend({
        defaults: {
            login: '',
            email: '',
            password: '',
            firstName: '',
            lastName: '',
            birthday: '',
            role: {
                id: 2,
                name: 'user'
            }
        },
        urlRoot: '/users/'
    });
});