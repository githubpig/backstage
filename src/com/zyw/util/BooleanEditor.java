/**
 * tzdesk系统平台
 * tzupload
 * com.tz.util
 * DateFormateEditor.java
 * 创建人:xuchengfei 
 * 时间：2015年11月13日-下午8:56:36 
 * 2015潭州教育公司-版权所有
 */
package com.zyw.util;

import java.beans.PropertyEditorSupport;

/**
 * 
 * DateFormateEditor
 * 创建人:xuchengfei 
 * 时间：2015年11月13日-下午8:56:36 
 * @version 1.0.0
 * 
 */
public class BooleanEditor extends PropertyEditorSupport{
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(TmStringUtils.isNotEmpty(text)){
			if(text.equalsIgnoreCase("3"))setValue(true);
			if(text.equalsIgnoreCase("4"))setValue(false);
		}else{
			setValue(false);
		}
	}
}
