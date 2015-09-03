package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.entities.MasStaffType;


public interface MasStaffTypeService {
	
	public void create(MasStaffType masStaffType);
	public void update(MasStaffType masStaffType);
	public void delete(MasStaffType masStaffType);
	public MasStaffType find(Integer Id);
	public List<MasStaffType> findAll();

}
