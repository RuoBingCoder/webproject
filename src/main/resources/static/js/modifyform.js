layui.use('form', function () {
    var form = layui.form;
    var addUrl = "/user/adduser";
    var modifyUrl = "/user/updateuser";
    var flag = false;
    //监听提交
    form.on('submit(formData)', function (data) {
        var user = {};
        var id = $("#id").val();
        if (id) {
            user.id = id;
            flag = true;

        }
        var userName = $("#userName").val();
        var age = $("#age").val();
        var phoneNumber = $("#phoneNumber").val();
        user.userName = userName;
        user.age = age;
        user.phoneNumber = phoneNumber;
        var formData = new FormData();
        formData.append("userStr", JSON.stringify(user));
        $.ajax({
            type: 'post',
            url: flag ? modifyUrl : addUrl,
            data: formData,
            contentType: false,
            processData: false,
            cache: false,
            success: function (data1) {
                if (data1.code === 1) {
                    layer.msg(data1.msg);
                    parent.location.reload();
                } else {
                    layer.msg(data1.msg);
                }
            }
            //刷新父页面

        });
        return false;
    });



});