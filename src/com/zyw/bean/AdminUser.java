package com.zyw.bean;

import java.io.Serializable;
import java.util.Date;

public class AdminUser implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;//����
	private String username;//�û���
	private String password;//����
	private String email;//����
	private Integer age;//����
	private Integer male;//�Ա�:0Ů1��
	private String address;//��ַ
	private String telephone;//�绰
	private Integer isDelete;//0δɾ��1ɾ��
	private Date createTime;//����ʱ��
	private Date updateTime;//����ʱ��
	private Date birthday;//����
	private Integer forbiden;//0��ֹ��½1�����¼
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
