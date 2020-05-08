package com.zyw.bean;

import java.util.Date;
/**
 * 
 * 作用: Message实体类
 * 类名：Message
 * 创建人:pig
 * 时间:2017年05月13日 06:08:59
 * 手机号 : 15237360630
 * pig公司-版权所有
 */
public class Message implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;// 主键 
	private String name;// 名称 
	private Date createTime;// 创建时间
	private Date updateTime;// 创建时间
	private Integer userId;// 用户ID
	private Integer isDelete;// 0删除1未删除
	private Integer status; //0未发布1发布
	
	public Message() {
		super();
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
