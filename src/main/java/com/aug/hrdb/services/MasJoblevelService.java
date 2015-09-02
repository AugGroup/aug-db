package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.entities.MasJoblevel;

public interface MasJoblevelService {
	
	public void create(MasJoblevel masJoblevel);
	public void update(MasJoblevel masJoblevel);
	public void delete(MasJoblevel masJoblevel);
	public MasJoblevel find(Integer id);
	public List<MasJoblevel> findAll();
	public List<MasJoblevel> findByCriteria(MasJoblevel masJoblevel);
	public MasJoblevel deleteById(Integer id);

}
