/**
 *
 * @author Preeyaporn
 * @date 5 มิ.ย. 2558
 */
package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.entities.MasAllowance;

public interface MasAllowanceRepository extends GenericRepository<MasAllowance, Integer>{

	public List<MasAllowance> findByCriteria(MasAllowance masAllowances);

}
