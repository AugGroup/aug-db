package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.dto.FamilyDto;
import com.aug.hrdb.entities.Family;

public interface FamilyService {

  void create(Family family);

  void update(Family family);

  void delete(Family family);

  Family find(Integer id);

  List<Family> findAll();

  void deleteById(Integer id);

  List<Family> findFamilyByApplicantId(Integer id);

  List<FamilyDto> findFamilyList(Integer id);

  List<FamilyDto> findFamilyById(Integer id);

  FamilyDto findFamily(Integer id);

  Family findLastFamily(Integer id);

  void createFindMasRelationAndEmployee(FamilyDto familyDto);

  void updateFindMasRelationAndEmployee(FamilyDto familyDto);

}