package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.entities.MasJoblevel;

public interface MasJoblevelRepository extends GenericRepository<MasJoblevel,Integer> {

	public List<MasJoblevel> findByCriteria(MasJoblevel masJoblevel);

}
