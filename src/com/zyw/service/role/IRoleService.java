package com.zyw.service.role;

import java.util.HashMap;
import java.util.List;

import com.zyw.bean.AdminUser;
import com.zyw.bean.Role;
import com.zyw.bean.RolePermission;
import com.zyw.bean.ZywParams;
/**
 * 作用: Role 数据操作方法
 * 接口：IRoleService
 * 创建人:pig
 * 时间:2017年05月21日 02:38:53
 * 手机号 : 15237360630
 * pig公司-版权所有
 */
public interface IRoleService {
	
	/**
	 * 查询操作
	 * 方法名:queryRoles
	 * 创建人:pig	
	 * 时间:2017年05月21日 02:38:53
	 * @param params
	 * @return 
	 * 返回类型: List<Role>
	 */
	public List<Role> queryRoles(ZywParams params);
	/**
	 * 保存操作
	 * 方法名:save
	 * 创建人:pig	
	 * 时间:2017年05月21日 02:38:53
	 * @param role
	 * @return 
	 * 返回类型: int
	 */
	public int save(Role role);
	/**
	 * 更新操作
	 * 方法名:update
	 * 创建人:pig	
	 * 时间:2017年05月21日 02:38:53
	 * @param role
	 * @return 
	 * 返回类型: int
	 */
	public int update(Role role);
	/**
	 * 删除操作
	 * 方法名:delete
	 * 创建人:pig	
	 * 时间:2017年5月8日-下午3:05:32
	 * @param params
	 * @return 
	 * 返回类型: int
	 */
	public int delete(ZywParams params);
	/**
	 * 根据id查询操作
	 * 方法名:getRole
	 * 创建人:pig
	 * 时间:2017年05月21日 02:38:53
	 * @param id
	 * @return 
	 * 返回类型: Role
	 */
	 public Role getRole(Integer id);
	/**
	 * 查询内容总条数
	 * 方法名:countRole
	 * 创建人:pig
	 * 时间:2017年05月21日 02:38:53
	 * @param params
	 * @return 
	 * 返回类型: int
	 */
	 public int countRole(ZywParams params);
	 /**
	 * 分配角色
	 * 方法名:saveUserRole
	 * 创建人:pig	
	 * 时间:2017年5月21日-下午9:33:23
	 * @param userId
	 * @param roleId
	 * @return 
	 * 返回类型: int
	 */
	public int saveUserRole(Integer userId,Integer roleId);
	/**
	 * 查询出没有分配指定角色id 的用户
	 * 方法名:queryNotRole
	 * 创建人:pig	
	 * 时间:2017年5月21日-下午10:18:39
	 * @param params
	 * @return 
	 * 返回类型: List<AdminUser>
	 */
	public List<AdminUser> queryNotRole( ZywParams params);
	/**
	 * 角色授权
	 * 方法名:saveRolePermission
	 * 创建人:pig	
	 * 时间:2017年5月23日-上午10:36:09
	 * @param roleId
	 * @param permissionId
	 * @return 
	 * 返回类型: int
	 */
	public int saveRolePermission(Integer roleId,Integer permissionId);
	/**
	 * 根据角色 删除 授权相关权限
	 * 方法名:deleteRolePermission
	 * 创建人:pig	
	 * 时间:2017年5月23日-下午1:31:08
	 * @param roleId
	 * @return 
	 * 返回类型: int
	 */
	public int deleteRolePermission(Integer roleId);
	/**
	 * 查询角色权限
	 * 方法名:queryRolePermission
	 * 创建人:pig	
	 * 时间:2017年5月23日-下午2:27:11
	 * @return 
	 * 返回类型: List<HashMap<String,Object>>
	 */
	public List<RolePermission> queryRolePermission();
	/**
	 * 根据用户ID查询角色
	 * 方法名:queryUserRole
	 * 创建人:pig	
	 * 时间:2017年5月24日-上午11:24:19
	 * @param userId
	 * @return 
	 * 返回类型: List<HashMap<String,Object>>
	 */
	public HashMap<String, Object> queryUserRole(Integer userId);
}
