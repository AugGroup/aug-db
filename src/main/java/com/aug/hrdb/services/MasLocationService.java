/**
 *
 * @author Pranrajit
 * @date 13 พ.ค. 2558
 */
package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.entities.MasLocation;


public interface MasLocationService {

	public void create(MasLocation masLocation);
	public void update(MasLocation masLocation);
	public void delete(MasLocation masLocation);
	public MasLocation find(Integer id);
	public List<MasLocation> findAll();
	public List<MasLocation> findByCriteria(MasLocation masLocation);
	public void deleteById(Integer id);
	//public MasLocation findByLocationCode(String locationCode);
}
