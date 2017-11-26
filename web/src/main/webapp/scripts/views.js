/**
 * Created by stryzhov on 23/12/2014.
 */
_.templateSettings = {
    interpolate : /\{\{([\s\S]+?)\}\}/g
};
var user = new User();

/**
 * A view representing single row in a users list
 */
var UserInfoRowView = Backbone.View.extend({
    className: 'row borders',
    model: User,
    removing: false,
    template: _.template($("#infoShort").html()),
    events: {
        'click': 'expand',
        'click a#remove': 'remove'
    },
    initialize: function(){
        this.model.on("change", this.render, this);
    },
    render: function(){
        this.$el.html(this.template(this.model.toJSON()));
        return this;
    },
    expand: function(){
        user = this.model;
        form.model = this.model;
        infoExpanded.render();
        var infoPanel = infoExpanded.$el;
        //hide if expanded for another row
        var nextID = this.$el.next().attr("id");
        if (nextID != "info" && infoPanel.attr("hidden") == undefined) {
            infoPanel.prev().removeClass("active");
            infoPanel.hide();
            infoPanel.attr("hidden", true);
        }
        //expand/collapse for current row
        if (infoPanel.attr("hidden") != undefined
            && !this.removing) {
            prepareFormUi();
            this.$el.addClass("active");
            this.$el.after(infoPanel);
            infoPanel.find("h3").after(form.$el);
            infoPanel.find("h3").after(errorMessage);
            $("#login").attr("disabled", "disabled");
            infoPanel.slideDown();
            infoPanel.removeAttr("hidden");
        } else {
            this.$el.removeClass("active");
            infoPanel.slideUp();
            infoPanel.attr("hidden", true);
        }
    },
    remove: function(){
        if (confirm("Are you sure?")) {
            this.removing = true;
            var _thisView = this;
            this.model.destroy({
                success: function(){
                    _thisView.$el.fadeOut(function(){
                        _thisView.$el.remove();
                    });
                    successMessage.html("<strong>Success:</strong> user removed");
                    successMessage.show();
                    setTimeout(function(){
                        successMessage.fadeOut("slow");
                    }, 4000);
                },
                error: function(model, response){
                    $("#usersListHeader").before(errorMessage);
                    errorMessage.html("<strong>Error:</strong> "
                                      + response.responseJSON.message)
                    errorMessage.fadeIn();
                    _thisView.removing = false;
                }
            });
        }
    }
});

/**
 * A view representing expanded user info with form
 */
var UserInfoExpandedView = Backbone.View.extend({
    className: 'container row expanded',
    model: User,
    template: _.template($("#infoExpanded").html()),
    initialize: function(){
        this.$el.attr("id", "info");
        this.$el.attr("hidden", true);
    },
    render: function(){
        this.$el.html(this.template());
        this.$el.find("h3").after(errorMessage);
        errorMessage.after(form.$el);
        form.render();
        this.$el.find("#updateButton").click(this.update);
        return this;

    },
    update: function(){
        if (validateForm()) {
            var $btn = $(this).button('loading');
            $.each(form.$el.find("input, select"), function(){
                if ($(this).attr("id") == "datepicker") {
                    user.set("birthday",$(this).val())
                } else if ($(this).is("select")){
                    var roleName = $(this).find("option:selected").text();
                    user.set("role", rolesCollection.get(roleName))
                } else {
                    user.set($(this).attr("id"), $(this).val())
                }
            });
            user.save(null,{
                wait: true,
                success:function(){
                    $btn.button('complete');
                    setTimeout(function(){
                        successMessage.html("<strong>Success:</strong> user updated");
                        successMessage.fadeIn();
                        setTimeout(function(){
                            successMessage.fadeOut("slow");
                        }, 4000);
                        infoExpanded.$el.prev().removeClass("active");
                        infoExpanded.$el.attr("hidden", true);
                        infoExpanded.$el.slideUp();
                    }, 500);
                },
                error:function(object,response){
                    user.fetch();
                    $btn.button('reset');
                    errorMessage.fadeIn();
                    errorMessage.html("<strong>Error:</strong> "
                    + response.responseJSON.message);
                }
            });
        } else {
            errorMessage.html("<strong>Error:</strong> invalid data");
            errorMessage.fadeIn();
            setTimeout(function(){
                errorMessage.fadeOut("slow");
            }, 8000);
        }
    }
});


/**
 * A view representing users list
 */
var UserInfoListView = Backbone.View.extend({
    className: 'container-fluid',
    template: _.template($("#usersTable").html()),
    render: function(){
        this.$el.html(this.template());
        $("#usersListHeader").before(successMessage);
        var _thisView = this;
        this.collection.fetch({async: false}).done(function(){
            _thisView.collection.each(function(user){
                var infoRow = new UserInfoRowView({model: user});
                _thisView.$el.append(infoRow.render()
                    .$el.hide().fadeIn().slideDown());
            }, _thisView);
        });
        return this;
    }
});

/**
 * A view representing one role option in role select
 */
var RoleOptionView = Backbone.View.extend({
    tagName: 'option',
    model: Role,
    render: function(){
        var roleName = this.model.toJSON().name;
        this.$el.html(roleName);
        if (user.toJSON().role != undefined
            && roleName == user.toJSON().role.name) {
            this.$el.attr("selected", true);
        }
        return this;
    }
});

/**
 * A view representing select element in user editing form
 */
var RolesSelectView = Backbone.View.extend({
    tagName: 'select',
    className: 'form-control',
    initialize: function(){
        this.collection.fetch({async: false});
    },
    render: function(){
        this.collection.each(function(role){
            var roleOption = new RoleOptionView({model: role});
            this.$el.append(roleOption.render().el);
        }, this);
        return this;
    }
});

/**
 * A view representing form for user info editing
 */
var UserEditFormView = Backbone.View.extend({
    tagName: 'form',
    className: 'form-horizontal',
    role: 'form',
    template: _.template($("#userForm").html()),
    model: User,
    events : {
        'focus input#datepicker' : 'pickDate',
        'mouseenter [title]' : 'tooltip'
    },
    render: function(){
        this.$el.html(this.template(this.model.toJSON()));
        roleSelect = new RolesSelectView({collection: rolesCollection});
        this.$el.find("#roleSelect").append(roleSelect.render().$el);
        this.delegateEvents();
        return this;
    },
    pickDate: function(){
        this.$el.find("#datepicker").datepicker({
            dateFormat: 'yy-mm-dd',
            maxDate: "-1D",
            changeMonth: true,
            changeYear: true,
            showOtherMonths: true,
            selectOtherMonths: true
        });
    },
    tooltip: function(){
        this.$el.find($("[title]")).tooltip({
            position: {
                my: "left top",
                at: "right+5 top-5"
            }
        });
    }
});


var rolesCollection = new RolesCollection();
var usersCollection = new UsersCollection();
var infoList = new UserInfoListView({collection: usersCollection});
var roleSelect;
var infoExpanded = new UserInfoExpandedView();
var form = new UserEditFormView();
var errorMessage = $(".alert-danger");
var successMessage = $(".alert-success");
$("#usersListHeader").after(infoList.render().el);

$(document).ready(function(){
    var addUserModal = $("#myModal");
    addUserModal.on('show.bs.modal', function() {
        infoExpanded.$el.attr("hidden", true);
        infoExpanded.$el.prev().removeClass("active");
        infoExpanded.$el.hide();
        form.model = new User();
        prepareFormUi();
        $(this).find(".modal-body").html(form.$el);
        form.$el.before(errorMessage);
        form.render();
    });
    addUserModal.on('hidden.bs.modal', function() {
    });

    $("#registerButton").click(function(){
        if (validateForm()) {
            var newUser = new User();
            var $btn = $(this).button('loading');
            $.each(form.$el.find("input, select"), function(){
                if ($(this).attr("id") == "datepicker") {
                    newUser.set("birthday",$(this).val())
                } else if ($(this).is("select")){
                    var roleName = $(this).find("option:selected").text();
                    newUser.set("role", rolesCollection.get(roleName))
                } else {
                    newUser.set($(this).attr("id"), $(this).val())
                }
            });
            usersCollection.create(newUser, {
                success : function(){
                    $btn.button('complete');
                    setTimeout(function(){
                        successMessage.html("<strong>Success:</strong> user added");
                        successMessage.fadeIn();
                        setTimeout(function(){
                            successMessage.fadeOut("slow");
                        }, 4000);
                        addUserModal.modal("hide");
                        infoList.render();
                    }, 500);
                },
                error : function(model, response) {
                    $btn.button('reset');
                    errorMessage.html("<strong>Error:</strong> "
                                      + response.responseJSON.message);
                    errorMessage.fadeIn();
                }
                }
            );
        } else {
            errorMessage.html("<strong>Error:</strong> invalid data");
            errorMessage.fadeIn();
        }
    });
});