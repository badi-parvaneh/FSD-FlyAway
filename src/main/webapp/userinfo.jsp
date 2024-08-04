<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><%@include file="css/design.jsp"%>

	<title>Customer Management Application</title>
</head>
<body>
	<center>
       	<br>
       	<br>
       	<br>
       	<a href="index.html"><button type="button" class="btn btn-primary">Back to Home Page</button></a>
        	
		<br>
       	<br>
       	<br>
       	<br>
       	<br>
       	<br>
    <div align="center">
    
    <form action="passenger?action=addPassenger&flight_id=${requestScope.flight_id}&num=${requestScope.num}" method="post">
        <table border="1" cellpadding="5">
           	<h2>Enter Your Information</h2>
             
            <tr>
                <th>First Name: </th>
                <td>
                <input type="text" name="fname" class="form-control" size="45"/>
                </td>  
            </tr>
            
            <tr>
                <th>Last Name: </th>
                <td>
                <input type="text" class="form-control" name="lname" size="45"/>
                </td> 
            </tr>
            
            <tr>
                <th>Email: </th>
                <td>
                <input type="email" class="form-control" name="email" size="45"/>
                </td> 
            </tr>
           
            <tr>
            	<td colspan="2" align="center">
           			<input type="submit" class="btn btn-warning" value="Proceed">
            	</td>
            </tr>
        </table>
        </form>

    </div>	
</body>
</html>