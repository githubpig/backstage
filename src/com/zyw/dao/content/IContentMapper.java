package com.zyw.dao.content;

import java.util.List;

import com.zyw.bean.Content;
import com.zyw.bean.ZywParams;

public interface IContentMapper {
	
	public List<Content> queryContents(ZywParams params);
	
	/**
	 * ������:countContent
	 * ������:pig	
	 * ʱ��:2017��5��13��-����4:35:22
	 * @param params
	 * @return 
	 * ��������: int
	 */
	public int countContent(ZywParams params);
	/**
	 * ����ɾ���ͷ���״̬
	 * ������:update
	 * ������:pig	
	 * ʱ��:2017��5��13��-����9:16:38
	 * @param content
	 * @return 
	 * ��������: int
	 */
	public int update(Content content);
	
	/**
	 * ����idɾ��
	 * ������:delete
	 * ������:pig	
	 * ʱ��:2017��5��14��-����12:24:42
	 * @param params
	 * @return 
	 * ��������: int
	 */
	public int delete(ZywParams params);
}
