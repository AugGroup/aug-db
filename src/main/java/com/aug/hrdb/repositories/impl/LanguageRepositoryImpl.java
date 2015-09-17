package com.aug.hrdb.repositories.impl;







import java.util.List;

import org.hibernate.Query;
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
	public List<LanguageDto> listSkillLanguageByEmployee(Integer id) {
		Query nameQuery = getCurrentSession().getNamedQuery("listSkillLanguage").setInteger("appId" ,id);
		//namedQuery.executeUpdate();
		List<LanguageDto> skillDto = nameQuery.list();
	     return skillDto;
	}

	

	

	
}
