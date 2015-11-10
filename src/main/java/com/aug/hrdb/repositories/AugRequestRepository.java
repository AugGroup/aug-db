package com.aug.hrdb.repositories;

import java.io.Serializable;
import java.util.List;

import com.aug.hrdb.dto.AugRequestDto;
import com.aug.hrdb.entities.AugRequest;
import com.aug.hrdb.repositories.GenericRepository;

/**
*
* @author Supannika Pattanodom
*/
public interface AugRequestRepository extends GenericRepository<AugRequest, Serializable> {

	public List<AugRequestDto> findAllAugRequest();
	
	public AugRequestDto findAugRequestById(Integer id);

	/*--------------------For test SQLGrammaEception----------------------*/
	public AugRequestDto findAugRequestByIdTest(Integer id);
	
	public List<AugRequestDto> getJobcaseCode();

}
