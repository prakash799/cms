<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>|Error Page|</title>
</head>
<body>
<c:if test="${not empty errCode}">
		<h1>${errCode} : System Errors</h1>
	</c:if>
	
	<c:if test="${empty errCode}">
		<h1>System Errors</h1>
	</c:if>

	<c:if test="${not empty errMsg}">
		<h4>${errMsg}</h4>
	</c:if>
</body>
</html>