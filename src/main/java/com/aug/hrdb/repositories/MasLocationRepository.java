/**
 *
 * @author Pranrajit
 * @date 13 พ.ค. 2558
 */
package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.entities.MasLocation;


public interface MasLocationRepository extends GenericRepository<MasLocation,Integer>{

	public List<MasLocation> findByCriteria(MasLocation masLocation);
	public MasLocation findByLocationCode(String locationCode);
	
}