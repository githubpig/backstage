package com.zyw.service.adminuser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyw.bean.AdminUser;
import com.zyw.bean.ZywParams;
import com.zyw.dao.adminuser.IAdminUserMapper;

@Service
public class AdimUserServiceImp implements IAdimUserService{

	@Autowired
	private IAdminUserMapper mapper;
	
	@Override
	public AdminUser getLogin(String email, String password) {
		return mapper.getLogin(email, password);
	}

	@Override
	public int saveBatch(List<AdminUser> adminUsers) {
		return mapper.saveBatch(adminUsers);
	}

	@Override
	public int updateBatch(List<AdminUser> adminUsers) {
		
		return mapper.updateBatch(adminUsers);
	}

	@Override
	public List<AdminUser> query() {
		return mapper.query();
	}

	@Override
	public int count(ZywParams params) {
		
		return mapper.count(params);
	}

}
