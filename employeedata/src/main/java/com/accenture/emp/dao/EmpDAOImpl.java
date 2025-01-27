package com.accenture.emp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.emp.beans.EmployeeBean;
import com.accenture.emp.entity.EmpEntity;

@Repository
@Transactional(value="txManager")
public class EmpDAOImpl implements EmpDAO {
	
		
	@PersistenceContext
	EntityManager eManager;

	
	@Override
	public void addEmployeeDetails(EmployeeBean employeeBean) {
		
		EmpEntity empEntity = new EmpEntity();
		BeanUtils.copyProperties(employeeBean, empEntity);
		eManager.persist(empEntity);
		eManager.close();
	}

	@Override
	public List<EmployeeBean> showEmployeeDetails() {
		
		Query q = eManager.createQuery("select empEnt from EmpEntity empEnt");
		List<EmpEntity> empEntList = q.getResultList();
		
		List<EmployeeBean> empList = new ArrayList<>();
		
		for(EmpEntity item : empEntList) {
			
			EmployeeBean bean = new EmployeeBean();
			BeanUtils.copyProperties(item, bean);
			empList.add(bean);
		}
		
		return empList;
	}

	@Override
	public void removeEmployeeDetails(int empId) {
		
		EmpEntity e = eManager.find(EmpEntity.class, empId);
		eManager.remove(e);
		
	}
	
	

}
