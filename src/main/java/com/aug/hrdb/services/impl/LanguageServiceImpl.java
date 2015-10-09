package com.aug.hrdb.services.impl;


import java.util.Calendar;
import java.util.List;





import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.LanguageDto;
import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Language;
import com.aug.hrdb.repositories.LanguageRepository;
import com.aug.hrdb.services.ApplicantService;
import com.aug.hrdb.services.LanguageService;




@Service
@Transactional
public class LanguageServiceImpl implements LanguageService{

	@Autowired
	private LanguageRepository languageRepository;
	
	@Autowired
	private ApplicantService applicantService;


	@Override
	public void create(Language language) {
		languageRepository.create(language);
		
	}

	@Override
	public void update(Language language) {
		languageRepository.update(language);
		
	}

	@Override
	public void delete(Language language) {
		languageRepository.delete(language);
		
	}

	@Override
	public Language find(Integer Id) {
		
		return languageRepository.find(Id);
	}

	@Override
	public List<Language> findAll() {
		// TODO Auto-generated method stub
		return languageRepository.findAll();
	}

	

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		 languageRepository.deleteById(id);
	}

	@Override
	public List<LanguageDto> findLanguagesById(Integer id) {
		List<LanguageDto> languageses = languageRepository.findLanguagesById(id);
		return languageses;
	}

	@Override
	public LanguageDto findLanguages(Integer id) {
		LanguageDto languages = languageRepository.findByLanguagesId(id);
		return languages;
	}


	
	
	
	
	@Override
	@Transactional
	public void saveByFindEmployee(Integer employeeId,
			LanguageDto languageDto) {
		// TODO Auto-generated method stub
		try{
			
			
    		Applicant applicant = applicantService.findById(languageDto.getApplicantId());
     		Language languageObj = new Language(); 
     		languageObj.setNameLanguage(languageDto.getNameLanguage());
     		languageObj.setReading(languageDto.getReading());
     		languageObj.setWriting(languageDto.getWriting());
     		languageObj.setUnderstanding(languageDto.getUnderstanding());
     		languageObj.setSpeaking(languageDto.getSpeaking());
     		languageObj.setApplicant(applicant);
     		languageObj.setCreatedBy(employeeId);
			/*Calendar cal = Calendar.getInstance();
			languageObj.setCreatedTimeStamp(cal.getTime());
			languageObj.setAuditFlag("C");*/
			languageRepository.create(languageObj);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	@Transactional
	public LanguageDto findLanguageById(Integer id) {
		// TODO Auto-generated method stub
		
		Language language = languageRepository.findIdJoinEmployee(id);
		Hibernate.initialize(language.getApplicant());
		
		Applicant applicant = applicantService.findById(language.getApplicant().getId());
	
		LanguageDto languageDto = new LanguageDto();
		languageDto.setNameLanguage(language.getNameLanguage());
		languageDto.setReading(language.getReading());
		languageDto.setWriting(language.getWriting());
		languageDto.setUnderstanding(language.getUnderstanding());
		languageDto.setSpeaking(language.getSpeaking());
		languageDto.setApplicantId(language.getApplicant().getId());
	
		return languageDto;
	}

	
	
	@Override
	public void updateSetLanguage(LanguageDto languageDto) {
		// TODO Auto-generated method stub
		Language languageUpdate = languageRepository.find(languageDto.getId());
		/*languageUpdate.setAuditFlag("U");
		languageUpdate.setUpdatedTimeStamp(Calendar.getInstance().getTime());
		languageUpdate.setUpdatedBy(languageDto.getEmployeeId());*/
		languageUpdate.setNameLanguage(languageDto.getNameLanguage());
		languageUpdate.setReading(languageDto.getReading());
		languageUpdate.setSpeaking(languageDto.getSpeaking());
		languageUpdate.setUnderstanding(languageDto.getUnderstanding());
		languageUpdate.setWriting(languageDto.getWriting());
		languageRepository.update(languageUpdate);
	}

	@Override
	public Boolean checkLanguageName(Integer id, String languageName) {
		Boolean checking = languageRepository.chkLanguageName(id, languageName);
		return checking;
	}

}
