package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.dto.LanguageDto;
import com.aug.hrdb.entities.Language;

public interface LanguageService {

  void create(Language language);

  void update(Language language);

  void delete(Language language);

  Language find(Integer Id);

  List<Language> findAll();

  void deleteById(Integer id);

  List<LanguageDto> findLanguagesById(Integer id);

  LanguageDto findByLanguagesId(Integer id);

  List<LanguageDto> listLanguageByEmployee(Integer id);

  Language findIdJoinEmployee(Integer id);

  Boolean checkLanguageName(Integer id, String languageName);

  void saveByFindEmployee(Integer employeeId, LanguageDto languageDto);

  LanguageDto findLanguageEmployeeById(Integer id);

  void updateSetLanguage(LanguageDto languageDto);

}