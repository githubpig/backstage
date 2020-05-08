package com.zyw.service.message;

import java.util.List;

import com.zyw.bean.Message;
import com.zyw.bean.ZywParams;
/**
 * 作用: Message 数据操作方法
 * 接口：IMessageService
 * 创建人:pig
 * 时间:2017年05月13日 05:57:24
 * 手机号 : 15237360630
 * pig公司-版权所有
 */
public interface IMessageService {
	
	/**
	 * 查询操作
	 * 方法名:queryMessages
	 * 创建人:pig	
	 * 时间:2017年05月13日 05:57:24
	 * @param params
	 * @return 
	 * 返回类型: List<Message>
	 */
	public List<Message> queryMessages(ZywParams params);
	/**
	 * 保存操作
	 * 方法名:save
	 * 创建人:pig	
	 * 时间:2017年05月13日 05:57:24
	 * @param message
	 * @return 
	 * 返回类型: int
	 */
	public int save(Message message);
	/**
	 * 更新操作
	 * 方法名:update
	 * 创建人:pig	
	 * 时间:2017年05月13日 05:57:24
	 * @param message
	 * @return 
	 * 返回类型: int
	 */
	public int update(Message message);
	/**
	 * 删除操作
	 * 方法名:delete
	 * 创建人:pig	
	 * 时间:2017年5月8日-下午3:05:32
	 * @param params
	 * @return 
	 * 返回类型: int
	 */
	public int delete(ZywParams params);
	/**
	 * 根据id查询操作
	 * 方法名:getMessage
	 * 创建人:pig
	 * 时间:2017年05月13日 05:57:24
	 * @param id
	 * @return 
	 * 返回类型: Message
	 */
	 public Message getMessage(Integer id);
	/**
	 * 查询内容总条数
	 * 方法名:countMessage
	 * 创建人:pig
	 * 时间:2017年05月13日 05:57:24
	 * @param params
	 * @return 
	 * 返回类型: int
	 */
	 public int countMessage(ZywParams params);
	 
}
