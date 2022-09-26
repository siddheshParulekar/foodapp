<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% ArrayList<String> list= (ArrayList<String>)session.getAttribute("cartList");  %>
<table class="styled-table">
<thead>
	<tr>
		<th>food Id</th>
		<th>food Name</th>
		<th>food Price</th>
		<th>Quantity</th>
		<th>Total price</th>
		<th>Action</th>
	</tr>
</thead>
<tbody>
<% if (list.size()!=0) { %>
         <c:forEach items="${cartList}" var="food" >
	
		<tr>
		<td id="foodId${i}">${food.foodId}</td>
		<td>${food.name}</td>
		
		<td id="foodPrice${i }">${food.price}</td>
		<td><input id="foodQuantity${i}" class="" type="number" min="1" max="50" value="1" oninput="updateCart(${i })"> </td>
		<td id="totalPrice${i}" class="tprice">${food.price}</td>
		<td><a href="CartServlet?act=removefood&id=${food.foodId}">remove</a></td>
		</tr>
		<c:set var="i" value="${i+1}"></c:set>
	</c:forEach>
      <% } else { %>
      <tr>
         <td></td>
         <td></td>
         <td></td>
         <td>YOUR CART IS EMPTY...</td>
         <td></td>
         <td></td>
         <td></td>
      <% } %>
      </tr>
	
	
</tbody>
</table>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
function updateCart(i){
	
	 let quantity=document.getElementById("foodQuantity"+i).value;
	 console.log(quantity);
	 let foodId=document.getElementById("foodId"+i).innerText;
	 console.log(foodId);
	let foodPrice=document.getElementById("foodPrice"+i).innerText;
	 console.log(foodPrice);
	let totalPrice=quantity*foodPrice;
	document.getElementById("totalPrice"+i).innerText=totalPrice;
	console.log(totalPrice); 
	$.post('CartServlet?act=update', 
			{quantity:quantity, foodId:foodId,totalPrice:totalPrice },
			function(response){ 
	    	console.log("success");
			});	 
}
</script>
</body>
</html>