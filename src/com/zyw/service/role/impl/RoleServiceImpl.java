package com.zyw.service.role.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyw.bean.AdminUser;
import com.zyw.bean.Role;
import com.zyw.bean.RolePermission;
import com.zyw.bean.ZywParams;
import com.zyw.dao.role.IRoleMapper;
import com.zyw.service.role.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private IRoleMapper roleMapper;
	//查询，返回List<Role>
	@Override
	public List<Role> queryRoles(ZywParams params) {
		return roleMapper.queryRoles(params);
	}
	//保存 
	@Override
	public int save(Role role) {
		return roleMapper.save(role);
	}
	//更新
	@Override
	public int update(Role role) {
		return roleMapper.update(role);
	}
	//删除
	@Override
	public int delete(ZywParams params) {
		return roleMapper.delete(params);
	}
	//根据id查找数据
	@Override
	public Role getRole(Integer id) {
		return roleMapper.getRole(id);
	}
	//查询内容总条数
	@Override
	public int countRole(ZywParams params) {
		return roleMapper.countRole(params);
	}
	@Override
	public int saveUserRole(Integer userId, Integer roleId) {
		return roleMapper.saveUserRole(userId, roleId);
	}
	@Override
	public List<AdminUser> queryNotRole(ZywParams params) {
		
		return roleMapper.queryNotRole(params);
	}
	@Override
	public int saveRolePermission(Integer roleId, Integer permissionId) {
		return roleMapper.saveRolePermission(roleId, permissionId);
	}
	@Override
	public int deleteRolePermission(Integer roleId) {
		
		return roleMapper.deleteRolePermission(roleId);
	}
	@Override
	public List<RolePermission> queryRolePermission() {
		
		return roleMapper.queryRolePermission();
	}
	@Override
	public HashMap<String, Object> queryUserRole(Integer userId) {
		
		return roleMapper.queryUserRole(userId);
	}
}
