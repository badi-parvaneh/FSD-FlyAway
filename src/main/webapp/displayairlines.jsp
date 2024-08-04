<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><%@include file="css/design.jsp"%>

	<title>Cities</title>
</head>
<body>
	<center>
		<br>
		<br>
		<h1>Airlines</h1>
	</center>
	<center>
	<a href="admindashboard.html"><button type="button" class="btn btn-primary">Back to Dashboard</button></a>
	</center>
	<br>
	<br>
	<br>
	<br>
    <div align="center" class="table">
        <table border="1" cellpadding="5" class="table-bordered">
        <h2>List of Airlines</h2>
            <tr>
                <th scope="col"></th>
                <th scope="col">Airline</th>               
            </tr>
            <c:forEach var="flight" items="${flightList}">
                <tr>
                    <td><c:out value="${flight.flight_id}" /></td>
                    <td><c:out value="${flight.airline}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>	
    <br>
</body>
</html>