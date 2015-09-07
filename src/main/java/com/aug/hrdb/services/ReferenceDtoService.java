package com.aug.hrdb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.ReferenceDto;
import com.aug.hrdb.repositories.ReferenceRepository;

@Service("referenceDtoService")
@Transactional
public class ReferenceDtoService {
	
	@Autowired private ReferenceRepository referenceRepository;
	
	public List<ReferenceDto> searchReference(Integer id){
		return referenceRepository.searchReference(id);
	}
}
