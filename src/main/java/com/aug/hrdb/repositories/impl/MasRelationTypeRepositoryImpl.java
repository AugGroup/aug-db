package com.aug.hrdb.repositories.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.aug.hrdb.entities.MasRelationType;
import com.aug.hrdb.repositories.MasRelationTypeRepository;

@Repository(value="masRelationTypeRepository")
public class MasRelationTypeRepositoryImpl extends GenericRepositoryImpl<MasRelationType, Integer> implements MasRelationTypeRepository {

	public MasRelationTypeRepositoryImpl() {
		super(MasRelationType.class);
	}

	@Override
	public MasRelationType findByName(String name) {
		
		Criteria c = getCurrentSession().createCriteria(MasRelationType.class);
		c.add(Restrictions.eq("relationType", name));
		
		MasRelationType masRelation = (MasRelationType) c.uniqueResult();
		
		return masRelation;
		
	}

}