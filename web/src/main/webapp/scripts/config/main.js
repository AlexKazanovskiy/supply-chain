define(function (require) {
    var ConfigView = require('config/view.config');
    var view = new ConfigView();
    $("body").append(view.render().el);
    $('#map').vectorMap();
});