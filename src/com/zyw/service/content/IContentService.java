package com.zyw.service.content;

import java.util.List;

import com.zyw.bean.Content;
import com.zyw.bean.ZywParams;

public interface IContentService {
	//��ѯ����
	public List<Content> queryContents(ZywParams params);
	//��ѯ����������
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
