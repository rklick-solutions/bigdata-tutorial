if (window.console) {
  console.log("Welcome to your Play application's JavaScript!");
  console.log(Messages('en', 'spark.core.feature'));
}

var populateDescription = function() {
	/*var name = $("#name").val();
	if(name.length > 0) {
		console.log(Messages('en', "hello", "Anand"));
	} else {
		name = "?"
	}*/

    $("#description").html(Messages('en', 'spark.core.feature'));
	//$("#hindiPanelContent").html(Medescriptionssages('hi', 'welcome', name));
	//$("#frenchPanelContent").html(Messages('fr', 'welcome', name));
	//$("#latinPanelContent").html(Messages('la', 'welcome', name));
}

