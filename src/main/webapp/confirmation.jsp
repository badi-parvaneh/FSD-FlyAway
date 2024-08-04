<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head><%@include file="css/design.jsp"%>

<title>Confirmation</title>
</head>
<body>
	<br>
	<br>
	<br>
	<center>
		<h1>Your ticket is confirmed!</h1>
		
	</center>
	<br>
	<br>
	<br>
	<div align="center"  class="table">
		<table border="0" cellpadding="5" class="table-bordered">
		
			<tr>
			<th scope="col">Ticket ID</th>
			<th  scope="col">First Name</th>
			<th  scope="col">Last Name</th>
			<th  scope="col">Flight ID</th>
			<th  scope="col">Quantity</th>
		 	<th  scope="col">Price</th>
		 	<th  scope="col">Status</th>
			</tr>

			<tr>
			<td><c:out value="${ticket.id}" /></td>
				<td><c:out value="${ticket.fname}" /></td>
				<td><c:out value="${ticket.lname}" /></td>
				<td><c:out value="${ticket.flight_id}" /></td>
				<td><c:out value="${ticket.quantity}" /></td>	
				 <td>$<c:out value="${ticket.price}" /></td> 
				 <td><c:out value="${ticket.status}" /></td>
			</tr>
		</table>
	</div><br>
	<br>
	<br>
	<br>
	<center>
		<h1>Your Flight Details:</h1>
	</center>
		<br>
		<br>
	<div align="center"  class="table">
		<table border="0" cellpadding="5" class="table-bordered">
		
			<tr>
			<th scope="col">Departure Airport</th>
			<th  scope="col">Arrival Airport</th>
			<th  scope="col">Departure Date and Time</th>
			<th  scope="col">Airline</th>
			</tr>

			<tr>
			<td><c:out value="${flight.source_airport}" /></td>
				<td><c:out value="${flight.destination}" /></td>
				<td><c:out value="${flight.departure_time}" /></td>
				<td><c:out value="${flight.airline}" /></td>
			</tr>
		</table>
	</div><br>
	
</body>
</html>