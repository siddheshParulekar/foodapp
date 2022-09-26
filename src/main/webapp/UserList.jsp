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
 <jsp:include page="UserHeader.jsp"></jsp:include> 
${successMessage}
<table>
<c:forEach items="${uList}" var="user">
<tr>
	<td>${user.name}</td>
	<td>${user.username}</td>
	<td>${user.emailId}</td>
	<td>${user.password}</td>
	<td>${user.contact}</td>
	
	<td><a href="UserServlet?act=delete&username=${user.username}">delete</a></td>
	<td><a href="Change.html">update</a></td>
	<td><a href="CartServlet?act=addtocart&id=${food.foodId}">ADD to CART</a> 
</tr>
</c:forEach>
</table>
</body>
</html>