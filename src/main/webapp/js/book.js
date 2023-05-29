//重置添加和编辑窗口中输入框的内容
function resetFrom() {
    $("#aoe").attr("disabled",true)
    const $values = $("#addOrEditBook input");
    $values.each(function(){
        $(this).attr("style","").val("")
    });
}


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
            $("#book_publish_time").val(response.data.book_publish_time)
    })
}

//点击编辑的窗口的确定按钮时，提交图书信息
function addOrEdit() {
    //获取表单中图书id的内容
    const book_id = $("#book_id").val();
    //如果表单中有图书id的内容，说明本次为编辑操作
    if(book_id > 0){
        const url = getProjectPath() + "/editBook";
        alert(url)
        $.post(url, $("#addOrEditBook").serialize(), function (response) {
            alert(url)
            console.log($("#book_author"))
            alert(response.message)
            if (response.success === true) {
                const book_name = $("#book_name").val();
                alert(book_name);
                window.location.href = getProjectPath()+"/book_manage?inputContent="+book_name;
            }
        })
    } else{
        const url = getProjectPath() + "/addBook";
        const book_name = $("#book_name")
        alert(book_name)
        $.post(url, $("#addOrEditBook").serialize(), function (response) {
            alert(book_name)
            alert(response.message)
            if (response.success === true) {
                window.location.href = getProjectPath()+"/book_manage?inputContent="+book_name;
            }
        })
    }

}
/**
 * 查询项目路径
 */
function getProjectPath() {
    const pathName = window.document.location.pathname;
    return  pathName.substring(0, pathName.substring(1).indexOf('/') + 1);
}
//页面加载完成后，给图书模态窗口的输入框绑定失去焦点和获取焦点事件
$(function() {
    const $inputs = $("#addOrEditBook input");
    let book_isbn = "";
    $inputs.each(function () {
        //给输入框绑定失去焦点事件
        $(this).blur(function () {
            if($(this).val()===''){
                $("#aoe").attr("disabled",true)
                $(this).attr("style","color:red").val("不能为空！")
            }
            else if($(this).attr("name")==="isbn"&&book_isbn!==$(this).val()){
                if($(this).val().length!==13){
                    $("#aoe").attr("disabled",true)
                    alert("必须为13位数的标准ISBN，请重新输入！")
                    $(this).val("")
                }
            }else{
                checkVal()
            }
        }).focus(function () {
            if($(this).val()==='不能为空！'){
                $(this).attr("style","").val("")
            }else{
                $(this).attr("style","")
            }
            if($(this).attr("name")==="isbn"){
                book_isbn=$(this).val();
            }
        })
    })
});

//检查图书信息的窗口中，图书信息填写是否完整
function checkVal(){
    const $inputs = $("#addOrEditTab input");
    let count = 0;
    $inputs.each(function () {
        if($(this).val()===''||$(this).val()==="不能为空！"){
            count+=1;
        }
    })
    //如果全部输入框都填写完整，解除确认按钮的禁用状态
    if(count===0){
        $("#aoe").attr("disabled",false)
    }
}
//点击借阅后查询
function borrowBook(bookId){
    resetStyle();
    const url = getProjectPath() + "/findById?id=" + bookId;
    $.get(url, function (response) {
        $("#saveMsg").attr("disabled",true)
        $("#book_return_time").val("");
        $("#book_id").val(response.data.book_id);
        $("#book_name").val(response.data.book_name);
        $("#book_isbn").val(response.data.book_isbn);
        $("#book_press").val(response.data.book_press);
        $("#book_author").val(response.data.book_author);
        $("#book_price").val(response.data.book_price);
        $("#book_publish_time").val(response.data.book_publish_time)
    })
}

/**
 * 点击保存
 */
function borrow() {
    const url = getProjectPath() + "/book_borrow";
    const book_name = $("#book_name").val();
    $.post(url, $("#borrowBook").serialize(), function (response) {
        alert(response.message)
        if (response.success === true) {
            window.location.href = getProjectPath()+"/searchBorrowBook?inputContent="+book_name;
        }
    })
}


/**
 * 数据展示页面分页插件的参数
 * cur 当前页
 * total 总页数
 * len   显示多少页数
 * pageSize 1页显示多少条数据
 * goUrl 页码变化时 跳转的路径
 * targetId 分页插件作用的id
 */
const pageArgs = {
    cur: 1,
    total: 0,
    len: 5,
    pageSize: 10,
    goUrl: "",
    targetId: 'pagination',
    callback: function (total) {
        const oPages = document.getElementsByClassName('page-index');
        for (let i = 0; i < oPages.length; i++) {
            oPages[i].onclick = function () {
                changePage(this.getAttribute('data-index'), pageArgs.pagesize);
            }
        }
        const goPage = document.getElementById('go-search');
        goPage.onclick = function () {
            const index = document.getElementById('yeshu').value;
            if (!index || (+index > total) || (+index < 1)) {
                return;
            }
            changePage(index, pageArgs.pagesize);
        }
    }
};
/**
 *图书查询栏的查询参数
 * name 图书名称
 * author 图书作者
 * press 图书出版社
 */
const bookVO = {
    name: '',
    author: '',
    press: ''
};
/**
 *借阅记录查询栏的查询参数
 * name 图书名称
 * borrower 借阅人
 */
const recordVO = {
    bookName: '',
    borrower: ''
};

//数据展示页面分页插件的页码发送变化时执行
function changePage(pageNo,pageSize) {
    pageargs.cur=pageNo;
    pageargs.pagesize=pageSize;
    document.write("<form action="+pageargs.gourl +" method=post name=form1 style='display:none'>");
    document.write("<input type=hidden name='pageNum' value="+pageargs.cur+" >");
    document.write("<input type=hidden name='pageSize' value="+pageargs.pagesize+" >");
    //如果跳转的是图书信息查询的相关链接，提交图书查询栏中的参数
    if(pageargs.gourl.indexOf("book")>=0){
        document.write("<input type=hidden name='name' value="+bookVO.name+" >");
        document.write("<input type=hidden name='author' value="+bookVO.author+" >");
        document.write("<input type=hidden name='press' value="+bookVO.press+" >");
    }
    //如果跳转的是图书记录查询的相关链接，提交图书记录查询栏中的参数
    if(pageargs.gourl.indexOf("record")>=0){
        document.write("<input type=hidden name='bookname' value="+recordVO.bookname+" >");
        document.write("<input type=hidden name='borrower' value="+recordVO.borrower+" >");
    }
    document.write("</form>");
    document.form1.submit();
    pagination(pageargs);
}

