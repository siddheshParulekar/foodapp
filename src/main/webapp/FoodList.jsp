<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Food List</title>
</head>
<body>
 <jsp:include page="Header.jsp"></jsp:include> 
${successMessage}
<table>
<c:forEach items="${fList}" var="food">
<tr>
	<td>${food.name}</td>
	<td>${food.price}</td>
	<td>${food.foodId}</td>
	
	<td><a href="FoodServlet?act=delete&id=${food.foodId}">delete</a></td>
	<td><a href="FoodServlet?act=foodupdate&id=${food.foodId}">update</a></td>
	<td><a href="CartServlet?act=addtocart&id=${food.foodId}">ADD to CART</a> 
</tr>
</c:forEach>
</table>
</body>
</html>