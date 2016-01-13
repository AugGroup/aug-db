package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.dto.SiteDto;
import com.aug.hrdb.entities.Site;

public interface SiteService {

  void create(Site site);

  void update(Site site);

  void delete(Site site);

  Site find(Integer Id);

  List<Site> findAll();

  void deleteById(Integer id);

  List<SiteDto> listByNameNativeQuery(Integer id);

  SiteDto findByIdReturnToDto(Integer id);

  void createSetDtoToEntity(SiteDto siteDto);

  void updateSetDtoToEntity(SiteDto siteDto);

}