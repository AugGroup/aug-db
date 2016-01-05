package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.dto.EducationDto;
import com.aug.hrdb.entities.Education;

public interface EducationService {

	void create(Education education);
	Education findById(Integer id);
	void update(Education education);
	void delete(Education education);
	void deleteById(Integer id);
	List<Education> findAll();
	List<EducationDto> findEducationById(Integer id);
	EducationDto findByEducationId(Integer id);
	List<EducationDto> searchEducation(Integer id);

}
