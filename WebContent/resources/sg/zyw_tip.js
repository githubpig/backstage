(function($){
	//$.fn.组件名 或  $.组件名
	$.fn.zywTip = function(options){
		
		/*对象混入---- $.extend (针对的是:属性  属性有则覆盖，属性无则添加)
		 $.extend(flag,target,object1,object2)
		 flag : true,  递归混入((target + object1 + object2)混入到target,再用 target2+object3 +	//	object4)混入到target; 
				false, 第一次 ：target + object1 + object2 混入后为 target1;  
					   第二次 ：target + object3 + object4 混入后为 target2;*/

		var opts = $.extend(false,$.fn.zywTip.defaults,options,$.fn.zywTip.methods);
		
		//this : jQuery 对象（指当前方法的调用者）
		return this.on(opts.type,function(e){
			opts.style1(opts,this);
			opts.style2(opts,this);
			opts.init(opts,this);
			$(this).on("mouseout",function(){
				$(".ui-tip").fadeOut("fast");
			});
		});
	};
	
	
	//默认参数
	$.fn.zywTip.defaults = { 
		type : "mouseover",
		content : "我是一个tip框哦!!!",
		bgcolor : "orange"
	};
	
	//默认方法
	$.fn.zywTip.methods = {
		//初始化
		init : function(opts,targetObj){
			//初始化模板
			var $tip = this.template(opts);
			$(".ui-tip").css("background",opts.bgcolor);
			$(".tip-triangle").css("border-top","10px solid "+opts.bgcolor);
			this._position($tip,targetObj);
		},
		//模板html
		template : function(opts){
			var html = "<div class= 'ui-tip' > "+
				" <span>"+opts.content+"</span> "+
				" <span class= 'tip-triangle'></span> "+
				" </div> ";
			var $tip = $(html);
			$(".ui-tip").remove();
			$("body").append($tip);
			var width = $(".ui-tip").width()/2;
			$(".tip-triangle").css("left",width);
			return $tip;
		},
		_position : function($tip,targetObj){

			var left = $(targetObj).width()/2+$(targetObj).offset().left-$tip.width()/2-10;
			var top =  $(targetObj).offset().top- $(targetObj).height()-18;
			$tip.css({"left":left+"px","top":top+"px"});
		},
		//显示数字样式 
		style1 : function(opts,targetObj){
			var index = $(targetObj).index()+1;
			opts.content = index;
		},
		//显示时间样式
		style2 : function(opts,targetObj){
			var time = $(targetObj).data("time");
			if((typeof time) != "undefined"){
				opts.content = time;
			}
		}
	};

})(jQuery);