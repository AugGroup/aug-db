package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.dto.SiteDto;
import com.aug.hrdb.entities.Site;


public interface SiteRepository extends GenericRepository<Site, Integer>{
	
	public List<SiteDto> listByNameNativeQuery(Integer id);

}
