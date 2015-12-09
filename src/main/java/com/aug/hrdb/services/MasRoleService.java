package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.entities.MasRole;

public interface MasRoleService {

	public void create(MasRole masRole);
	public void update(MasRole masRole);
	public void delete(MasRole masRole);
	public MasRole findById(Integer id);
	public List<MasRole> findAll();
	public void deleteById(Integer id);
	
}