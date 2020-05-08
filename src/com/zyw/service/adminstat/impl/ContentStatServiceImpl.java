package com.zyw.service.adminstat.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyw.bean.ZywParams;
import com.zyw.dao.adminstat.IContentStatMapper;
import com.zyw.service.adminstat.IContentStatService;
@Service
public class ContentStatServiceImpl implements IContentStatService {

	@Autowired
	private IContentStatMapper contentStatMapper;
	
	@Override
	public List<HashMap<String, Object>> contentStat(ZywParams params) {
		//按月统计内容数量
		return contentStatMapper.contentStat(params);
	}
	
}
