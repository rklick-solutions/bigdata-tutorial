 $(function(){

        var json =
  {
     "name": "Spark 1.6",
     "icon": "http://inquidia.com/sites/default/files/spark.png",
     "children": [
         {
             "name": "Core",
             "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
             "children": [
                 {
                     "name": "Introduction to Apache Spark",
                     "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png"
                 },
                 {
                     "name": "Feature of Apache Spark",
                     "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png"
                 },
                 {
                     "name": "Initializing Spark",
                     "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png"
                 },
                 {
                     "name": "RDD's",
                     "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                     "children": [
                         {
                         "name": "Creating RDD's",
                         "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png"
                         },
                         {
                         "name": "RDD's Operations",
                         "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                          "children": [
                         {
                         "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                         "name": "Action"
                         },
                         {
                         "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                         "name": "Transformation"
                         }
                            ]
                         }
                     ]
                 }
             ]
         },
         {
             "name": "SQL",
             "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
             "children": [
                 {
                     "name": "Initializing Spark SQL",
                     "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png"
                 },
                 {
                     "name": "Basic Query Example",
                     "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png"
                 }
             ]
         },
         {
             "name": "Dataframes",
             "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
             "children": [
                  {
                      "name": "Creating Dataframes",
                       "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png"
                  },
                  {
                      "name": "Dataframes API Functionality",
                      "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                      "children": [
                          {
                            "name": "Action",
                            "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png"
                          },
                          {
                            "name": "Basic Dataframe Functions",
                            "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png"
                          },
                          {
                           "name": "Dataframes Operations",
                           "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png"
                           },
                      ]
                  },
                  {
                    "name": "Interoperating With RDD's",
                    "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                    "children": [
                      {
                       "name": "Inferring the Schema using Reflection",
                       "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png"
                      },
                      {
                       "name": "Programmatically Specifying the Schema",
                        "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png"
                      }
                    ]
                },
                {
                    "name": "Data Sources",
                    "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                    "children": [
                      {
                       "name": "JSON",
                       "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png"
                      },
                      {
                       "name": "CSV",
                        "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png"
                      },
                      {
                         "name": "TXT",
                          "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png"
                      }
                    ]
                }
             ]
         },
         {
             "name": "Datasets",
             "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
             "children": [
                {
                    "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                    "name": "Creating Datasets"
                },
                {
                    "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                    "name": "Basic Dataset Functions"
                }

             ]
         },
         {
               "name": "Streaming",
               "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
               "children": [
                 {
                 "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                 "name": "Child 1"},
                 {
                 "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                 "name": "Child 2"},
                 {
                 "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                 "name": "Child 3"}
               ]
         },
         {
           "name": "MLib",
           "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
           "children": [
             {
             "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
             "name": "Estimators"},
             {
             "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
             "name": "Transformers"},
             {
             "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
             "name": "Pipelines"}
           ]
         },
         {
           "name": "GraphX",
           "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
           "children": [
             {
               "name": "Core",
               "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png"
             },
            {
              "name": "PageRank",
              "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png"
            },
            {
            "name": "Triangle",
            "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png"
            },
            {"name": "Connected Component",
            "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png"
            },
            {"name": "Strongly Connected Component",
            "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png"
            }
           ]
         },
         {
           "name": "SparkR",
           "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png"

         }
     ]
 };

var width = 700;
var height = 650;
var maxLabel = 150;
var duration = 500;
var radius = 5;

var i = 0;
var root;

var tree = d3.layout.tree()
    .size([height, width]);

var diagonal = d3.svg.diagonal()
    .projection(function(d) { return [d.y, d.x]; });

var svg = d3.select("#tree").append("svg")
    .attr("width", width)
    .attr("height", height)
        .append("g")
        .attr("transform", "translate(" + maxLabel + ",0)");

root = json;
root.x0 = height / 2;
root.y0 = 0;

root.children.forEach(collapse);

function update(source)
{
    // Compute the new tree layout.
    var nodes = tree.nodes(root).reverse();
    var links = tree.links(nodes);

    // Normalize for fixed-depth.
    nodes.forEach(function(d) { d.y = d.depth * maxLabel; });

    // Update the nodes…
    var node = svg.selectAll("g.node")
        .data(nodes, function(d){
            return d.id || (d.id = ++i);
        });

    // Enter any new nodes at the parent's previous position.
    var nodeEnter = node.enter()
        .append("g")
        .attr("class", "node")
        .attr("transform", function(d){ return "translate(" + source.y0 + "," + source.x0 + ")"; })
        .on("click", click);

    nodeEnter.append("image")
      .attr("xlink:href", function(d) { return d.icon; })
      .attr("x", "-12px")
      .attr("y", "-12px")
      .attr("width", "24px")
      .attr("height", "24px");

    nodeEnter.append("circle")
        .attr("r", 0)
        .style("fill", function(d){
            return d._children ? "lightsteelblue" : "white";
        });

    nodeEnter.append("text")
        .attr("x", function(d){
            var spacing = computeRadius(d) + 5;
            return d.children || d._children ? -spacing : spacing;
        })
        .attr("dy", "3")
        .attr("text-anchor", function(d){ return d.children || d._children ? "end" : "start"; })
        .text(function(d){ return d.name; })
        .style("fill-opacity", 0);

    // Transition nodes to their new position.
    var nodeUpdate = node.transition()
        .duration(duration)
        .attr("transform", function(d) { return "translate(" + d.y + "," + d.x + ")"; });

    nodeUpdate.select("circle")
        .attr("r", function(d){ return computeRadius(d); })
        .style("fill", function(d) { return d._children ? "lightsteelblue" : "#fff"; });

    nodeUpdate.select("text").style("fill-opacity", 1);

    // Transition exiting nodes to the parent's new position.
    var nodeExit = node.exit().transition()
        .duration(duration)
        .attr("transform", function(d) { return "translate(" + source.y + "," + source.x + ")"; })
        .remove();

    nodeExit.select("circle").attr("r", 0);
    nodeExit.select("text").style("fill-opacity", 0);

    // Update the links…
    var link = svg.selectAll("path.link")
        .data(links, function(d){ return d.target.id; });

    // Enter any new links at the parent's previous position.
    link.enter().insert("path", "g")
        .attr("class", "link")
        .attr("d", function(d){
            var o = {x: source.x0, y: source.y0};
            return diagonal({source: o, target: o});
        });

    // Transition links to their new position.
    link.transition()
        .duration(duration)
        .attr("d", diagonal);

    // Transition exiting nodes to the parent's new position.
    link.exit().transition()
        .duration(duration)
        .attr("d", function(d){
            var o = {x: source.x, y: source.y};
            return diagonal({source: o, target: o});
        })
        .remove();

    // Stash the old positions for transition.
    nodes.forEach(function(d){
        d.x0 = d.x;
        d.y0 = d.y;
    });
}

function computeRadius(d)
{
    if(d.children || d._children) return radius + (radius * nbEndNodes(d) / 10);
    else return radius;
}

function nbEndNodes(n)
{
    nb = 0;
    if(n.children){
        n.children.forEach(function(c){
            nb += nbEndNodes(c);
        });
    }
    else if(n._children){
        n._children.forEach(function(c){
            nb += nbEndNodes(c);
        });
    }
    else nb++;

    return nb;
}

function click(d)
{
    if (d.children){
        d._children = d.children;
        d.children = null;
    }
    else{
        d.children = d._children;
        d._children = null;
    }
    update(d);
}

function collapse(d){
    if (d.children){
        d._children = d.children;
        d._children.forEach(collapse);
        d.children = null;
    }
}

    update(root);


});


