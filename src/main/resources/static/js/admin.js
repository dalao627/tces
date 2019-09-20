$(function () {
    $(".list_dt").on("click",function () {
        $('.list_dd').stop();
        $(this).siblings("dt").removeAttr("id");
        if($(this).attr("id")=="open"){
            $(this).removeAttr("id").siblings("dd").slideUp();
        }else{
            $(this).attr("id","open").next().slideDown().siblings("dd").slideUp();
        }
    });

    // 点击列表项跳转到相应地址
    listClick();
});

/**
 * 点击列表项跳转到相应地址
 */
function listClick() {
    $(".list_li").on("click",function () {
        var addr = $(this).attr("href");
       $.ajax({
           url: addr,
           type: "get",
           success: function () {
               window.location = addr;
           }
       })
    });
}

