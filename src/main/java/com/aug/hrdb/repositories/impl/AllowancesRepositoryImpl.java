/**
 *
 * @author Preeyaporn
 * @date 3 มิ.ย. 2558
 */
package com.aug.hrdb.repositories.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.dto.AllowancesDto;
import com.aug.hrdb.entities.Allowances;
import com.aug.hrdb.repositories.AllowancesRepository;
import com.mysql.jdbc.StringUtils;

@Repository
public class AllowancesRepositoryImpl extends GenericRepositoryImpl<Allowances, Integer> implements AllowancesRepository{

	public AllowancesRepositoryImpl() {
		super(Allowances.class);
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Allowances> findByCriteria(Allowances allowances) {
//		Criteria c = getCurrentSession().createCriteria(Allowances.class);
//		if (!StringUtils.isNullOrEmpty(allowances.getName())) {
//			c.add(Restrictions.like("name", "%" + allowances.getName() + "%"));
//		}
//		return c.list();
//	}


	@SuppressWarnings("unchecked")
	@Override
	public List<AllowancesDto> searchAllowances(Integer id) {
		Query namedQuery = getCurrentSession().getNamedQuery("searchAllowances").setInteger("empId" ,id);
		//namedQuery.executeUpdate();
		List<AllowancesDto> allowancesDtos = namedQuery.list();
	     return allowancesDtos;
	}

}
