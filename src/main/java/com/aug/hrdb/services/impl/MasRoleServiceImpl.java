package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasRole;
import com.aug.hrdb.services.MasRoleService;

@Service("masRoleService")
@Transactional
public class MasRoleServiceImpl implements MasRoleService{

	@Autowired
	private MasRoleRepositories masRoleRepositories;

	@Override
	public void create(MasRole masRole) {
		masRoleRepositories.create(masRole);
		
	}

	@Override
	public void update(MasRole masRole) {
		masRoleRepositories.update(masRole);
		
	}

	@Override
	public void delete(MasRole masRole) {
		masRoleRepositories.delete(masRole);
		
	}

	@Override
	public MasRole find(Integer id) {
		return masRoleRepositories.find(id);
	}

	@Override
	public List<MasRole> findAll() {
		return masRoleRepositories.findAll();
	}

	@Override
	public MasRole deleteById(Integer id) {
		return masRoleRepositories.deleteById(id);
	}
	
}
