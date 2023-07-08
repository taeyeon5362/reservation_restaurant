<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.79.0">
<title>통계</title>

<!-- Bootstrap core CSS -->
<link href="../../resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Favicons -->
<%@ include file="NAVbar.jsp"%>

<style>
</style>

<link href="../../resources/css/carousel.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>

window.onload=function(){

google.charts.load('current', {packages: ['corechart', 'bar']});
google.charts.setOnLoadCallback(drawAnnotations);
$.ajax({
          url:"/manager/Income/data",
          type:'post',
          //type:'get',
          contentType:'application/json; charset=utf8',
          dataType:'json',
          success:function(data){
              console.log(data);
              //chartData = data;
              console.log(data.length);
              drawAnnotations(data, (data.length+1));
          }
    });
}

function drawAnnotations(chartData, size) {
    console.log(chartData);
    //chartData = JSON.stringify(chartData);
    var dataArr = new Array();
    var dataArr_count = new Array();
    for(var i=0; i<size; i++){
        var temp = new Array();
        var temp_count = new Array();
        if(i==0){
            temp[0] = '음식매출량';
            temp[1] = '매출금액';
            temp_count[0] = '판매 수'
            temp_count[1] = '판매횟수';
            dataArr[i] = temp;
            dataArr_count[i] = temp_count;
        }else{
            temp[0] = chartData[i-1].dish;
            temp[1] = chartData[i-1].sumProfit;
            temp_count[0] = chartData[i-1].dish;
            temp_count[1] = chartData[i-1].sumDishCount;
            //temp[2] = chartData[i-1].sumDishCount+'';
            dataArr[i] = temp;
            dataArr_count[i] = temp_count;
        }
    }

    var total = 0;
    for(var i=0; i<size-1; i++){
        total = total + chartData[i].sumProfit;
    }

    $("#total").html('총매출액 : ' + total + '원');
    console.log(dataArr);

      var data = google.visualization.arrayToDataTable(dataArr);

      var data_count = google.visualization.arrayToDataTable(dataArr_count);

      var options = {
        chartArea: {width: '50%'},
        annotations: {
          alwaysOutside: true,
          textStyle: {
            fontSize: 12,
            auraColor: 'none',
            color: '#555'
          },
          boxStyle: {
            stroke: '#ccc',
            strokeWidth: 1,
            gradient: {
              color1: '#f3e5f5',
              color2: '#f3e5f5',
              x1: '0%', y1: '0%',
              x2: '100%', y2: '100%'
            }
          }
        },
        hAxis: {
          title: '메뉴별 매출량',
          minValue: 0,
        }

      };

      var options_count = {

          chartArea: {width: '50%'},
          annotations: {
            alwaysOutside: true,
            textStyle: {
              fontSize: 12,
              auraColor: 'none',
              color: '#777'
            },
            boxStyle: {
              stroke: '#ccc',
              strokeWidth: 1,
              gradient: {
                color1: '#f3e5f5',
                color2: '#f3e5f5',
                x1: '0%', y1: '0%',
                x2: '100%', y2: '100%'
              }
            }
          },
          hAxis: {
            title: '메뉴별 판매량',
            minValue: 0,
          }

        };
      var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
      chart.draw(data, options);
      var chart_count = new google.visualization.BarChart(document.getElementById('chart_div_count'));
      chart_count.draw(data_count, options_count);
    }
</script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
</head>

<body load="drawAnnotations()">
  <div id="chart_div"></div>
  <div id="chart_div_count"></div>
  <div id="total"></div>
  <%@ include file="Footer.jsp"%>
</body>
</html>