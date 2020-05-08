/**

 @Name：layuiAdmin 内容系统
 @Author：star1029
 @Site：http://www.layui.com/admin/
 @License：LPPL
    
 */
var basePath = layui.setter.base.substr(0,layui.setter.base.indexOf("/resources"));
layui.define(['table', 'form'], function(exports){
  var $ = layui.$
  ,table = layui.table
  ,form = layui.form;
  console.log("=="+basePath);
  //文章管理
  table.render({
    elem: '#LAY-app-content-list'
    ,url: basePath+'/admin/project/query' //模拟接口
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
      ,{field: 'id', width: 100, title: '项目ID', sort: true}
      ,{field: 'project_type', title: '投资规模'}
      ,{field: 'name', title: '投资名称', minWidth: 100}
      ,{field: 'rate', title: '预期收益'}
      ,{field: 'duration', title: '投资期限'}
      ,{field: 'start_money', title: '起投金额'}
      ,{field: 'projectrate', title: '投资进度'}
      ,{field: 'status', title: '发布状态', templet: '#buttonTpl', minWidth: 80, align: 'center'}
      ,{title: '操作', minWidth: 150, align: 'center', fixed: 'right', toolbar: '#table-content-list'}
    ]]
    ,page: true
    ,limit: 10
    ,limits: [10, 15, 20, 25, 30]
    ,text: '对不起，加载出现异常！'
  });
  
  //监听工具条
  table.on('tool(LAY-app-content-list)', function(obj){
    var data = obj.data;
    if(obj.event === 'del'){
      layer.confirm('确定删除此项目？', function(index){
    	  $.ajax({
			type : "POST",
			url: basePath + '/admin/project/del?id='+data.id,
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
        layer.close(index);
      });
    } else if(obj.event === 'edit'){
      layer.open({
        type: 2
        ,title: '编辑项目'
        ,content: basePath+'/admin/project/editform?id='+ data.id
        ,maxmin: true
        ,area: ['550px', '550px']
        ,btn: ['确定', '取消']
        ,yes: function(index, layero){
          var iframeWindow = window['layui-layer-iframe'+ index]
          ,submit = layero.find('iframe').contents().find("#layuiadmin-app-form-edit");
          //监听提交
          iframeWindow.layui.form.on('submit(layuiadmin-app-form-edit)', function(data){
        	  if(data.field.status == 'on'){
            	  data.field.status = 1;
              }else{
            	  data.field.status = 0;
              }
        	  var project = data.field; //获取提交的字段
        	  console.log(project);
        	  //提交 Ajax 成功后，静态更新表格中的数据
        	  //$.ajax({});
	            $.ajax({
					type : "POST",
					url: basePath + '/admin/project/update',
					data:project,
					error:function(data){
						var dataObj = $.parseJSON(data);
						layer.msg(dataObj.msg);
					},
					success : function(data){
						var dataObj = $.parseJSON(data);
						if(project.project_type == 0){
							project.project_type = '短期精选';
						}else if(project.project_type == 1){
							project.project_type = '中期稳健';
						}else{
							project.project_type = '长期增值';
						}
						if(dataObj.code == 0){
						    obj.update({
				              id: project.id
				              ,project_type: project.project_type
				              ,name: project.name
				              ,rate: project.rate
				              ,duration: project.duration
				              ,start_money: project.start_money
				              ,projectrate: project.projectrate
				              ,status: project.status
				            }); //数据更新
				            form.render();
						}else{
							layer.msg(dataObj.msg);
						}
					}
	      	  });
	          layer.close(index); //关闭弹层
          });  
          submit.trigger('click');
        }
      });
    }
  });

  //分类管理
  table.render({
    elem: '#LAY-app-content-tags'
    ,url: layui.setter.base + 'json/content/tags.js' //模拟接口
    ,cols: [[
      {type: 'numbers', fixed: 'left'}
      ,{field: 'id', width: 100, title: 'ID', sort: true}
      ,{field: 'tags', title: '分类名', minWidth: 100}
      ,{title: '操作', width: 150, align: 'center', fixed: 'right', toolbar: '#layuiadmin-app-cont-tagsbar'}
    ]]
    ,text: '对不起，加载出现异常！'
  });
  
  //监听工具条
  table.on('tool(LAY-app-content-tags)', function(obj){
    var data = obj.data;
    if(obj.event === 'del'){
      layer.confirm('确定删除此分类？', function(index){
        obj.del();
        layer.close(index);
      });
    } else if(obj.event === 'edit'){
      var tr = $(obj.tr);
      layer.open({
        type: 2
        ,title: '编辑分类'
        ,content: '../../../views/app/content/tagsform.html?id='+ data.id
        ,area: ['450px', '200px']
        ,btn: ['确定', '取消']
        ,yes: function(index, layero){
          //获取iframe元素的值
          var othis = layero.find('iframe').contents().find("#layuiadmin-app-form-tags")
          ,tags = othis.find('input[name="tags"]').val();
          
          if(!tags.replace(/\s/g, '')) return;
          
          obj.update({
            tags: tags
          });
          layer.close(index);
        }
        ,success: function(layero, index){
          //给iframe元素赋值
          var othis = layero.find('iframe').contents().find("#layuiadmin-app-form-tags").click();
          othis.find('input[name="tags"]').val(data.tags);
        }
      });
    }
  });

  //评论管理
  table.render({
    elem: '#LAY-app-content-comm'
    ,url: layui.setter.base + 'json/content/comment.js' //模拟接口
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
      ,{field: 'id', width: 100, title: 'ID', sort: true}
      ,{field: 'reviewers', title: '评论者', minWidth: 100}
      ,{field: 'content', title: '评论内容', minWidth: 100}
      ,{field: 'commtime', title: '评论时间', minWidth: 100, sort: true}
      ,{title: '操作', width: 150, align: 'center', fixed: 'right', toolbar: '#table-content-com'}
    ]]
    ,page: true
    ,limit: 10
    ,limits: [10, 15, 20, 25, 30]
    ,text: '对不起，加载出现异常！'
  });
  
  //监听工具条
  table.on('tool(LAY-app-content-comm)', function(obj){
    var data = obj.data;
    if(obj.event === 'del'){
      layer.confirm('确定删除此条评论？', function(index){
        obj.del();
        layer.close(index);
      });
    } else if(obj.event === 'edit') {
      layer.open({
        type: 2
        ,title: '编辑评论'
        ,content: '../../../views/app/content/contform.html'
        ,area: ['450px', '300px']
        ,btn: ['确定', '取消']
        ,yes: function(index, layero){
          var iframeWindow = window['layui-layer-iframe'+ index]
          ,submitID = 'layuiadmin-app-comm-submit'
          ,submit = layero.find('iframe').contents().find('#'+ submitID);

          //监听提交
          iframeWindow.layui.form.on('submit('+ submitID +')', function(data){
            var field = data.field; //获取提交的字段
            
            //提交 Ajax 成功后，静态更新表格中的数据
            //$.ajax({});
            table.reload('LAY-app-content-comm'); //数据刷新
            layer.close(index); //关闭弹层
          });  
          
          submit.trigger('click');
        }
        ,success: function(layero, index){
          
        }
      });
    }
  });

  exports('contlist', {})
});