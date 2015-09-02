/**
 *
 * @author Preeyaporn
 * @date 3 มิ.ย. 2558
 */
package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.dto.AllowancesDto;
import com.aug.hrdb.entities.Allowances;

public interface AllowancesRepository extends GenericRepository<Allowances, Integer>{

//	public List<Allowances> findByCriteria(Allowances allowances);

	public Allowances deleteById(Integer id);

	public List<AllowancesDto> searchAllowances(Integer id);

}
