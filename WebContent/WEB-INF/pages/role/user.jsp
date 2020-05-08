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
	<style type="text/css">
		.userBox {height:357px;overflow-y:auto;}
		.userBox .userList li{height:30px;border-bottom:1px dotted #c5c5c5;cursor:pointer;}
		.userBox .userList li input{margin-left:4px;}
		.userBox .userList li span {line-height:30px;padding:0 2px;}
	</style>
 </head>
 <body>
 	<div class="userBox">
		<ul class="userList">
			<c:forEach items="${maps}" var="map" varStatus="cindex">
				<li>   
					<span><input type="checkbox" value="${map.id }"/></span>
					<span class="num">${cindex.count}:<span> 
					<span class="name">${map.name }</span>
					<span class="email">${map.email}</span>
				</li>
			</c:forEach>  
		</ul>
 	</div>
	<script type="text/javascript">
		var roleUser = {
			init : function(){
				$(".userList").find("li").on("click",function(){
					$(this).find("input").filter(function(){
						$(this).prop("checked",!$(this).prop("checked"));
						//var flag = !$(this).prop("checked");
						//console.log(flag);
					});
				});
			},
			save : function(opid){
				var arr = [];
				var $checked = $(".userList").find("input:checked");
				if($checked.length == 0){
					loading("请为用户分配角色",3);
					return;
				} 
				 $checked.each(function(){
					 var values = $(this).val();
					 arr.push(values);
				 });
				 alert(arr.toString());
				 $.ajax({
					 type : "post",
					 data : {"users":arr.toString(),"roleId":opid},
					 url : adminPath + "/role/save",
					 success :function(data){
						if(data == "success"){
							loading("角色分配成功",4);
							$checked.parents("li").fadeOut("fast",function(){
								$(this).remove();
							});
						}else{
							loading("角色分配失败",3);
						}
					 }
				 });
				
			}
		};
		roleUser.init();
	</script>
 </body>
</html>
