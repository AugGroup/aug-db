package com.aug.hrdb.repositories;

import com.aug.hrdb.entities.MasRole;

public interface MasRoleRepository extends GenericRepository<MasRole, Integer>{
	
	public MasRole deleteById(Integer id);
}
