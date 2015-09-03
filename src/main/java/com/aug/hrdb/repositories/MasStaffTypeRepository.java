package com.aug.hrdb.repositories;

import com.aug.hrdb.entities.MasStaffType;

public interface MasStaffTypeRepository extends GenericRepository<MasStaffType, Integer>{
	
	public void create(MasStaffType masStaffType);
	public void update(MasStaffType masStaffType);
	public void delete(MasStaffType masStaffType);
	public MasStaffType find(Integer Id);


}
