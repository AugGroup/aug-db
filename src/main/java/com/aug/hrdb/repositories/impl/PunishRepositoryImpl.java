package com.aug.hrdb.repositories.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.dto.PunsihDto;
import com.aug.hrdb.entities.Punish;
import com.aug.hrdb.repositories.PunishRepository;
import com.mysql.jdbc.StringUtils;


@Repository("PunishDao")
public class PunishRepositoryImpl extends GenericRepositoryImpl<Punish, Integer>implements PunishRepository {

	
	public PunishRepositoryImpl() {
		super(Punish.class);
		
	}

	
	@Override
	public List<Punish> findByCriteria(Punish punish) {
		Criteria c = getCurrentSession().createCriteria(Punish.class);
		if (!StringUtils.isNullOrEmpty(punish.getDescription())) {
			c.add(Restrictions.like("Description", "%" + punish.getDescription() + "%"));
		}
		return c.list();
	}

	
	public Punish deleteById(Integer id) {
		Punish punish =(Punish)getCurrentSession().load(Punish.class, id);
		getCurrentSession().delete(punish);
		return punish;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<PunsihDto> searchPunish(Integer id) {
		Query nameQuery = getCurrentSession().getNamedQuery("searchPunish").setInteger("empId" ,id);
		List<PunsihDto> punsihDtos = nameQuery.list();
		return punsihDtos;
	}

}
