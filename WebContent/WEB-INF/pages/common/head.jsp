<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="header1">
	<ul class="fl">
		 <li class="titems"><a href="javascript:void(0);"><i class="fa fa-user"></i>欢迎${session_user_username}【${session_user_role.names ==null? "没有权限":session_user_role.names}】来到cms后台</a></li>
		 <li class="titems"><a href="javascript:void(0);"><i class="fa fa-envelope"></i>消息0个!</a></li>
		 <li class="titems"><a href="javascript:void(0);"><i class="fa fa-cog"></i>设置</a></li>
		 <li class="titems"><a href="${basePath}/logout"><i class="fa fa-share-alt"></i>退出</a></li>	
	</ul>
	<div class="fr sbtn none">
		<input type="text" class="fl" placeholder="搜索的关键字..."/><a href="javascript:void(0)"  class="fl"><i class="fa fa-search "></i></a>
	</div>
	<div class="clearfix" style="clear:both;"></div>
</div>