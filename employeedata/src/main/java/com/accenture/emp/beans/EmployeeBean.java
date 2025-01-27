package com.accenture.emp.beans;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class EmployeeBean {
	
	int empId;
	
	@NotBlank(message="This is a required field")
	String empName;
	float empSal;
	
	int roleId;
	
	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public float getEmpSal() {
		return empSal;
	}
	public void setEmpSal(float empSal) {
		this.empSal = empSal;
	}
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	@Override
	public String toString() {
		return "EmployeeBean [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + ", roleId=" + roleId
				+ "]";
	}
	
	
	
	
	
	

}
