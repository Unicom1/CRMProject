/**
 * 
 */
$(document).ready(function(){
	
	$("#test").click(function(){
		alert("OK");
		
		$.ajax({
			type:"GET",
			url:"/index/user",
			data:{
				"userId":1,
			},
			success:function(result){
				alert(result.userName);
			}

		});
	})
});