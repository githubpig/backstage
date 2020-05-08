package com.zyw.service.content;

import java.util.List;

import com.zyw.bean.Content;
import com.zyw.bean.ZywParams;

public interface IContentService {
	//查询内容
	public List<Content> queryContents(ZywParams params);
	//查询内容总条数
	public int countContent(ZywParams params);
	/**
	 * 更新删除和发布状态
	 * 方法名:update
	 * 创建人:pig	
	 * 时间:2017年5月13日-下午9:16:38
	 * @param content
	 * @return 
	 * 返回类型: int
	 */
	public int update(Content content);
	
	/**
	 * 根据id删除
	 * 方法名:delete
	 * 创建人:pig	
	 * 时间:2017年5月14日-下午12:24:42
	 * @param params
	 * @return 
	 * 返回类型: int
	 */
	public int delete(ZywParams params);
}
