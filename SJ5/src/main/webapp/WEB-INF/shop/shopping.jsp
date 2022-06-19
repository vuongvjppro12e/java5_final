<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>vuongchimto</title>
</head>
<body>
	<h2>Phong's Store</h2>
	<a href="/shop/cart">Go to Cart</a>
	<table border=1>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${page.getContent()}" var="product">
                    <tr>
                        <td>${product.productId}</td>
                        <td>${product.productName}</td>
                        <td>${product.quantity}</td>
                        <td>${product.price}</td>
                        <td>
                        	<a href="/shop/cart/${product.productId}">Add to Cart</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>
        	<c:if test="${page.getNumber() > 0 }">
        		<a href="/shop?pageNumber=${page.getNumber() - 1}">Previous</a>
        	</c:if>
        	${ page.getNumber() + 1} / ${page.getTotalPages() }
        	<a href="/shop?pageNumber=${page.getNumber() + 1}">Next</a>
        </p>
</body>
</html>