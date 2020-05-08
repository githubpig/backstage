<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tld/pig.tld"  prefix="pig" %>
<%@include file="../common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>layuiAdmin 文章管理 iframe 框</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="${basePath}/resources/layuiadmin/layui/css/layui.css" media="all">
</head>
<body>
  <div class="layui-form" lay-filter="layuiadmin-app-form-list" id="layuiadmin-app-form-list" style="padding: 20px 30px 0 0;">
  	<div class="layui-form-item" hidden="hidden">
      <label class="layui-form-label">ID</label>
      <div class="layui-input-inline">
        <input type="text" name="id"  placeholder="请输投资ID" autocomplete="off" class="layui-input" value="${project.id}"/>
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">投资名称</label>
      <div class="layui-input-inline">
        <input type="text" name="name" lay-verify="required" placeholder="请输投资名称" autocomplete="off" class="layui-input" value="${project.name}"/>
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">预期收益</label>
      <div class="layui-input-inline">
        <input type="text" name="rate" lay-verify="required" placeholder="请输入百分比" autocomplete="off" class="layui-input" value="${project.rate}"/>
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">投资期限</label>
      <div class="layui-input-inline">
        <input type="text" name="duration" lay-verify="required" placeholder="请输入整数自然日" autocomplete="off" class="layui-input" value="${project.duration}"/>
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">起投金额</label>
      <div class="layui-input-inline">
        <input type="text" name="start_money" lay-verify="required" placeholder="人民币" autocomplete="off" class="layui-input" value="${project.start_money}"/>
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">投资进度</label>
      <div class="layui-input-inline">
        <input type="text" name="projectrate" lay-verify="required" placeholder="请输入进度百分比" autocomplete="off" class="layui-input" value="${project.projectrate}"/>
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">标签</label>
      <div class="layui-input-inline">
        <select name="project_type" lay-verify="required">
          <option value="">请选择投资规模</option>
           <pig:if test="${project.project_type == 0 }">
				<pig:then><option value="0" selected="selected">短期精选</option></pig:then>
				<pig:else><option value="0">短期精选</option></pig:else>
		   </pig:if>
		   <pig:if test="${project.project_type == 1 }">
				<pig:then><option value="1" selected="selected">中期稳健</option></pig:then>
				<pig:else><option value="1">中期稳健</option></pig:else>
		   </pig:if>
            <pig:if test="${project.project_type == 2 }">
				<pig:then><option value="2" selected="selected">长期增值</option></pig:then>
				<pig:else><option value="2">长期增值</option></pig:else>
		   </pig:if>
        </select>
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">发布状态</label>
      <div class="layui-input-inline">
       	<c:if test = "${project.status == 0 }">
       		<input type="checkbox" lay-verify="required" lay-filter="status" name="status" lay-skin="switch" lay-text="已发布|待修改"/> 
      		<div class="layui-unselect layui-form-switch" lay-skin="_switch"><em>待修改</em><i></i></div>
       	 </c:if>
       	 <c:if test = "${project.status == 1 }">
    	 	<input type="checkbox" checked="checked" lay-verify="required" lay-filter="status" name="status" lay-skin="switch" lay-text="已发布|待修改"/> 
   			<div class="layui-unselect layui-form-switch layui-form-onswitch" lay-skin="_switch"><em>已发布</em><i></i></div>
       	 </c:if>
      </div>
    </div>
    <div class="layui-form-item layui-hide">
      <input type="button" lay-submit lay-filter="layuiadmin-app-form-submit" id="layuiadmin-app-form-submit" value="确认添加">
      <input type="button" lay-submit lay-filter="layuiadmin-app-form-edit" id="layuiadmin-app-form-edit" value="确认编辑">
    </div>
  </div>
  <script src="${basePath}/resources/layuiadmin/layui/layui.js"></script>  
  <script>
  layui.config({
    base: '${basePath}/resources/layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index', 'form'], function(){
    var $ = layui.$
    ,form = layui.form;
  })
  </script>
</body>
</html>