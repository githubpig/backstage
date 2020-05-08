package com.zyw.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import org.apache.struts2.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyw.bean.Permission;
import com.zyw.bean.ZywParams;
import com.zyw.service.permission.IPermissionService;

/**
 * 
 * 作用:内容控制层
 * 类名：PermissionController
 * 创建人:pig
 * 时间:2017年05月20日 03:07:48
 * 手机号 : 15237360630
 * pig公司-版权所有
 */
@Controller
@RequestMapping("admin/permission")
public class PermissionController {
	
	@Autowired
	private IPermissionService permissionService;
	
	@RequestMapping("list")
	public String list(){
		return "permission/list";
	}
	//返回数据
	HashMap<String, Object> resultMap = null;
	//孩子目录
	TreeMap<String, List<HashMap<String,Object>>> childrenMaps = null;
	@ResponseBody
	@RequestMapping("/root")
	public HashMap<String, Object> root() throws JSONException{
		resultMap = new HashMap<>();//由root，children,count(总条数)两元素
		resultMap.put("count",getCount());
		List<Permission> permissions = permissionService.queryRoot();
		if(permissions != null && permissions.size()>0){
			childrenMaps = new TreeMap<>();
			//根目录
			List<HashMap<String, Object>> maps = new ArrayList<>();
			for(Permission per: permissions){
				HashMap<String, Object> map = new HashMap<>();
				map.put("name", per.getName());
				map.put("url", per.getUrl());
				map.put("opid", per.getId()); //id号 1
				map.put("pid", per.getId()); //该目录别名：1
				maps.add(map);
				getChildren(per.getId());
			}
			resultMap.put("root",maps);
			//String result = JSONUtil.serialize(maps);//JSON序列化后返回到页面的是字符串数组;在页面中转为对象数组：eval("(++)");
			//返回页面,直接是对象数组
			return resultMap;
		}else{
			return null;
		}
	}
	//根据父ID查询子类
	public void getChildren(Integer pid){
		List<Permission> pers = permissionService.queryChildren(pid);
		if( pers != null && pers.size()>0){
			List<HashMap<String, Object>> maps = new ArrayList<>();
			for(Permission per: pers){
				HashMap<String, Object> map = new HashMap<>();
				map.put("name", per.getName());
				map.put("url", per.getUrl());
				map.put("opid", per.getId());
				map.put("pid", per.getId());
				maps.add(map);
				getChildren(per.getId());
			}
			childrenMaps.put(pid+"", maps);
		}
		resultMap.put("children",childrenMaps);
	}
	//总条数
	public int getCount(){
		ZywParams params = new ZywParams();
		params.setIsDelete(0);
		return permissionService.countPermission(params);
	}
}
