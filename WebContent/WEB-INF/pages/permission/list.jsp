<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="../common/taglib.jsp"%>
<!DOCTYPE HTML>
<html lang="en">
  <head>
    <title>permission page</title>
	<meta content="no-cache">
	<meta content="no-cache">
	<meta content="0">    
	<meta content="keyword1,keyword2,keyword3">
	<meta content="This is my page">
	<%@include file="../common/common.jsp" %>
	<script type="text/javascript" src="${basePath}/resources/sg/tz_page.js"></script>
	<!-- 引入树的js和css -->
	<link rel="stylesheet" href="${basePath}/resources/sg/tree/tm_tree.css"/>
	<script type="text/javascript" src="${basePath}/resources/sg/tree/tm_tree.js"></script>
 </head>
 <body>
	<div class="wrap">
		<!-- 左边 -->
		<%@include file="../common/left.jsp"%>
	
		<div class="content">
			<%@include file="../common/head.jsp" %>
			<div class="channel"> Home > Table</div>
			<div class="cnt">
				<div class="tabwrap">
					<div id="permissiontree"></div>
				</div>
			</div> 	
		</div>
	</div>
	
	<script type="text/javascript">
		
		$(function(){
			
			function initPermissionTree(){
				$.ajax({
					post : "post",
					url : adminPath+ "/permission/root",
					success : function(data){
						//alert(JSON.stringify(data));
						var root = data.root;
						var children = data.children;
						var count = data.count;
						//tmTree: 的成员是对象
						$("#permissiontree").tmTree({
										outhtml:"<a class='remove' style='padding-left:10px;display:inline-block' href='javascript:void(0)'><i class='fa fa-remove'></i></a><a class='zyw_add' style='padding-left:10px;display:inline-block' href='javascript:void(0)'><i class='fa fa-google-plus-square'></i></a>",
										root:root,children:children,type:"checkbox",count:count,onclick:function($this,data){
							},callback:function(opid){
							console.log(opid);
							$this = $(this);
							$.tzConfirm({content:"你确定删除么？",callback:function(ok){
								if(ok){
									$this.closest("li").remove();
								}
							}});
						}});
					}
				});
			}
			initPermissionTree();
			
			
			$(".nav").find("li.items").find("a").click(function(){
				var len = $(this).next().length;
				if(len>0){
					$(this).next().stop(true,true).slideToggle()
					.end().parents("li")
					.addClass("active")
					.siblings().removeClass("active")
					.find("ul").slideUp("slow");
				}
			});
		});
	</script>
 </body>
</html>
