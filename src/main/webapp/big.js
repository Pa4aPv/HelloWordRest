	$(document).ready(function() {
        $('#btCreate').click(function() {
            var textValue = $('#txCreate').val();
            alert(textValue+" до");
        	$.ajax({
     		   url: "service/hello/" + textValue,
     		            type: "get",
     		            success: function(data) {
     		            	alert(data+" после");
     		            	console.log(data);
     		            },
        				dataType: "text"
     		  });
            
			
        });
    });
	
	
