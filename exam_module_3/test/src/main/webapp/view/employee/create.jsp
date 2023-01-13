<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12-01-23
  Time: 4:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
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
                            <a class="nav-link active" aria-current="page" href="/employee">Employee</a>
                        </li>
                    </ul>
                    <form class="d-flex" action="/employee" method="get">
                        <input class="form-control me-2" type="text" placeholder="name" aria-label="Search" name="name"
                               value="">
                        <div class="form-control me-2">
                            <select class="form-select" aria-label="Default select example" name="positionId">
                                <option value="">position</option>
                                <c:forEach var="positionId" items="${positionIdSet}">
                                    <option value="${positionId}">${positionMap.get(positionId)}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <button class="btn btn-outline-success" type="submit" name="action" value="search">Search
                        </button>
                    </form>
                </div>
            </div>
        </nav>
    </div>
<%--    form--%>
    <div class="d-flex justify-content-center">
        <form class="w-50 border border-2 border-dark p-3 rounded" action="/employee" method="post">
            <div>
                <p style="color: red">${mess}</p>
            </div>
<%--text--%>
            <div class="mb-3">
                <label for="name" class="form-label">Name Employee</label>
                <input type="text" class="form-control" id="name" name="name">
            </div>
<%--date--%>
            <div class="mb-3">
                <label for="dateOfBirth" class="form-label">Date Of Birth</label>
                <input type="date" class="form-control" id="dateOfBirth" name="dateOfBirth" required>
            </div>
<%--gender--%>
            <div class="mb-3">
                <label class="form-label">Gender</label>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gender" id="flexRadioDefault1" value="true">
                    <label class="form-check-label" for="flexRadioDefault1">
                        Nam
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gender" id="flexRadioDefault2" value="false">
                    <label class="form-check-label" for="flexRadioDefault2">
                        Nu
                    </label>
                </div>
            </div>
<%--select option--%>
            <div class="form-control me-2 mb-3">
                <label class="form-label">Position</label>
                <select class="form-select" aria-label="Default select example" id="positionId" name="positionId">
                    <option value="">position</option>
                    <c:forEach var="positionId" items="${positionIdSet}">
                        <option value="${positionId}">${positionMap.get(positionId)}</option>
                    </c:forEach>
                </select>
            </div>
<%--button--%>
            <div>
                <button class="btn btn-outline-success" type="submit" name="action" value="save">SAVE</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
