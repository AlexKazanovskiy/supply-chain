/**
 * Created by stryzhov on 20/12/2014.
 */
function prepareFormUi() {
    $.each($("form").find(".has-feedback"), function(){
        $(this).removeClass("has-error");
        $(this).removeClass("has-success");
        $.each($(this).find("span"), function() {
            $(this).removeClass("glyphicon-warning-sign");
            $(this).removeClass("glyphicon-ok");
        });
    });
    $(".alert").hide();
    $("button").button('reset');
}

function validateForm() {
    prepareFormUi();
    $.each($("form").find("input"), function(){
        var value = $(this).val(),
            iconHolder = $(this).next(),
            parentDiv = $(this).parents(".has-feedback");
        if (!$(this).attr("disabled")){
            var regEx;
            switch ($(this).attr("id")) {
                case "login" :
                    regEx = /^[a-zA-Z0-9]{3,15}$/;
                    break;
                case "email":
                    regEx = /[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4}/;
                    break;
                case "datepicker" :
                    regEx = /^\d{2,4}-\d{1,2}-\d{1,2}$/;
                    break;
                case "password":
                    regEx = /.{3,}/;
                    break;
                case "passwordAgain":
                    regEx = new RegExp($("#password").val());
                    break;
                case "firstName" :
                case "lastName" :
                default :
                    regEx = /[a-zA-z]+((['-][a-zA-Z])*)+[a-zA-Z]*$/;
                    break;
            }
            if (!regEx.test(value)) {
                iconHolder.addClass("glyphicon-warning-sign");
                parentDiv.addClass("has-error");
            } else {
                iconHolder.addClass("glyphicon-ok");
                parentDiv.addClass("has-success");
            }
            if ($(this).attr("id") == "password"
                && value.length < 3) {
                iconHolder.addClass("glyphicon-warning-sign");
                parentDiv.addClass("has-error");
            }
        }
    });
    return $("form").find(".has-error").length == 0;
}
