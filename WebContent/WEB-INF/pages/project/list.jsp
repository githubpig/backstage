<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="../common/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
  <meta charset="utf-8">
  <title>投资项目管理</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <%@include file="../common/common.jsp" %>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="${basePath}/resources/layuiadmin/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="${basePath}/resources/layuiadmin/style/admin.css" media="all">
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
			<div class="channel"> 后台 > 投资项目</div>
			<div class="cnt">
					  <div class="layui-fluid">
					    <div class="layui-card">
					      <div class="layui-form layui-card-header layuiadmin-card-header-auto">
					        <div class="layui-form-item">
					          <div class="layui-inline">
					            <label class="layui-form-label">项目ID</label>
					            <div class="layui-input-inline">
					              <input type="text" name="id" placeholder="请输入" autocomplete="off" class="layui-input">
					            </div>
					          </div>
					          <div class="layui-inline">
					            <label class="layui-form-label">项目名称</label>
					            <div class="layui-input-inline">
					              <input type="text" name="name" placeholder="请输入" autocomplete="off" class="layui-input">
					            </div>
					          </div>
					          <div class="layui-inline">
					            <label class="layui-form-label">起投金额</label>
					            <div class="layui-input-inline">
					              <input type="text" name="start_money" placeholder="请输入" autocomplete="off" class="layui-input">
					            </div>
					          </div>
					          <div class="layui-inline">
					            <label class="layui-form-label">项目类型</label>
					            <div class="layui-input-inline">
					              <select name="project_type">
					                <option value="">请选择标签</option>
					                <option value="0">短期精选</option>
					                <option value="1">中期稳健</option>
					                <option value="2">长期增值</option>
					              </select>
					            </div>
					          </div>
					          <div class="layui-inline">
					            <button class="layui-btn layuiadmin-btn-list" lay-submit lay-filter="LAY-app-contlist-search">
					              <i class="layui-icon layui-icon-search layuiadmin-button-btn"></i>
					            </button>
					          </div>
					        </div>
					      </div>
					
					      <div class="layui-card-body">
					        <div style="padding-bottom: 10px;">
					          <button class="layui-btn layuiadmin-btn-list" data-type="batchdel">删除</button>
					          <button class="layui-btn layuiadmin-btn-list" data-type="add">添加</button>
					        </div>
					        <table id="LAY-app-content-list" lay-filter="LAY-app-content-list"></table> 
					        <script type="text/html" id="buttonTpl">
          {{#  if(d.status){ }}
            <button class="layui-btn layui-btn-xs">已发布</button>
          {{#  } else { }}
            <button class="layui-btn layui-btn-primary layui-btn-xs">待修改</button>
          {{#  } }}
        </script>
					        <script type="text/html" id="table-content-list">
          <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>编辑</a>
          <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon layui-icon-delete"></i>删除</a>
        </script>
					      </div>
					    </div>
					  </div>
			  </div>
			</div>
	  </div>
  <script src="${basePath}/resources/layuiadmin/layui/layui.js"></script>  
  <script>
  layui.config({
	    base: '${basePath}/resources/layuiadmin/' //静态资源所在路径
	  }).extend({
	    index: 'lib/index' //主入口模块
	  }).use(['index', 'contlist', 'table','form'], function(){
	    var table = layui.table
	    ,form = layui.form;
	    console.log(222222222);
	    //监听搜索
	    form.on('submit(LAY-app-contlist-search)', function(data){
	      var field = data.field;
	      console.log(field);
	    //执行重载
	      table.reload('LAY-app-content-list', {
	        page: {
	            curr: 1 //重新从第 1 页开始
	        }
	        ,where: field
	      });
	      /* $.ajax({
   			type : "POST",
   			url: basePath + "/admin/project/search",
   			data:field,
   			error:function(data){
   				var dataObj = $.parseJSON(data);
   				layer.msg(dataObj.msg);
   			},
   			success : function(data){
   				var dataObj = $.parseJSON(data);
   				if(dataObj.code == 0){
   				  
   				}else{
   					layer.msg(dataObj.msg);
   				}
   			}
      	  }); */
	    });
	    
	    var $ = layui.$, active = {
	      batchdel: function(){
	        var checkStatus = table.checkStatus('LAY-app-content-list')
	        ,checkData = checkStatus.data; //得到选中的数据
			
	        var arrid = [];
			$.each(checkData, function(key, val) {
				arrid.push(checkData[key].id);
			});
			console.log(arrid);
	        if(checkData.length === 0){
	          return layer.msg('请选择数据');
	        }
	      
	        layer.confirm('确定删除吗？', function(index) {
	        	
        	 $.ajax({
      			type : "POST",
      			url: basePath + "/admin/project/delete",
      			data:{"arrid":arrid},
      			error:function(data){
      				var dataObj = $.parseJSON(data);
      				layer.msg(dataObj.msg);
      			},
      			success : function(data){
      				var dataObj = $.parseJSON(data);
      				if(dataObj.code == 0){
      					//layer.msg(dataObj.msg);
      					table.reload('LAY-app-content-list');
      					layer.msg('已删除成功');
      				}else{
      					layer.msg(dataObj.msg);
      				}
      			}
	      	  });
	          //执行 Ajax 后重载
	          /*
	          admin.req({
	            url: 'xxx'
	            //,……
	          });
	          */
	        });
	      },
	      add: function(){
	        layer.open({
	          type: 2
	          ,title: '添加项目'
	          ,content: 'listform'
	          ,maxmin: true
	          ,area: ['550px', '550px']
	          ,btn: ['确定', '取消']
	          ,yes: function(index, layero){
	            //点击确认触发 iframe 内容中的按钮提交
	            var submit = layero.find('iframe').contents().find("#layuiadmin-app-form-submit");
	            console.log(submit);
	            submit.click();
	            layer.msg("添加成功");
	          }
	        }); 
	      }
	    }; 

	    $('.layui-btn.layuiadmin-btn-list').on('click', function(){
	      var type = $(this).data('type');
	      active[type] ? active[type].call(this) : '';
	    });

	  });
  </script>
</body>
</html>
