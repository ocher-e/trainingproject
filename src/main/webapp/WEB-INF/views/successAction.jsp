<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Professor entering confirmation</title>
	<!--<link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>-->
</head>
<body>
	<div class="success">
		Confirmation message : ${success}
	</div>
        <h2><a href="<c:url value="/logout" />" > Logout</a></h2>
</body>
</html>