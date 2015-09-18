package com.aug.hrdb.services.impl;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.FamilyDto;
import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Family;
import com.aug.hrdb.entities.MasRelationType;
import com.aug.hrdb.repositories.ApplicantRepository;
import com.aug.hrdb.repositories.FamilyRepository;
import com.aug.hrdb.services.FamilyService;
import com.aug.hrdb.services.MasRelationTypeService;



@Service
@Transactional
public class FamilyServiceImpl implements FamilyService{
	
	@Autowired
	private FamilyRepository familyRepository;
	@Autowired
	private ApplicantRepository applicantRepo;
	@Autowired
	private MasRelationTypeService masRelationService;

	@Override
	public void create(Family empFamily) {
		// TODO Auto-generated method stub
		familyRepository.create(empFamily);
	}

	@Override
	public void update(Family empFamily) {
		// TODO Auto-generated method stub
		familyRepository.update(empFamily);
	}

	@Override
	public void delete(Family empFamily) {
		// TODO Auto-generated method stub
		familyRepository.delete(empFamily);
	}

	@Override
	public Family find(Integer Id) {
		// TODO Auto-generated method stub
		Family empFamily = familyRepository.find(Id);
		return empFamily;
	}

	@Override
	public List<Family> findAll() {
		// TODO Auto-generated method stub
		List<Family> empFamilyList = familyRepository.findAll();
		return empFamilyList;
	}


	@Override
	public List<Family> findFamilyByEmployeeId(Integer Id) {
		// TODO Auto-generated method stub
		List<Family> empFamilyList = familyRepository.findFamilyByApplicantId(Id);
		return empFamilyList;
	}

	

	@Override
	public Family findLastFamily(Integer Id) {
		// TODO Auto-generated method stub
		Family empfamily = familyRepository.findLastFamily(Id);
		return empfamily;
	}


	@Override
	public void deleteByNameQuery(FamilyDto family) {
		// TODO Auto-generated method stub
		familyRepository.deleteByNameQuery(family);
	}

	@Override
	public void createFindMasRelationAndEmployee(FamilyDto familyDto){
		// TODO Auto-generated method stub

		Family family = new Family();

		MasRelationType masRelationType = new MasRelationType();
				
		if(familyDto.getMasRelationTypeId()!=null){
			masRelationType = masRelationService.find(familyDto.getMasRelationTypeId());
			family.setMasRelationType(masRelationType);		
		}
		
		family.setAuditFlag("C");
		family.setCreatedBy(0);
		Calendar cal = Calendar.getInstance();
		family.setCreatedTimeStamp(cal.getTime());
		
		
		Applicant applicant = new Applicant();
		if(familyDto.getAppId()!=null){
			applicant = applicantRepo.find(familyDto.getAppId());
		}
		family.setApplicant(applicant);
		family.setFamilyName(familyDto.getFamilyName());
		family.setAge(familyDto.getAge());
		family.setAddress(familyDto.getAddress());
		family.setOccupation(familyDto.getOccupation());
		family.setGender(familyDto.getGender());
		family.setMobile(familyDto.getMobile());
		family.setPosition(familyDto.getPosition());
		family.setGender(familyDto.getGender());
		
	    familyRepository.create(family);
	    
	}

	@Override
	public FamilyDto findForInitEdit(FamilyDto family) {
		// TODO Auto-generated method stub

        Family familyEdit = familyRepository.findLastFamily(new Integer(family.getId()));
        Hibernate.initialize(familyEdit);
       
        FamilyDto familyDto = new FamilyDto();
        familyDto.setId(familyEdit.getId());
        familyDto.setFamilyName(familyEdit.getFamilyName());
        familyDto.setAge(familyEdit.getAge());
        familyDto.setAddress(familyEdit.getAddress());
        familyDto.setGender(familyEdit.getGender());
        familyDto.setMobile(familyEdit.getMobile());
        familyDto.setOccupation(familyEdit.getOccupation());
        familyDto.setPosition(familyEdit.getPosition());
        familyDto.setMasRelationTypeId(familyEdit.getMasRelationType().getId());
        familyDto.setMasRelationTypeName(familyEdit.getMasRelationType().getRelationType());
		return familyDto;
	}

	@Override
	public void updateFindMasRelationAndEmployee(FamilyDto familyDto) {
		// TODO Auto-generated method stub
		
		MasRelationType masRelationType = new MasRelationType();
		masRelationType = masRelationService.find(familyDto.getMasRelationTypeId());
		
		
		Family familyObj = new Family();
		familyObj = familyRepository.findLastFamily(familyDto.getId());	
		familyObj.setFamilyName(familyDto.getFamilyName());
		familyObj.setGender(familyDto.getGender());
		familyObj.setAge(familyDto.getAge());
		familyObj.setAddress(familyDto.getAddress());
		familyObj.setMobile(familyDto.getMobile());
		familyObj.setOccupation(familyDto.getOccupation());
		familyObj.setPosition(familyDto.getPosition());
		familyObj.setMasRelationType(masRelationType);
		Calendar cal = Calendar.getInstance();
		familyObj.setUpdatedTimeStamp(cal.getTime());
		familyObj.setAuditFlag("U");
		familyObj.setUpdatedBy(familyDto.getAppId());	
		familyRepository.update(familyObj);
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		familyRepository.deleteById(id);
		
	}

	@Override
	public List<FamilyDto> findFamilyById(Integer id) {
		List<FamilyDto> families = familyRepository.findFamilyById(id);
		return families;
	}

	@Override
	public FamilyDto findFamily(Integer id) {
		FamilyDto family = familyRepository.findFamily(id);
		return family;
	}


	
	
}
