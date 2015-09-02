package com.aug.hrdb.repositories.impl;







import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.dto.SkillLanguageDto;
import com.aug.hrdb.entities.SkillLanguage;
import com.aug.hrdb.repositories.SkillLanguageRepositories;



@Repository
public class SkillLanguageRepositoriesImpl extends GenericRepositoryImpl<SkillLanguage,Integer> implements SkillLanguageRepositories{

	

	public SkillLanguageRepositoriesImpl() {
		super(SkillLanguage.class);
		// TODO Auto-generated constructor stub
	}


	@Override
	public SkillLanguage deleteById(Integer id) {
		SkillLanguage SkillLanguage =(SkillLanguage)getCurrentSession().load(SkillLanguage.class, id);
		getCurrentSession().delete(SkillLanguage);
		return SkillLanguage;
	}


	@Override
	public List<SkillLanguageDto> listSkillLanguageByEmployee(Integer id) {
		Query namedQuery = getCurrentSession().getNamedQuery("listSkillLanguageByEmployee").setInteger("empId" ,id);
		//namedQuery.executeUpdate();
		List<SkillLanguageDto> skillDto = namedQuery.list();
	     return skillDto;
	}

	

	

	
}
