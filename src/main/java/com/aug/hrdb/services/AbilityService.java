/**
 *
 * @author Pranrajit
 * @date 27 เม.ย. 2558
 */
package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.entities.Ability;




public interface AbilityService {

	public void create(Ability ability);
	public void update(Ability Ability);
	public void delete(Ability Ability);
	public Ability find(Integer Id);
	public List<Ability> findAll();
	public List<Ability> findByCriteria(Ability ability);
	public Ability deleteById(Integer id);
	//public List<Employee> findByCriteria(Employee employee);
	
	
}
