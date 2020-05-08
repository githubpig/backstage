<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="../common/taglib.jsp"%>
<!DOCTYPE HTML>
<html lang="en">
  <head>
    <title>adminstat page</title>
	<meta content="no-cache">
	<meta content="no-cache">
	<meta content="0">    
	<meta content="keyword1,keyword2,keyword3">
	<meta content="This is my page">
	<%@include file="../common/common.jsp" %>
	<script type="text/javascript" src="${basePath}/resources/sg/tz_page.js"></script>
	<script type="text/javascript" src="${basePath}/resources/js/echarts.js"></script>
	<script type="text/javascript" src="${basePath}/resources/js/date/WdatePicker.js"></script>
	
 </head>
 <body>
	<div class="wrap">
		<!-- 左边 -->
		<%@include file="../common/left.jsp"%>
		<div class="content">
			<%@include file="../common/head.jsp" %>
			<div class="channel"> Home &gt; Table</div>
			<div class="cnt">
				<div style="margin-left:10px;">
					<input type="text" id="5421" onFocus="WdatePicker({dateFmt:'yyyy',onpicking:function(dp){changeDate(dp)}})" class="Wdate"/>
				</div>
				<div class="tabwrap">
					 <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
	  				 <div id="main" style="width: 600px;height:400px;"></div>
				</div>
				<div id="page"></div>
			</div> 	
		</div>
	</div>
	<script src="${basePath }/resources/js/echarts-all.js"></script>
	<script type="text/javascript">
		$(function(){
			initDate();
		});
		//初始化日期
		function initDate(){
			var year = new Date().getFullYear();
			$(".Wdate").val(year);
			statData(year);
		}
		//改变日期
		function changeDate(dp){
			var year = dp.cal.newdate.y;
			statData(year);
		}
		function statData(year){
			$.ajax({
				type : "post",
				data : {year:year},
				url : adminPath + "/stat/listData",
				success : function(data){
					if(data == "logout"){ //
						window.location.href=basePath + "/login";
					}else{
						var jdata = {
							title : year+"网站用户每月内容情况统计",
							data : JsonArr(data)
						};
						initChar("main",jdata);
					}
				}
			});
		}
		//数据格式化
		function JsonArr(jArr){
			//alert(parseInt(jArr[0].m));
			var arr = [];
			for(var i=0;i<12;i++){
				arr.push(0);
			}
			for(var index in jArr){
				var m = parseInt(jArr[index].m);
				arr[m-1] = jArr[index].num;
			}
			return arr;
		}
		//初始化echars统计报表
		function initChar(targetId,jdata){
			require.config({
	            paths: {
	                echarts: basePath+'/resources/js'
	            }
	        });
	        require(
	            [
	                'echarts',
	                'echarts/chart/bar',
					'echarts/chart/pie'
	            ],
	           function (ec) {
	            	// 基于准备好的dom，初始化echarts实例
	        	    var myChart = ec.init(document.getElementById(targetId));
	        	    // 指定图表的配置项和数据
	        	    var option = {
	        				title : {
	        					x : 'center',
	        					text: jdata.title,
	        					subtext: '数量/每月'
	        				},
	        				tooltip : {
	        					trigger: 'axis'
	        				},
	        				legend: {
	        					x : 'left',
	        					data:['内容数量']
	        				},
	        				calculable : true,
	        				xAxis : [
	        					{
	        						type : 'category',
	        						data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
	        					}
	        				],
	        				yAxis : [
	        					{
	        						type : 'value'
	        					}
	        				],
	        				series : [
	        					{
	        						name:'用户量',
	        						type:'bar',
	        						data: jdata.data,
	        						markPoint : {
	        							data : [
	        								{type : 'max', name: '最大值'},
	        								{type : 'min', name: '最小值'}
	        							]
	        						},
	        						markLine : {
	        							data : [
	        								{type : 'average', name: '平均值'}
	        							]
	        						}
	        					},
	        				]
	        		};
	        	    // 使用刚指定的配置项和数据显示图表。
	        	    myChart.setOption(option);
	        	    var ecConfig = require('echarts/config');
	        	    //点击事件
	        	    myChart.on(ecConfig.EVENT.CLICK, eConsole);
	            }
	       );
		   function eConsole(param) {
			   //mes: 事件类型: click
		      var mes = '【' + param.type + '】';
		      
		      /* if (typeof param.seriesIndex != 'undefined') {
		           mes += '  seriesIndex : ' + param.seriesIndex;
		           mes += '  dataIndex : ' + param.dataIndex;
		       }
		       if (param.type == 'hover') {
		           document.getElementById('hover-console').innerHTML = 'Event Console : ' + mes;
		       }
		       else {
		           document.getElementById('console').innerHTML = mes;
		       }
		       console.log(param);  */
		   }
		}
	</script>
 </body>
</html>
