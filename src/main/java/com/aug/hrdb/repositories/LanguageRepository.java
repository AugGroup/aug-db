package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.dto.LanguageDto;
import com.aug.hrdb.entities.Language;

public interface LanguageRepository extends GenericRepository<Language, Integer> {

  List<LanguageDto> findLanguagesById(Integer id);

  LanguageDto findByLanguagesId(Integer id);

  List<LanguageDto> listLanguageByEmployee(Integer id);

  Language findIdJoinEmployee(Integer id);

  Boolean checkLanguageName(Integer id, String languageName);

}