package com.aug.hrdb.repositories.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.dto.SiteDto;
import com.aug.hrdb.entities.Site;
import com.aug.hrdb.repositories.SiteRepository;


@Repository
public class SiteRepositoryImpl extends GenericRepositoryImpl<Site, Integer> implements SiteRepository,Serializable{

	
	private static final long serialVersionUID = 1L;

	public SiteRepositoryImpl() {
		super(Site.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<SiteDto> listByNameNativeQuery(Integer id) {
		// TODO Auto-generated method stub
		
		Query query = getCurrentSession().getNamedQuery("listSite").setInteger("empId", id);	
		return query.list();
	}

}
