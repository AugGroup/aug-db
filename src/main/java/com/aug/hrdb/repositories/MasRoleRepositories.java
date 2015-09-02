package com.aug.hrdb.repositories;

import com.aug.hrdb.entities.MasRole;

public interface MasRoleRepositories extends GenericDao<MasRole, Integer>{
	
	public MasRole deleteById(Integer id);
}
