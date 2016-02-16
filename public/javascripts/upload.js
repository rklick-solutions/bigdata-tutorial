
$(function(){
   //Program a custom submit function for the form
   $("#form-data").submit(function(event){
     //disable the default form submission
     event.preventDefault();

     //grab all form data
     var formData = new FormData($(this)[0]);

     $.ajax({
       url: '/upload',
       type: 'POST',
       data: formData,
       async: false,
       cache: false,
       contentType: false,
       processData: false,
       success: function (message) {
         alert(message);
       },
       error: function(err) {
        alert(err)
       }
     });

     return false;
   });

})
