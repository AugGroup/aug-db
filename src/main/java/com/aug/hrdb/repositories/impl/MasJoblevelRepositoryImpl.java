/**
 *
 * @author Pranrajit
 * @date 11 พ.ค. 2558
 */
package com.aug.hrdb.repositories.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.entities.MasJobLevel;
import com.aug.hrdb.repositories.MasJoblevelRepository;
import com.mysql.jdbc.StringUtils;

@Repository
public class MasJoblevelRepositoryImpl extends GenericRepositoryImpl<MasJobLevel,Integer> implements MasJoblevelRepository{

	public MasJoblevelRepositoryImpl( ) {
		super(MasJobLevel.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MasJobLevel> findByCriteria(MasJobLevel masJoblevel) {
		Criteria c = getCurrentSession().createCriteria(MasJobLevel.class);
		if (!StringUtils.isNullOrEmpty(masJoblevel.getName())) {
			c.add(Restrictions.like("Name", "%" + masJoblevel.getName() + "%"));
		}
		return c.list();
	}


}
