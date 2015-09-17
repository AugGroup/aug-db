/**
 *
 * @author Pranrajit
 * @date 20 พ.ค. 2558
 */
package com.aug.hrdb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import com.aug.hrdb.dto.EducationDto;
import com.aug.hrdb.entities.Education;
import com.aug.hrdb.repositories.EducationRepository;


@Service("educationDtoService")
@Transactional
public class EducationDtoService {

	@Autowired private EducationRepository educationRepository;
	
	public List<EducationDto> searchEducation(Integer id){
		return educationRepository.searchEducation(id);
	}
	
}
