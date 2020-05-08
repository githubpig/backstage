package com.zyw.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zyw.bean.AdminUser;
import com.zyw.bean.Role;
import com.zyw.bean.RolePermission;
import com.zyw.bean.ZywParams;
import com.zyw.service.adminuser.IAdimUserService;
import com.zyw.service.role.IRoleService;
import com.zyw.util.PigStringUtils;

/**
 * 
 * 作用:内容控制层
 * 类名：RoleController
 * 创建人:pig
 * 时间:2017年05月21日 02:38:53
 * 手机号 : 15237360630
 * pig公司-版权所有
 */
@Controller
@RequestMapping("admin/role")
public class RoleController {
	
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IAdimUserService adminUserService;
	
	@ResponseBody
	@RequestMapping("/list")
	public ModelAndView list(ZywParams params){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/role/list");
		return modelAndView;
	}
	
	@ResponseBody
	//url请求参数 要与 ZywParams 的属性名 相同
	@RequestMapping("/template")
	public ModelAndView template(ZywParams params){
		ModelAndView modelAndView = new ModelAndView();
		List<Role> roles = roleService.queryRoles(params);
		int count = roleService.countRole(params);
		modelAndView.setViewName("/role/template");
		modelAndView.addObject("roles",roles);
		modelAndView.addObject("count",count);
		return modelAndView;
	}
	@ResponseBody
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public String update(Role role){
		roleService.update(role);
		return "success";
	}
	
	@RequestMapping("/user/{opid}")
	public ModelAndView user(@PathVariable("opid")Integer roleId, ZywParams params){
		ModelAndView modelAndView = new ModelAndView();
		params.setIsDelete(0);
		params.setRoleId(roleId);
		List<AdminUser> adminUsers = roleService.queryNotRole(params);
		List<HashMap<String, Object>> maps = new ArrayList<>();
		HashMap<String, Object> map = null;
		for(AdminUser user : adminUsers ){
			map = new HashMap<>();
			map.put("id", user.getId());
			map.put("name", user.getUsername());
			map.put("email", user.getEmail());
			maps.add(map);
		}
		modelAndView.setViewName("/role/user");
		modelAndView.addObject("maps",maps);
		return modelAndView;
	}
	
	@RequestMapping("/permission/{opid}")
	public ModelAndView permission(@PathVariable("opid")Integer roleId, ZywParams params){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/role/permission");
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String save(HttpServletRequest request){
		String userIds = request.getParameter("users");
		String roleId = request.getParameter("roleId");
		if(PigStringUtils.isNotEmpty(userIds) &&PigStringUtils.isNotEmpty(roleId)){
			String [] userstrs = userIds.split(",");
			for(String str : userstrs){
				roleService.saveUserRole(Integer.parseInt(str), Integer.parseInt(roleId));
			}
			return "success";
		}else{
			return "fail";
		}
	}
	//授权
	@ResponseBody
	@RequestMapping(value="/saveImpower",method = RequestMethod.POST)
	public String impower(HttpServletRequest request){
		String permissionIds = request.getParameter("permissionId");
		String roleId = request.getParameter("roleId");
		if(PigStringUtils.isNotEmpty(permissionIds) &&PigStringUtils.isNotEmpty(roleId)){
			Integer rid = Integer.parseInt(roleId);
			roleService.deleteRolePermission(rid);
			String [] pers = permissionIds.split(",");
			for(String str : pers){
				roleService.saveRolePermission(rid,Integer.parseInt(str));
			}
			return "success";
		}else{
			return "fail";
		}
	}
	
	//查询角色已有授权
	@ResponseBody
	@RequestMapping(value="/roleImpower",method = RequestMethod.POST)
	public List<RolePermission> roleImpower(){
		List<RolePermission> rolePermissions= roleService.queryRolePermission();
		return rolePermissions;
	}
	
}

