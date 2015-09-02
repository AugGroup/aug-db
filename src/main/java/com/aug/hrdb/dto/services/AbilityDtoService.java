/**
 *
 * @author Pranrajit
 * @date 19 พ.ค. 2558
 */
package com.aug.hrdb.dto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import com.aug.hrdb.dto.AbilityDto;
import com.aug.hrdb.repositories.AbilityRepository;

@Service("abilityDtoService")
@Transactional
public class AbilityDtoService {
	@Autowired private AbilityRepository abilityRepository;
	
	public List<AbilityDto> searchAbility(Integer id){
		return abilityRepository.searchAbility(id);
	}

}
