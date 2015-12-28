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
	public void deleteById(Integer id);
	public Ability find(Integer Id);
	public List<Ability> findAll();
	public AbilityDto findByAbilityId(Integer Id);
	public List<AbilityDto> searchAbility(Integer Id);
	public Boolean checkSpecialty(Integer id,Integer sp_id);

}
