<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="com.cms.page.PageService"%>
<%@page import="com.cms.page.PageServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="navObj" class="com.cms.navigation.Navigation" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>|Create New Navigation|</title>
<style type="text/css">
	.error{
		color: #ff0000;
	}
</style>
</head>
<body>
	<div class="container-fluid">
	<%@include file="navigation.jsp" %>
	<%@include file="commoninclude.jsp"%>
		<form:form method="post" action="createnav" class="form-horizontal" modelAttribute="nav">
			<div class="form-group">
			<div class="col-sm-4 col-sm-offset-4">
				<form:input type="text" class="form-control" path="label" name="label" placeholder="Enter Navigation label" onfocus="this.placeholder" onblur="this.placeholder='Enter Navigation label'"/>
				<form:errors cssClass="error" path="label"/>
			</div>
			</div>
			<div class="form-group">
			<div class="col-sm-4 col-sm-offset-4">
				<form:input type="text" class="form-control" path="title" name="title" placeholder="Enter Title for navigation" onfocus="this.placeholder" onblur="this.placeholder='Enter Title for navigation'"/>
				<form:errors cssClass="error" path="title"/>
			</div>
			</div>
			<div class="form-group">
			<div class="col-sm-4 col-sm-offset-4">
				<form:input type="text" class="form-control" path="pageOrder" name="pageOrder" placeholder="Enter Page Order" onfocus="this.placeholder" onblur="this.placeholder='Enter Page Order'"/>
				<form:errors cssClass=" error" path="pageOrder"/>
			</div>
			</div>
			
			<div class="form-group">
			<div class="col-sm-4 col-sm-offset-4">
				<form:select path="" name="pid" class="form-control">
					<form:option value="NONE" label="---Select---"/>
					<c:forEach var="entry" items="${map}">
					
					<option value="${entry.key}">${entry.value}</option>
			
					</c:forEach>
				</form:select>
			</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-4 col-md-offset-4">
					<input class="btn btn-primary btn-sm-4" type="submit" value="Submit">
					<input class="btn btn-primary btn-sm-4" type="reset" value="Reset">
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>