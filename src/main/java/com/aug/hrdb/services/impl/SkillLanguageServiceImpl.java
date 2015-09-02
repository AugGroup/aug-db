package com.aug.hrdb.services.impl;

import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hr.dao.SkillLanguageDao;
import com.aug.hr.entity.Employee;
import com.aug.hr.entity.MasSkillLanguage;
import com.aug.hr.entity.SkillLanguage;
import com.aug.hr.entity.dto.SkillLanguageDto;
import com.aug.hr.services.EmployeeService;
import com.aug.hr.services.MasSkillLanguageService;
import com.aug.hr.services.SkillLanguageService;


@Service
@Transactional
public class SkillLanguageServiceImpl implements SkillLanguageService{

	@Autowired
	private SkillLanguageDao skillLanguageDao;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private MasSkillLanguageService masSkillLanguageService;
	private final static Logger logger = Logger
			.getLogger(SkillLanguage.class);
	
	
	@Override
	public void create(SkillLanguage skillLanguage) {
		// TODO Auto-generated method stub
		skillLanguageDao.create(skillLanguage);
	}

	@Override
	public void update(SkillLanguage skillLanguage) {
		// TODO Auto-generated method stub
		skillLanguageDao.update(skillLanguage);
	}

	@Override
	public void delete(SkillLanguage skillLanguage) {
		// TODO Auto-generated method stub
		skillLanguageDao.delete(skillLanguage);
	}

	@Override
	public SkillLanguage find(Integer Id) {
		// TODO Auto-generated method stub
		SkillLanguage skillLanguage = skillLanguageDao.find(Id);
		return skillLanguage;
	}

	@Override
	public List<SkillLanguage> findAll() {
		// TODO Auto-generated method stub
		List<SkillLanguage> skillLanguageList = skillLanguageDao.findAll();
		return skillLanguageList;
	}

	@Override
	public List<SkillLanguage> findAllByEmployee(Integer IdEmployee) {
		// TODO Auto-generated method stub
		List<SkillLanguage> skillLanguageList = skillLanguageDao.findAllByEmployee(IdEmployee);
		return skillLanguageList;
	}

	@Override
	@Transactional
	public void saveByFindEmployee(Integer employeeId,
			SkillLanguageDto skillLanguage) {
		// TODO Auto-generated method stub
		try{
			
			Employee employee = employeeService.findById(employeeId);
    		MasSkillLanguage masSkillLanguage = masSkillLanguageService.find(skillLanguage.getMasSkillLanguageId());
    		//Hibernate.initialize(skillLanguage.getMasSkillLanguage());
    		//Hibernate.initialize(skillLanguage.getEmployee());
    		//Hibernate.initialize(employee.getTechnology());
			logger.info("employeeservice: "+employee.getId());
     		logger.info("masSkillLanguageservice: "+masSkillLanguage.getId());
     		SkillLanguage skillLanguageObj = new SkillLanguage(); 
     		skillLanguageObj.setAbilityReading(skillLanguage.getAbilityReading());
     		skillLanguageObj.setAbilityWriting(skillLanguage.getAbilityWriting());
     		skillLanguageObj.setAbilityUnderstanding(skillLanguage.getAbilityUnderstanding());
     		skillLanguageObj.setAbilitySpeaking(skillLanguage.getAbilitySpeaking());
     		skillLanguageObj.setMasSkillLanguage(masSkillLanguage);
     		skillLanguageObj.setEmployee(employee);
     		skillLanguageObj.setCreatedBy(employee.getId());
			Calendar cal = Calendar.getInstance();
			skillLanguageObj.setCreatedTimeStamp(cal.getTime());
			skillLanguageObj.setAuditFlag("C");
			logger.info(skillLanguage.toString());
			skillLanguageDao.create(skillLanguageObj);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	@Transactional
	public SkillLanguageDto findSkillLanguageById(Integer id) {
		// TODO Auto-generated method stub
		SkillLanguage skilllanguage = skillLanguageDao.findIdJoinEmployee(id);
		Hibernate.initialize(skilllanguage.getMasSkillLanguage());
		logger.info("emp: "+skilllanguage.getEmployee().toString());
		logger.info("masskilllanguage: "+skilllanguage.getMasSkillLanguage().toString());
		//logger.info("skilllanguage list: "+skilllanguage.getMasSkillLanguage().getSkillLanguage());
		SkillLanguageDto skillLanguageDto = new SkillLanguageDto();
		skillLanguageDto.setAbilityReading(skilllanguage.getAbilityReading());
		skillLanguageDto.setAbilityWriting(skilllanguage.getAbilityWriting());
		skillLanguageDto.setAbilityUnderstanding(skilllanguage.getAbilityUnderstanding());
		skillLanguageDto.setAbilitySpeaking(skilllanguage.getAbilitySpeaking());
		skillLanguageDto.setEmployeeId(skilllanguage.getEmployee().getId());
		skillLanguageDto.setEmployeeCode(skilllanguage.getEmployee().getEmployeeCode());
		skillLanguageDto.setMasSkillLanguageId(skilllanguage.getMasSkillLanguage().getId());
		skillLanguageDto.setMasSkillLanguageName(skilllanguage.getMasSkillLanguage().getName());
		return skillLanguageDto;
	}

	@Override
	public void updateSetSkillLanguage(SkillLanguageDto skillLanguage) {
		// TODO Auto-generated method stub
		SkillLanguage skillLanguageUpdate = skillLanguageDao.find(skillLanguage.getId());
		MasSkillLanguage masSkillLanguage = masSkillLanguageService.find(skillLanguage.getMasSkillLanguageId());
		skillLanguageUpdate.setMasSkillLanguage(masSkillLanguage);
		skillLanguageUpdate.setAuditFlag("U");
		skillLanguageUpdate.setUpdatedTimeStamp(Calendar.getInstance().getTime());
		skillLanguageUpdate.setUpdatedBy(skillLanguageUpdate.getEmployee().getId());
		skillLanguageUpdate.setAbilityReading(skillLanguage.getAbilityReading());
		skillLanguageUpdate.setAbilitySpeaking(skillLanguage.getAbilitySpeaking());
		skillLanguageUpdate.setAbilityUnderstanding(skillLanguage.getAbilityUnderstanding());
		skillLanguageUpdate.setAbilityWriting(skillLanguage.getAbilityWriting());
		skillLanguageDao.update(skillLanguageUpdate);
	}

	@Override
    public SkillLanguage findJoinMasSkillLanguage(Integer id) {
		// TODO Auto-generated method stub		
		return skillLanguageDao.findJoinMasSkillLanguage(id);
	}
 

	
}
