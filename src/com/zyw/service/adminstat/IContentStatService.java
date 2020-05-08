package com.zyw.service.adminstat;

import java.util.HashMap;
import java.util.List;

import com.zyw.bean.ZywParams;

public interface IContentStatService {
	
	//按月统计内容数量
	public List<HashMap<String, Object>>  contentStat(ZywParams params);
}
