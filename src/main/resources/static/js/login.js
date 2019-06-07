$(function () {
    var loginUrl = "/user/login";

    $("#submit").on("click", function () {
        var userName = $("#localName").val();
        var password = $("#password").val();
        $.ajax({
            type: 'post',
            url: loginUrl,
            data: {
                userName: userName,
                password: password
            },
            success: function (data) {
                if (data.code === 7) {
                    layer.msg(data.msg);
                    window.location.href = "/user/list";
                } else {
                    layer.msg(data.msg);
                }
            }

        })

    });

});