/**
 *
 * @author Pranrajit
 * @date 28 เม.ย. 2558
 */
package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Ability;
import com.aug.hrdb.repositories.AbilityRepository;
import com.aug.hrdb.services.AbilityService;


@Service("abilityService")
@Transactional
public class AbilityServiceImpl implements AbilityService{

	@Autowired
	private AbilityRepository abilityRepository;
	@Override
	public void create(Ability Ability) {
		abilityRepository.create(Ability);
		
	}

	@Override
	public void update(Ability Ability) {
		abilityRepository.update(Ability);
		
	}

	@Override
	public void delete(Ability Ability) {
		abilityRepository.delete(Ability);
		
	}

	@Override
	public Ability find(Integer id) {
		
		return abilityRepository.find(id);
	}

	@Override
	public List<Ability> findAll() {
		
		return abilityRepository.findAll();
	}

	/*@Override
	public List<Employee> findByCriteria(Employee employee) {
		// TODO Auto-generated method stub
		return abilityRepository.findByCriteria(employee);
	}*/

	@Override
	public Ability deleteById(Integer id) {
	return	 abilityRepository.deleteById(id);
		
	}

	@Override
	public List<Ability> findByCriteria(Ability ability) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
