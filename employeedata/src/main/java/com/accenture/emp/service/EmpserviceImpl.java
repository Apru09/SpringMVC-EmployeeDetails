package com.accenture.emp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.emp.beans.EmployeeBean;
import com.accenture.emp.beans.EmployeeDataExistsException;
import com.accenture.emp.beans.RoleBean;
import com.accenture.emp.dao.EmpDAO;
import com.accenture.emp.dao.EmpDAO2;
import com.accenture.emp.dao.RoleBeanWrapper;
import com.accenture.emp.entity.EmpEntity;

@Service
public class EmpserviceImpl implements EmpService {
	
	
	@Autowired
	EmpDAO empDAO;
	
	@Autowired
	EmpDAO2 empDAO2;
	
	@Autowired
	RoleBeanWrapper roleBeanWrapper;

	@Override
	public void addEmployeeDetails(EmployeeBean employeeBean) {
		
		EmpEntity eEnt = empDAO2.getEmployeeByRole(employeeBean.getEmpName(), employeeBean.getRoleId());
		
		if(eEnt != null) {
			throw new EmployeeDataExistsException("Employee Data Already Added");
		}
		
		empDAO.addEmployeeDetails(employeeBean);
	}

	@Override
	public List<EmployeeBean> viewEmployeeDetails() {
		
		return empDAO.showEmployeeDetails();
	}

	@Override
	public void removeEmployeeDetails(int empId) {
		
		empDAO.removeEmployeeDetails(empId);
		
	}

	@Override
	public Map<Integer, String> getAllEmps() {
		
		Map<Integer, String> map = new HashMap<>();
		
		List<RoleBean> roleList = roleBeanWrapper.getAllEmps();
		
		for(RoleBean bean : roleList) {
			map.put(bean.getRoleId(), bean.getRoleName());
		}
		
		Set<Integer> s = map.keySet();
		
		for(Integer k : s) {
			
			System.out.println(k + "..." + map.get(k));
		}
		
		return map;
		
	}

}
