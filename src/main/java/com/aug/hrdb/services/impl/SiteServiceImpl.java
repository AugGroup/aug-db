package com.aug.hrdb.services.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.SiteDto;
import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.entities.Site;
import com.aug.hrdb.repositories.SiteRepository;
import com.aug.hrdb.services.EmployeeService;
import com.aug.hrdb.services.SiteService;

@Transactional
@Service(value = "siteService")
public class SiteServiceImpl implements SiteService {

  @Autowired
  private SiteRepository siteRepository;

  @Autowired
  private EmployeeService employeeService;

  @Override
  public void create(Site site) {
    siteRepository.create(site);
  }

  @Override
  public void update(Site site) {
    siteRepository.update(site);
  }

  @Override
  public void delete(Site site) {
    siteRepository.delete(site);
  }

  @Override
  public Site find(Integer Id) {
    return siteRepository.find(Id);
  }

  @Override
  public List<Site> findAll() {
    return siteRepository.findAll();
  }

  @Override
  public void deleteById(Integer id) {
    siteRepository.deleteById(id);
  }

  @Override
  public List<SiteDto> listByNameNativeQuery(Integer id) {
    return siteRepository.listByNameNativeQuery(id);
  }

  @Override
  public void createSetDtoToEntity(SiteDto siteDto) {
    Employee employee = employeeService.findById(siteDto.getEmployeeId());

    Site site = new Site();
    site.setProjectName(siteDto.getProjectName());
    site.setProjectOwner(siteDto.getProjectOwner());
    site.setProjectOwnerContact(siteDto.getProjectOwnerContact());
    site.setStartDate(siteDto.getStartDate());
    site.setEndDate(siteDto.getEndDate());
    site.setEmployee(employee);
    site.setAuditFlag("C");
    site.setCreatedBy(siteDto.getEmployeeId());
    site.setCreatedTimeStamp(Calendar.getInstance().getTime());

    siteRepository.create(site);

  }

  @Override
  public SiteDto findByIdReturnToDto(Integer id) {
    Site site = siteRepository.find(id);

    SiteDto siteDto = new SiteDto();
    siteDto.setId(site.getId());
    siteDto.setProjectName(site.getProjectName());
    siteDto.setProjectOwner(site.getProjectOwner());
    siteDto.setProjectOwnerContact(site.getProjectOwnerContact());
    siteDto.setStartDate(site.getStartDate());
    siteDto.setEndDate(site.getEndDate());
    siteDto.setEmployeeId(site.getEmployee().getId());
    siteDto.setEmployeeCode(site.getEmployee().getEmployeeCode());

    return siteDto;

  }

  @Override
  public void updateSetDtoToEntity(SiteDto siteDto) {
    Site site = siteRepository.find(siteDto.getId());
    site.setAuditFlag("U");
    site.setUpdatedBy(siteDto.getEmployeeId());
    site.setUpdatedTimeStamp(Calendar.getInstance().getTime());
    site.setProjectName(siteDto.getProjectName());
    site.setStartDate(siteDto.getStartDate());
    site.setEndDate(siteDto.getEndDate());
    site.setProjectOwner(siteDto.getProjectOwner());
    site.setProjectOwnerContact(siteDto.getProjectOwnerContact());

    siteRepository.update(site);

  }

}