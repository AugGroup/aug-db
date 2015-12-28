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

import com.aug.hrdb.dto.AbilityDto;
import com.aug.hrdb.entities.Ability;
import com.aug.hrdb.repositories.AbilityRepository;
import com.aug.hrdb.services.AbilityService;

@Service(value = "abilityService")
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

	@Override
	public void deleteById(Integer id) {
		 abilityRepository.deleteById(id);
	}

	@Override
	public AbilityDto findByAbilityId(Integer id) {
		AbilityDto ability = abilityRepository.findByAbilityId(id);
		return ability;
	}

	@Override
	public List<AbilityDto> searchAbility(Integer id) {
		List<AbilityDto> abilities = abilityRepository.searchAbility(id);
		return abilities;
	}

	@Override
	public Boolean checkSpecialty(Integer id,Integer sp_id) {
		Boolean checking = abilityRepository.checkSpecialty(id,sp_id);
		return checking;
	}

}
