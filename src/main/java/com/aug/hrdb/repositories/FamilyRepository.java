package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.dto.FamilyDto;
import com.aug.hrdb.entities.Family;

public interface FamilyRepository extends GenericRepository<Family, Integer> {

  List<Family> findFamilyByApplicantId(Integer Id);

  Family findLastFamily(Integer Id);

  List<FamilyDto> findFamilyList(Integer id);

  List<FamilyDto> findFamilyById(Integer id);

  FamilyDto findFamily(Integer id);

}