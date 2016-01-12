package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.dto.ReferenceDto;
import com.aug.hrdb.entities.Reference;

public interface ReferenceRepository extends GenericRepository<Reference, Integer> {

  List<Reference> findByCriteria(Reference reference);

  List<ReferenceDto> searchReference(Integer id);

  List<ReferenceDto> findReferenceById(Integer id);

  ReferenceDto findReference(Integer id);

}
