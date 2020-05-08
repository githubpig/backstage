package com.zyw.bean;

import java.util.Date;
/**
 * 
 * 作用: Permission实体类
 * 类名：Permission
 * 创建人:pig
 * 时间:2017年05月20日 03:07:48
 * 手机号 : 15237360630
 * pig公司-版权所有
 */
public class Permission implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;// 主键 
	private String name;// 名称 
	private Integer userId;// 用户ID
	private Integer parentId; //父节点id
	private String model;  //模块
	private String url; 	//地址
	private Date createTime;// 创建时间
	private Date updateTime;// 创建时间
	private Integer isDelete;// 0删除1未删除

	public Permission() {
		super();
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
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
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
}
