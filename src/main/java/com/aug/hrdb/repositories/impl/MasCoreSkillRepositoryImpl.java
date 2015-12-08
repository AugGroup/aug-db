package com.aug.hrdb.repositories.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.entities.MasCoreSkill;
import com.aug.hrdb.repositories.MasCoreSkillRepository;
import com.mysql.jdbc.StringUtils;

@Repository(value="masCoreSkillRepository")
public class MasCoreSkillRepositoryImpl extends GenericRepositoryImpl<MasCoreSkill, Integer> implements MasCoreSkillRepository {

	public MasCoreSkillRepositoryImpl() {
		super(MasCoreSkill.class);
	}
	
	@Override
	@SuppressWarnings(value="unchecked")
	public List<MasCoreSkill> findByCriteria(MasCoreSkill masCoreSkill) {
		
		Criteria c = getCurrentSession().createCriteria(MasCoreSkill.class);
		
		if (!StringUtils.isNullOrEmpty(masCoreSkill.getName())) {
			c.add(Restrictions.like("name", "%" + masCoreSkill.getName() + "%"));
		}
		
		return c.list();
		
	}
	
}
