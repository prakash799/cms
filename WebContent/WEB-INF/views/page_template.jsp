<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/WEB-INF/views/commoninclude.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${page.pageTitle}</title>

</head>
<body>
<%@include file="/WEB-INF/views/template_header.jspf" %>
<div class="container">
${page.pageBody }
</div>
<%@include file="/WEB-INF/views/template_footer.jspf" %>
</body>
</html>