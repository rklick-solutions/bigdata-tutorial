var loading1 = '<img src="/assets/images/loading2.gif">';
var loading2 = '<span class="text-center"><img src="/assets/images/preloader.gif"></span>';

var startLoading = function() {
    $("#currentCount").html(loading1);
    $("#showingCount").html(loading1);
    //$("#barChartDiv").hide();
    //$("#barChartLoadingDiv").show();
}

var updateCount = function(current, showing) {
    $("#currentCount").html(current);
    $("#showingCount").html(showing);
}

var updateTable = function(data) {
    $("#dataTableDiv").html(data);
}

var applyFunction = function(dataUrl) {
    startLoading();
    $.ajax({
        url: dataUrl,
        success: function(result) {
            updateCount(result.current, result.showing);
            updateTable(result.table);
            drawPieChart(result.company, result.bank);
        },
        error: function(err) {
            updateCount(0, 0);
        }
    });
}

