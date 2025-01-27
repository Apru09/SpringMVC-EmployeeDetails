package com.accenture.emp.dao;

import java.util.List;

import com.accenture.emp.beans.EmployeeBean;

public interface EmpDAO {
	
	
	void addEmployeeDetails(EmployeeBean employeeBean);
	
	List<EmployeeBean> showEmployeeDetails();
	
	void removeEmployeeDetails(int empId);

}
