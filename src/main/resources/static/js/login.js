function check_login() {

    var roleId = $("option:checked").val();
    $.ajax({
        url: "/login/" + roleId,
        type: "POST",
        data: $("#login_form").serialize(),
        success: function (data) {
            if (data.code === 200) {
                if (roleId == 1) {
                    window.location = "/admin";
                }
            }
        }
    })
}

$(function () {
    $("#login").click(function () {
        check_login();
        return false;
    });
    $('.message a').click(function () {
        $('form').animate({
            height: 'toggle',
            opacity: 'toggle'
        }, 'slow');
    });
});
