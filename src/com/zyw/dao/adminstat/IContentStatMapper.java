package com.zyw.dao.adminstat;

import java.util.HashMap;
import java.util.List;

import com.zyw.bean.ZywParams;

public interface IContentStatMapper {
	
	//����ͳ����������
	public List<HashMap<String, Object>>  contentStat(ZywParams params);
}
