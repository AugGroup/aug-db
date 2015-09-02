package com.aug.hrdb.repositories.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.aug.hr.dao.SkillLanguageDao;
import com.aug.hr.entity.SkillLanguage;
import com.aug.hr.entity.dto.SkillLanguageDto;

@Repository
public class SkillLanguageRepositoriesImpl extends GenericDaoImpl<SkillLanguage,Integer> implements SkillLanguageDao,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SkillLanguageRepositoriesImpl() {
		super(SkillLanguage.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<SkillLanguage> findAllByEmployee(Integer IdEmployee) {
		// TODO Auto-generated method stub
		Criteria c = getCurrentSession().createCriteria(SkillLanguage.class,"skillLanguage");
		c.setFetchMode("employee",FetchMode.JOIN);
		c.createAlias("employee", "employee");
		c.setFetchMode("masSkillLanguage",FetchMode.JOIN);		
		return c.list();
	}

	@Override
	public List<SkillLanguageDto> listSkillLanguageByEmployee(Integer id) {
		// TODO Auto-generated method stub
		Query query =  getCurrentSession().getNamedQuery("listSkillLanguage").setInteger("empId" ,id);
		List<SkillLanguageDto> skillLanguageDtoList = query.list();
		return skillLanguageDtoList;
	}

	@Override
	public SkillLanguage findIdJoinEmployee(Integer id) {
		// TODO Auto-generated method stub
		Criteria c = getCurrentSession().createCriteria(SkillLanguage.class,"skillLanguage");
		c.setFetchMode("employee",FetchMode.JOIN);
		c.createAlias("employee", "employee");
		c.setFetchMode("masSkillLanguage",FetchMode.JOIN);	
		c.createAlias("masSkillLanguage", "masSkillLanguage");
		c.add(Restrictions.eq("skillLanguage.id", id));
		SkillLanguage skillLanguage = (SkillLanguage) c.uniqueResult();
		return skillLanguage;
	}

	@Override
	public SkillLanguage findJoinMasSkillLanguage(Integer id) {
		// TODO Auto-generated method stub
		Criteria c = getCurrentSession().createCriteria(SkillLanguage.class,"skillLanguage");
		c.setFetchMode("employee",FetchMode.JOIN);
		c.createAlias("employee", "employee");
		c.setFetchMode("masSkillLanguage",FetchMode.JOIN);	
		c.createAlias("masSkillLanguage", "masSkillLanguage");
		c.add(Restrictions.eq("skillLanguage.masSkillLanguage.id", id));
		SkillLanguage skillLanguage = (SkillLanguage) c.uniqueResult();
		return skillLanguage;
	}

}
