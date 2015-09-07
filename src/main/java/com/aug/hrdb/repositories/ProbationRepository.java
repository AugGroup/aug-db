package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.dto.ProbationDto;
import com.aug.hrdb.entities.Probation;

public interface ProbationRepository extends GenericRepository<Probation, Integer>{


	public List<Probation> findByCriteria(Probation probation);
	
	public List<ProbationDto> searchProbation(Integer id);

	public void createProbation(ProbationDto probationDto);
}
