/**
 *
 * @author Preeyaporn
 * @date 5 มิ.ย. 2558
 */
package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.entities.MasAllowances;

public interface MasAllowancesRepository extends GenericRepository<MasAllowances, Integer>{

	public List<MasAllowances> findByCriteria(MasAllowances masAllowances);

}
