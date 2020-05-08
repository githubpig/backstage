package com.zyw.dao.permission;

import java.util.List;

import com.zyw.bean.Permission;
import com.zyw.bean.ZywParams;
/**
 * 作用: Permission 数据操作方法
 * 接口：IPermissionMapper
 * 创建人:pig
 * 时间:2017年05月20日 03:07:48
 * 手机号 : 15237360630
 * pig公司-版权所有
 */
public interface IPermissionMapper {
	
	/**
	 * 查询操作
	 * 方法名:queryPermissions
	 * 创建人:pig	
	 * 时间:2017年05月20日 03:07:48
	 * @param params
	 * @return 
	 * 返回类型: List<Permission>
	 */
	public List<Permission> queryPermissions(ZywParams params);
	/**
	 * 保存操作
	 * 方法名:save
	 * 创建人:pig	
	 * 时间:2017年05月20日 03:07:48
	 * @param permission
	 * @return 
	 * 返回类型: int
	 */
	public int save(Permission permission);
	/**
	 * 更新操作
	 * 方法名:update
	 * 创建人:pig	
	 * 时间:2017年05月20日 03:07:48
	 * @param permission
	 * @return 
	 * 返回类型: int
	 */
	public int update(Permission permission);
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
	 * 方法名:getPermission
	 * 创建人:pig
	 * 时间:2017年05月20日 03:07:48
	 * @param id
	 * @return 
	 * 返回类型: Permission
	 */
	 public Permission getPermission(Integer id);
	/**
	 * 查询内容总条数
	 * 方法名:countPermission
	 * 创建人:pig
	 * 时间:2017年05月20日 03:07:48
	 * @param params
	 * @return 
	 * 返回类型: int
	 */
	public int countPermission(ZywParams params);
	
	/**
	 * 查询出根目录
	 * 方法名:queryRoot
	 * 创建人:pig	
	 * 时间:2017年5月20日-下午3:41:38
	 * @return 
	 * 返回类型: List<HashMap<String,Object>>
	 */
	public List<Permission> queryRoot();
	/**
	 * 根据父id查询子目录
	 * 方法名:queryChildren
	 * 创建人:pig	
	 * 时间:2017年5月20日-下午8:21:26
	 * @param pid
	 * @return 
	 * 返回类型: List<Permission>
	 */
	public List<Permission> queryChildren(Integer pid);
}
