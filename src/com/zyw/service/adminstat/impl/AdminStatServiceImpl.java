package com.zyw.service.adminstat.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyw.bean.AdminStat;
import com.zyw.bean.ZywParams;
import com.zyw.dao.adminstat.IAdminStatMapper;
import com.zyw.service.adminstat.IAdminStatService;

@Service
public class AdminStatServiceImpl implements IAdminStatService {

	@Autowired
	private IAdminStatMapper adminstatMapper;
	//查询，返回List<AdminStat>
	@Override
	public List<AdminStat> queryAdminStats(ZywParams params) {
		return adminstatMapper.queryAdminStats(params);
	}
	//保存 
	@Override
	public int save(AdminStat adminstat) {
		return adminstatMapper.save(adminstat);
	}
	//更新
	@Override
	public int update(AdminStat adminstat) {
		return adminstatMapper.update(adminstat);
	}
	//删除
	@Override
	public int delete(ZywParams params) {
		return adminstatMapper.delete(params);
	}
	//根据id查找数据
	@Override
	public AdminStat getAdminStat(Integer id) {
		return adminstatMapper.getAdminStat(id);
	}
	//查询内容总条数
	@Override
	public int countAdminStat(ZywParams params) {
		return adminstatMapper.countAdminStat(params);
	}
}
