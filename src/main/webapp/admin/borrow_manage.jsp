<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>借阅管理</title>
    <link rel="stylesheet" href="https://fastly.jsdelivr.net/npm/admin-lte@3.2/dist/css/adminlte.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link rel="icon" href="${pageContext.request.contextPath}/bootstrap-icons-1.10.5/house-add-fill.svg" />
    <link href="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="../js/jquery.min.js/"></script>
    <script src="https://cdn.staticfile.org/jquery/3.6.4/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/mhDoLbDldZc3qpsJHpLogda//BVZbgYuw6kof4u2FrCedxOtgRZDTHgHUhOCVim" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/admin-lte@3.2/dist/js/adminlte.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/book.js"></script>
</head>
<body class="hold-transition skin-green sidebar-mini">
<div class="wrapper">
    <!-- 页面头部 -->
    <header class="main-header">
        <!-- 头部导航 -->
        <nav class="main-header navbar navbar-expand navbar-white navbar-light">
            <!-- Left navbar links -->
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" data-widget="control-sidebar" data-controlsidebar-slide="true" onclick="window.location.href='${pageContext.request.contextPath}/logout'" role="button">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-right" viewBox="0 0 16 16">
                            <path fill-rule="evenodd" d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0v2z"></path>
                            <path fill-rule="evenodd" d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"></path>
                        </svg>
                        <i class="bi bi-box-arrow-right">logout</i>
                    </a>
                </li>
            </ul>
        </nav>
        <!-- 头部导航 -->
    </header>
    <!-- 页面头部 /-->

    <!-- 导航侧栏 -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <!-- Brand Logo -->
        <a href="${pageContext.request.contextPath}/Home" class="brand-link">
            <img src="https://th.bing.com/th/id/OIP.nH4dYsyTgnm_eXamCJrvwgHaH5?pid=ImgDet&rs=1" alt="Logo" class="brand-image img-circle elevation-3"
                 style="opacity: .8">
            <span class="brand-text font-weight-light">Library</span>
        </a>

        <!-- 侧边栏 -->
        <div class="sidebar os-padding">
            <!-- Sidebar user panel (optional) -->
            <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                <div class="image">
                    <img src="https://th.bing.com/th/id/R.5cf32306964edb85eee97858641bbaa5?rik=Qfaaz3ebjRMrAg&riu=http%3a%2f%2fpic.616pic.com%2fys_img%2f00%2f04%2f45%2fB98tg4SeIs.jpg&ehk=KWu4l1ltCRmNh4nwz8gwopU65thfexHaIZo9NmMBdVs%3d&risl=&pid=ImgRaw&r=0" class="img-circle elevation-2" alt="User Image">
                </div>
                <div class="info">
                    ${sessionScope.USER_SESSION.username}
                </div>
            </div>
            <!-- 侧栏菜单 -->
            <nav class="mt-2">
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordtion="false">
                    <!-- Add icons to the links using the .nav-icon class
                         with font-awesome or any other icon font library -->
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/Home" class="nav-link">
                            <i class="nav-icon fas fa-tachometer-alt"></i>
                            <p>
                                首页
                                <i class="right fas fa-angle-left"></i>
                            </p>
                        </a>
                    </li>
                    <c:if test="${sessionScope.USER_SESSION.role == 'Admin'}">
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/book" class="nav-link">
                                <i class="nav-icon fas fa-tachometer-alt"></i>
                                <p>
                                    图书管理
                                    <i class="right fas fa-angle-left"></i>
                                </p>
                            </a>
                        </li>
                    </c:if>
                    <li class="nav-item">
                        <a href="<c:url value="/admin/book_borrow.jsp"/>" class="nav-link">
                            <i class="nav-icon fas fa-tachometer-alt"></i>
                            <p>
                                图书借阅
                                <i class="right fas fa-angle-left"></i>
                            </p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/searchBorrow" class="nav-link">
                            <i class="nav-icon fas fa-tachometer-alt"></i>
                            <p>
                                当前借阅
                                <i class="right fas fa-angle-left"></i>
                            </p>
                        </a>
                    </li>
                    <c:if test="${sessionScope.USER_SESSION.role == 'Admin'}">
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/confirmBook" class="nav-link active">
                                <i class="nav-icon fas fa-tachometer-alt"></i>
                                <p>
                                    借阅管理
                                    <i class="right fas fa-angle-left"></i>
                                </p>
                            </a>
                        </li>
                    </c:if>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/recordHistory" class="nav-link">
                            <i class="nav-icon fas fa-tachometer-alt"></i>
                            <p>
                                借阅记录
                                <i class="right fas fa-angle-left"></i>
                            </p>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </aside>
    <!-- 导航侧栏 /-->
    <div class="content-wrapper" style="min-height: 955px;">
        <!-- 主体内容 -->
        <section class="content">
            <div class="container-fluid">
                <div class="row-12">
                    <%--页面内容--%>
                    <div class="card-body p-0">
                        <div class="table-responsive">
                            <table class="table m-0">
                                <thead>
                                <tr>
                                    <th class="sorting_asc">借阅图书名称</th>
                                    <th class="sorting">标准ISBN</th>
                                    <th class="sorting">书籍状态</th>
                                    <th class="sorting">借阅人</th>
                                    <th class="sorting">借阅时间</th>
                                    <th class="sorting">归还时间</th>
                                    <th class="text-center">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${confirmBook.rows}" var="record">
                                    <tr>
                                        <td>${record.book_name}</td>
                                        <td>${record.book_isbn}</td>
                                        <td>
                                            <c:if test="${record.book_status == 1}"><span class="badge badge-warning">借阅中</span></c:if>
                                            <c:if test="${record.book_status == 2}"><span class="badge badge-info">归还中</span></c:if>
                                        </td>
                                        <td>${record.book_borrower}</td>
                                        <td>${record.book_borrow_time}</td>
                                        <td>${record.book_return_time}</td>
                                        <td class="text-center">
                                            <button type="button" class="btn bg-olive btn-xs" onclick="confirmBook(${record.book_id})">确认归还</button>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.table-responsive -->
                    </div>
                </div>
            </div>
        </section>
    </div>
</div>
</body>
<script>
    function confirmBook(bookId) {
        const flag = confirm("是否确认归还");
        if(flag){
            const url = getProjectPath() + "/confirmReturn?id=" + bookId;
            $.post(url, function (response) {
                alert(response.message);
                console.log(response.success)
                if(response.success === true){
                    window.location.href = getProjectPath()+"/confirmBook";
                }
            })
        }
    }
</script>
</html>
