<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 	<%@ include file="/public/head.jspf" %>
 	<script type="text/javascript" src="${shop }/jquery-easyui-1.3.5/jscharts.js"></script>
 	 <script type="text/javascript">
  		$(function(){
  			$("#submit").click(function(){
  				//发送ajax请求
  				$.post($("#sale").val(),{number:$("#number").val()},function(data){
  					var colorArr=['#44A622','#A7B629','#CAD857','#E4DB7B','#ECDE49','#ECC049','#EC9649','#D97431','#D95531'];
  					var myChart = new JSChart('chart_container', $("#type").val(), '');
  					myChart.setDataArray(data);
  					myChart.colorize(colorArr.slice(0,data.length));
  					myChart.setSize(100*$("#number").val(), 300);
  					myChart.setBarValues(false);
  					myChart.setBarSpacingRatio(45);
  					myChart.setBarOpacity(1);
  					myChart.setBarBorderWidth(0);
  					myChart.setTitle('商品销售报表');
  					myChart.setTitleFontSize(10);
  					myChart.setTitleColor('#607985');
  					myChart.setAxisValuesColor('#607985');
  					myChart.setAxisNameX('商品名称',false );
  					myChart.setAxisNameY('商品销量', false);
  					myChart.set3D(true);
  					myChart.setGridOpacity(0.8);
  					myChart.draw();
  				},"json");
  			});
  		});
  	</script>
  </head>
  	 <body>
  	 	请选择报表的类型：
  		<select id="sale">
  			<option value="sorder_querySale.action">年度销售报表</option>
  		</select>
  		查询的数量：
  		<select id="number">
  			<option value="5">5</option>
  			<option value="7">7</option>
  			<option value="10">10</option>
  		</select>
  		报表类型：
  		<select id="type">
  			<option value="bar">柱状图</option>
  			<option value="line">线性图</option>
  			<option value="pie">饼状图</option>
  		</select>
  		<input type="button" id="submit" value="查询"/>
  		<div id="chart_container">请选择</div>
  	</body>
</html>
