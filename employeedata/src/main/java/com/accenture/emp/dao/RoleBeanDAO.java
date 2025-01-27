package com.accenture.emp.dao;

import java.util.List;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.emp.entity.RoleEntity;

@RepositoryDefinition(idClass = Integer.class, domainClass = RoleEntity.class)
@Transactional(value="txManager")
public interface RoleBeanDAO {
	
	List<RoleEntity> findAll();
}
