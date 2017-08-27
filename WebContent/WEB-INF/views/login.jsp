<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>CMS Application</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>|Login|</title>
<style type="text/css">
	.error{
		color: red;
	}
</style>
</head>
<body>
	<div class="container-fluid">
		<%@include file="/WEB-INF/views/header.jsp"%>
		<%@include file="/WEB-INF/views/commoninclude.jsp"%>		
		<form:form action="login" class="form-horizontal" method="post" modelAttribute="user">
			<div class="form-group">
			<div class="col-sm-4 col-sm-offset-4">
				<form:input path="loginid" name="loginid" class="form-control" placeholder="Enter your Id" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter your Id'"/>
				<form:errors path="loginid" cssClass="error" />
			</div>
			</div>
			<div class="form-group">
			<div class="col-sm-4 col-sm-offset-4">
				<form:input type="password" path="password" name="password"  class="form-control" placeholder="Enter your Password" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter your Password'"/>
				<form:errors path="password" cssClass="error" />
			</div>
			</div>
			<div class="col-sm-1 col-sm-offset-4">
				<input type="submit" class="btn btn-success" value="Login">
			</div>
		</form:form>
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>