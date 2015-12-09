/**
 *
 * @author Pranrajit
 * @date 29 เม.ย. 2558
 */
package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.entities.MasProvince;

public interface MasProvinceService {
	
	public void create(MasProvince masProvince);
	public void update(MasProvince masProvince);
	public void delete(MasProvince masProvince);
	public MasProvince findById(Integer Id);
	public List<MasProvince> findAll();
	public void deleteById(Integer id);

}