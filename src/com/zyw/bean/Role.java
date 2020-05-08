package com.zyw.bean;

import java.util.Date;
/**
 * 
 * 作用: Role实体类
 * 类名：Role
 * 创建人:pig
 * 时间:2017年05月21日 02:38:53
 * 手机号 : 15237360630
 * pig公司-版权所有
 */
public class Role implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;// 主键 
	private String name;// 名称 
	private Date createTime;// 创建时间
	private Integer isDelete;// 0删除1未删除
	private String description;//描述

	
	public Role() {
		super();
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
}
