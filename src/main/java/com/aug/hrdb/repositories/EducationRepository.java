package com.aug.hrdb.repositories;

import java.io.Serializable;
import java.util.List;

import com.aug.hrdb.dto.EducationDto;
import com.aug.hrdb.entities.Education;

public interface EducationRepository extends GenericRepository<Education, Serializable> {
	
	List<EducationDto> findEducationById(Integer id);
	EducationDto findByEducationId(Integer id);
	List<EducationDto> searchEducation(Integer id);

}

