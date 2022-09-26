<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UpdateForm</title>
</head>
<body>
<h2>Update Food Details</h2>
<form action="FoodServlet" method="post">
<label>Enter id:</label> 
<input type="number" name="fId"  value="${food.foodId}" readonly="readonly"> 
<label>Enter name:</label>
<input type="text" name="fName"  value="${food.name}"> 
<label>Enter price:</label>
<input type="number" name="fPrice"  value="${food.price}"> 

<input type="submit" value="update"> 
<input type="hidden" name="act" value="update">
</form>
</body>
</html>