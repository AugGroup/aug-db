/**
 *
 * @author Pranrajit
 * @date 25 พ.ค. 2558
 */
package com.aug.hrdb.repositories.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;




import com.aug.hrdb.entities.MasLeaveType;
import com.aug.hrdb.repositories.MasLeaveTypeRepository;
import com.mysql.jdbc.StringUtils;


@Repository
public class MasLeaveTypeRepositoryImpl extends GenericRepositoryImpl<MasLeaveType,Integer> implements MasLeaveTypeRepository{

	public MasLeaveTypeRepositoryImpl() {
		super(MasLeaveType.class);
		// TODO Auto-generated constructor stub
	}
	@Override
	public List<MasLeaveType> findByCriteria(MasLeaveType masLeaveType) {
		Criteria c = getCurrentSession().createCriteria(MasLeaveType.class);
		if (!StringUtils.isNullOrEmpty(masLeaveType.getName())) {
			c.add(Restrictions.like("Name", "%" + masLeaveType.getName() + "%"));
		}
		return c.list();
	}

	
	

		

}
