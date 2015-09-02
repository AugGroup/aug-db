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

import com.aug.hrdb.entities.MasJoblevel;
import com.aug.hrdb.repositories.MasJoblevelRepository;
import com.mysql.jdbc.StringUtils;

@Repository
public class MasJoblevelRepositoryImpl extends GenericRepositoryImpl<MasJoblevel,Integer> implements MasJoblevelRepository{

	public MasJoblevelRepositoryImpl( ) {
		super(MasJoblevel.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MasJoblevel> findByCriteria(MasJoblevel masJoblevel) {
		Criteria c = getCurrentSession().createCriteria(MasJoblevel.class);
		if (!StringUtils.isNullOrEmpty(masJoblevel.getName())) {
			c.add(Restrictions.like("Name", "%" + masJoblevel.getName() + "%"));
		}
		return c.list();
	}

	@Override
	public MasJoblevel deleteById(Integer id) {
		MasJoblevel masJoblevel =(MasJoblevel)getCurrentSession().load(MasJoblevel.class, id);
		getCurrentSession().delete(masJoblevel);
		return masJoblevel;
	}

}
