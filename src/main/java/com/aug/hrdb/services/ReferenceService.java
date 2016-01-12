package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.dto.ReferenceDto;
import com.aug.hrdb.entities.Reference;

public interface ReferenceService {

  void create(Reference reference);

  void update(Reference reference);

  void delete(Reference reference);

  Reference findById(Integer id);

  void deleteById(Integer id);

  List<Reference> findAll();

  List<Reference> findByCriteria(Reference reference);

  List<ReferenceDto> findReferenceById(Integer id);

  ReferenceDto findReference(Integer id);

  List<ReferenceDto> searchReference(Integer id);

}