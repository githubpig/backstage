<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <div class="layui-form-item">
      <label class="layui-form-label">投资名称</label>
      <div class="layui-input-inline">
        <input type="text" name="name" lay-verify="required" placeholder="请输投资名称" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">预期收益</label>
      <div class="layui-input-inline">
        <input type="text" name="rate" lay-verify="required" placeholder="请输入百分比" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">投资期限</label>
      <div class="layui-input-inline">
        <input type="text" name="duration" lay-verify="required" placeholder="请输入整数自然日" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">起投金额</label>
      <div class="layui-input-inline">
        <input type="text" name="start_money" lay-verify="required" placeholder="人民币" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">投资进度</label>
      <div class="layui-input-inline">
        <input type="text" name="projectrate" lay-verify="required" placeholder="请输入进度百分比" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">项目类型</label>
      <div class="layui-input-inline">
        <select name="project_type" lay-verify="required">
          <option value="">请选择投资规模</option>
          <option value="0">短期精选</option>
          <option value="1">中期稳健</option>
          <option value="2">长期增值</option>
        </select>
      </div>
    </div>
    <div class="layui-form-item">
      <label class="layui-form-label">发布状态</label>
      <div class="layui-input-inline">
        <input type="checkbox" lay-verify="required" lay-filter="status" name="status" lay-skin="switch" lay-text="已发布|待修改">
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
    var basePath = layui.setter.base.substr(0,layui.setter.base.indexOf("/resources"));
    //监听提交
    form.on('submit(layuiadmin-app-form-submit)', function(data){
      if(data.field.status == 'on'){
    	  data.field.status = 1;
      }else{
    	  data.field.status = 0;
      }
      var project = data.field; //获取提交的字段
      var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引  
      //提交 Ajax 成功后，关闭当前弹层并重载表格
      //$.ajax({});
       $.ajax({
			type : "POST",
			url: basePath + "/admin/project/save",
			data:project,
			success : function(data){
				var dataObj = $.parseJSON(data);
				if(dataObj.code == 0){
					parent.layui.table.reload('LAY-app-content-list'); //重载表格
				}else{layer.msg(dataObj.msg);}
			}
	  });
	  parent.layer.close(index); //再执行关闭 
    });
  })
  </script>
</body>
</html>