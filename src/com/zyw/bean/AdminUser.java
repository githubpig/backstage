package com.zyw.bean;

import java.io.Serializable;
import java.util.Date;

public class AdminUser implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;//主键
	private String username;//用户名
	private String password;//密码
	private String email;//邮箱
	private Integer age;//年龄
	private Integer male;//性别:0女1男
	private String address;//地址
	private String telephone;//电话
	private Integer isDelete;//0未删除1删除
	private Date createTime;//创建时间
	private Date updateTime;//更新时间
	private Date birthday;//生日
	private Integer forbiden;//0禁止登陆1允许登录
	public AdminUser(Integer id, String username, String password, String email,
			Integer age, Integer male, String address, String telephone,
			Integer isDelete, Date createTime, Date updateTime, Date birthday,
			Integer forbiden) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.age = age;
		this.male = male;
		this.address = address;
		this.telephone = telephone;
		this.isDelete = isDelete;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.birthday = birthday;
		this.forbiden = forbiden;
	}
	public AdminUser() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getMale() {
		return male;
	}
	public void setMale(Integer male) {
		this.male = male;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getForbiden() {
		return forbiden;
	}
	public void setForbiden(Integer forbiden) {
		this.forbiden = forbiden;
	}
	@Override
	public String toString() {
		return "AdminUser [id=" + id + ", username=" + username + ", password="
				+ password + ", email=" + email + ", age=" + age + ", male="
				+ male + ", address=" + address + ", telephone=" + telephone
				+ ", isDelete=" + isDelete + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", birthday=" + birthday
				+ ", forbiden=" + forbiden + "]";
	}
}
