<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>|Feedback|</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/staticresources/scripts/custom.js"></script>
<style type="text/css">
	.error{
		color: #ff0000;
	}
</style>
</head>
<body>
	<div class="container-fluid">
	<%@include file="commoninclude.jsp"%>
	<%@include file="navigation.jsp" %>
		<c:if test="${not empty message}">
		<h5 style="color: green" align="center">${message}</h5>
		</c:if>
		<form:form  class="form-horizontal" action="submitfeedback" modelAttribute="userfeedback">
			<div class="form-group">
			<div class="col-sm-4 col-sm-offset-4">
				<form:input class="form-control" name="username" path="username" type="text" placeholder="Enter your name" onfocus="this.placeholder=''" onblur="this.placeholder='Enter your name'"/>
				<form:errors path="username" cssClass="error"/>
			</div>
			</div>
			<div class="form-group">
			<div class="col-sm-4 col-sm-offset-4">
				<form:input class="form-control" name="useremail" path="useremail" type="text" placeholder="Enter your email" onfocus="this.placeholder=''" onblur="this.placeholder='Enter your email'"/>
				<form:errors path="useremail" cssClass="error"/>
			</div>
			</div>
			<div class="form-group">
			<div class="col-sm-4 col-sm-offset-4">
				<form:input class="form-control" name="userphone" onkeypress="return isNumberKey(event)" path="userphone" type="text" placeholder="Enter your phone" onfocus="this.placeholder=''" onblur="this.placeholder='Enter your phone'"/>
				<form:errors path="userphone" cssClass="error"/>
			</div>
			</div>
			<div class="form-group">
			<label class="col-sm-4 col-sm-offset-4">Enter your Feedback</label>
			<div class="col-sm-4 col-sm-offset-4">
				<form:textarea name="userfeedback" path="userfeedback" rows="10" cols="65"></form:textarea>
				<form:errors path="userfeedback" cssClass="error"/>
			</div>
			</div>
			<div class="col-sm-4 col-sm-offset-4">
				<input type="submit" class="btn btn-success" value="Submit Feedback">
				<input type="reset" class="btn btn-success" value="Reset">
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