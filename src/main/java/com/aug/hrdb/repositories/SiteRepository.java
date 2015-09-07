package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.dto.SiteDto;
import com.aug.hrdb.entities.Site;


public interface SiteRepository extends GenericRepository<Site, Integer>{
	
	
	 public void create(Site site);
	 public void update(Site site);
	 public void delete(Site site);
	 public Site find(Integer Id);
	 public List<Site> findAll();	
	 public void deleteById(Integer id);
  	 public List<SiteDto> listByNameNativeQuery(Integer id);

}
