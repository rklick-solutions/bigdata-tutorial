if (window.console) {
  console.log("Welcome to your Big Data Tutorial!");
}

var populateDescription = function(key) {
     if(key == undefined || key.isEmpty){
       key = 'spark.core.introduction';
     }
    $("#description").html(Messages('en', key));
}

