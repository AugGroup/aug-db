package com.aug.hrdb.repositories;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import com.aug.hrdb.dto.SiteDto;
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

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class SiteRepositoryTest {

  @Autowired
  private MasCoreSkillRepository masCoreSkillRepository;

  @Autowired
  private MasJobLevelRepository masJobLevelRepository;

  @Autowired
  private MasTechnologyRepository masTechnologyRepository;

  @Autowired
  private MasDivisionRepository masDivisionRepository;

  @Autowired
  private ApplicantRepository applicantRepository;

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private SiteRepository siteRepository;

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
    masCoreSkillRepository.create(masCoreSkill);

    MasJobLevel masJobLevel = new MasJobLevel();
    masJobLevel.setAuditFlag("C");
    masJobLevel.setCreatedBy(1);
    masJobLevel.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masJobLevel.setIsActive(true);
    masJobLevel.setCode("C");
    masJobLevel.setName("Consultant");
    masJobLevelRepository.create(masJobLevel);

    MasTechnology masTechnology = new MasTechnology();
    masTechnology.setAuditFlag("C");
    masTechnology.setCreatedBy(1);
    masTechnology.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masTechnology.setIsActive(true);
    masTechnology.setCode("1");
    masTechnology.setName("Java");
    masTechnologyRepository.create(masTechnology);

    Applicant applicant = new Applicant();
    applicant.setAuditFlag("C");
    applicant.setCreatedBy(1);
    applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
    applicant.setFirstNameEN("Anat");
    applicant.setCoreSkill(masCoreSkillRepository.find(masCoreSkill.getId()));
    applicant.setJoblevel(masJobLevelRepository.find(masJobLevel.getId()));
    applicant.setTechnology(masTechnologyRepository.find(masTechnology.getId()));
    applicantRepository.create(applicant);

    // create mas division
    MasDivision masDivision = new MasDivision();
    masDivision.setAuditFlag("C");
    masDivision.setCreatedBy(1);
    masDivision.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masDivision.setIsActive(true);
    masDivision.setCode("ITS");
    masDivision.setName("Integrate Technology Services");
    masDivisionRepository.create(masDivision);

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
    employeeRepository.create(employee);

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
    siteRepository.create(site);
    
  }

  @Test
  public void testLoadRepositoriesShouldPass() throws Exception {
    assertNotNull(siteRepository);
    assertNotNull(masCoreSkillRepository);
    assertNotNull(masJobLevelRepository);
    assertNotNull(masDivisionRepository);
    assertNotNull(masTechnologyRepository);
    assertNotNull(employeeRepository);
    assertNotNull(applicantRepository);

  }

  @Test
  public void testFindWithSiteRepositoryShouldReturnSiteThatSetup() throws Exception {
    Site result = siteRepository.find(site.getId());
    assertNotNull(result);
    assertThat(result.getEmployee().getApplicant().getFirstNameEN(), is("Anat"));
    assertThat(result.getProjectName(), is("PROJECT NAME"));
    assertThat(result.getProjectOwner(), is("PROJECT OWNER"));
    assertThat(result.getProjectOwnerContact(), is("PROJECT OWNER CONTACT"));

  }

  @Test
  public void testFindAllWithSiteRepositoryShouldReturnListOfAllSite() throws Exception {
    List<Site> result = siteRepository.findAll();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testUpdateWithSiteRepositoryShouldReturnSiteThatUpdate() throws Exception {
    Site update = siteRepository.find(site.getId());
    assertThat(update.getProjectName(), is("PROJECT NAME"));
    assertThat(update.getProjectOwner(), is("PROJECT OWNER"));
    assertThat(update.getProjectOwnerContact(), is("PROJECT OWNER CONTACT"));

    update.setProjectName("UPDATE PROJECT NAME");
    siteRepository.update(update);

    Site result = siteRepository.find(update.getId());
    assertThat(result.getProjectName(), is("UPDATE PROJECT NAME"));

  }

  @Test
  public void testDeleteWithSiteRepositoryShouldNotFindThatSite() throws Exception {
    Site delete = siteRepository.find(site.getId());
    siteRepository.delete(delete);

    Site result = siteRepository.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteByIdWithSiteRepositoryShouldNotFindThatSite() throws Exception {
    Site delete = siteRepository.find(site.getId());
    siteRepository.deleteById(delete.getId());

    Site result = siteRepository.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testListByNameNativeQueryWithSiteRepositoryShouldReturnListOfSiteDtoOfThatEmployeeId() throws Exception {
    List<SiteDto> result = siteRepository.listByNameNativeQuery(site.getEmployee().getId());
    assertNotNull(result);
    assertThat(result.get(0).getProjectName(), is("PROJECT NAME"));
    assertThat(result.get(0).getProjectOwner(), is("PROJECT OWNER"));
    assertThat(result.get(0).getProjectOwnerContact(), is("PROJECT OWNER CONTACT"));

  }

}