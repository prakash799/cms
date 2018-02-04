<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>|List All Feedback|</title>
<%@include file="/WEB-INF/views/commoninclude.jsp"%>
<%@include file="/WEB-INF/views/navigation.jsp"%>
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
        <th>User Name</th>
        <th>Email</th>
        <th>Phone Number</th>
        <th>Comments</th>
      </tr>
    </thead>
    <tfoot>
    <tr>
        <th>User Name</th>
        <th>Email</th>
        <th>Phone Number</th>
        <th>Comments</th>
      </tr>
    </tfoot>
    <tbody>
    <c:forEach items="${listfeedback}" var="element">
      <tr>
        <td>${element.username }</td>
        <td>${element.useremail}</td>
        <td>${element.userphone}</td>
        <td>${element.userfeedback}</td>
      </tr>
     </c:forEach>
    </tbody>
  </table>
	</div>
</body>
</html>