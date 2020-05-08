var zywPage = {
	pageNo : 0,
	pageSize : 10,
	timer : null,
	init : function(itemcount){
		$("#page").tzPage(itemcount, {
			num_edge_entries : 1,//边缘页数
			num_display_entries : 4,//主体页数
			num_edge_entries: 5,
			current_page: 0,
			showGo:true,
			showSelect:true,
			items_per_page : 10,//每页显示X项
			prev_text : "前一页",
			next_text : "后一页",
			callback : function(pageNo,pageSize){
				zywPage.loadData(pageNo,pageSize);
			}
		});
	},
	loadData : function (pageNo,pageSize,callback){
		var keyWord = $("#keyWord").val();
		var model = $("#tbody").data("model");//模块化
		$this = this;
		clearTimeout($this.timer);
		$this.timer = setTimeout(function(){
			$.ajax({
				type : "post",
				url: adminPath + "/"+model+"/template",
				data:{"pageNo" : pageNo*pageSize, "pageSize" : pageSize,"keyWord":keyWord},
				success : function(data){
					$("#tbody").html(data);
					$(".tip").zywTip({bgcolor:"#111"});
					if(isNotEmpty(keyWord))$this.hightWords(keyWord);
					if(callback){
						var count = $("#tbody").find("#itemCount").val();
						callback(count);
					}
				}
			});
		},300);
	},
	hightWords : function(keyWord){
		if(isEmpty(keyWord))return;
		$("#tbody").find("td.key").each(function(){
			var title = $(this).text();
			//ig: 忽略大小写，全局 , 正则格式
			var regex = new RegExp(keyWord,"ig");
			//查找到替换
			var tilteHtml = title.replace(regex,"<span class='red'>"+keyWord+"</span>");
			$(this).html(tilteHtml);
		});
	},
	search: function(obj){
		var keyWord = $("#keyWord").val();
		var words = $("#keyWord").data("words");
		if(isEmpty(keyWord)){
			loading("请输入关键字...",3);
			return;
		}
		//重复搜索相同的关键字
		if(eqauls(words, keyWord)){
			loading("搜索结果如下...",3);
			return;
		}
		$("#keyWord").data("words",keyWord);
		//回调函数 ：可以初始化一次
		zywPage.loadData(zywPage.pageNo,zywPage.pageSize,function(itemcount){
			zywPage.init(itemcount);
		});
	},
	op: function(obj){
		var model = $("#tbody").data("model");//模块化
		$this = $(obj);
		var id = $this.data("id");
		var val = $this.data("val");
		var mark = $this.data("mark");
		var value = val == 0? 1 : 0;
		var params = {};
		params["id"] = id;
		params[mark] = value;
		//清除未执行的动画
		clearTimeout(this.timer);
		//200ms执行一次
		this.timer = setTimeout(function(){
			$.ajax({
				type:"post",
				data:params,
				url : adminPath + "/"+model+"/update",
				success : function(data){
					var data = data.trim();
					if(data == "success"){
						var $span = $this.children("span");
						var sign = $span.hasClass("red");
						sign == true ? $span.removeClass().text("是").addClass("green"):$span.removeClass().text("否").addClass("red");
						//修改状态
						$this.data("val",value);
						loading("执行成功...",2);
					}
				}
			 });
		},200);
	},
	remove : function(obj){
		var model = $("#tbody").data("model");//模块化
		$.tzConfirm({title:"友情提示",content:"您确定删除吗?",callback:function(ok){
			if(ok){
				$this = $(obj);
				var id = $this.data("id");
				$.ajax({
					type : "post",
					data : {"id":id},
					url : adminPath + "/"+model+"/delete",
					success : function(data){
						var data = data.trim();
						if(data=="success"){
							$this.parents("tr").fadeOut("slow",function(){
								$(this).remove();
							});
						}
					}
				});
				loading("删除成功...",3);
			}
		}});
	}
};