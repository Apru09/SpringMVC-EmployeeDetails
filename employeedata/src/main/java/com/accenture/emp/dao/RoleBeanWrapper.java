package com.accenture.emp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.emp.beans.RoleBean;
import com.accenture.emp.entity.RoleEntity;

@Repository
@Transactional(value="txManager")
public class RoleBeanWrapper {
	
	
	@Autowired
	RoleBeanDAO roleBeanDAO;
	
	public List<RoleBean> getAllEmps(){
		
		List<RoleEntity> roleEntList = roleBeanDAO.findAll();
	
		List<RoleBean> roleList = new ArrayList<>();
	
		for(RoleEntity item : roleEntList) {
		
			RoleBean bean = new RoleBean();
			BeanUtils.copyProperties(item, bean);
			roleList.add(bean);
		}
	
		return roleList;
	
	}
}
