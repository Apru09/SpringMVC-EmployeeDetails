package com.accenture.emp.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.emp.entity.EmpEntity;


@RepositoryDefinition(idClass = Integer.class, domainClass = EmpEntity.class)
@Transactional(value="txManager")
public interface EmpDAO2 {
	
	
	@Query(name="getEmpByEmpNameAndEmpId")
	EmpEntity getEmployeeByRole(String eName, int rId);

}
