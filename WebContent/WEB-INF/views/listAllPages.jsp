<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="commoninclude.jsp"%>
<%@include file="navigation.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>|Page Created|</title>
<script type="text/javascript">
$(document).ready(function(){
	 $('#example').DataTable();
});
</script>
</head>
<body>
	
	<div class="container-fluid">
		<table id="example" class="display" cellspacing="0" width="100%">
			<thead>
			<tr>
				<th>Page Id</th>
				<th>Page Name</th>
				<th>Page Title</th>
				<th>Action</th>
			</tr>
			</thead>
			<tfoot>
			<tr>
				<th>Page Id</th>
				<th>Page Name</th>
				<th>Page Title</th>
				<th>Action</th>
			</tr>
			</tfoot>
			<tbody>
			<c:forEach items="${allpages}" var="p">
				<tr>
					<td>${p.pid}</td>
					<td>${p.pageName}</td>
					<td>${p.pageTitle}</td>
					<td>
					<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
						<a href="/spring_cms/page?id=${p.pid}" target="_blank"><input type="button" class="btn btn-info btn-xs" value="View Page"></a> | 
						<a href="/spring_cms/editpage?id=${p.pid}"><input type="button" class="btn btn-primary btn-xs" value="Edit"></a> |
						<a href="/spring_cms/deletepage?id=${p.pid}"><input type="button" onclick="return confirm('Are you sure to delete this page?')" class="btn btn-danger btn-xs" value="Delete"></a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>