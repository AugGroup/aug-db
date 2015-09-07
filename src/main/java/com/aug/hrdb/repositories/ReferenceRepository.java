package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.dto.ReferenceDto;
import com.aug.hrdb.entities.Reference;

public interface ReferenceRepository extends GenericRepository<Reference, Integer>{

	public List<Reference> findByCriteria(Reference reference);
	public List<ReferenceDto> searchReference(Integer id);
}
