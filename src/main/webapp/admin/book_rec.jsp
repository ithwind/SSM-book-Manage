<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书推荐</title>
  <link rel="stylesheet" href="https://fastly.jsdelivr.net/npm/admin-lte@3.2/dist/css/adminlte.min.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  <link rel="icon" href="${pageContext.request.contextPath}/bootstrap-icons-1.10.5/house-add-fill.svg" />
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/mhDoLbDldZc3qpsJHpLogda//BVZbgYuw6kof4u2FrCedxOtgRZDTHgHUhOCVim" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/admin-lte@3.2/dist/js/adminlte.min.js"></script>
</head>
<body>
<div class="box-header with-border">
  <h3 class="box-title">新书推荐</h3>
</div>
<!--数据展示头部-->
<div class="card">
  <div class="card-header border-transparent">
    <h3 class="card-title"></h3>
    <div class="card-tools">
      <button type="button" class="btn btn-tool" data-card-widget="collapse">
        <i class="fas fa-minus"></i>
      </button>
      <button type="button" class="btn btn-tool" data-card-widget="remove">
        <i class="fas fa-times"></i>
      </button>
    </div>
  </div>
  <!-- /.card-header -->
  <div class="card-body p-0">
    <div class="table-responsive">
      <table class="table m-0">
        <thead>
        <tr>
          <th class="sorting_asc">图书名称</th>
          <th class="sorting">图书作者</th>
          <th class="sorting">出版社</th>
          <th class="sorting">标准ISBN</th>
          <th class="sorting">书籍状态</th>
          <th class="sorting">借阅人</th>
          <th class="sorting">借阅时间</th>
          <th class="sorting">预计归还时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageResult.rows}" var="book">
          <tr>
            <td> ${book.book_name}</td>
            <td>${book.book_author}</td>
            <td>${book.book_press}</td>
            <td>${book.book_isbn}</td>
            <td>
              <c:if test="${book.book_status ==0}"><span class="badge badge-success">可借阅</span></c:if>
              <c:if test="${book.book_status ==1}"><span class="badge badge-warning">借阅中</span></c:if>
              <c:if test="${book.book_status ==2}"><span class="badge badge-info">归还中</span></c:if>
            </td>
            <td>${book.book_borrower}</td>
            <td>${book.book_borrow_time}</td>
            <td>${book.book_return_time}</td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
    <!-- /.table-responsive -->
  </div>
  <!-- /.card-body -->
  <div class="card-footer clearfix">
  </div>
  <!-- /.card-footer -->
</div>
<!--数据展示头部-->
<!--数据展示内容区-->
<!-- 数据展示内容区/ -->
<%--引入存放模态窗口的页面--%>
</body>
</html>
