package com.aug.hrdb.repositories.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.entities.MasSpecialty;
import com.aug.hrdb.repositories.MasSpecialtyRepository;
import com.mysql.jdbc.StringUtils;


@Repository("specialtyRepository")
public class MasSpecialtyRepositoryImpl extends GenericRepositoryImpl<MasSpecialty, Integer> implements MasSpecialtyRepository{

			public MasSpecialtyRepositoryImpl(){
				super(MasSpecialty.class);
			}

			

			@Override
			public List<MasSpecialty> findByCriteria(MasSpecialty specialty) {
				Criteria c = getCurrentSession().createCriteria(MasSpecialty.class);
				if (!StringUtils.isNullOrEmpty(specialty.getName())) {
					c.add(Restrictions.like("name", "%" + specialty.getName() + "%"));
				}
				return c.list();
			}

//			@Override
//			public MasSpecialty deleteById(Integer id) {
//				MasSpecialty specialty =(MasSpecialty)getCurrentSession().load(MasSpecialty.class, id);
//				getCurrentSession().delete(specialty);
//				return specialty;
//			}
}
