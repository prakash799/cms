<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>|Upload Images and Video|</title>
<link href="<%=request.getContextPath()%>/staticresources/style/bootstrap/css/stylesheet.css" rel="stylesheet">
</head>
<body>
	<div class="container-fluid">
		<%@include file="commoninclude.jsp"%>
		<%@include file="navigation.jsp"%>
		
		<form action="uploadFile" method="post" enctype="multipart/form-data">
		<label class="btn btn-primary" for="my-file-selector">
    		<input name="multipartFile" id="my-file-selector" type="file" style="display:none;" onchange="$('#upload-file-info').html($(this).val());"/>
    		Select file...
		</label>
		<span class='label label-info' id="upload-file-info"></span>
		<input id="chargeBar3" type="submit" value="Upload File" class="btn btn-success"> 
		<h3>${message}</h3>
		</form>
	</div>

</body>
</html>