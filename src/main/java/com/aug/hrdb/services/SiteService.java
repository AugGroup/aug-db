package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.dto.SiteDto;
import com.aug.hrdb.entities.Site;


public interface SiteService {
	
	public void create(Site site);
	public void update(Site site);
	public void delete(Site site);
	public Site find(Integer Id);
	public List<Site> findAll();
	 public void deleteById(Integer id);
	public void createSetDtoToEnity(SiteDto siteDto);
	public SiteDto findByIdReturnToDto(Integer id);
	public void updateSetDtoToEntity(SiteDto siteDto);

}
