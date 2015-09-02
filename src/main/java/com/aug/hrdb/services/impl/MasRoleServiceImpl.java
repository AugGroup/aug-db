package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasRole;
import com.aug.hrdb.repositories.MasRoleRepository;
import com.aug.hrdb.services.MasRoleService;

@Service("masRoleService")
@Transactional
public class MasRoleServiceImpl implements MasRoleService{

	@Autowired
	private MasRoleRepository masRoleRepository;

	@Override
	public void create(MasRole masRole) {
		masRoleRepository.create(masRole);
		
	}

	@Override
	public void update(MasRole masRole) {
		masRoleRepository.update(masRole);
		
	}

	@Override
	public void delete(MasRole masRole) {
		masRoleRepository.delete(masRole);
		
	}

	@Override
	public MasRole find(Integer id) {
		return masRoleRepository.find(id);
	}

	@Override
	public List<MasRole> findAll() {
		return masRoleRepository.findAll();
	}

	@Override
	public MasRole deleteById(Integer id) {
		return masRoleRepository.deleteById(id);
	}
	
}
