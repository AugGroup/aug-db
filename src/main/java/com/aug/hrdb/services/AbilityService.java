/**
 *
 * @author Pranrajit
 * @date 27 เม.ย. 2558
 */
package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.dto.AbilityDto;
import com.aug.hrdb.entities.Ability;




public interface AbilityService {

	public void create(Ability ability);
	public void update(Ability Ability);
	public void delete(Ability Ability);
	public Ability find(Integer Id);
	public List<Ability> findAll();
	public List<Ability> findByCriteria(Ability ability);
	public void deleteById(Integer id);
	public AbilityDto findAbility(Integer Id);
	public List<AbilityDto> findAbilityList(Integer Id);
	public AbilityDto findBySpecialty(Integer id);

	//public List<Employee> findByCriteria(Employee employee);
	
	
}
