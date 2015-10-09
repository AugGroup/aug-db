/**
 *
 * @author Pranrajit
 * @date 27 เม.ย. 2558
 */
package com.aug.hrdb.repositories.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.dto.AbilityDto;
import com.aug.hrdb.dto.AddressDto;
import com.aug.hrdb.entities.Ability;
import com.aug.hrdb.repositories.AbilityRepository;


@Repository
public class AbilityRepositoryImpl extends GenericRepositoryImpl<Ability,Integer> implements AbilityRepository{

	public AbilityRepositoryImpl() {
		super(Ability.class);
		// TODO Auto-generated constructor stub
	}
/*
	@SuppressWarnings("unchecked")
	public List<Employee> findByCriteria(Employee employee) {
		Criteria c = getCurrentSession().createCriteria(Employee.class);
		if (!StringUtils.isNullOrEmpty(employee.getName())) {
			c.add(Restrictions.like("Name", "%" + employee.getName() + "%"));
		}
		return c.list();
	}*/



	@SuppressWarnings("unchecked")
	public List<AbilityDto> searchAbility(Integer id) {
		Query namedQuery = getCurrentSession().getNamedQuery("searchAbility").setInteger("ID" ,id);
		//namedQuery.executeUpdate();
		List<AbilityDto> abiDto = namedQuery.list();
	     return abiDto;
	}

	@Override
	public AbilityDto findByAbilityId(Integer id) {
		Query query = getCurrentSession().getNamedQuery("SEARCH_ABILITY_ID");
		query.setParameter("ID", id);
		List<AbilityDto> result = query.list();
		AbilityDto app = result.get(0);
		return app;
	}



	@Override
	public Boolean checkSpecialty(Integer id,Integer sp_id) {
		Query query = getCurrentSession().getNamedQuery("SEARCH_SPACIALTY_ID");
		query.setParameter("SP_ID", sp_id);
		query.setParameter("ID", id);
		List<AbilityDto> result = query.list();
		
		Boolean find = false;
		
		if (result.size() != 0) {
			find = true;
		}
		
		return find;
	}

}

	


