package com.zyw.dao.adminstat;

import java.util.List;

import com.zyw.bean.AdminStat;
import com.zyw.bean.ZywParams;
/**
 * 作用: AdminStat 数据操作方法
 * 接口：IAdminStatMapper
 * 创建人:pig
 * 时间:2017年05月14日 06:10:31
 * 手机号 : 15237360630
 * pig公司-版权所有
 */

public interface IAdminStatMapper {
	
	/**
	 * 查询操作
	 * 方法名:queryAdminStats
	 * 创建人:pig	
	 * 时间:2017年05月14日 06:10:31
	 * @param params
	 * @return 
	 * 返回类型: List<AdminStat>
	 */
	public List<AdminStat> queryAdminStats(ZywParams params);
	/**
	 * 保存操作
	 * 方法名:save
	 * 创建人:pig	
	 * 时间:2017年05月14日 06:10:31
	 * @param adminstat
	 * @return 
	 * 返回类型: int
	 */
	public int save(AdminStat adminstat);
	/**
	 * 更新操作
	 * 方法名:update
	 * 创建人:pig	
	 * 时间:2017年05月14日 06:10:31
	 * @param adminstat
	 * @return 
	 * 返回类型: int
	 */
	public int update(AdminStat adminstat);
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
	 * 方法名:getAdminStat
	 * 创建人:pig
	 * 时间:2017年05月14日 06:10:31
	 * @param id
	 * @return 
	 * 返回类型: AdminStat
	 */
	 public AdminStat getAdminStat(Integer id);
	/**
	 * 查询内容总条数
	 * 方法名:countAdminStat
	 * 创建人:pig
	 * 时间:2017年05月14日 06:10:31
	 * @param params
	 * @return 
	 * 返回类型: int
	 */
	public int countAdminStat(ZywParams params);
}
