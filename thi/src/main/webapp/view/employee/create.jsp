<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11-01-23
  Time: 10:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Employee</title>
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
                        <input class="form-control me-2" type="text" placeholder="" aria-label="Search" name="name"
                               value="">
                        <div class="form-control me-2" >
                            <select class="form-select" aria-label="Default select example" name="positionId">
                                <option value="" >position</option>
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
    <div class="d-flex justify-content-center">
        <form class="w-50 border border-2 border-dark p-3 rounded" action="/employee" method="post">
            <div>
                <p style="color: red">${mess}</p>
            </div>
            <div class="mb-3">
                <label for="name" class="form-label">Name Employee</label>
                <input type="text" class="form-control" id="name" name="name" required pattern="^([A-Z][a-z]+ )+\d*$"
                       title="Tên dịch vụ được phép chứa số và các kí tự đầu tiên của mỗi từ phải viết hoa.">
            </div>
            <div class="mb-3">
                <label for="dayOfBirth" class="form-label">Day Of Birthday</label>
                <input type="date" class="form-control" id="dayOfBirth" name="dayOfBirth" required>
            </div>

            <div class="mb-3">
                <label for="area" class="form-label">Area</label>
                <input type="text" class="form-control" id="area" name="area">
            </div>

            <div class="mb-3">
                <label for="cost" class="form-label">Cost</label>
                <input type="number" class="form-control" id="cost" name="cost"  required pattern="^[1-9]\d*[.]?\d+$" title="Lương, Giá, Tiền đặt cọc phải là số dương.">
            </div>

            <div class="mb-3" id="maxPeople1">
                <label for="maxPeople" class="form-label">Max People</label>
                <input type="number" class="form-control" id="maxPeople" name="maxPeople">
            </div>

<%--            <div class="mb-3 w-25" id="rentType1">--%>
<%--                <label for="rentType" class="form-label">Rent Type</label>--%>
<%--                <select class="form-select" aria-label="Default select example" id="rentType" name="rentTypeId">--%>
<%--                    <option selected>Rent Type</option>--%>
<%--                    <c:forEach var="rentType" items="${idSetRentType}">--%>
<%--                        <option value="${rentType}">${rentTypeMap.get(rentType)}</option>--%>
<%--                    </c:forEach>--%>
<%--                </select>--%>
<%--            </div>--%>

<%--            <div class="mb-3 w-25" id="facilityType1">--%>
<%--                <label for="facilityType" class="form-label">Facility Type</label>--%>
<%--                <select class="form-select" aria-label="Default select example" id="facilityType" name="facilityTypeId">--%>
<%--                    <option selected>Facility Type</option>--%>
<%--                    <c:forEach var="facilityType" items="${idSetFacilityType}">--%>
<%--                        <option value="${facilityType}">${facilityTypeMap.get(facilityType)}</option>--%>
<%--                    </c:forEach>--%>
<%--                </select>--%>
<%--            </div>--%>

            <div class="mb-3" id="standardRoom1">
                <label for="standardRoom" class="form-label">Standard Room</label>
                <input type="text" class="form-control" id="standardRoom" name="standardRoom" value="">
            </div>

            <div class="mb-3" id="descriptionOtherConvenience1">
                <label for="descriptionOtherConvenience" class="form-label">Description Other Convenience</label>
                <input type="text" class="form-control" id="descriptionOtherConvenience" name="descriptionOtherConvenience" value="">
            </div>

            <div class="mb-3" id="poolArea1">
                <label for="poolArea" class="form-label">Pool Area</label>
                <input type="number" class="form-control" id="poolArea" name="poolArea" value="0">
            </div>

            <div class="mb-3" id="numberOfFloors1">
                <label for="numberOfFloors" class="form-label">Number Of Floors</label>
                <input type="number" class="form-control" id="numberOfFloors" name="numberOfFloors" value="0" required pattern="^[1-9]\d*$" title="Số lượng, Số tầng phải là số nguyên dương.">
            </div>

            <div class="mb-3" id="facilityFree1">
                <label for="facilityFree" class="form-label">Facility Free</label>
                <input type="text" class="form-control" id="facilityFree" name="facilityFree" value="">
            </div>
            <div>
                <button class="btn btn-outline-success" type="submit" name="action" value="save">SAVE</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
