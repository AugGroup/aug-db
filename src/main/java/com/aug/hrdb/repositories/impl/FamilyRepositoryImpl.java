package com.aug.hrdb.repositories.impl;


import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.dto.FamilyDto;
import com.aug.hrdb.entities.Family;
import com.aug.hrdb.repositories.FamilyRepository;



@Repository
public class FamilyRepositoryImpl extends GenericRepositoryImpl<Family, Integer> implements FamilyRepository,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FamilyRepositoryImpl() {
		super(Family.class);
		// TODO Auto-generated constructor stub
	}

	

	
	@Override
	public List<Family> findFamilyByApplicantId(Integer Id) {
		// TODO Auto-generated method stub
		
		Criteria c = getCurrentSession().createCriteria(Family.class,"family");		
		c.setFetchMode("applicant",FetchMode.JOIN);
		c.createAlias("applicant", "employee");
		c.setFetchMode("masRelation",FetchMode.JOIN);
		c.createAlias("masRelation", "masRelation");
		c.add(Restrictions.eq("family.applicant.id", Id));
	  
		return c.list();
		
	}

	
	
	
	@Override
	public Family findLastFamily(Integer Id) {
		// TODO Auto-generated method stub
		Criteria c = getCurrentSession().createCriteria(Family.class,"family");
		c.setFetchMode("applicant",FetchMode.JOIN);
		c.createAlias("applicant", "employee");
		c.setFetchMode("masRelationType",FetchMode.JOIN);
		c.createAlias("masRelationType", "masRelationType");
		c.add(Restrictions.eq("id", Id));
		Family empFamily = (Family)c.uniqueResult();
		return empFamily;
	}





	@Override
	public void deleteByNameQuery(FamilyDto family) {
		// TODO Auto-generated method stub
		Query query =  getCurrentSession().getNamedQuery("deleteFamily");
		query.setInteger("familyId", family.getId());
		query.executeUpdate();
	}




	@Override
	public List<FamilyDto> findFamilyList(Integer id) {
		// TODO Auto-generated method stub
		Query query =  getCurrentSession().getNamedQuery("listFamily").setInteger("appId" ,id);
		List<FamilyDto> familyDtoList = query.list();
		return familyDtoList;
	}




	@Override
	public List<FamilyDto> findFamilyById(Integer id) {
		Query query = getCurrentSession().getNamedQuery("listFamily");
		query.setParameter("appId", id);
		List<FamilyDto> result = query.list();
		System.out.println("QUERYADDRESS :: " + result);
		return result;
	}

	@Override
	public FamilyDto findFamily(Integer id) {
		Query query = getCurrentSession().getNamedQuery("SEARCH_FAMILY_ID");
		query.setParameter("ID", id);
		List<FamilyDto> result = query.list();
		FamilyDto app = result.get(0);
		return app;
	}
}
