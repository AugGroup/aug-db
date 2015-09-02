package com.aug.hrdb.repositories;

import com.aug.hrdb.entities.MasRelationType;

public interface MasRelationTypeRepository extends GenericRepository<MasRelationType, Integer>{
	
	public MasRelationType findByName(String name);

}
