<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>|Create New Page|</title>
<style type="text/css">
	.error{
		color: red;
	}
</style>
</head>
<body>
	<%@include file="commoninclude.jsp"%>
	<script src="<%=request.getContextPath()%>/staticresources/ckeditor/ckeditor.js"></script>
	
	<div class="container-fluid">
	<%@include file="navigation.jsp"%>
		<form:form action="submitcreatedpage" method="post" modelAttribute="pg">
		<c:set var="pageerror"><form:errors path="pageName"/></c:set>
			<div class="form-group">
				<div class="col-sm-3 col-sm-offset-2">
					<form:input path="pageName" name="pageName" class="form-control" type="text" placeholder="Enter Page Name" onfocus="this.placeholder=''" onblur="this.placeholder='Enter Page Name'"/>
				<form:errors path="pageName" cssClass="error" />					
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-3 col-sm-offset-1">
					<form:input path="pageTitle" name="pageTitle" class="form-control" type="text" placeholder="Enter Page Title" onfocus="this.placeholder=''" onblur="this.placeholder='Enter Page Title'"/>
				<form:errors path="pageTitle" cssClass="error"/>
				</div>
			</div>
			<div style="margin-top: 40px;" class="col-md-10 col-sm-offset-1">
				<form:errors path="pageBody" cssClass="error"/>
				<textarea rows="30" cols="60" name="pageBody"></textarea>
			</div>
			
				<script>
						CKEDITOR.replace( 'pageBody', { });
				</script>
			<div class="form-group">
			<div class="col-sm-3 col-sm-offset-1">
				<button type="submit" class="btn btn-primary">Submit</button>
				<button type="reset" class="btn btn-primary">Reset</button>
				<label style="size: 30px;"><form:errors path="pid" cssClass="error"/></label>
			</div>
			</div>
		</form:form>
	</div>
</body>
</html>