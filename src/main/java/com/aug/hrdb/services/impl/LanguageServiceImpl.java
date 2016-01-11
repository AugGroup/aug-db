package com.aug.hrdb.services.impl;

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

@Transactional
@Service(value = "languageService")
public class LanguageServiceImpl implements LanguageService {

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
    return languageRepository.findAll();
  }

  @Override
  public void deleteById(Integer id) {
    languageRepository.deleteById(id);
  }

  @Override
  public List<LanguageDto> findLanguagesById(Integer id) {
    return languageRepository.findLanguagesById(id);
  }

  @Override
  public Boolean checkLanguageName(Integer id, String languageName) {
    return languageRepository.checkLanguageName(id, languageName);
  }

  @Override
  public LanguageDto findByLanguagesId(Integer id) {
    return languageRepository.findByLanguagesId(id);
  }

  @Override
  public List<LanguageDto> listLanguageByEmployee(Integer id) {
    return languageRepository.listLanguageByEmployee(id);
  }

  @Override
  public Language findIdJoinEmployee(Integer id) {
    return languageRepository.findIdJoinEmployee(id);
  }

  @Override
  public void saveByFindEmployee(Integer employeeId, LanguageDto languageDto) {
    try {
      Applicant applicant = applicantService.findById(languageDto.getApplicantId());
      Language language = new Language();
      language.setNameLanguage(languageDto.getNameLanguage());
      language.setReading(languageDto.getReading());
      language.setWriting(languageDto.getWriting());
      language.setUnderstanding(languageDto.getUnderstanding());
      language.setSpeaking(languageDto.getSpeaking());
      language.setApplicant(applicant);
      language.setCreatedBy(employeeId);

      languageRepository.create(language);

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  @Override
  public LanguageDto findLanguageEmployeeById(Integer id) {
    Language language = this.findIdJoinEmployee(id);
    Hibernate.initialize(language.getApplicant());

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
    Language languageUpdate = languageRepository.find(languageDto.getId());
    languageUpdate.setNameLanguage(languageDto.getNameLanguage());
    languageUpdate.setReading(languageDto.getReading());
    languageUpdate.setSpeaking(languageDto.getSpeaking());
    languageUpdate.setUnderstanding(languageDto.getUnderstanding());
    languageUpdate.setWriting(languageDto.getWriting());

    languageRepository.update(languageUpdate);

  }

}