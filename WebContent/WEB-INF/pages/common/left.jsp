<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib uri="/WEB-INF/tld/pig.tld"  prefix="pig" %>
<div class="slider">
	<div class="logo">
		<a href="javascript:void(0)"><img src="${basePath}/resources/images/logo.png"/></a>
	</div>
	<div class="nav">
		<ul>	
			 <pig:if test="${pig:indexOf(pageContext.request.requestURI,'index') != -1}">
				<pig:then><li class="items active"><a href="javascript:void(0)"><i class="fa fa-home"></i>首页</a></li></pig:then>
				<pig:else><li class="items"><a href="${basePath}/admin/index"><i class="fa fa-home"></i>首页</a></li></pig:else>
			 </pig:if>
			 
			<pig:if test="${pig:indexOf(pageContext.request.requestURI,'permission/list') != -1}">
				<pig:then><li class="items active"><a href="javascript:void(0)"><i class="fa fa-user"></i>权限管理</a></li></pig:then>
				<pig:else><li class="items"><a href="${basePath}/admin/permission/list"><i class="fa fa-user"></i>权限管理</a></li></pig:else>
			 </pig:if>
			 
			 <pig:if test="${pig:indexOf(pageContext.request.requestURI,'role/list') != -1}">
				<pig:then><li class="items active"><a href="javascript:void(0)"><i class="fa fa-user"></i>角色管理</a></li></pig:then>
				<pig:else><li class="items"><a href="${basePath}/admin/role/list"><i class="fa fa-user"></i>角色管理</a></li></pig:else>
			 </pig:if>
			 
			 <pig:if test="${pig:indexOf(pageContext.request.requestURI,'content/list') != -1}">
				<pig:then><li class="items active"><a href="javascript:void(0)"><i class="fa fa-user"></i>内容管理</a></li></pig:then>
				<pig:else><li class="items"><a href="${basePath}/admin/content/list"><i class="fa fa-user"></i>内容管理</a></li></pig:else>
			 </pig:if>
			 
			 <pig:if test="${pig:indexOf(pageContext.request.requestURI,'/adminuser/list') != -1}">
				<pig:then><li class="items active"><a href="javascript:void(0)"><i class="fa fa-signal"></i>用户管理</a></li></pig:then>
				<pig:else><li class="items"><a href="${basePath}/admin/adminuser/list"><i class="fa fa-signal"></i>用户管理</a></li></pig:else>
			 </pig:if>	
			 
			  <pig:if test="${pig:indexOf(pageContext.request.requestURI,'adminstat/fun') != -1}">
				<pig:then><li class="items active"><a href="javascript:void(0)"><i class="fa fa-signal"></i>日志管理</a></li></pig:then>
				<pig:else><li class="items"><a href="${basePath}/admin/adminstat/fun"><i class="fa fa-signal"></i>日志管理</a></li></pig:else>
			 </pig:if>	
			 
			 <pig:if test="${pig:indexOf(pageContext.request.requestURI,'stat/list') != -1}">
				<pig:then><li class="items active"><a href="javascript:void(0)"><i class="fa fa-signal"></i>方法统计</a></li></pig:then>
				<pig:else><li class="items"><a href="${basePath}/admin/stat/list"><i class="fa fa-signal"></i>方法统计</a></li></pig:else>
			 </pig:if>	
			 
			 <pig:if test="${pig:indexOf(pageContext.request.requestURI,'gather/list') != -1}">
				<pig:then><li class="items active"><a href="javascript:void(0)"><i class="fa fa-send"></i>爬虫采集</a></li></pig:then>
				<pig:else><li class="items"><a href="${basePath}/admin/gather/list"><i class="fa fa-send"></i>爬虫采集</a></li></pig:else>
			 </pig:if>
			 
			 <pig:if test="${pig:indexOf(pageContext.request.requestURI,'project/list') != -1}">
				<pig:then><li class="items active"><a href="javascript:void(0)"><i class="fa fa-send"></i>投资项目</a></li></pig:then>
				<pig:else><li class="items"><a href="${basePath}/admin/project/list"><i class="fa fa-send"></i>投资项目</a></li></pig:else>
			 </pig:if>		
			 
			 <%-- <li class="items"><a href="${basePath}/admin/music/list"><i class="fa fa-inbox"></i>音乐管理</a></li>
			 <li class="items"><a href="${basePath}/admin/stat/list"><i class="fa fa-th"></i>统计报表</a></li>
			 
			 <li class="items">
				<a href="javascript:void(0);"><i class="fa fa-th-list"></i>表单</a>
				<ul>
					 <li class="citems"><a href="javascript:void(0);"><i class="fa fa-inbox"></i>区块</a></li>
					 <li class="citems"><a href="javascript:void(0);"><i class="fa fa-th"></i>表格</a></li>
					 <li class="citems"><a href="javascript:void(0);"><i class="fa fa-send"></i>其他</a></li>
				</ul>
				<span class="numicon c5">3</span>
			 </li>
			 <li class="items">
				<a href="javascript:void(0);"><i class="fa fa-tint"></i>按钮组</a>
				<ul>
					 <li class="citems"><a href="javascript:void(0);"><i class="fa fa-inbox"></i>区块</a></li>
					 <li class="citems"><a href="javascript:void(0);"><i class="fa fa-th"></i>表格</a></li>
					 <li class="citems"><a href="javascript:void(0);"><i class="fa fa-send"></i>其他</a></li>
					 <li class="citems"><a href="javascript:void(0);"><i class="fa fa-th"></i>表格</a></li>
					 <li class="citems"><a href="javascript:void(0);"><i class="fa fa-send"></i>其他</a></li>
				</ul>
				<span class="numicon c1">5</span>
			 </li>
			 <li class="items"><a href="javascript:void(0);"><i class="fa fa-pencil"></i>元素</a></li>
			 <li class="items"><a href="javascript:void(0);"><i class="fa fa-star"></i>Addons 5</a></li>
			 <li class="items"><a href="javascript:void(0);"><i class="fa fa-file-o"></i>Error</a></li> --%>
		</ul>
	</div>
</div>
<script type="text/javascript">
	$(function(){
		$(".nav").find("li.items").find("a").click(function(){
			$(this).parents("li").addClass("active").siblings().removeClass("active");
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
