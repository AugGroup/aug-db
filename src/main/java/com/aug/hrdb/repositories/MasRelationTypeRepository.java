package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.entities.MasRelationType;

public interface MasRelationTypeRepository extends GenericRepository<MasRelationType, Integer> {
	
	public void create(MasRelationType masRelationType);
	public void update(MasRelationType masRelationType);
	public void delete(MasRelationType masRelationType);
	public MasRelationType find(Integer Id);
	public List<MasRelationType> findAll();
	public MasRelationType findByName(String name);
	public void deleteById(Integer id);

}