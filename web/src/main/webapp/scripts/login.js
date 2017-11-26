/**
 * Created by stryzhov on 20/12/2014.
 */

$(document).ready(function(){

//datepicker
    $(function() {
        $( "#datepicker" ).datepicker({
            dateFormat: 'yy-mm-dd',
            maxDate: "-1D",
            changeMonth: true,
            changeYear: true,
            showOtherMonths: true,
            selectOtherMonths: true
        });
    });

    //user form tips
    $(function() {
        var tooltips = $( "[title]" ).tooltip({
            position: {
                my: "left top",
                at: "right+5 top-5"
            }
        });
    });

    var loginForm = $("#loginForm"),
        userForm = $("#userForm"),
        errorDiv = $("#errorDiv"),
        successDiv = $("#successDiv"),
        signUpModal = $("#myModal");


    signUpModal.on('show.bs.modal', function() {
        prepareFormUi();
    });

    $("#signUpBtn").click(function(){
        prepareFormUi();
        if(grecaptcha.getResponse()) {
            if (validateForm()) {
                var user = new User();
                $.each(userForm.find("input, select"), function(){
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
                        setTimeout(function(){
                            successDiv.html("<strong>Success:</strong> user registered");
                            successDiv.fadeIn();
                            setTimeout(function(){
                                successDiv.fadeOut("slow");
                            }, 4000);
                            signUpModal.modal("hide");
                        }, 500);
                    },
                    error:function(object,response){
                        errorDiv.fadeIn();
                        errorDiv.html("<strong>Error:</strong> "
                        + response.responseJSON.message);
                    }
                });
            } else {
                errorDiv.html("<strong>Error:</strong> invalid data");
                errorDiv.fadeIn();
            }
        } else {
            errorDiv.html("<strong>Error:</strong> invalid captcha");
            errorDiv.fadeIn();
        }
    });
});