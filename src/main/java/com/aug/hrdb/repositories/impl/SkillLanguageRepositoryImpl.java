package com.aug.hrdb.repositories.impl;







import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.dto.SkillLanguageDto;
import com.aug.hrdb.entities.SkillLanguage;
import com.aug.hrdb.repositories.SkillLanguageRepository;



@Repository
public class SkillLanguageRepositoryImpl extends GenericRepositoryImpl<SkillLanguage,Integer> implements SkillLanguageRepository{

	

	public SkillLanguageRepositoryImpl() {
		super(SkillLanguage.class);
		// TODO Auto-generated constructor stub
	}


	@Override
	public SkillLanguage deleteById(Integer id) {
		SkillLanguage SkillLanguage =(SkillLanguage)getCurrentSession().load(SkillLanguage.class, id);
		getCurrentSession().delete(SkillLanguage);
		return SkillLanguage;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<SkillLanguageDto> listSkillLanguageByEmployee(Integer id) {
		Query nameQuery = getCurrentSession().getNamedQuery("listSkillLanguageByEmployee").setInteger("empId" ,id);
		//namedQuery.executeUpdate();
		List<SkillLanguageDto> skillDto = nameQuery.list();
	     return skillDto;
	}

	

	

	
}
