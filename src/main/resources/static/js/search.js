$(function () {
    var url = "/user/userlist";
    $("#vaguesearch").onclick(function (t) {
        var name = $("#searchname").val();
        $.ajax({
            type: 'post',
            url: url,
            data: {
                userName: name
            },
            success: function (data) {
                if (data.code === 5) {
                    layer.msg(data.msg());
                } else {
                    layer.msg("查询失败！");
                }
            }

        })


    })

})