if (window.console) {
  console.log("Welcome to your Play application's JavaScript!");
  console.log(Messages('en', 'spark.core.feature'));
}

var populateDescription = function(key) {
     if(key == undefined || key.isEmpty){
       key = 'spark.core.feature';
     }
    $("#description").html(Messages('en', key));
}

