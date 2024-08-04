<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><%@include file="css/design.jsp"%>

	<title>Purchase</title>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<center>
	<a href="index.html"><button type="button" class="btn btn-primary">Back to Home</button></a>
	</center>
	<br>
	<br>
	<br>
	<br>
    <div align="center" class="table">
        <table border="1" cellpadding="5" class="table-bordered">
        <h2>Confirm Purchase</h2>
            <tr>
            	<th scope="col">First Name</th>
            	<th scope="col">Last Name</th>
                <th scope="col">Departure Airport</th>
                <th scope="col">Arrival Airport</th>
                <th scope="col">Airline</th>
                <th scope="col">Departure Time</th>
                <th scope="col">Quantity</th>
                <th scope="col">Price</th>
                
            </tr>
            <tr>
            	<td><c:out value="${passenger.fname}"/></td>
            	<td><c:out value="${passenger.lname}"/></td>
            	<td><c:out value="${flight.source_airport}"/></td>
            	<td><c:out value="${flight.destination}"/></td>
            	<td><c:out value="${flight.airline}"/></td>
            	<td><c:out value="${flight.departure_time}"/></td>
            	<td><c:out value="${num}"/></td>
            	<td>$<c:out value="${flight.price}"/></td>
            </tr>
        </table>
        	<br>
        	<br>
        	<br>
        	<br>
           <a href="ticket?action=purchaseTicket&user_id=${requestScope.passenger.user_id}&flight_id=${requestScope.flight.flight_id}&num=${requestScope.num}">
           <button type="button" class="btn btn-warning">Confirm Purchase</button></a>
    </div>	
    <br>
</body>
</html>