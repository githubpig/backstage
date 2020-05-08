<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="../common/taglib.jsp"%>
<!DOCTYPE HTML>
<html lang="en">
  <head>
    <title>role page</title>
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
		<%@include file="../common/left.jsp" %>
	
		<div class="content">
			<!-- 头部 -->
			<%@include file="../common/head.jsp" %>
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
								<th>创建时间</th>	
								<th>删除状态</th>
								<th>角色分配</th>
								<th>操作</th>
							</tr>
						</thead>
						<!--身体部  -->
						<tbody id="tbody" data-itemcount="${count}" data-model="role">
						</tbody>
					</table>
				</div>
				<div id="page"></div>
			</div> 	
		</div>
	</div>
	<script type="text/javascript">
		
		var zywRole = {
			//分配角色
			allotUser : function(obj){
				$obj = $(obj);
				var opid = $obj.data("opid");
				$.tzIframe({width : 320, height: 400,drag:false,content:adminPath+"/role/user/"+opid,callback:function(iframe,$dialog,opts){
					if(iframe){
						iframe.roleUser.save(opid,$dialog);
					}
				}});
			},
			impower : function(obj){
				$obj = $(obj);
				var opid = $obj.data("opid");
				$.tzIframe({width : 320, height: 400,drag:false,content:adminPath+"/role/permission/"+opid,callback:function(iframe,$dialog,opts){
					if(iframe){
						iframe.impower(opid,$dialog,opts);
					}
				},loadSuccess:function(iframe){
					iframe.initPermissionTree(function(){
						var arr =[];
						$.ajax({
							type : "post",
							url : adminPath+"/role/roleImpower",
							success : function(data){
								for(var i in data){
									if(i<data.length){
										arr.push(data[i].permissionId);
									}
								}
								alert(arr);
								for(var i = 0; i<arr.length;i++){
									$(iframe.document).find("body").find(".tm-tree-checkbox[opid = "+arr[i]+"]")
									.addClass("tm-tree-checkbox-checked");
								}
							}
						});
						
					});
				}});
			}
		};
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
