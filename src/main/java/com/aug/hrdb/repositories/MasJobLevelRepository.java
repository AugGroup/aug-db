package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.entities.MasJobLevel;

public interface MasJobLevelRepository extends GenericRepository<MasJobLevel,Integer> {

	public List<MasJobLevel> findByCriteria(MasJobLevel masJoblevel);

}