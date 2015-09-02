package com.aug.hrdb.repositories.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.aug.hrdb.entities.MasRelationType;
import com.aug.hrdb.repositories.MasRelationTypeRepository;

@Repository
public class MasRelationTypeRepositoryImpl extends GenericRepositoryImpl<MasRelationType, Integer> implements MasRelationTypeRepository{

	public MasRelationTypeRepositoryImpl() {
		super(MasRelationType.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public MasRelationType findByName(String name) {
		// TODO Auto-generated method stub
		Criteria c = getCurrentSession().createCriteria(MasRelationType.class);
		c.add(Restrictions.eq("relationType", name));
		MasRelationType masRelation = (MasRelationType) c.uniqueResult();
		return masRelation;
	}
	
	

}
