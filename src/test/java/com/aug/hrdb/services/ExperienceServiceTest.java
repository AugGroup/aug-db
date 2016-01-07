package com.aug.hrdb.services;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import com.aug.hrdb.dto.ExperienceDto;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class ExperienceServiceTest {

  @Autowired
  private MasCoreSkillService masCoreSkillService;

  @Autowired
  private MasJobLevelService masJobLevelService;

  @Autowired
  private MasTechnologyService masTechnologyService;

  @Autowired
  private ApplicantService applicantService;

  @Autowired
  private MasDivisionService masDivisionService;

  @Autowired
  private EmployeeService employeeService;

  @Autowired
  private ExperienceService experienceService;

  private  Experience experience;

  private  Employee employee;

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
    employee = new Employee();
    employee.setAuditFlag("C");
    employee.setCreatedBy(1);
    employee.setCreatedTimeStamp(Calendar.getInstance().getTime());
    employee.setEmployeeCode("TEST0001");
    employee.setStatusEmp("Employee");
    employee.setTelHome("02-9998877");
    employee.setApplicant(applicant);
    employee.setMasDivision(masDivision);
    employeeService.create(employee);

    // create experience
    experience = new Experience();
    experience.setAuditFlag("C");
    experience.setCreatedBy(1);
    experience.setCreatedTimeStamp(Calendar.getInstance().getTime());
    experience.setCompanyName("PTT");
    experience.setSalary(20000);
    experience.setApplicant(applicant);
    experienceService.create(experience);

  }

  @Test
  public void testLoadServicesShouldPass() throws Exception {
    assertNotNull(experienceService);
    assertNotNull(masCoreSkillService);
    assertNotNull(masJobLevelService);
    assertNotNull(masTechnologyService);
    assertNotNull(applicantService);
    assertNotNull(masDivisionService);
    assertNotNull(employeeService);

  }

  @Test
  public void testFindWithExperienceServiceShouldReturnExperienceThatSetup() throws Exception {
    Experience result = experienceService.findById(experience.getId());
    assertNotNull(result);
    assertThat(result.getCompanyName(), is("PTT"));
    assertThat(result.getSalary(), is((long)20000));

  }

  @Test
  public void testFindAllWithExperienceServiceShouldReturnListOfAllExperience() throws Exception {
    List<Experience> result = experienceService.findAll();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testUpdateWithExperienceServiceShouldReturnExperienceThatUpdate() throws Exception {
    Experience update = experienceService.findById(experience.getId());
    assertThat(update.getCompanyName(), is("PTT"));
    update.setCompanyName("DST");
    experienceService.update(update);

    Experience result = experienceService.findById(update.getId());
    assertThat(result.getCompanyName(), is("DST"));

  }

  @Test
  public void testDeleteWithExperienceServiceShouldNotFindThatExperience() throws Exception {
    Experience delete = experienceService.findById(experience.getId());
    experienceService.delete(delete);

    Experience result = experienceService.findById(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteByIdWithExperienceServiceShouldNotFindThatExperience() throws Exception {
    Experience delete = experienceService.findById(experience.getId());
    experienceService.deleteById(delete.getId());

    Experience result = experienceService.findById(delete.getId());
    assertNull(result);

  }

  @Test
  public void testFindExperienceByIdWithExperienceServiceShouldReturnListOfExperienceDtoOfThatApplicantId() throws Exception {
    List<ExperienceDto> result = experienceService.findExperienceById(experience.getApplicant().getId());
    assertNotNull(result);
    assertThat(result.get(0).getCompanyName(), is("PTT"));

  }

  @Test
  public void testFindExperienceWithExperienceServiceShouldReturnExperienceDtoOfThatExperienceId() throws Exception {
    ExperienceDto result = experienceService.findExperience(experience.getId());
    assertNotNull(result);
    assertThat(result.getCompanyName(), is("PTT"));
    assertThat(result.getSalary(), is((long) 20000));

  }

  @Test
  public void testSearchExperienceWithExperienceServiceShouldReturnListOfExperienceDtoOfThatEmployeeId() throws Exception {
    List<ExperienceDto> result = experienceService.searchExperience(employee.getId());
    assertNotNull(result);
    assertThat(result.get(0).getCompanyName(), is("PTT"));

  }
  
}