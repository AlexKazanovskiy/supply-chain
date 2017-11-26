/**
 * Created by stryzhov on 23/12/2014.
 */
var UsersCollection = Backbone.Collection.extend({
    model: User,
    url: '/users'
});

var RolesCollection = Backbone.Collection.extend({
    model: Role,
    url: '/roles'
});