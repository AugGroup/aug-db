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

import com.aug.hrdb.entities.MasAddressType;
import com.aug.hrdb.repositories.MasAddressTypeRepository;
import com.mysql.jdbc.StringUtils;

@Repository
public class MasAddressTypeRepositoryImpl extends GenericRepositoryImpl<MasAddressType, Integer> implements MasAddressTypeRepository{

	public MasAddressTypeRepositoryImpl() {
		super(MasAddressType.class);
		
	}

	@SuppressWarnings("unchecked")
	public List<MasAddressType> findByCriteria(MasAddressType masAddressType) {
		
		Criteria c = getCurrentSession().createCriteria(MasAddressType.class);
		if (!StringUtils.isNullOrEmpty(masAddressType.getName())) {
			c.add(Restrictions.like("name", "%" + masAddressType.getName() + "%"));
		}
		return c.list();
		
	}

	

}
