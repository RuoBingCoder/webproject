layui.config({
    version: '1559524961023' //为了更新 js 缓存，可忽略
});
layui.use(['laydate', 'laypage', 'form', 'layer', 'table', 'carousel', 'upload', 'element', 'slider'], function (page, count) {
    var laydate = layui.laydate //日期
        , laypage = layui.laypage //分页
        , layer = layui.layer //弹层
        , table = layui.table //表格
        , carousel = layui.carousel //轮播
        , upload = layui.upload //上传
        , element = layui.element //元素操作
        , slider = layui.slider //滑块
        , form = layui.form;

    //监听Tab切换
    element.on('tab(demo)', function (data) {
        layer.tips('切换了 ' + data.index + '：' + this.innerHTML, this, {
            tips: 1
        });
    });

    //执行一个 table 实例
    table.render({
        elem: '#demo'
        , height: 600
        , url: '/user/userlist' //数据接口
        , title: '用户表'
        , page: true//开启分页
        , toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
        , totalRow: true //开启合计行
        , groups: 5
        , cols: [
            [ //表头
                {type: 'checkbox', fixed: 'left'}
                , {field: 'id', title: 'ID', width: 140, sort: true, fixed: 'left', totalRowText: '合计：'}
                , {field: 'userName', title: '用户名', width: 140}
                , {field: 'age', title: '年龄', width: 140, sort: true, totalRow: true}
                , {field: 'phoneNumber', title: '电话', width: 140, sort: true, totalRow: true}
                , {fixed: 'right', width: 220, align: 'center', toolbar: '#barDemo'}

            ]
        ]
    });

    //监听头工具栏事件
    table.on('toolbar(test)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id)
            , data = checkStatus.data; //获取选中的数据
        switch (obj.event) {
            case 'add':
                layer.open({
                    title: '用户信息添加',
                    type: 2,
                    skin: 'layui-layer-rim', //加上边框
                    area: ['40%', '50%'], //宽高
                    content: 'adduserfrom', //弹出的页面
                    shadeClose: true, //点击遮罩关闭
                    success: function (layero, index) {
                        var body = layer.getChildFrame('body', index);
                        var iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
                        //console.log(body.html()) //得到iframe页的body内容
                        //初始化表单数据的值
                    },

                });
                break;
            case 'update':
                if (data.length === 0) {
                    layer.msg('请选择一行');
                } else if (data.length > 1) {
                    layer.msg('只能同时编辑一个');
                } else {
                    layer.alert('编辑 [id]：' + checkStatus.data[0].id);
                }
                break;
            case 'delete':
                if (data.length === 0) {
                    layer.msg('请选择一行');
                } else {
                    layer.msg('删除');
                }
                break;
        }

    });

    //监听行工具事件
    table.on('tool(test)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
        var data = obj.data //获得当前行数据
            , layEvent = obj.event; //获得 lay-event 对应的值
        if (layEvent === 'detail') {
            layer.msg('查看操作');
        } else if (layEvent === 'del') {

            layer.confirm('真的删除行么', function (index) {//删除对应行（tr）的DOM结构
                var id = data.id;
                $.ajax({
                    type: "get",
                    url: "/user/deleteuser",
                    data: {
                        id: id
                    },
                    success: function (data1) {
                        if (data1.code === 3) {
                            obj.del();
                            layer.close(index);
                            layer.msg(data1.msg);
                        } else {
                            layer.msg(data1.msg);
                        }
                    }
                });
                layer.close(index);
                //向服务端发送删除指令
            });
        } else if (layEvent === 'edit') {
            layer.open({
                type: 2,
                title: "更改信息",
                // fixed: false, //不固定
                skin: 'layui-layer-rim', //加上边框
                area: ['40%', '50%'],
                content: "adduserfrom",
                success: function (layero, index) {
                    // var div = layero.find('iframe').contents().find("#userform");
                    var body = layer.getChildFrame('body', index);
                    //可有可无
                    var iframeWin = window[layero.find('iframe')[0]['name']];
                    body.find('#id').val(data.id);
                    body.find('#userName').val(data.userName);
                    body.find('#age').val(data.age);
                    body.find('#phoneNumber').val(data.phoneNumber);
                }
            });

            //表单值

            // layer.alert('编辑 [id]：' + id);
        }

    });


    //分页
    laypage.render({
        elem: 'pageDemo' //分页容器的id
        , count: count
        , skin: '#1E9FFF' //自定义选中色值
        , limits: [10, 20, 30]
        //,skip: true //开启跳页
        , curr: 2
        , limit: 10
        , jump: function (obj, first) {
            if (!first) {
                location.href = '第' + obj.curr + '页';
            }
        }
    });

    //上传
    upload.render({
        elem: '#uploadDemo'
        , url: '' //上传接口
        , done: function (res) {
            console.log(res)
        }
    });

    //搜索加载--数据表格重载
    var $ = layui.$, active = {
            reload: function () {
                //执行重载
                table.reload('demo', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                        userName: $searchName
                    }
                });
            }
        }
    ;

    $('#vaguesearch').on('click', function () {
        var type = $(this).data('type');
        $searchName = $("#searchname").val();
        active[type] ? active[type].call(this) : '';
        $("#searchname").val('');
    });
    element.init();
});




