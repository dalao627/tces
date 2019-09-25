$(function () {
    //打开修改模态框
    openModal_2();
    //修改信息
    updateAll();
});

//点击修改按钮 打开修改表单模态框
function openModal_2() {
    $(".btn_e").click(function () {
        //获取当前选中的id
        var id = $(this).parents("tr").find("td:eq(1)").text();
        //获取当前页面路径
        var upurl=window.location.pathname;
        //去掉路径后缀id
        upurl=upurl.substring(0,upurl.length-1);
        //alert("路径为:"+upurl+"update/"+id);
        $.ajax({
            url:upurl+"update/"+id,
            type: "GET",
            dataType: 'json',
            success: function (data) {
                //alert( $("#studentNo").val(data.studentNo));
                //获取后台值
                //获取id
                $("#studentId").val(data.studentId);
                //学号
                $("#studentNo").val(data.studentNo);
                //姓名
                $("#studentName").val(data.studentName);
                //性别
                $("#sexId").val(data.studentSex);
                //班级id
                $("#studentGradeId").val(data.studentGradeId);
                //评价状态
                $("#studentStatus").val(data.studentStatus == 1? "已评价" : "未评价");

                //跳转到模态页面
                $(".modal_2").modal({
                    backdrop: false
                });
            }
        });

    });
}



/**
 * 修改用户信息后
 */
function updateAll() {
    $(".btn-up").click(function () {
        // 获取当前编号
        var id = $(this).closest("#formId").find("div:eq(0) input").val();
       // alert("当前id值："+id);
        //获取form表单所有元素值
        var datas=$(this).closest('#formId').serializeArray();
        //alert("所有值为："+datas);
        //获取当前页面路径
        var uplurl=window.location.pathname;
        //alert("当前路径为"+uplurl);
        //去掉路径id
        uplurl=uplurl.substring(0,uplurl.length-1);
        //修改后的路径
        //alert("修改后的路径"+uplurl);
        if (confirm("你确定要修改编号为【" + id + "】的用户吗？")) {
            //勾选当前要修改的记录
            $(this).parents("tr").find("td:eq(0) input").attr("checked", true);
            //发送修改请求
            $.ajax({
                //url: "/admin/teacher/" + id,
                url:uplurl+id,
                type: "PUT",
                data:datas,
                success: function (data) {
                    //跳转到当前页
                    rePage();
                }
            })
        } else {
            $(this).parents("tr").find("td:eq(0) input").attr("checked", false);
        }
    });
}
/**
 * 返回当前页面路径
 * */
function rePage() {
    var no = $("#pageInfo span:eq(0)").attr("alt");
    var uplurl=window.location.pathname;
    location.href = uplurl;
}

