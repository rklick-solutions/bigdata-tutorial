 $(function(){

        var json =
  {
     "name": "Spark 1.6",
     "icon": "/assets/images/spark-logo-hd.png",
     "children": [
         {
             "name": "Core",
             "icon": "",
             "children": [
                 {
                     "name": "Introduction",
                     "icon": "",
                     "msg": "spark.core.introduction"
                 },
                 {
                     "name": "Feature",
                     "icon": "",
                      "msg": "spark.core.feature"
                 },
                 {
                     "name": "Initializing",
                     "icon": "",
                     "msg": "spark.core.initialize"
                 },
                 {
                     "name": "RDD's",
                     "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                     "children": [
                         {
                             "name": "Create",
                             "icon": "",
                             "msg": "spark.core.rdd.create"
                         },
                         {
                             "name": "Operations",
                             "icon": "",
                              "children": [
                                 {
                                     "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                                     "name": "Action",
                                     "msg": "spark.core.rdd.operations.actions"
                                 },
                                 {
                                     "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                                     "name": "Transformation",
                                     "msg": "spark.core.rdd.operations.transformation"
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
                     "name": "Initializing",
                     "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                     "msg": "spark.sql.initializing"
                 },
                 {
                     "name": "Basic Query",
                     "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                     "msg": "spark.sql.basic"
                 }
             ]
         },
         {
             "name": "Dataframes",
             "icon": "/assets/images/dataframe.png",
             "children": [
                  {
                      "name": "Create",
                       "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                       "msg": "spark.dataframes.create"
                  },
                  {
                      "name": "API",
                      "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                      "children": [
                          {
                            "name": "Action",
                            "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                            "msg": "spark.dataframes.api.action"
                          },
                          {
                            "name": "Basic",
                            "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                            "msg": "spark.dataframes.api.basic"
                          },
                          {
                           "name": "Operations",
                           "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                           "msg": "spark.dataframes.api.operations"
                           },
                      ]
                  },
                  {
                    "name": "Interoperating RDD",
                    "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                    "children": [
                      {
                       "name": "Inferring Schema",
                       "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                       "msg": "spark.dataframes.interoperating.infering"
                      },
                      {
                       "name": "Specifying Schema",
                        "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                        "msg": "spark.dataframes.interoperating.specifying"
                      }
                    ]
                },
                {
                    "name": "Data Sources",
                    "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                    "children": [
                      {
                       "name": "JSON",
                       "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                       "msg": "spark.dataframes.sources.json"
                      },
                      {
                       "name": "CSV",
                        "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                        "msg": "spark.dataframes.sources.csv"
                      },
                      {
                         "name": "TXT",
                          "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                          "msg": "spark.dataframes.sources.json"
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
                    "name": "Create",
                    "msg": "spark.datasets.create"
                },
                {
                    "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                    "name": "Basic",
                    "msg": "spark.datasets.basic"
                }

             ]
         },
         {
               "name": "Streaming",
               "icon": "/assets/images/streaming.png",
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
           "icon": "/assets/images/Mlib.png",
           "children": [
              {
                   "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                   "name": "Overview",
                   "children": [
                        {
                             "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                             "name": "Estimators",
                             "msg": "spark.mlib.overview.estimators"
                         },
                         {
                             "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                             "name": "Transformers",
                             "msg": "spark.mlib.overview.transformers"
                         },
                         {
                             "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                             "name": "Pipelines",
                             "msg": "spark.mlib.overview.pipelines"
                         }
                   ]
              },
              {
                    "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                    "name": "Algorithm",
                    "children": [
                      {
                           "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                           "name": "Classification",
                           "msg": "spark.mlib.algorithm.classification"
                       },
                       {
                           "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                           "name": "Clustering",
                           "msg": "spark.mlib.algorithm.clustering"
                       },
                       {
                           "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                           "name": "Regression",
                           "msg": "spark.mlib.algorithm.regression"
                       }
                    ]
              }
           ]
         },
         {
           "name": "GraphX",
           "icon": "/assets/images/Graphx.png",
           "children": [
             {
               "name": "Core",
               "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
               "msg": "spark.graphx.core"
             },
             {
                "name": "Algorithms",
                "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                "children": [
                    {
                       "name": "PageRank",
                       "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                       "msg": "spark.graphx.algorithm.pagerank"
                    },
                    {
                        "name": "Triangle",
                        "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                        "msg": "spark.graphx.algorithm.triangle"
                    },
                    {
                        "name": "Connected Component",
                        "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                        "msg": "spark.graphx.algorithm.connected"
                    },
                    {
                        "name": "Strongly Connected Component",
                        "icon": "http://cdn.appstorm.net/mac.appstorm.net/files/2012/07/icon4.png",
                        "msg": "spark.graphx.algorithm.strongly"
                    }
                ]
              },
           ]
         },
         {
           "name": "SparkR",
           "icon": "/assets/images/sparkr.png",
           "msg": "spark.sparkr"

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

    nodeEnter.append("img")
      .attr("class", "img-responsive")
      .attr("xlink:src", function(d) { return d.icon; })
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
        if(d.msg != undefined){
            populateDescription(d.msg);
        }
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


