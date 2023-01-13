<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12-01-23
  Time: 10:29 AM
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
                            <a class="nav-link active" aria-current="page" href="/employee">Sach</a>
                        </li>
                    </ul>
                    <form class="d-flex" action="/employee" method="get">
                        <input class="form-control me-2" type="text" placeholder="name" aria-label="Search" name="name"
                               value="">




                        <button class="btn btn-outline-success" type="submit" name="action" value="search">Search
                        </button>
                    </form>
                </div>
            </div>
        </nav>
    </div>
    <div>
        <h1 style="text-align: center"> THONG KE SACH DANG CHO MUON </h1>
        <h3 style="color: red;text-align: center" >${mess}</h3>
<%--        <button type="submit" class="btn btn-outline-success m-2 "><a href="/employee?action=create">THEM SACH</a></button>--%>
        <%--        table--%>
        <div>
            <table class="table table-striped" id="sachTable" >
                <thead>
                <tr>
                    <th scope="col">Ma muon sach</th>
                    <th scope="col">Ten Sach</th>
                    <th scope="col">Tac gia</th>
                    <th scope="col">Ten hoc sinh</th>
                    <th scope="col">Lop</th>
                    <th scope="col">Ngay muon</th>
                    <th scope="col">Ngay tra</th>
                    <th scope="col">Tra sach</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="theMuonSach" items="${theMuonSachList}">
                    <tr>
                        <td>${theMuonSach.maMuonSach}</td>
                    <c:forEach var="sach" items="${sachList}">
                        <c:if test="${theMuonSach.getSach().getMaSach().equals(sach.maSach)}">
                            <td>${sach.tenSach}</td>
                            <td>${sach.tacGia}</td>
                        </c:if>
                    </c:forEach>
                    <c:forEach var="hocSinh" items="${hocSinhList}">
                        <c:if test="${theMuonSach.getHocSinh().ma_hoc_sinh==hocSinh.ma_hoc_sinh}">
                        <td>${hocSinh.ho_ten}</td>
                        <td>${hocSinh.lop}</td>
                        </c:if>
                    </c:forEach>
                        <td>${theMuonSach.ngayMuon}</td>
                        <td>${theMuonSach.ngayTra}</td>
                        <td>
                            <button type="submit" class="btn btn-outline-primary"><a href="/employee">Tra sach</a></button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form action="/employee" method="post">
                        <div class="modal-body">
                            <input type="hidden" id="deleteId" name="id">
                            <span>Ban co muon xoa nhan vien</span>
                            <span id="deleteName"></span>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                            <button type="submit" class="btn btn-primary" name="action" value="delete">Delete</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>
<script>
    function infoDelete(id,name){
        document.getElementById("deleteName").innerText=name;
        document.getElementById("deleteId").value=id;
    }
</script>
</script>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function() {
        $('#sachTable').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        } );
    } );
</script>
</body>
<script src="bootstrap-5.1.3-dist/bootstrap-5.1.3-dist/js/bootstrap.js"></script>
</html>
