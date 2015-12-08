/**
 *
 * @author Pranrajit
 * @date 13 พ.ค. 2558
 */
package com.aug.hrdb.repositories.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.entities.MasLocation;
import com.aug.hrdb.repositories.MasLocationRepository;
import com.mysql.jdbc.StringUtils;

@Repository(value="masLocationRepository")
public class MasLocationRepositoryImpl  extends GenericRepositoryImpl<MasLocation,Integer> implements MasLocationRepository{

	public MasLocationRepositoryImpl() {
		super(MasLocation.class);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MasLocation> findByCriteria(MasLocation masLocation) {
		
		Criteria c = getCurrentSession().createCriteria(MasLocation.class);
		
		if (!StringUtils.isNullOrEmpty(masLocation.getName())) {
			c.add(Restrictions.like("name", "%" + masLocation.getName() + "%"));
		}
		
		return c.list();
		
	}

	@Override
	public MasLocation findByLocationCode(String locationCode) {
		
		Criteria c = getCurrentSession().createCriteria(MasLocation.class);
	    c.add(Restrictions.eq("code", locationCode));
	    MasLocation location = (MasLocation) c.uniqueResult();
		
	    return location;
	    
	}

}