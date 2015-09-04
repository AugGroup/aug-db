package com.aug.hrdb.repositories.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.aug.hrdb.dto.ReferenceDto;
import com.aug.hrdb.entities.Reference;
import com.aug.hrdb.repositories.ReferenceRepository;
import com.mysql.jdbc.StringUtils;

@Repository("referenceRepository")
public class ReferenceRepositoryImpl extends GenericRepositoryImpl<Reference, Integer> implements ReferenceRepository{

	public ReferenceRepositoryImpl(){
		super(Reference.class);
	}

	@Override
	public List<Reference> findByCriteria(Reference reference) {
		
		Criteria c = getCurrentSession().createCriteria(Reference.class);
		if (!StringUtils.isNullOrEmpty(reference.getName())) {
			c.add(Restrictions.like("name", "%" + reference.getName() + "%"));
		}
		return c.list();
	}
	

	@Override
	public Reference deleteById(Integer id) {
		Reference reference =(Reference)getCurrentSession().load(Reference.class, id);
		getCurrentSession().delete(reference);
		return reference;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ReferenceDto> searchReference(Integer id) {
		 Query   namedQuery = getCurrentSession().getNamedQuery("searchReference").setInteger("empId" ,id);
			List<ReferenceDto> refDto = namedQuery.list();
			return refDto;
	}
		
	
}
