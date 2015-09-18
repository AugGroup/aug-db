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


@Repository
public class LanguageRepositoryImpl extends GenericRepositoryImpl<Language,Integer> implements LanguageRepository{

	public LanguageRepositoryImpl() {
		super(Language.class);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override

	public List<LanguageDto> listLanguageByEmployee(Integer id) {
		Query nameQuery = getCurrentSession().getNamedQuery("listLanguage").setInteger("empId" ,id);
		List<LanguageDto> LanguageDtoList = nameQuery.list();
	    return LanguageDtoList;
	}
	

	@Override
	public List<LanguageDto> findLanguagesById(Integer id) {
		Query query = getCurrentSession().getNamedQuery("SEARCH_LANGUAGES");
		query.setParameter("ID", id);
		List<LanguageDto> result = query.list();
		System.out.println("QUERYADDRESS :: " + result);
		return result;
	}

	@Override
	public LanguageDto findByLanguagesId(Integer id) {
		Query query = getCurrentSession().getNamedQuery("SEARCH_LANGUAGES_ID");
		query.setParameter("ID", id);
		List<LanguageDto> result = query.list();
		LanguageDto app = result.get(0);
		return app;
	}


	@Override
	public Language findIdJoinEmployee(Integer id) {
		// TODO Auto-generated method stub
		Criteria c = getCurrentSession().createCriteria(Language.class,"language");
		c.setFetchMode("applicant",FetchMode.JOIN);
		c.createAlias("applicant", "applicant");
		c.setFetchMode("employee",FetchMode.JOIN);
		c.createAlias("employee", "employee");
		c.add(Restrictions.eq("language.id", id));
		Language language = (Language) c.uniqueResult();
		return language;
	}
	
	
}
