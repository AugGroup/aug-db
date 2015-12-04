package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.entities.MasJobLevel;

public interface MasJoblevelService {
	
	public void create(MasJobLevel masJoblevel);
	public void update(MasJobLevel masJoblevel);
	public void delete(MasJobLevel masJoblevel);
	public MasJobLevel find(Integer id);
	public List<MasJobLevel> findAll();
	public List<MasJobLevel> findByCriteria(MasJobLevel masJoblevel);

}
