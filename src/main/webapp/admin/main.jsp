<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" href="https://fastly.jsdelivr.net/npm/admin-lte@3.2/dist/css/adminlte.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/mhDoLbDldZc3qpsJHpLogda//BVZbgYuw6kof4u2FrCedxOtgRZDTHgHUhOCVim" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/admin-lte@3.2/dist/js/adminlte.min.js"></script>
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
                    <a class="nav-link" data-widget="control-sidebar" data-controlsidebar-slide="true" href="${pageContext.request.contextPath}/logout" role="button">
                        <i class="fas fa-th-large">logout</i>
                    </a>
                </li>
            </ul>
        </nav>
        <!-- 头部导航 -->
    </header>
    <!-- 页面头部 /-->

    <!-- 导航侧栏 -->
    <!-- Main Sidebar Container -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <!-- Brand Logo -->
        <a href="${pageContext.request.contextPath}/Home" class="brand-link">
            <img src="https://th.bing.com/th/id/OIP.nH4dYsyTgnm_eXamCJrvwgHaH5?pid=ImgDet&rs=1" alt="Logo" class="brand-image img-circle elevation-3"
                 style="opacity: .8">
            <span class="brand-text font-weight-light">Library</span>
        </a>

        <!-- 侧边栏 -->
        <div class="sidebar">
            <!-- Sidebar user panel (optional) -->
            <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                <div class="image">
                    <img src="https://th.bing.com/th/id/R.5cf32306964edb85eee97858641bbaa5?rik=Qfaaz3ebjRMrAg&riu=http%3a%2f%2fpic.616pic.com%2fys_img%2f00%2f04%2f45%2fB98tg4SeIs.jpg&ehk=KWu4l1ltCRmNh4nwz8gwopU65thfexHaIZo9NmMBdVs%3d&risl=&pid=ImgRaw&r=0" class="img-circle elevation-2" alt="User Image">
                </div>
                <div class="info">
                    ${USER_SESSION.username}
                </div>
            </div>

            <!-- 侧栏菜单 -->
            <nav class="mt-2">
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu">
                    <!-- Add icons to the links using the .nav-icon class
                         with font-awesome or any other icon font library -->
                    <li class="nav-item menu-open">
                        <a href="${pageContext.request.contextPath}/Home" class="nav-link active">
                            <i class="nav-icon fas fa-tachometer-alt"></i>
                            <p>
                                首页
                                <i class="right fas fa-angle-left"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="#" class="nav-link active">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Active Page</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Inactive Page</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-th"></i>
                            <p>
                                Simple Link
                                <span class="right badge badge-danger">New</span>
                            </p>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </aside>
    <!-- 导航侧栏 /-->
    <!-- 内容展示区域 -->
</div>
</body>
</html>
