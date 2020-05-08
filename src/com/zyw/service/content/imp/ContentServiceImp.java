package com.zyw.service.content.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyw.bean.Content;
import com.zyw.bean.ZywParams;
import com.zyw.dao.content.IContentMapper;
import com.zyw.service.content.IContentService;
import com.zyw.util.TmStringUtils;

@Service
public class ContentServiceImp implements IContentService{

	@Autowired
	private IContentMapper contentMapper;
	
	@Override
	public List<Content> queryContents(ZywParams params) {
		if(TmStringUtils.isEmpty(params.getOrder()))params.setOrder("create_time desc");
		return contentMapper.queryContents(params);
	}
	//查询内容总条数
	@Override
	public int countContent(ZywParams params) {
		return contentMapper.countContent(params);
	}
	@Override
	public int update(Content content) {
		return contentMapper.update(content);
	}
	@Override
	public int delete(ZywParams params) {
		return contentMapper.delete(params);
	}
}
