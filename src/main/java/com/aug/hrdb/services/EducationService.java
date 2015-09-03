package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.dto.EducationDto;
import com.aug.hrdb.entities.Education;

public interface EducationService {

	public void create(Education education);

	public Education findById(Integer id);

	public void update(Education education);

	public void delete(Education education);
	
	public void deleteByApplicantId(Integer id);

	public List<Education> findAll();
	
	public List<EducationDto> findEducationById(Integer id);

	public EducationDto findEducation(Integer id);

}
