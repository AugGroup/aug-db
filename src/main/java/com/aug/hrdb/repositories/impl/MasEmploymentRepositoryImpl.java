/**
 *
 * @author natechanok
 * @date Apr 27, 2015
 */

package com.aug.hrdb.repositories.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.entities.MasEmployment;
import com.aug.hrdb.repositories.MasEmploymentRepository;
import com.mysql.jdbc.StringUtils;

@Repository
public class MasEmploymentRepositoryImpl extends GenericRepositoryImpl<MasEmployment, Integer> implements MasEmploymentRepository{

	public MasEmploymentRepositoryImpl() {
		super(MasEmployment.class);
		
	}

	@SuppressWarnings("unchecked")
	public List<MasEmployment> findByCriteria(MasEmployment masEmployment) {
		
		Criteria c = getCurrentSession().createCriteria(MasEmployment.class);
		if (!StringUtils.isNullOrEmpty(masEmployment.getName())) {
			c.add(Restrictions.like("name", "%" + masEmployment.getName() + "%"));
		}
		return c.list();
	}

	

	
}
