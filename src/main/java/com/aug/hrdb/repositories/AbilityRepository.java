/**
 *
 * @author Pranrajit
 * @date 27 เม.ย. 2558
 */
package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.dto.AbilityDto;
import com.aug.hrdb.entities.Ability;

public interface AbilityRepository extends GenericRepository<Ability, Integer> {

//	public List<Employee> findByCriteria(Employee employee);
	
	public Ability deleteById(Integer id);

	public List<AbilityDto> searchAbility(Integer id);

	
}
