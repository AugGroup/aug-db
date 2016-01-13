package com.aug.hrdb.services;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.aug.hrdb.entities.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.GreaterOrEqual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.SiteDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class SiteServiceTest {

  @Autowired
  private MasCoreSkillService masCoreSkillService;

  @Autowired
  private MasJobLevelService masJobLevelService;

  @Autowired
  private MasTechnologyService masTechnologyService;

  @Autowired
  private MasDivisionService masDivisionService;

  @Autowired
  private ApplicantService applicantService;

  @Autowired
  private EmployeeService employeeService;

  @Autowired
  private SiteService siteService;

  private Site site;

  @Before
  public void setUp() throws Exception {
    // create applicant
    MasCoreSkill masCoreSkill = new MasCoreSkill();
    masCoreSkill.setAuditFlag("C");
    masCoreSkill.setCreatedBy(1);
    masCoreSkill.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masCoreSkill.setIsActive(true);
    masCoreSkill.setCode("ITS");
    masCoreSkill.setName("ITS");
    masCoreSkillService.create(masCoreSkill);

    MasJobLevel masJobLevel = new MasJobLevel();
    masJobLevel.setAuditFlag("C");
    masJobLevel.setCreatedBy(1);
    masJobLevel.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masJobLevel.setIsActive(true);
    masJobLevel.setCode("C");
    masJobLevel.setName("Consultant");
    masJobLevelService.create(masJobLevel);

    MasTechnology masTechnology = new MasTechnology();
    masTechnology.setAuditFlag("C");
    masTechnology.setCreatedBy(1);
    masTechnology.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masTechnology.setIsActive(true);
    masTechnology.setCode("1");
    masTechnology.setName("Java");
    masTechnologyService.create(masTechnology);

    Applicant applicant = new Applicant();
    applicant.setAuditFlag("C");
    applicant.setCreatedBy(1);
    applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
    applicant.setFirstNameEN("Anat");
    applicant.setCoreSkill(masCoreSkillService.findById(masCoreSkill.getId()));
    applicant.setJoblevel(masJobLevelService.findById(masJobLevel.getId()));
    applicant.setTechnology(masTechnologyService.findById(masTechnology.getId()));
    applicantService.create(applicant);

    // create mas division
    MasDivision masDivision = new MasDivision();
    masDivision.setAuditFlag("C");
    masDivision.setCreatedBy(1);
    masDivision.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masDivision.setIsActive(true);
    masDivision.setCode("ITS");
    masDivision.setName("Integrate Technology Services");
    masDivisionService.create(masDivision);

    // create employee
    Employee employee = new Employee();
    employee.setAuditFlag("C");
    employee.setCreatedBy(1);
    employee.setCreatedTimeStamp(Calendar.getInstance().getTime());
    employee.setEmployeeCode("TEST0001");
    employee.setStatusEmp("Employee");
    employee.setTelHome("02-9998877");
    employee.setApplicant(applicant);
    employee.setMasDivision(masDivision);
    employeeService.create(employee);

    // create date
    //first date
    Calendar first = Calendar.getInstance();
    first.set(Calendar.DAY_OF_MONTH, 1);
    Date today = first.getTime();

    //last date
    Calendar last = Calendar.getInstance();
    last.set(Calendar.DAY_OF_MONTH, last.getActualMaximum(Calendar.DAY_OF_MONTH));
    Date lastDay = last.getTime();

    // create site
    site = new Site();
    site.setAuditFlag("C");
    site.setCreatedBy(1);
    site.setCreatedTimeStamp(Calendar.getInstance().getTime());
    site.setStartDate(today);
    site.setEndDate(lastDay);
    site.setProjectName("PROJECT NAME");
    site.setProjectOwner("PROJECT OWNER");
    site.setProjectOwnerContact("PROJECT OWNER CONTACT");
    site.setEmployee(employee);
    siteService.create(site);

  }

  @Test
  public void testLoadServicesShouldPass() throws Exception {
    assertNotNull(siteService);
    assertNotNull(masCoreSkillService);
    assertNotNull(masJobLevelService);
    assertNotNull(masDivisionService);
    assertNotNull(masTechnologyService);
    assertNotNull(employeeService);
    assertNotNull(applicantService);

  }

  @Test
  public void testFindWithSiteServiceShouldReturnSiteThatSetup() throws Exception {
    Site result = siteService.find(site.getId());
    assertNotNull(result);
    assertThat(result.getEmployee().getApplicant().getFirstNameEN(), is("Anat"));
    assertThat(result.getProjectName(), is("PROJECT NAME"));
    assertThat(result.getProjectOwner(), is("PROJECT OWNER"));
    assertThat(result.getProjectOwnerContact(), is("PROJECT OWNER CONTACT"));

  }

  @Test
  public void testFindAllWithSiteServiceShouldReturnListOfAllSite() throws Exception {
    List<Site> result = siteService.findAll();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testUpdateWithSiteServiceShouldReturnSiteThatUpdate() throws Exception {
    Site update = siteService.find(site.getId());
    assertThat(update.getProjectName(), is("PROJECT NAME"));
    assertThat(update.getProjectOwner(), is("PROJECT OWNER"));
    assertThat(update.getProjectOwnerContact(), is("PROJECT OWNER CONTACT"));

    update.setProjectName("UPDATE PROJECT NAME");
    siteService.update(update);

    Site result = siteService.find(update.getId());
    assertThat(result.getProjectName(), is("UPDATE PROJECT NAME"));

  }

  @Test
  public void testDeleteWithSiteServiceShouldNotFindThatSite() throws Exception {
    Site delete = siteService.find(site.getId());
    siteService.delete(delete);

    Site result = siteService.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteByIdWithSiteServiceShouldNotFindThatSite() throws Exception {
    Site delete = siteService.find(site.getId());
    siteService.deleteById(delete.getId());

    Site result = siteService.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testListByNameNativeQueryWithSiteServiceShouldReturnListOfSiteDtoOfThatEmployeeId() throws Exception {
    List<SiteDto> result = siteService.listByNameNativeQuery(site.getEmployee().getId());
    assertNotNull(result);
    assertThat(result.get(0).getProjectName(), is("PROJECT NAME"));
    assertThat(result.get(0).getProjectOwner(), is("PROJECT OWNER"));
    assertThat(result.get(0).getProjectOwnerContact(), is("PROJECT OWNER CONTACT"));

  }

  @Test
  public void testFindByIdReturnToDtoWithSiteServiceShouldReturnSiteDtoOfThatSiteId() throws Exception {
    SiteDto result = siteService.findByIdReturnToDto(site.getId());
    assertThat(result.getProjectName(), is("PROJECT NAME"));
    assertThat(result.getProjectOwnerContact(), is("PROJECT OWNER CONTACT"));
    assertThat(result.getProjectOwner(), is("PROJECT OWNER"));

  }

//  wait dto
//  @Test
//  public void testCreateSetDtoToEntityWithSiteServiceShouldPass() throws Exception {
//
//  }

  @Test
  public void testUpdateSetDtoToEntityWithSiteServiceShouldPass() throws Exception {
    SiteDto update = siteService.findByIdReturnToDto(site.getId());
    assertThat(update.getProjectName(), is("PROJECT NAME"));
    assertThat(update.getProjectOwnerContact(), is("PROJECT OWNER CONTACT"));
    assertThat(update.getProjectOwner(), is("PROJECT OWNER"));

    update.setProjectName("UPDATE PROJECT NAME");
    siteService.updateSetDtoToEntity(update);

    Site result = siteService.find(update.getId());
    assertThat(result.getProjectName(), is("UPDATE PROJECT NAME"));
    assertThat(result.getProjectOwner(), is("PROJECT OWNER"));
    assertThat(result.getProjectOwnerContact(), is("PROJECT OWNER CONTACT"));

  }

}