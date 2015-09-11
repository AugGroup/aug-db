package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.EducationDto;
import com.aug.hrdb.entities.Education;
import com.aug.hrdb.repositories.EducationRepository;
import com.aug.hrdb.services.EducationService;

@Service(value = "educationService")
@Transactional
public class EducationServiceImpl implements EducationService{
	
	@Autowired
	private EducationRepository educationRepository;
	
	@Override
	public Education findById(Integer id) {
		return educationRepository.find(id);
	}

	@Override
	public void create(Education education) {
		educationRepository.create(education);
		
	}

	@Override
	public void update(Education education) {
		educationRepository.update(education);
		
	}

	public void delete(Education education) {
		educationRepository.delete(education);
		
	}
	
	@Override
	public void deleteById(Integer id) {
		educationRepository.deleteById(id);
		
	}

	@Override
	public List<Education> findAll() {
		List<Education> educationList = educationRepository.findAll();
		return educationList;
	}

	@Override
	public List<EducationDto> findEducationById(Integer id) {
		List<EducationDto> educations = educationRepository.findEducationById(id);
		return educations;
	}
	
	@Override
	public EducationDto findEducation(Integer id){
		EducationDto education = educationRepository.findByEducationId(id);
		return education;
	}
}