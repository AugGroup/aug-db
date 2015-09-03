package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.dto.ExperienceDto;
import com.aug.hrdb.entities.Experience;

public interface ExperienceService {
	
	public void create(Experience experience);
	
	public Experience findById(Integer id);
	
	public void update(Experience experience);
	
	public void deleteByApplicantId(Integer id);
	
	public void delete(Experience experience);
	
	public List<Experience> findAll();
	
	public List<ExperienceDto> findExperienceById(Integer id);

	public ExperienceDto findExperience(Integer id);

}