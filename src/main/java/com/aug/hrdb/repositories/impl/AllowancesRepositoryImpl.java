/**
 *
 * @author Preeyaporn
 * @date 3 มิ.ย. 2558
 */
package com.aug.hrdb.repositories.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.dto.AllowancesDto;
import com.aug.hrdb.entities.Allowance;
import com.aug.hrdb.repositories.AllowancesRepository;

@Repository
public class AllowancesRepositoryImpl extends GenericRepositoryImpl<Allowance, Integer> implements AllowancesRepository{

	public AllowancesRepositoryImpl() {
		super(Allowance.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AllowancesDto> searchAllowances(Integer id) {
		Query namedQuery = getCurrentSession().getNamedQuery("searchAllowances").setInteger("empId" ,id);
		//namedQuery.executeUpdate();
		List<AllowancesDto> allowancesDtos = namedQuery.list();
	     return allowancesDtos;
	}

}
