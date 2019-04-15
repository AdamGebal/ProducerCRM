<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Producer list</title>
</head>
<body>
<h2>Producers</h2>
<c:forEach var="producer" items="${producers}">
<br/>${producer.name} - ${producer.email}
	<c:forEach var="producerCode" items="${producer.producerCodes}">
		<br/>====== ${producerCode.code}
		</c:forEach>
</c:forEach>
<br/><br/>

</body>
</html>