package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.entities.MasJoblevel;

public interface MasJoblevelRepositories extends GenericDao<MasJoblevel,Integer> {

	public List<MasJoblevel> findByCriteria(MasJoblevel masJoblevel);

	public MasJoblevel deleteById(Integer id);

}
