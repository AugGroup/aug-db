/**
 *
 * @author Pranrajit
 * @date 27 เม.ย. 2558
 */
package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.entities.MasDegreetype;



public interface MasDegreetypeRepository extends GenericRepository<MasDegreetype,Integer>{


	
	public List<MasDegreetype> findByCriteria(MasDegreetype masDegreetype);

	public MasDegreetype deleteById(Integer id);

	
}
