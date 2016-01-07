package com.aug.hrdb.services.impl;

import java.util.Calendar;
import java.util.List;

import com.aug.hrdb.services.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.FamilyDto;
import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Family;
import com.aug.hrdb.entities.MasRelationType;
import com.aug.hrdb.repositories.FamilyRepository;
import com.aug.hrdb.services.FamilyService;
import com.aug.hrdb.services.MasRelationTypeService;

@Transactional
@Service(value = "familyService")
public class FamilyServiceImpl implements FamilyService {

  @Autowired
  private FamilyRepository familyRepository;

  @Autowired
  private ApplicantService applicantService;

  @Autowired
  private MasRelationTypeService masRelationTypeService;

  @Override
  public void create(Family family) {
    familyRepository.create(family);
  }

  @Override
  public void update(Family family) {
    familyRepository.update(family);
  }

  @Override
  public void delete(Family family) {
    familyRepository.delete(family);
  }

  @Override
  public Family find(Integer id) {
    return familyRepository.find(id);
  }

  @Override
  public List<Family> findAll() {
    return familyRepository.findAll();
  }

  @Override
  public Family findLastFamily(Integer id) {
    return familyRepository.findLastFamily(id);
  }

  @Override
  public void deleteById(Integer id) {
    familyRepository.deleteById(id);
  }

  @Override
  public List<FamilyDto> findFamilyById(Integer id) {
    return familyRepository.findFamilyById(id);
  }

  @Override
  public FamilyDto findFamily(Integer id) {
    return familyRepository.findFamily(id);
  }

  @Override
  public List<Family> findFamilyByApplicantId(Integer id) {
    return familyRepository.findFamilyByApplicantId(id);
  }

  @Override
  public List<FamilyDto> findFamilyList(Integer id) {
    return familyRepository.findFamilyList(id);
  }

  @Override
  public void createFindMasRelationAndEmployee(FamilyDto familyDto) {
    Family family = new Family();

    if (familyDto.getMasRelationTypeId() != null) {
      MasRelationType masRelationType = masRelationTypeService.findById(familyDto.getMasRelationTypeId());
      family.setMasRelationType(masRelationType);
    }

    Applicant applicant = applicantService.findById(familyDto.getAppId());
    if (applicant != null) {
      family.setApplicant(applicant);
    }

    family.setId(familyDto.getId());
    family.setFamilyName(familyDto.getFamilyName());
    family.setAge(familyDto.getAge());
    family.setAddress(familyDto.getAddress());
    family.setOccupation(familyDto.getOccupation());
    family.setGender(familyDto.getGender());
    family.setMobile(familyDto.getMobile());
    family.setPosition(familyDto.getPosition());
    family.setGender(familyDto.getGender());
    family.setAuditFlag("C");
    family.setCreatedBy(1);
    family.setCreatedTimeStamp(Calendar.getInstance().getTime());

    this.create(family);

  }

  @Override
  public void updateFindMasRelationAndEmployee(FamilyDto familyDto) {
    MasRelationType masRelationType = masRelationTypeService.findById(familyDto.getMasRelationTypeId());

    Family family = this.findLastFamily(familyDto.getId());
    family.setFamilyName(familyDto.getFamilyName());
    family.setGender(familyDto.getGender());
    family.setAge(familyDto.getAge());
    family.setAddress(familyDto.getAddress());
    family.setMobile(familyDto.getMobile());
    family.setOccupation(familyDto.getOccupation());
    family.setPosition(familyDto.getPosition());
    family.setMasRelationType(masRelationType);
    family.setUpdatedTimeStamp(Calendar.getInstance().getTime());
    family.setAuditFlag("U");
    family.setUpdatedBy(familyDto.getAppId());

    this.update(family);

  }

}