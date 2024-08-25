$(document).ready(function() {
		console.log("Hello Jquery");
		
		$("#email").blur(function(){
			console.log("Email value:"+$("#email").val());
			alert($("input[name=_csrf]").val())
		
		$.ajax({
			  type: "POST",
			  url: "findByEmail",
			  data: {"email":$("#email").val(), "_csrf":$("#csrf").val()},
			  success: function(emailExists){
				  console.log("Result is:"+emailExists);
				  if(emailExists){
					  $("#successMessage").html("");
					  $("#errorMessage").html("User Already Exists");
				  }else{
					  $("#errorMessage").html("");
				  }
			  }
			});
	   })
	});