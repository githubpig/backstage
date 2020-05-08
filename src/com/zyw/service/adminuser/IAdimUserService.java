package com.zyw.service.adminuser;

import java.util.List;

import com.zyw.bean.AdminUser;
import com.zyw.bean.ZywParams;

public interface IAdimUserService {
	
	//��¼
	public AdminUser getLogin(String email,String password);
	//��������
	public int saveBatch(List<AdminUser> adminUsers);
	//��������
	public int updateBatch(List<AdminUser> adminUsers);
	//�û���ѯ
	public List<AdminUser> query();
	//��ѯ����
	public int count(ZywParams params);
}
