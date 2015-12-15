/**
 *
 * @author Preeyaporn
 * @date 3 มิ.ย. 2558
 */
package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.dto.AllowanceDto;
import com.aug.hrdb.entities.Allowance;

public interface AllowanceRepository extends GenericRepository<Allowance, Integer>{

	public List<AllowanceDto> searchAllowances(Integer id);

}
