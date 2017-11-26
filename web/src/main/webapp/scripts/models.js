/**
 * Created by stryzhov on 23/12/2014.
 */
var User = Backbone.AssociatedModel.extend({
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
    urlRoot: '/users/',
    relations: [
        {
            type: Backbone.One,
            key: "role",
            relatedModel: "Role"
        }
    ]
});

var Role = Backbone.AssociatedModel.extend({
    idAttribute: 'name',
    urlRoot: '/roles/'
});

