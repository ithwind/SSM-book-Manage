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

/**
 * 查询项目路径
 */
function getProjectPath() {
    var pathName = window.document.location.pathname;
    var projectName = pathName.substring(0, pathName.substring(1).indexOf('/') + 1);
    return  projectName;
}