$(function () {
    // 实现全选|全不选功能
    checked();
    // 批量删除
    del_List();
    // 删除单个用户信息
    delOne();
    // 打开新增模态框
    openModal_1();
});

// 实现全选|全不选功能
function checked() {
    $("#check_all").on("click", function () {
        $(this).text() === "全选" ? $(".check_item").prop("checked", true) : $(".check_item").prop("checked", false);
        $(".check_item:checked").length === 8 ? $("#check_all").text("取消全选") : $("#check_all").text("全选");

    });


    $(".check_item").on("click", function () {
        $(".check_item:checked").length === 8 ? $("#check_all").text("取消全选") : $("#check_all").text("全选");
    })

}

//去当前页
function to_page() {
    var no = $("#pageInfo span:eq(0)").attr("alt");
    var delurl=window.location.pathname;
    location.href = delurl;
}

//删除多个用户信息
function del_List() {
    $("#btn_del_all").click(function () {
        //拼接删除老师ID字符串
        var ids = "";
        var names = "";
        $.each($(".check_item:checked"), function () {
            ids += $(this).parents("tr").find("td:eq(1)").text() + "-";
            names += $(this).parents("tr").find("td:eq(3)").text() + ",";
        });
        ids = ids.substring(0, ids.length - 1);
        names = names.substring(0, names.length - 1);
        //获取当前页面路径
        var delurl=window.location.pathname;
        //去掉路径id
        delurl=delurl.substring(0,delurl.length-1);
        //发送删除所选中比赛请求
        if (ids.length == 0) {
            alert("请选择需要删除的比赛");
        } else if (confirm("你确定要删除【" + names + "】等用户吗？")) {
            $.ajax({
                url: delurl + ids,
                type: "DELETE",
                success: function (data) {
                    to_page();
                }
            })
        }
    });

}

// 删除单个用户信息
function delOne() {
    $(".btn_d").click(function () {
        // alert("删除");
        var id = $(this).parents("tr").find("td:eq(1)").text();
        //获取当前页面路径
        var delurl=window.location.pathname;
        //去掉路径id
        delurl=delurl.substring(0,delurl.length-1);
        if (confirm("你确定要删除编号为【" + id + "】的用户吗？")) {
            //选择要删除的比赛
            $(this).parents("tr").find("td:eq(0) input").attr("checked", true);
            //发送删除请求
            $.ajax({
                //url: "/admin/teacher/" + id,
                url:delurl+id,
                type: "DELETE",
                success: function (data) {
                    //跳转到当前页
                    to_page();
                }
            })
        } else {
            $(this).parents("tr").find("td:eq(0) input").attr("checked", false);
        }
    });
}

//点击新增比赛按钮 打开新增表单模态框
function openModal_1() {
    $("#btn_add").click(function () {
        // alert("新增模态框");
        $(".modal_1").modal({
            backdrop: false
        });
    });
}
