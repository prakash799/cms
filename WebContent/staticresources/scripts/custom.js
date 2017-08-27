/*function checkEmailStatus(){
	var email=$("#email").val();
	//alert("hi");
	$.ajax({
			type:'post',
			url:'registration.jsp',
			data:{email:email},
			success:function(msg){
				alert(msg);
			}
	});
}
*/

function doAjaxPost() {
    // get the form values
    var name = $('#name').val();
    var email = $('#email').val();
    var phone = $('#phone').val();
    var loginid = $('#loginid').val();
    var password = $('#password').val();

    $.ajax({
        type: "POST",
        url: contexPath + "registerUser",
		        data : "name=" + name + "&email=" + email + "&phone=" + phone
				+ "&loginid=" + loginid + "&password=" + password,
        success: function(response){
            // we have the response
            if(response.status == "SUCCESS"){
                userInfo = "<ol>";
                for(i =0 ; i < response.result.length ; i++){
                    userInfo += "<br><li><b>Name</b> : " + response.result[i].name +";<b> email</b> : " + response.result[i].email+";<b> phone</b> : " + response.result[i].phone+";<b> loginid</b> : " + response.result[i].loginid+";<b> password</b> : " + response.result[i].password;
                 }
                 userInfo += "</ol>";
                 $('#info').html("User has been added to the list successfully. " + userInfo);
                 $('#name').val('');
                 $('#education').val('');
                 $('#error').hide('slow');
                 $('#info').show('slow');
             }else{
                 errorInfo = "";
                 for(i =0 ; i < response.result.length ; i++){
                     errorInfo += "<br>" + (i + 1) +". " + response.result[i].code;
                 }
                 $('#error').html("Please correct following errors: " + errorInfo);
                 $('#info').hide('slow');
                 $('#error').show('slow');
             }
         },
         error: function(e){
             alert('Error: ' + e);
         }
    });
}

/*Restrict user to put number only for phone and userid start*/
function isNumberKey(evt){
    var charCode = (evt.which) ? evt.which : event.keyCode
    if (charCode > 31 && (charCode < 48 || charCode > 57))
        return alert("Only Numbers are allowed");
    return true;
}    
/*end*/

/*delete confirmation start*/
$(document).ready(function() {
    var deleteLink = $("a:contains('Delete')");
    $(deleteLink).click(function(event) {
        var conBox = confirm("Are you sure ?");
        if(conBox){
        $.ajax({
            url: $(event.target).attr("href"),
            type: "DELETE",

            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },

            success: function() {
                var tr = $(event.target).closest("tr");
                tr.css("background-color","#000000");
                tr.fadeIn(1000).fadeOut(200, function(){
                tr.remove();})
            }
        });
        } else {
            event.preventDefault();
        }
        event.preventDefault();
    });
});
/*end*/