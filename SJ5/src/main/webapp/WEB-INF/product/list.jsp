<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>List of products</title>
    </head>
    <body>
    	<h2>List of products</h2> 
    	<a href="/product/new">New</a>
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
                        	<a href="/product/${product.productId}">Detail</a>
                        	<a href="/product/delete/${product.productId}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>
        	<c:if test="${page.getNumber() > 0 }">
        		<a href="/product?pageNumber=${page.getNumber() - 1}">Previous</a>
        	</c:if>
        	${ page.getNumber() + 1} / ${page.getTotalPages() }
        	<a href="/product?pageNumber=${page.getNumber() + 1}">Next</a>
        </p>
    </body>
</html>