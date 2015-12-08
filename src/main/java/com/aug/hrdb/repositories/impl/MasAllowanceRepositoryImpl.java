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

import com.aug.hrdb.entities.MasAllowance;
import com.aug.hrdb.repositories.MasAllowanceRepository;
import com.mysql.jdbc.StringUtils;

@Repository(value="masAllowanceRepository")
public class MasAllowanceRepositoryImpl extends GenericRepositoryImpl<MasAllowance, Integer> implements MasAllowanceRepository{

	public MasAllowanceRepositoryImpl() {
		super(MasAllowance.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MasAllowance> findByCriteria(MasAllowance masAllowances) {
		
		Criteria c = getCurrentSession().createCriteria(MasAllowance.class);
		
		if (!StringUtils.isNullOrEmpty(masAllowances.getName())) {
			c.add(Restrictions.like("name", "%" + masAllowances.getName() + "%"));
		}
		
		return c.list();
		
	}

}
