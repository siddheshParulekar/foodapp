<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TiffinLo</title>
    <link rel="stylesheet" href="CSS//Homestyle.css">
</head>
<body >

   <div>
      <nav id="topnav">
         <ul >
            <li><a href="index.html">Home</a></li>
            <li> <a href="Home.jsp">Update Food</a> </li>
            <li><a href="UserHeader.jsp">Update User</a></li>
            <li> <a href="CartServlet?act=showcart"> Mycart</a></li>
            <li> <a href="Register.html"> Log Out</a></li>
         </ul>
       </nav>
   </div>
   <div id="Main">
    
    <div  id="slides">

        <img src='./Media/Dosa1.png' alt="Slides"  id="img1" height="300px"  width="100%">

    </div>

    <!-- <div id="Toggle">
        <div class="Option">
            <button id="bt1">Lunch</button>
            <button id="bt2">Dinner</button>
        </div>
    </div> -->


<sql:setDataSource var = "fooddata" driver = "com.mysql.cj.jdbc.Driver"
         url = "jdbc:mysql://localhost:3306/jdbc_siddhesh"
         user = "root"  password = "root"/>
 
      <sql:query dataSource = "${fooddata}" var = "result">
         SELECT * from food;
      </sql:query>

	 <c:forEach var = "row" items = "${result.rows}">
		<div id="ele-one" class="sections">
		     
		        <p class="Names"><b>${row.name}</b></p>
		        <p><i>${row.price}</i></p>
		        <p><i>${row.fid}</i></p>
		        <a  href="CartServlet?act=addToCart&id=${row.fid}">Add to cart</a>
    </div>		
	</c:forEach>

      
       
   </div>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
        var img = document.getElementById('img1');
        var imgarr = ['./Media/Dosa1.jpg','./Media/Dosa2.jpg','./Media/Dosa3.jpg','./Media/Dosa4.jpg','./Media/Dosa5.jpg'];
        var i = 0;
        function slide(){
            img.setAttribute('src',imgarr[i]);
            i++;
            if(i == imgarr.length){
                i = 0;
            }
        }
        setInterval('slide()',2000);   


        $(document).ready(function(){
              $(".AddTo").click(function(){
                
                alert("The Tiffin is added to the cart.");
              });

            
        })
    </script>
</body>
</html>