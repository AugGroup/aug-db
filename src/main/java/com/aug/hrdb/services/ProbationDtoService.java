package com.aug.hrdb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.ProbationDto;
import com.aug.hrdb.repositories.ProbationRepository;

@Service("probationDtoService")
@Transactional
public class ProbationDtoService {
	
	@Autowired private ProbationRepository probationRepository;

	public List<ProbationDto> searchProbation(Integer id){
		return probationRepository.searchProbation(id);
	}
	
	public void createProbation(ProbationDto probationDto){
		probationRepository.createProbation(probationDto);
	}	
}
