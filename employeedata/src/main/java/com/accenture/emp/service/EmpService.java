package com.accenture.emp.service;

import java.util.List;
import java.util.Map;

import com.accenture.emp.beans.EmployeeBean;

public interface EmpService {
	
	
	void addEmployeeDetails(EmployeeBean employeeBean);
	
	List<EmployeeBean> viewEmployeeDetails();
	
	void removeEmployeeDetails(int empId);
	
	Map<Integer, String> getAllEmps();

}
