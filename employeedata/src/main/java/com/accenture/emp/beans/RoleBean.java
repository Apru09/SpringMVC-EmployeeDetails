package com.accenture.emp.beans;

public class RoleBean {
	
	int roleId;
	
	String roleName;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "RoleBean [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
	
	

}
