package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.entities.MasCoreSkill;

public interface MasCoreSkillRepository extends GenericRepository<MasCoreSkill, Integer> {

	public List<MasCoreSkill> findByCriteria(MasCoreSkill masCoreSkill);
	public void deleteById(Integer id);
	
}
