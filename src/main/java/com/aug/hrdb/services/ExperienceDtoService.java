package com.aug.hrdb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.ExperienceDto;
import com.aug.hrdb.repositories.ExperienceRepository;


@Service("experienceDtoService")
@Transactional
public class ExperienceDtoService {

	@Autowired private ExperienceRepository experienceRepository;
	
	public List<ExperienceDto> searchExperience(Integer id){
		return experienceRepository.searchExperience(id);
	}
}
