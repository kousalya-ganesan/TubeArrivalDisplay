<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="java.io.*,java.text.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tube Arrival Predictions</title>

<style type="text/css">
table.imagetable {
	font-family: "Comic Sans MS", cursive, sans-serif;
	font-size: 11px;
	border-width: 1px;
	border-color: #999999;
	overflow-y: auto;    /* Trigger vertical scroll    */
    overflow-x: hidden
}

table.imagetable th {
	background: MediumPurple;
	border-width: 1px;
	padding: 6px;
	border-style: solid;
	border-color: #999999;
	font-size: 1.25em;
}

table.imagetable td {
	background: SpringGreen;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #999999;
	font-size: 1.18em;
	font-weight: bold;
}

body {
	background-image: url("http://citytransport.info/Digi/P1340680a.jpg");
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
</head>
<body class="body">
	<%
		// Page will be auto refresh after 10 seconds
		response.setIntHeader("Refresh", 10);
	%>

	<br />
	<center>
		<h1 style="color: DarkSlateBlue;">Next trains due to arrive at
			${stationName}</h1>
	</center>

	<table width="100%" class="imagetable">
		<th colspan="7" style="background-color: SlateBlue"><font
			size="+1">${eastBoundTrainList}</font></th>
		<tr>
			<th>S.No</th>
			<th>Platform</th>
			<th>Towards</th>
			<th>Time To Station(HH:mm:ss)</th>
			<th>Expected Arrival</th>
			<th>Destination</th>
			<th>Current Location</th>

		</tr>
		<c:forEach var="eastBoundTrain" items="${eastBoundTrains}" varStatus="loopCounter" >
			<tr>
				<td><c:out value="${loopCounter.count}"/></td>
				<td><c:out value="${eastBoundTrain.platformName}" /></td>
				<td><c:out value="${eastBoundTrain.towards}" /></td>
				<td><c:out value="${eastBoundTrain.timeToStationInHHMM}" /></td>
				<td><c:out value="${eastBoundTrain.expectedArrival}" /></td>
				<td><c:out value="${eastBoundTrain.destinationName}" /></td>
				<td><c:out value="${eastBoundTrain.currentLocation}" /></td>
			</tr>
		</c:forEach>
	</table>

	<br />
	<table width="100%" class="imagetable">
		<th colspan="7" style="background-color: SlateBlue"><font
			size="+1">${westBoundTrainList}</font></th>
		<tr>
			<th>S.No</th>
			<th>Platform Name</th>
			<th>Towards</th>
			<th>Time To Station(HH:mm:ss)</th>
			<th>Expected Arrival</th>
			<th>Destination</th>
			<th>Current Location</th>
		</tr>
		<c:forEach var="westBoundTrain" items="${westBoundTrains}" varStatus="loopCount" >
			<tr>
				<td><c:out value="${loopCount.count}"/></td>
				<td><c:out value="${westBoundTrain.platformName}" /></td>
				<td><c:out value="${westBoundTrain.towards}" /></td>
				<td><c:out value="${westBoundTrain.timeToStationInHHMM}" /></td>
				<td><c:out value="${westBoundTrain.expectedArrival}" /></td>
				<td><c:out value="${westBoundTrain.destinationName}" /></td>
				<td><c:out value="${westBoundTrain.currentLocation}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>