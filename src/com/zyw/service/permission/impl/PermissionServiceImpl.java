package com.zyw.service.permission.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyw.bean.Permission;
import com.zyw.bean.ZywParams;
import com.zyw.dao.permission.IPermissionMapper;
import com.zyw.service.permission.IPermissionService;

@Service
public class PermissionServiceImpl implements IPermissionService {

	@Autowired
	private IPermissionMapper permissionMapper;
	//查询，返回List<Permission>
	@Override
	public List<Permission> queryPermissions(ZywParams params) {
		return permissionMapper.queryPermissions(params);
	}
	//保存 
	@Override
	public int save(Permission permission) {
		return permissionMapper.save(permission);
	}
	//更新
	@Override
	public int update(Permission permission) {
		return permissionMapper.update(permission);
	}
	//删除
	@Override
	public int delete(ZywParams params) {
		return permissionMapper.delete(params);
	}
	//根据id查找数据
	@Override
	public Permission getPermission(Integer id) {
		return permissionMapper.getPermission(id);
	}
	//查询内容总条数
	@Override
	public int countPermission(ZywParams params) {
		return permissionMapper.countPermission(params);
	}
	@Override
	public List<Permission> queryRoot() {
		
		return permissionMapper.queryRoot();
	}
	@Override
	public List<Permission> queryChildren(Integer pid) {
		return permissionMapper.queryChildren(pid);
	}
}
