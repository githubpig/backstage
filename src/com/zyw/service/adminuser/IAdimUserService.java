package com.zyw.service.adminuser;

import java.util.List;

import com.zyw.bean.AdminUser;
import com.zyw.bean.ZywParams;

public interface IAdimUserService {
	
	//登录
	public AdminUser getLogin(String email,String password);
	//批量保存
	public int saveBatch(List<AdminUser> adminUsers);
	//批量更新
	public int updateBatch(List<AdminUser> adminUsers);
	//用户查询
	public List<AdminUser> query();
	//查询总数
	public int count(ZywParams params);
}
