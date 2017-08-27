<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>|Registration Page|</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/staticresources/scripts/custom.js"></script>
<style type="text/css">
	.error{
		color: red;
	}
	.password{
		color: red;
	}
</style>
</head>
<body>
	<div class="container-fluid">
		<%@include file="commoninclude.jsp" %>
		<%@include file="navigation.jsp" %>
		<form:form action="processregistration" class="form-horizontal" method="post" modelAttribute="user">
			<div class="form-group">
			<div class="col-sm-4 col-sm-offset-4">
			<form:input type="text" name="name" id="name" path="name" class="form-control" placeholder="Enter your full name" onfocus="this.placeholder=''" onblur="this.placeholder='Enter your full name'"/>
			<form:errors path="name" cssClass="error"/>
			</div>
			</div>
			<div class="form-group">
			<div class="col-sm-4 col-sm-offset-4">
			<form:input type="text" name="email" id="email" onkeydown="checkEmailStatus()" path="email" class="form-control" placeholder="Enter your email" onfocus="this.placeholder=''" onblur="this.placeholder='Enter your Enter your email'"/>
			<form:errors path="email" cssClass="error"/>
			<div id="email_availability"></div>
			</div>
			</div>
			<div class="form-group">
			<div class="col-sm-4 col-sm-offset-4">
			<form:input type="text" name="phone" id="phone" onkeypress="return isNumberKey(event)" path="phone" class="form-control" placeholder="Enter your phone number" onfocus="this.placeholder=''" onblur="this.placeholder='Enter your phone number'"/>
			<form:errors path="phone" cssClass="error"/>
			</div>
			</div>
			<div class="form-group">
			<div class="col-sm-4 col-sm-offset-4">
			<form:input type="text" name="loginid" id="loginid" onkeypress="return isNumberKey(event)" path="loginid" class="form-control" placeholder="Enter your login id" onfocus="this.placeholder=''" onblur="this.placeholder='Enter your login id'"/>
			<form:errors path="loginid" cssClass="error"/>
			</div>
			</div>
			<div class="form-group">
			<div class="col-sm-4 col-sm-offset-4">
			<form:input type="password" name="password" id="password" path="password" class="form-control" placeholder="Enter your password" onfocus="this.placeholder=''" onblur="this.placeholder='Enter your password'"/>
			<form:errors path="password" cssClass="password"/>
			</div>
			</div>
			<div class="col-sm-4 col-sm-offset-4">
				<input type="submit" value="Register" class="btn btn-success">
				<input type="reset" value="Reset" class="btn btn-success">
			</div>
		</form:form>
	</div>
	<script type="text/javascript">
	$(".reset").click(function() {
	    $(this).closest('form').find("input[type=password],input[type=text]").val("");
	});
	</script>
</body>
</html>