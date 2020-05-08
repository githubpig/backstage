package com.zyw.dao.adminuser;

import java.util.List;
import com.zyw.bean.AdminUser;
import com.zyw.bean.ZywParams;

public interface IAdminUserMapper {
	
	public AdminUser getLogin(String email,String password);
	
	public List<AdminUser> query();
	
	public int saveBatch(List<AdminUser> adminUsers);
	
	public int updateBatch(List<AdminUser> adminUsers);
	
	public int count(ZywParams params);
}
