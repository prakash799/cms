<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0 maximum-scale=1.0, user-scalable=no"/>
<title>|User Details|</title>
<%@include file="/WEB-INF/views/commoninclude.jsp"%>
<%@include file="/WEB-INF/views/navigation.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/staticresources/scripts/custom.js"></script>
<script type="text/javascript">
function openpopupForm(){
	$( "#dialog-1" ).dialog({
        autoOpen: false,
        modal: true,
        hide: "puff",
        show : "slide",
        height:600,
        width:1000
     });
	
	$( "#dialog-1" ).dialog({
        autoOpen: false,  
     });
	$( "#dialog-1" ).dialog( "open" );
}
function fillForm(userId){
	$.ajax({
	      type: 'POST',
	      url: "getuserdetails",
	      data:{id:userId,updateflag:''},
	      dataType: "text",
	      success: function(resultData) { 
	    	  
	    	 var responseData= JSON.parse(resultData);
	    	 $('#userid').val(responseData.id);
	    	 $('#name').val(responseData.name);
	    	 $('#loginid').val(responseData.loginid);
	    	 $('#email').val(responseData.email);
	    	 $('#phone').val(responseData.phone);
	    	 $('#password').val(responseData.password);
	    	  openpopupForm();
 }
	}).error(
		function() { 
			alert("Something went wrong"); 
	});
}
</script>
</head>
<body>
	<div class="container-fluid">
	<table class="table table-responsive">
    <thead>
      <tr>
        <th>Name</th>
        <th>Login id</th>
        <th>Email</th>
        <th>Phone Number</th>
        <th>Choose Action</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${userlist}" var="element">
      <tr>
        <td>${element.name }</td>
        <td>${element.loginid}</td>
        <td>${element.email}</td>
        <td>${element.phone}</td>
        <td>
        <div class="row">
        <div class="col-md-2">
        <c:url var="deleteUrl" value="/delete" scope="request"/>
        <form id="${userFromId}" action="${deleteUrl}" method="post">
        	<input type="hidden" id="id" name="id" value="${element.id}">
        	<input type="submit" class="btn btn-danger btn-xs" value="Delete" onclick="return confirm('Are you Sure?')">
        </form>
        </div>
        <div class="col-md-2">
        <form action="updateUrl" method="post">
        	<input type="hidden" id="id" name="id" value="${element.id}">
        	<input type="button" class="btn btn-primary btn-xs" id="userupdate${element.id}" onclick="fillForm('${element.id}');return confirm('Are you Sure?')" value="Update" >
        </form>
        </div>
        </div>
        </td>
      </tr>
     </c:forEach>
    </tbody>
  </table>
</div>
	
	 <div id = "dialog-1" title = "Update User Details" style="display: none;border: solid sliver 1px; background-color: white;">
         <form:form action="updateuserdetails" class="form-horizontal" method="post" modelAttribute="user">
         <form:input type="hidden" id="userid" path="id" name="id"/>
         <input type="hidden" name="updateflag" value="true">
        	<div class="form-group">
				<div class="col-sm-4 col-sm-offset-4">
					<form:input type="text" name="name" id="name" path="name"
						class="form-control" placeholder="Enter your full name"
						onfocus="this.placeholder=''"
						onblur="this.placeholder='Enter your full name'" />
					<form:errors path="name" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-4 col-sm-offset-4">
					<form:input type="text" name="email" id="email"
						onkeydown="checkEmailStatus()" path="email" class="form-control"
						placeholder="Enter your email" onfocus="this.placeholder=''"
						onblur="this.placeholder='Enter your Enter your email'" />
					<form:errors path="email" cssClass="error" />
					<div id="email_availability"></div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-4 col-sm-offset-4">
					<form:input type="text" name="phone" id="phone"
						onkeypress="return isNumberKey(event)" path="phone"
						class="form-control" placeholder="Enter your phone number"
						onfocus="this.placeholder=''"
						onblur="this.placeholder='Enter your phone number'" />
					<form:errors path="phone" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-4 col-sm-offset-4">
					<form:input type="text" name="loginid" id="loginid"
						onkeypress="return isNumberKey(event)" path="loginid"
						class="form-control" placeholder="Enter your login id"
						onfocus="this.placeholder=''"
						onblur="this.placeholder='Enter your login id'"/>
					<form:errors path="loginid" cssClass="error"/>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-4 col-sm-offset-4">
					<form:input type="password" name="password" id="password"
						path="password" class="form-control"
						placeholder="Enter your password" onfocus="this.placeholder=''"
						onblur="this.placeholder='Enter your password'" />
					<form:errors path="password" cssClass="password" />
				</div>
			</div>
			<div class="col-sm-4 col-sm-offset-4">
				<input type="submit" value="Update" class="btn btn-success">
				<input type="reset" value="Reset" class="btn btn-success">
			</div>
         </form:form>
         </div>
</body>
</html>