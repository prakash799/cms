<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>|Page Created|</title>
</head>
<body>
	<%@include file="commoninclude.jsp"%>
	<%@include file="navigation.jsp"%>
	<div class="container-fluid">
		<table class="table table-responsive">
			<thead>
			<tr>
				<th>Page Id</th>
				<th>Page Name</th>
				<th>Page Title</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${allpages}" var="p">
				<tr>
					<td>${p.pageName}</td>
					<td>${p.pageTitle}</td>
					<td>${p.pageBody}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>