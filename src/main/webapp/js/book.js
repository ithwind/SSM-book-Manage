//重置添加和编辑窗口中输入框的样式
function resetStyle() {
    $("#aoe").attr("disabled",false)
    const $values = $("#addOrEditBook input");
    $values.each(function(){
        $(this).attr("style","")
    });
}

function findBookById(bookId){
    resetStyle();
    const url = getProjectPath() + "/findById?id=" + bookId;
    $.get(url, function (response) {
            $("#book_id").val(response.data.book_id);
            $("#book_name").val(response.data.book_name);
            $("#book_isbn").val(response.data.book_isbn);
            $("#book_press").val(response.data.book_press);
            $("#book_author").val(response.data.book_author);
            $("#book_price").val(response.data.book_price);
            $("#book_status").val(response.data.book_status);
    })

}

//点击编辑的窗口的确定按钮时，提交图书信息
function edit() {
    //获取表单中图书id的内容
    const book_id = $("#book_id").val();
    //如果表单中有图书id的内容，说明本次为编辑操作
    const url = getProjectPath() + "/editBook";
    $.post(url, $("#editBook").serialize(), function (response) {
        alert(response.message)
        if (response.success === true) {
            const book_name = $("#book_name").val();
            window.location.href = getProjectPath()+"/book_manage?inputContent="+book_name;
        }
    })
}
/**
 * 查询项目路径
 */
function getProjectPath() {
    const pathName = window.document.location.pathname;
    const projectName = pathName.substring(0, pathName.substring(1).indexOf('/') + 1);
    return  projectName;
}