<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
<div class="container">
    <c:if test="${pro.id==null}">
        <c:set var="uri" scope="session" value="/admin/skin/add"></c:set>
    </c:if>
    <c:if test="${pro.id!=null}">
        <c:set var="uri" scope="session" value="/admin/skin/update?id=${pro.id}"></c:set>
    </c:if>
    <%--@elvariable id="skin" type="lombok"--%>
    <form:form action="${uri}" method="post" modelAttribute="skin" enctype="multipart/form-data">
        <div class="row">
            <div class="form-group mt-4 col-6">
                <label class="form-label">type</label>
                <form:select class="form-select" path="type">
                    <form:options itemValue="id" itemLabel="name" items="${listCate}"></form:options>
                </form:select>
            </div>
            <div class="form-group mt-4 col-6">
                <form:label path="name">Name Product</form:label>
                <form:input name="name" path="name" class="form-control" value="${skin.name}"/>
            </div>
            <div class="form-group mt-4 col-6">
                <form:label path="image" class="form-lable">Image</form:label>
                <input type="file" class="form-control" name="attach">
            </div>
            <div class="form-group mt-4 col-6">
                <form:label path="price">Price</form:label>
                <form:input name="price" path="price" class="form-control" value="${skin.price}"/>
            </div>
            <div class="form-group mt-4 col-6">
                <form:label path="buff">Buff</form:label>
                <form:input name="buff" path="buff" class="form-control" value="${skin.buff}"/>
            </div>
            <div class="form-group mt-4 col-6">
                <form:label path="rare">Rare</form:label>
                <form:input name="rare" path="rare" class="form-control" value="${skin.rare}"/>
            </div>
        </div>
        <c:if test="${pro.id==null}">
            <button class="btn btn-success mt-2">Thêm</button>
        </c:if>
        <c:if test="${pro.id!=null}">
            <button class="btn btn-success mt-2">Cập Nhật</button>
        </c:if>
        <button type="reset" class="btn btn-primary mt-2">Làm Mới</button>
        <br>

        <c:if test="${empty list.content}">
            <p class="alert alert-warning">
                Vui Lòng Thêm Mới Dữ Liệu
            </p>
        </c:if>
        <c:if test="${!empty sessionScope.message }">
            <div class="alert alert-success mt-3">
                    ${ sessionScope.message }
                <c:remove var="message" scope="session"/>
            </div>
        </c:if>
        <c:if test="${!empty sessionScope.error }">
            <div class="alert alert-danger mt-3">
                    ${ sessionScope.error }
                <c:remove var="error" scope="session"/>
            </div>
        </c:if>
    </form:form>
    <form action="/admin/skin/search" method="get" class="row g-3 mb-3 mt-2">
        <div class="col-11">
            <input type="text" name="search" class="form-control">
        </div>
        <div class="col-1">
            <button type="submit" class="btn btn-primary">Tìm Kiếm</button>
        </div>
    </form>

    <table class="table table-success table-striped">
        <thead>
        <tr>
            <th>STT</th>
            <th>Type</th>
            <th>Image</th>
            <th>Name</th>
            <th>buff</th>
            <th>rare</th>
            <th>Price</th>
            <th>CreatedDate</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>

            <c:forEach items="${list.content}" var="skin" varStatus="status">
                <tr>
                    <td>#${status.count}</td>
                    <td>${skin.type.name}</td>
                    <td><img src="${skin.image}" height="50px"></td>
                    <td>${skin.name}</td>
                    <td>${skin.buff}</td>
                    <td>${skin.rare}</td>
                    <td><fmt:formatNumber value="${skin.price}" pattern="#,###"/> VND</td>
                    <td><fmt:formatDate value="${skin.createdDate}" pattern="dd/MM/yyyy"/></td>
                    <td>
                        <a href="/admin/skin/edit?id=${skin.id}" class="btn btn-primary">Cập Nhật</a>
                    </td>
                    <td>
                        <a data-bs-toggle="modal" data-bs-target="#b${skin.id}" class="btn btn-danger">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="row">
        <div class="col-6">
            <p class="d-flex justify-content-start">
                Trang Số : <span style="color: red">&nbsp ${list.number + 1} </span> &nbsp trong tổng số : <span
                    style="color: red">&nbsp${list.totalPages} </span>
            </p>
            <p class="d-flex justify-content-start">
                Hiển Thị : <span style="color: red"> &nbsp${list.numberOfElements} </span> &nbsp trong tổng số : <span
                    style="color: red"> &nbsp${list.totalElements} </span> &nbsp sản phẩm
            </p>
        </div>
        <nav aria-label="Page navigation example" class="d-flex justify-content-end col-6">
            <ul class="pagination">
                <c:if test="${list.number-1>0}">
                    <c:set var="number" scope="session" value="?page=${list.number -1}"></c:set>
                </c:if>
                <c:if test="${list.number-1<1}">
                    <c:set var="number" scope="session" value=""></c:set>
                </c:if>
                <c:if test="${list.number+1>list.totalPages}">
                    <c:set var="numberup" scope="session" value="?page=${list.totalPages}"></c:set>
                </c:if>
                <c:if test="${list.number+1<list.totalPages}">
                    <c:set var="numberup" scope="session" value="?page=${list.number+1}"></c:set>
                </c:if>
                <li class="page-item"><a class="page-link" href="/admin/skin/index${number} ">Previous</a></li>
                <c:forEach var="i" begin="0" end="${ list.totalPages - 1 < 0 ? 0:list.totalPages - 1 }">
                    <li class="page-item"><a class="page-link" href="/admin/skin/index?page=${ i }">${ i + 1 }</a></li>

                </c:forEach>
                <li class="page-item"><a class="page-link" href="/admin/skin/index${numberup}">Next</a></li>
            </ul>
        </nav>
    </div>
</div>
<c:forEach items="${list.content}" var="skin" varStatus="status">
    <div id="b${skin.id}" class="modal" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="modal-title">Xác nhận</h3>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                            aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <h5>Bạn muốn xóa skin ${skin.name} ?</h5>
                </div>
                <div class="modal-footer">
                    <form action="/admin/skin/delete" method="post">
                        <input type="hidden" value="${skin.id}" name="id">
                        <button class="btn btn-danger">Xóa</button>
                    </form>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"
                            aria-label="Close">Hủy
                    </button>
                </div>
            </div>
        </div>
    </div>
</c:forEach>

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
        crossorigin="anonymous"></script>
<script>
    $(document).ready(function () {
        // Activate tooltip
        $('[data-toggle="tooltip"]').tooltip();

        // Select/Deselect checkboxes
        var checkbox = $('table tbody input[type="checkbox"]');
        $("#selectAll").click(function () {
            if (this.checked) {
                checkbox.each(function () {
                    this.checked = true;
                });
            } else {
                checkbox.each(function () {
                    this.checked = false;
                });
            }
        });
        checkbox.click(function () {
            if (!this.checked) {
                $("#selectAll").prop("checked", false);
            }
        });
    });
</script>
</div>
