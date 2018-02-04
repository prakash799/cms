<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>|error page|</title>
</head>
<body>
<c:if test="${not empty errCode}">
		<h1>${errCode}: System Errors</h1>
		<h1>${errMsg}</h1>
	</c:if>

	<c:if test="${empty errCode}">
		<h1>${errCode} Invalid User!</h1>
		<h1>${errMsg}</h1>
	</c:if>

	<c:if test="${not empty errMsg}">
		<h2>${errMsg}</h2>
	</c:if>
</body>
</html>