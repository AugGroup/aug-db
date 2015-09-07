/**
 *
 * @author Preeyaporn
 * @date 5 มิ.ย. 2558
 */
package com.aug.hrdb.repositories.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.entities.MasAllowances;
import com.aug.hrdb.repositories.MasAllowancesRepository;
import com.mysql.jdbc.StringUtils;

@Repository
public class MasAllowancesRepositoryImpl extends GenericRepositoryImpl<MasAllowances, Integer> implements MasAllowancesRepository{

	public MasAllowancesRepositoryImpl() {
		super(MasAllowances.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MasAllowances> findByCriteria(MasAllowances masAllowances) {
		Criteria c = getCurrentSession().createCriteria(MasAllowances.class);
		if (!StringUtils.isNullOrEmpty(masAllowances.getName())) {
			c.add(Restrictions.like("Name", "%" + masAllowances.getName() + "%"));
		}
		return c.list();
	}


}
