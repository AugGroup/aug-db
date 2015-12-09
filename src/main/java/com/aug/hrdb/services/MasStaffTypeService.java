package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.entities.MasStaffType;

public interface MasStaffTypeService {
	
	public void create(MasStaffType masStaffType);
	public void update(MasStaffType masStaffType);
	public void delete(MasStaffType masStaffType);
	public MasStaffType findById(Integer id);
	public void deleteById(Integer id);
	public List<MasStaffType> findAll();

}