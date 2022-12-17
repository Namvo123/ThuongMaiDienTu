<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">

  google.charts.load('current', {'packages':['corechart']});

  google.charts.setOnLoadCallback(drawChart);
  function drawChart() {

    var data = new google.visualization.DataTable();
    data.addColumn('string', 'Topping');
    data.addColumn('number', 'Slices');
    data.addRows([
    <c:forEach items="${listC}" var="entry">
      [ '${entry.cName}', ${entry.sumMoney} ],
  	</c:forEach>
    ]);

    var options = {'title':'Revenue by category in December',
                   'width':600,
                   'height':500};

    var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
    chart.draw(data, options);
  }
  
  google.charts.load('current', {packages: ['corechart', 'bar']});
  google.charts.setOnLoadCallback(drawBasic);

function drawBasic() {

    var data = google.visualization.arrayToDataTable([
      ['Year', 'Revenue: $',],
      <c:forEach items="${listS}" var="entry">
      	[ '${entry.year}', ${entry.billPrice} ],
  	  </c:forEach>
    ]);

    var options = {
      title: 'Revenue by year','height': 600, 'width': 900,
      hAxis: {
        title: 'Revenue',
        minValue: 0
      },
      vAxis: {
        title: 'Year'
      }
    };

    var chart = new google.visualization.BarChart(document.getElementById('chart_div-column'));

    chart.draw(data, options);
  }
</script>
</head>

<body>
<div id="chart_div-column"></div>
<div id="chart_div"></div>
</body>
</html>