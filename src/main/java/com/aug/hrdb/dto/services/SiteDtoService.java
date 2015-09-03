package com.aug.hrdb.dto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.SiteDto;
import com.aug.hrdb.repositories.SiteRepository;


@Service
@Transactional
public class SiteDtoService {
	
	@Autowired
	private SiteRepository siteDao;
	
	public List<SiteDto> listByNameNativeQuery(Integer id){
		return siteDao.listByNameNativeQuery(id); 
	}

}
