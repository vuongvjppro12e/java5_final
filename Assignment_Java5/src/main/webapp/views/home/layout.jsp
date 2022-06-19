<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
        crossorigin="anonymous"></script>
<head>
    <meta charset="UTF-8">
    <title>IT16304</title>
    <link rel="stylesheet"
          href="../../js/bootstrap.min.js"/>
</head>
<nav class="navbar navbar-expand-lg navbar-light bg-light mx-5 ">
    <div class="container-fluid">
        <a class="navbar-brand" href="/home/index">GUN_STORE</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <c:if test="${sessionScope.user.admin ==1}">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                           aria-expanded="false">
                            USER
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="/admin/user/index">User manager</a></li>
                            <li><a class="dropdown-item" href="#">...</a></li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li><a class="dropdown-item" href="#">Something else here</a></li>
                        </ul>
                    </li>
                  <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                      SKIN
                    </a>

                    <ul class="dropdown-menu">
                      <li><a class="dropdown-item" href="/admin/skin/index">skin manager</a></li>
                      <li><a class="dropdown-item" href="#">...</a></li>
                      <li>
                        <hr class="dropdown-divider">
                      </li>
                      <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                  </li>
                  <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                      TYPE
                    </a>
                    <ul class="dropdown-menu">
                      <li><a class="dropdown-item" href="/admin/type/index">type manager</a></li>
                      <li><a class="dropdown-item" href="#">...</a></li>
                      <li>
                        <hr class="dropdown-divider">
                      </li>
                      <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                  </li>
                </c:if>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        ORDER
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="/home/cart">cart</a></li>
                        <li><a class="dropdown-item" href="/admin/order/index">order</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        ACCOUNT
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">đăng xuất</a></li>
                        <li><a class="dropdown-item" href="/login">đăng nhập</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                </li>

            </ul>
            <div class="me-5">using: <a class="text-dark"> ${sessionScope.user != null ? user.username:"none" }</a>
            </div>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<body>
<div class="container">
    <jsp:include page="${views}"/>
</div>
</body>

<footer class="bg-light text-center text-lg-start mt-4">
    <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
        © 2022 Copyright:
        <a class="text-dark" href="https://www.facebook.com/VTV.vjpPro/"> VUONGVT-PH15053</a>
    </div>
</footer>
<script src="../../js/jquery.min.js"></script>
<script src="../../js/popper.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
</html>