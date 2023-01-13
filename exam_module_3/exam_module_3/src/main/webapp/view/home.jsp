<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12-01-23
  Time: 8:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Employee</title>
  <link rel="stylesheet" href="bootstrap-5.1.3-dist/bootstrap-5.1.3-dist/css/bootstrap.css">
</head>
<body>
<div>
  <div class="row bg-warning h-auto ">
    <div class="col-md-2 ">
    </div>
    <div class="col-md-3  row">
    </div>
    <div class="col-md-3  row">
    </div>
    <div class="col-md-2  row">
    </div>
    <div class="col-md-2  row d-flex align-content-center">
      <div style="padding-left: 30%"><h4>PHẠM TIẾN</h4></div>
    </div>
  </div>
  <div>
    <nav class="navbar navbar-expand-lg navbar-light bg-info">
      <div class="container-fluid">
        <a class="navbar-brand" href="/home">Home</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="/sach">Sach</a>
            </li>
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="/theMuonSach">theMuonSach</a>
            </li>
          </ul>
          <form class="d-flex">
            <input class="form-control me-3" type="text" placeholder="" aria-label="Search" name="id"
                   value="">
            <button class="btn btn-outline-success" type="submit" name="action" value="search">Search
            </button>
          </form>
        </div>
      </div>
    </nav>
  </div>
  <div>
    <img src="https://duansungroup.com/wp-content/webp-express/webp-images/doc-root/wp-content/uploads/2022/08/bai-sao-phu-quoc-sun-star-fish.jpg.webp">
  </div>
  <div CLASS="row bg-black">
    <h1>THI MODULE 3</h1>
  </div>
</div>
</body>
<script src="bootstrap-5.1.3-dist/bootstrap-5.1.3-dist/js/bootstrap.js"></script>
</html>
