<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><%@include file="css/design.jsp"%>

	<title>Results</title>
</head>
<body>
	<center>
		<br>
		<br>
		<h1>Available Flights</h1>
	</center>
	<center>
	<a href="index.html"><button type="button" class="btn btn-primary">Start a new search</button></a>
	</center>
	<br>
	<br>
	<br>
	<br>
    <div align="center" class="table">
        <table border="1" cellpadding="5" class="table-bordered">
        <h2>Flight Search Results</h2>
            <tr>
                <th scope="col">Departure Airport</th>
                <th scope="col">Arrival Airport</th>
                <th scope="col">Airline</th>
                <th scope="col">Departure Time</th>
                <th scope="col">Arrival Time</th>
                <th scope="col">Price</th>
                
            </tr>
            <c:forEach var="flight" items="${flightList}">
                <tr>
                    <td><c:out value="${flight.source_airport}" /></td>
                    <td><c:out value="${flight.destination}" /></td>
                    <td><c:out value="${flight.airline}" /></td>
                    <td><c:out value="${flight.departure_time}" /></td>
                    <td><c:out value="${flight.arrival_time}" /></td>
                    <td>$<c:out value="${flight.price}" /></td>
                    <td><a href="passenger?action=addPassengerForm&flight_id=${flight.flight_id}&num=${num}">
                    <button type="button" class="btn btn-warning">Purchase</button></a></td>
				</tr>
                </tr>
            </c:forEach>
        </table>
    </div>	
    <br>
</body>
</html>