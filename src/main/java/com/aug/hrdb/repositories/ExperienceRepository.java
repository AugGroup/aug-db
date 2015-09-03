package com.aug.hrdb.repositories;

import java.io.Serializable;
import java.util.List;

import com.aug.hrdb.dto.ExperienceDto;
import com.aug.hrdb.entities.Experience;

public interface ExperienceRepository extends GenericRepository<Experience, Serializable> {
	
	public List<ExperienceDto> findExperienceById(Integer id);

	public ExperienceDto findExperience(Integer id);

}
