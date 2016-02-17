$(function () {

    $.ajax({
        url: "/spark/action/report",
        success: function(result) {
            drawPieChart(result.company, result.bank);
        },
        error: function(err) {

        }
    });

});

//-------------
//- PIE CHART -
//-------------
// Get context with jQuery - using jQuery's .get() method.
var canvas1 = $("#pieChart").get(0).getContext("2d");
//var canvas2 = $("#barChart").get(0).getContext("2d");
var companyPieChart = new Chart(canvas1);
//var bankPieChart = new Chart(canvas2);

var pieOptions = {
  //Boolean - Whether we should show a stroke on each segment
  segmentShowStroke: true,
  //String - The colour of each segment stroke
  segmentStrokeColor: "#fff",
  //Number - The width of each segment stroke
  segmentStrokeWidth: 2,
  //Number - The percentage of the chart that we cut out of the middle
  percentageInnerCutout: 50, // This is 0 for Pie charts
  //Number - Amount of animation steps
  animationSteps: 100,
  //String - Animation easing effect
  animationEasing: "easeOutBounce",
  //Boolean - Whether we animate the rotation of the Doughnut
  animateRotate: true,
  //Boolean - Whether we animate scaling the Doughnut from the centre
  animateScale: false,
  //Boolean - whether to make the chart responsive to window resizing
  responsive: true,
  // Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
  maintainAspectRatio: true,
  //String - A legend template
  legendTemplate: "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<segments.length; i++){%><li><span style=\"background-color:<%=segments[i].fillColor%>\"></span><%if(segments[i].label){%><%=segments[i].label%><%}%></li><%}%></ul>"
};

var drawPieChart = function(companyData, bankData) {
    //Create pie or douhnut chart
    // You can switch between pie and douhnut using the method below.
    companyPieChart.Pie(companyData, pieOptions).update();
    //bankPieChart.Doughnut(bankData, pieOptions).update();
}