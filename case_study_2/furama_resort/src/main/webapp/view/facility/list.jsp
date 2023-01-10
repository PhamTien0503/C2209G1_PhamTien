<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10-01-23
  Time: 4:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Facility</title>
    <link rel="stylesheet" href="bootstrap-5.1.3-dist/bootstrap-5.1.3-dist/css/bootstrap.css">
    <style>
        p {
            margin: 0 auto;
            text-align: justify;
        }
    </style>
</head>
<body>
<div>
    <div class="row bg-white  ">
        <div class="col-md-2 ">
            <img src="https://furamavietnam.com/wp-content/uploads/2018/08/logo.png " alt="Logo">
        </div>
        <div class="col-md-3  row">
            <img src="https://smartdata.tonytemplates.com/bestel/wp-content/uploads/2018/05/widget-tripadvisor-logo.png"
                 style="height: 20%;width: 80%" alt="Logo">
            <img src="https://furamavietnam.com/wp-content/uploads/2018/08/widget-tripadvisor-rating.png"
                 style="height: 30%;width: 60%" alt="logo">
            <p><i> 2746 reviews</i></p>
        </div>
        <div class="col-md-3  row">
            <span>&#10083</span> <i><span>103 – 105 Đường Võ Nguyên Giáp,</span></i><br>
            <p><i>Phường Khuê Mỹ, Quận Ngũ hành Sơn, Tp. Đà Nẵng, Việt Nam</i></p>
            <p><i>7.0 km từ Sân bay Quốc tế Đà Nẵng </i></p>
        </div>
        <div class="col-md-2  row">
            <span class="badge rounded-pill bg-primary w-50 h-25">Phone & Email</span>
            <span>84-236-3847 333/888</span>
            <span>reservation@furamavietnam.com</span>
        </div>
        <div class="col-md-2  row d-flex align-content-center">
            <div style="padding-left: 30%"><h4>PHẠM TIẾN</h4></div>
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
                            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                                <li class="nav-item">
                                    <a class="nav-link active" aria-current="page" href="/employee">Employee</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="/customer">Customer</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="/facility">Service</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link disabled" href="/contract" >Contract</a>
                                </li>
                            </ul>
                        </ul>
                        <form class="d-flex">
                            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                            <button class="btn btn-outline-success" type="submit">Search</button>
                        </form>
                    </div>
                </div>
            </nav>
        </div>
    </div>
    <h1 style="text-align: center"> Facility List </h1>
    <div>
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Name</th>
                <th scope="col">Area</th>
                <th scope="col">Cost</th>
                <th scope="col">Max of people</th>
                <th scope="col">Rent type</th>
                <th scope="col">Facility type</th>
                <th scope="col">Standard room</th>
                <th scope="col">Description other convenience</th>
                <th scope="col">Pool area</th>
                <th scope="col">Number of floor</th>
                <th scope="col">Facility Free</th>
                <th scope="col">Edit</th>
                <th scope="col">Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="facility" items="${facilityList}">
            <tr>
                <th scope="row">${facility.id}</th>
                <td>${facility.name}</td>
                <td>${facility.area}</td>
                <td>${facility.cost}</td>
                <td>${facility.maxPeople}</td>
                <td>${rentTypeMap.get(facility.rentTypeId)}</td>
                <td>${facilityTypeMap.get(facility.facilityTypeId)}</td>
                <td>${facility.standardRoom}</td>
                <td>${facility.descriptionOtherConvenience}</td>
                <td>${facility.poolArea}</td>
                <td>${facility.numberOfFloors}</td>
                <td>${facility.facilityFree}</td>
                <td>
                    <button type="button" class="btn btn-primary">Edit</button>
                </td>
                <td>
                    <button type="button" class="btn btn-danger">Delete</button>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <button type="button" class="btn btn-warning">ADD FACILITY</button>
    <div class="row bg-success">
        <div class="col-md-6">
            <h3> Liên hệ</h3>
            <h6>
                103 - 105 Vo Nguyen Giap Street, Khue My Ward, Ngu Hanh Son District, Danang City, Vietnam</h6>
            <h6>Tel.: 84-236-3847 333/888 * Fax: 84-236-3847 666</h6>
            <h6> Email: reservation@furamavietnam.com * www.furamavietnam.com GDS Codes: Amadeus-GD DADFUR,</h6>
            <h6> Galileo/Apollo-GD 16236, Sabre-GD 032771, Worldspan- GD DADFU</h6>
            </h1>
        </div>
        <div class="col-md-4">
            <h3> Hướng Dẫn Di Chuyển</h3>
            <h6>
                Khu nghỉ dưỡng Furama là cơ sở hàng đầu để khám phá một trong những điểm đến hấp dẫn nhất Châu Á.
                Địa chỉ chi tiết như bản đồ bên
            </h6>
        </div>
        <div class="col-md-2">
            <div>
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3834.491772817447!2d108.24887941400776!3d16.039950744484408!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31420fdbc8cc38ef%3A0x9a6a3e31121225d2!2sFurama%20Resort%20Danang!5e0!3m2!1svi!2s!4v1672327410548!5m2!1svi!2s"
                        width="200" height="150" style="border:1px;" allowfullscreen="" loading="lazy"
                        referrerpolicy="no-referrer-when-downgrade"></iframe>
            </div>
        </div>
    </div>
</div>
</body>
<script src="bootstrap-5.1.3-dist/bootstrap-5.1.3-dist/js/bootstrap.js"></script>
</html>
