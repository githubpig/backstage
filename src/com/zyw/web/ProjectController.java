package com.zyw.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.zyw.bean.Content;
import com.zyw.bean.Params;
import com.zyw.bean.Project;
import com.zyw.bean.ResultData;
import com.zyw.bean.ZywParams;
import com.zyw.service.project.IProjectService;



@Controller
@RequestMapping("/admin/project")
public class ProjectController {
	
	@Autowired
	private IProjectService  projectService;
	
	@RequestMapping("list")
	public String list(){
		return "project/list";
	}
	@RequestMapping("listform")
	public String listform(){
		return "project/listform";
	}
	@ResponseBody
	@RequestMapping(value="/search",method = RequestMethod.POST)
	public String search(HttpServletRequest request,
			HttpServletResponse response){
		
		Project person = new Project();
		String id = request.getParameter("id");
		if(id != "" && id != null){
			person.setId(Integer.parseInt(id));
		}
		String name = request.getParameter("name");
		if(name != "" && name != null){
			person.setName(name);
		}
		String start_money = request.getParameter("start_money");
		if(start_money != "" && start_money != null){
			person.setStart_money(Double.parseDouble(start_money));
		}
		String project_type = request.getParameter("project_type");
		if(project_type != "" && project_type != null){
			person.setProject_type(Integer.parseInt(project_type));
		}
		List<Project> ps = projectService.queryCondition(person);
		ResultData resultData = null;
		Map<String, Object> map = null;
		if(ps != null){
			resultData = new ResultData();
			List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
			for(Project p :ps){
				map = new HashMap<>();
				map.put("id", p.getId());
				map.put("project_type", getType(p.getProject_type()));
				map.put("name", p.getName());
				map.put("rate", p.getRate());
				map.put("duration", p.getDuration());
				map.put("start_money", p.getStart_money());
				map.put("projectrate", p.getProjectrate());
				map.put("status", p.getStatus());
				list.add(map);
			}
			resultData.setCode(0);
			resultData.setMsg("success");
			resultData.setCount("20");
			Object jsonArray = JSONArray.toJSON(list);
			resultData.setData(jsonArray);
		}else{
			resultData = new ResultData();
			resultData.setCode(-1);
			resultData.setMsg("查询投资项目数据失败");
		}
		String str = JSON.toJSONString(resultData);
		return str;
	}
	@ResponseBody
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public String update(HttpServletRequest request,
			HttpServletResponse response, Project project){
		int flag = projectService.update(project);
		ResultData resultData = new ResultData();
		if(flag<0){
			resultData.setCode(0);
			resultData.setMsg("success");
		}else{
			resultData.setCode(-1);
			resultData.setMsg("fail");
		}
		String str = JSON.toJSONString(resultData);
		return str;
	}
	//模板
	@RequestMapping("/editform")
	public ModelAndView editform(HttpServletRequest request,
			HttpServletResponse response,@RequestParam("id") int id){
		ModelAndView modelAndView = new ModelAndView();
		Project project = projectService.queryId(id);
		modelAndView.setViewName("/project/editform");
		modelAndView.addObject("project",project);
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping(value="/del",method = RequestMethod.POST)
	public String save(HttpServletRequest request,
			HttpServletResponse response,@RequestParam("id") int id){
		int flag = projectService.del(id);
		ResultData resultData = new ResultData();
		if(flag<0){
			resultData.setCode(0);
			resultData.setMsg("success");
		}else{
			resultData.setCode(-1);
			resultData.setMsg("fail");
		}
		String str = JSON.toJSONString(resultData);
		return str;
	}
	
	@ResponseBody
	@RequestMapping(value="/delete",method = RequestMethod.POST)
	public String save(HttpServletRequest request,
			HttpServletResponse response,@RequestParam("arrid[]") int [] arrid){
		int flag = projectService.delete(arrid);
		ResultData resultData = new ResultData();
		if(flag<0){
			resultData.setCode(0);
			resultData.setMsg("success");
		}else{
			resultData.setCode(-1);
			resultData.setMsg("fail");
		}
		String str = JSON.toJSONString(resultData);
		return str;
	}
	@ResponseBody
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String save(HttpServletRequest request,
			HttpServletResponse response,Project project){
		int flag = projectService.save(project);
		ResultData resultData = new ResultData();
		if(flag<0){
			resultData.setCode(0);
			resultData.setMsg("success");
		}else{
			resultData.setCode(-1);
			resultData.setMsg("fail");
		}
		String str = JSON.toJSONString(resultData);
		return str;
	}
	//page=1&limit=10 
	@ResponseBody
	@RequestMapping(value="/query",method = RequestMethod.GET)
	public String query(HttpServletRequest request,
			HttpServletResponse response,@RequestParam(value="page") String pageNo, @RequestParam (value="limit") String pageSize){
		Params param = new Params();
		int page = Integer.parseInt(pageNo);
		int size = Integer.parseInt(pageSize);
		param.setPageNo(( page - 1)*size);
		param.setPageSize(size);
		
		String id = request.getParameter("id");
		if(id != "" && id != null){
			param.setId(Integer.parseInt(id));
		}
		String name = request.getParameter("name");
		if(name != "" && name != null){
			param.setName(name);
		}
		String start_money = request.getParameter("start_money");
		if(start_money != "" && start_money != null){
			param.setStart_money(Double.parseDouble(start_money));
		}
		String project_type = request.getParameter("project_type");
		if(project_type != "" && project_type != null){
			param.setProject_type(Integer.parseInt(project_type));
		}
		List<Project>  ps = projectService.queryPageProjects(param);
		int count = projectService.count();
		ResultData resultData = null;
		Map<String, Object> map = null;
		if(ps != null){
			resultData = new ResultData();
			List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
			for(Project p :ps){
				map = new HashMap<>();
				map.put("id", p.getId());
				map.put("project_type", getType(p.getProject_type()));
				map.put("name", p.getName());
				map.put("rate", p.getRate());
				map.put("duration", p.getDuration());
				map.put("start_money", p.getStart_money());
				map.put("projectrate", p.getProjectrate());
				map.put("status", p.getStatus());
				list.add(map);
			}
			resultData.setCode(0);
			resultData.setMsg("success");
			resultData.setCount(count+"");
			Object jsonArray = JSONArray.toJSON(list);
			resultData.setData(jsonArray);
		}else{
			resultData = new ResultData();
			resultData.setCode(-1);
			resultData.setMsg("查询投资项目数据失败");
		}
		String str = JSON.toJSONString(resultData);
		return str;
	}
	public static String getType(int type){
		if(type == 0){
			return "短期精选";
		}else if(type == 1){
			return "中期稳健";
		}else if(type == 2){
			return "长期增值";
		}else{
			return "无";
		}
	}
}
