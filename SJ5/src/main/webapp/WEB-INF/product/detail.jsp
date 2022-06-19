<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Product Detail</title>
</head>
<body>
	<a href="/product">Back to List</a>
	<h2>Detail of Product - ${product.productId}</h2>
	<form:form method="PUT" action="/product/update" modelAttribute="product">
		<table>
			<form:input type="hidden" path="productId" value="${product.productId}" />
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name" value="${product.productName}" /></td>
			</tr>

			<tr>
				<td><form:label path="quantity">Quantity</form:label></td>
				<td><form:input path="quantity" type="number"
						value="${product.quantity}" /></td>
			</tr>
			<tr>
				<td><form:label path="price">Price</form:label></td>
				<td><form:input path="price" type="number"
						value="${product.price}" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>