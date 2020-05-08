package com.zyw.service.message.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyw.bean.Message;
import com.zyw.bean.ZywParams;
import com.zyw.dao.message.IMessageMapper;
import com.zyw.service.message.IMessageService;

@Service
public class MessageServiceImpl implements IMessageService {

	@Autowired
	private IMessageMapper messageMapper;
	//查询，返回List<Message>
	@Override
	public List<Message> queryMessages(ZywParams params) {
		return messageMapper.queryMessages(params);
	}
	//保存 
	@Override
	public int save(Message message) {
		return messageMapper.save(message);
	}
	//更新
	@Override
	public int update(Message message) {
		return messageMapper.update(message);
	}
	//删除
	@Override
	public int delete(ZywParams params) {
		return messageMapper.delete(params);
	}
	//根据id查找数据
	@Override
	public Message getMessage(Integer id) {
		return messageMapper.getMessage(id);
	}
	//查询内容总条数
	@Override
	public int countMessage(ZywParams params) {
		return messageMapper.countMessage(params);
	}
}
