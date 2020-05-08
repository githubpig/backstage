package com.zyw.bean;

import java.io.Serializable;

public class RolePermission implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer roleId;
	private Integer permissionId;
	
	public RolePermission() {
		super();
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}
	@Override
	public String toString() {
		return "RolePermission [roleId=" + roleId + ", permissionId="
				+ permissionId + "]";
	}
}
