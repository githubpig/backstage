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
	<style type="text/css">#permissiontree{height:358px;overflow-y:auto;}</style>
 </head>
 <body>
	<div id="permissiontree"></div>
	<script type="text/javascript">
		function initPermissionTree(callback){
			$.ajax({
				post : "post",
				url : adminPath+ "/permission/root",
				success : function(data){
					var root = data.root;
					var children = data.children;
					//tmTree: 的成员是对象
					$("#permissiontree").tmTree({outhtml:"<a class='remove' style='padding-left:10px;display:inline-block' href='javascript:void(0)'><i class='fa fa-remove'></i></a>",root:root,children:children,type:"checkbox",onclick:function($this,data){
						//alert(JSON.stringify(data));
						//alert(JSON.stringify(data.checkArr));
						//alert(typeof data.checkArr.opid);
						perIds = data.checkArr.opid;
					},callback:function(opid){
						alert(opid);
						$this = $(this);
						$.tzConfirm({content:"你确定删除么？",callback:function(ok){
							if(ok){
								$this.closest("li").remove();
							}
						}});
					},});
					if(callback)callback();
				}
			});
		}
		var perIds = "";
		//授权
		function impower(opid,$dialog,opts){
			if(isEmpty(perIds)){
				loading("请给角色选择新的权限",3);
				return;
			}
			$.ajax({
				type:"post",
				data:{"roleId":opid,"permissionId":perIds},
				url : adminPath+"/role/saveImpower",
				success : function(data){
					if(data == "success"){
						parent.loading("权限分配成功",3);
						$dialog.next().remove();//阴影层
	 					$dialog.remove();//弹窗
					}else{
						loading("权限分配失败",3);
					}
				}
			});
		}
	</script>
 </body>
</html>
