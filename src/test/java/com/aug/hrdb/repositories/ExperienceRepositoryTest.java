package com.aug.hrdb.repositories;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

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

import java.util.Calendar;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class ExperienceRepositoryTest {

  @Autowired
  private MasCoreSkillRepository masCoreSkillRepository;

  @Autowired
  private MasJobLevelRepository masJobLevelRepository;

  @Autowired
  private MasTechnologyRepository masTechnologyRepository;

  @Autowired
  private ApplicantRepository applicantRepository;

  @Autowired
  private MasDivisionRepository masDivisionRepository;

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private ExperienceRepository experienceRepository;

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
    employee = new Employee();
    employee.setAuditFlag("C");
    employee.setCreatedBy(1);
    employee.setCreatedTimeStamp(Calendar.getInstance().getTime());
    employee.setEmployeeCode("TEST0001");
    employee.setStatusEmp("Employee");
    employee.setTelHome("02-9998877");
    employee.setApplicant(applicant);
    employee.setMasDivision(masDivision);
    employeeRepository.create(employee);

    // create experience
    experience = new Experience();
    experience.setAuditFlag("C");
    experience.setCreatedBy(1);
    experience.setCreatedTimeStamp(Calendar.getInstance().getTime());
    experience.setCompanyName("PTT");
    experience.setSalary(20000);
    experience.setApplicant(applicant);
    experienceRepository.create(experience);

  }

  @Test
  public void testLoadRepositoriesShouldPass() throws Exception {
    assertNotNull(experienceRepository);
    assertNotNull(masCoreSkillRepository);
    assertNotNull(masJobLevelRepository);
    assertNotNull(masTechnologyRepository);
    assertNotNull(applicantRepository);
    assertNotNull(masDivisionRepository);
    assertNotNull(employeeRepository);

  }

  @Test
  public void testFindWithExperienceRepositoryShouldReturnExperienceThatSetup() throws Exception {
    Experience result = experienceRepository.find(experience.getId());
    assertNotNull(result);
    assertThat(result.getCompanyName(), is("PTT"));
    assertThat(result.getSalary(), is((long)20000));

  }

  @Test
  public void testFindAllWithExperienceRepositoryShouldReturnListOfAllExperience() throws Exception {
    List<Experience> result = experienceRepository.findAll();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testUpdateWithExperienceRepositoryShouldReturnExperienceThatUpdate() throws Exception {
    Experience update = experienceRepository.find(experience.getId());
    assertThat(update.getCompanyName(), is("PTT"));
    update.setCompanyName("DST");
    experienceRepository.update(update);

    Experience result = experienceRepository.find(update.getId());
    assertThat(result.getCompanyName(), is("DST"));

  }

  @Test
  public void testDeleteWithExperienceRepositoryShouldNotFindThatExperience() throws Exception {
    Experience delete = experienceRepository.find(experience.getId());
    experienceRepository.delete(delete);

    Experience result = experienceRepository.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteByIdWithExperienceRepositoryShouldNotFindThatExperience() throws Exception {
    Experience delete = experienceRepository.find(experience.getId());
    experienceRepository.deleteById(delete.getId());

    Experience result = experienceRepository.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testFindExperienceByIdWithExperienceRepositoryShouldReturnListOfExperienceDtoOfThatApplicantId() throws Exception {
    List<ExperienceDto> result = experienceRepository.findExperienceById(experience.getApplicant().getId());
    assertNotNull(result);
    assertThat(result.get(0).getCompanyName(), is("PTT"));

  }

  @Test
  public void testFindExperienceWithExperienceRepositoryShouldReturnExperienceDtoOfThatExperienceId() throws Exception {
    ExperienceDto result = experienceRepository.findExperience(experience.getId());
    assertNotNull(result);
    assertThat(result.getCompanyName(), is("PTT"));
    assertThat(result.getSalary(), is((long) 20000));

  }

  @Test
  public void testSearchExperienceWithExperienceRepositoryShouldReturnListOfExperienceDtoOfThatEmployeeId() throws Exception {
    List<ExperienceDto> result = experienceRepository.searchExperience(employee.getId());
    assertNotNull(result);
    assertThat(result.get(0).getCompanyName(), is("PTT"));

  }

}