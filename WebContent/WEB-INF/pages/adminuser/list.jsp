<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="../common/taglib.jsp"%>
<!DOCTYPE HTML>
<html lang="en">
  <head>
    <title>adminuser page</title>
	<meta content="no-cache">
	<meta content="no-cache">
	<meta content="0">    
	<meta content="keyword1,keyword2,keyword3">
	<meta content="This is my page">
	<%@include file="../common/common.jsp" %>
	<script type="text/javascript" src="${basePath}/resources/sg/tz_page.js"></script>
 </head>
 <body>
	<div class="wrap">
		<!-- 左边 -->
		<%@include file="../common/left.jsp"%>
		<div class="content">
			<div class="header1">
				<ul class="fl">
					 <li class="titems"><a href="javascript:void(0);"><i class="fa fa-user"></i>欢迎keke来到cms后台</a></li>
					 <li class="titems"><a href="javascript:void(0);"><i class="fa fa-envelope"></i>消息5个!</a></li>
					 <li class="titems"><a href="javascript:void(0);"><i class="fa fa-cog"></i>设置</a></li>
					 <li class="titems"><a href="${basePath}/logout"><i class="fa fa-share-alt"></i>退出</a></li>	
				</ul>
				<div class="fr sbtn none">
					<input type="text" class="fl" placeholder="搜索的关键字..."/><a href="javascript:void(0)"  class="fl"><i class="fa fa-search "></i></a>
				</div>
				<div class="clearfix" style="clear:both;"></div>
			</div>
			<div class="channel"> Home > Table</div>
			<div class="cnt">
				<div class="tabwrap">
					
					<!--表格-->
					<table class="tztab">
						<caption>
							2015年度一周统计报表数据
							<div class="fr sbtn">
								<input type="text" id="keyWord" data-words="" class="fl" placeholder="搜索的关键字..."/><a href="javascript:void(0)" class="fl" onclick="zywPage.search(this)"><i class="fa fa-search "></i></a>
							</div>
						</caption>
						<!--头部
						<colgroup id="days">
							<col/>
							<col style="background:green;width:200px;"/>
							<col id="t"/>
						</colgroup>-->
						<thead>
							<tr>
								<th>序号</th>
								<th>名称</th>
								<th>邮箱</th>
								<th>创建时间</th>
								<th>年龄</th>
								<th>性别</th>
								<th>地址</th>	
								<th>电话</th>
								<th>生日</th>	
								<th>删除状态</th>
								<th>禁止状态</th>
								<th>操作</th>
							</tr>
						</thead>
						<!--身体部  -->
						<tbody id="tbody" data-itemcount="${count}" data-model="adminuser">
							
						</tbody>
					</table>
				</div>
				<div id="page"></div>
			</div> 	
		</div>
	</div>
	<script type="text/javascript">
		
		$(function(){
			//分页
			//回调函数  ： 把函数当成参数，传进去,用到时再回头调用
			zywPage.loadData(zywPage.pageNo,zywPage.pageSize,function(itemcount){
				zywPage.init(itemcount);
			});
		});
	</script>
 </body>
</html>
