package com.zyw.bean;

import java.util.Date;
/**
 * 
 * 作用: AdminStat实体类
 * 类名：AdminStat
 * 创建人:pig
 * 时间:2017年05月14日 06:10:31
 * 手机号 : 15237360630
 * pig公司-版权所有
 */
public class AdminStat implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;// 主键 
	private String classname;// 名称 
	private Date createTime;// 创建时间
	private Integer userId;// 用户ID
	private String method;
	private long runtime;
	private String ip;
	private String ipaddress;
	private String username;

	
	public Integer getId() {
		return id;
	}

	public long getRuntime() {
		return runtime;
	}


	public void setRuntime(long runtime) {
		this.runtime = runtime;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getClassname() {
		return classname;
	}


	public void setClassname(String classname) {
		this.classname = classname;
	}


	public Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getMethod() {
		return method;
	}


	public void setMethod(String method) {
		this.method = method;
	}

	public String getIp() {
		return ip;
	}


	public void setIp(String ip) {
		this.ip = ip;
	}


	public String getIpaddress() {
		return ipaddress;
	}


	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public AdminStat() {
		super();
	}
}