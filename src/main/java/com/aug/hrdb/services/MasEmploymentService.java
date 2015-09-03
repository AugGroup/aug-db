/**
 *
 * @author natechanok
 * @date Apr 29, 2015
 */

package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.entities.MasEmployment;


public interface MasEmploymentService {
	
	public void create(MasEmployment masEmployment );
	public void update(MasEmployment masEmployment);
	public void delete(MasEmployment masEmployment);
	public MasEmployment findById(Integer Id);
	public List<MasEmployment> findAll();
	public List<MasEmployment> findByCriteria(MasEmployment masEmployment);
	public MasEmployment deleteById(Integer id);

}
