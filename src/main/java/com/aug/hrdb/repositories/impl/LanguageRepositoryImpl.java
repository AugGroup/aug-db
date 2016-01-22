package com.aug.hrdb.repositories.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.dto.LanguageDto;
import com.aug.hrdb.entities.Language;
import com.aug.hrdb.repositories.LanguageRepository;

@SuppressWarnings("unchecked")
@Repository(value = "LanguageRepository")
public class LanguageRepositoryImpl extends GenericRepositoryImpl<Language, Integer> implements LanguageRepository {

  public LanguageRepositoryImpl() {
    super(Language.class);
  }

  @Override
  public List<LanguageDto> listLanguageByEmployee(Integer id) {
    Query nameQuery = getCurrentSession().getNamedQuery("listLanguage").setInteger("appId", id);
    List<LanguageDto> LanguageDtoList = nameQuery.list();

    return LanguageDtoList;

  }

  @Override
  public List<LanguageDto> findLanguagesById(Integer id) {
    Query query = getCurrentSession().getNamedQuery("SEARCH_LANGUAGE");
    query.setParameter("ID", id);
    List<LanguageDto> result = query.list();

    return result;

  }

  @Override
  public LanguageDto findByLanguagesId(Integer id) {
    Query query = getCurrentSession().getNamedQuery("SEARCH_LANGUAGE_ID");
    query.setParameter("ID", id);
    List<LanguageDto> result = query.list();
    LanguageDto app = result.get(0);

    return app;

  }

  @Override
  public Language findIdJoinEmployee(Integer id) {
    Criteria c = getCurrentSession().createCriteria(Language.class, "language");
    c.setFetchMode("applicant", FetchMode.JOIN);
    c.createAlias("applicant", "applicant");
    c.add(Restrictions.eq("language.id", id));
    Language language = (Language) c.uniqueResult();

    return language;

  }

  @Override
  public Boolean checkLanguageName(Integer id, String languageName) {
    Query query = getCurrentSession().getNamedQuery("SEARCH_LANGUAGE_UNIQUE");
    query.setParameter("ID", id);
    query.setParameter("LANGUAGENAME", "%" + languageName + "%");
    List<Language> results = query.list();
    Boolean find = false;

    if (results.size() == 0) {
      find = true;
    }

    return find;

  }

}