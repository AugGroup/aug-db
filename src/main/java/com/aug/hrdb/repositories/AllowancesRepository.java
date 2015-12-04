/**
 *
 * @author Preeyaporn
 * @date 3 มิ.ย. 2558
 */
package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.dto.AllowancesDto;
import com.aug.hrdb.entities.Allowance;

public interface AllowancesRepository extends GenericRepository<Allowance, Integer>{

	public List<AllowancesDto> searchAllowances(Integer id);

}
