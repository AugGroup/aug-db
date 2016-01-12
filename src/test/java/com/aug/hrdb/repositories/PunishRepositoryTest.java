package com.aug.hrdb.repositories;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import com.aug.hrdb.dto.PunishDto;
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
public class PunishRepositoryTest {

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
  private PunishRepository punishRepository;

  private Punish punish;

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

    punish = new Punish();
    punish.setAuditFlag("C");
    punish.setCreatedBy(1);
    punish.setCreatedTimeStamp(Calendar.getInstance().getTime());
    punish.setDatePunish(Calendar.getInstance().getTime());
    punish.setDescription("DESC");
    punish.setPenalty("PENALTY");
    punish.setEmployee(employee);
    punishRepository.create(punish);

  }

  @Test
  public void testLoadRepositoriesShouldPass() throws Exception {
    assertNotNull(punishRepository);
    assertNotNull(masCoreSkillRepository);
    assertNotNull(masJobLevelRepository);
    assertNotNull(masDivisionRepository);
    assertNotNull(masTechnologyRepository);
    assertNotNull(employeeRepository);
    assertNotNull(applicantRepository);

  }

  @Test
  public void testFindWithPunishRepositoryShouldReturnPunishThatSetup() throws Exception {
    Punish result = punishRepository.find(punish.getId());
    assertNotNull(result);
    assertThat(result.getEmployee().getApplicant().getFirstNameEN(), is("Anat"));
    assertThat(result.getDescription(), is("DESC"));
    assertThat(result.getPenalty(), is("PENALTY"));

  }

  @Test
  public void testFindAllWithPunishRepositoryShouldReturnListOfAllPunish() throws Exception {
    List<Punish> result = punishRepository.findAll();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testUpdateWithPunishRepositoryShouldReturnPunishThatUpdate() throws Exception {
    Punish update = punishRepository.find(punish.getId());
    assertThat(update.getDescription(), is("DESC"));
    assertThat(update.getPenalty(), is("PENALTY"));

    update.setDescription("UPDATE DESC");
    punishRepository.update(update);

    Punish result = punishRepository.find(update.getId());
    assertThat(result.getDescription(), is("UPDATE DESC"));

  }

  @Test
  public void testDeleteWithPunishRepositoryShouldNotFindThatPunish() throws Exception {
    Punish delete = punishRepository.find(punish.getId());
    punishRepository.delete(delete);

    Punish result = punishRepository.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteByIdWithPunishRepositoryShouldNotFindThatPunish() throws Exception {
    Punish delete = punishRepository.find(punish.getId());
    punishRepository.deleteById(delete.getId());

    Punish result = punishRepository.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testFindByCriteriaWithPunishRepositoryShouldReturnListOfPunishOfThatDescription() throws Exception {
    List<Punish> result = punishRepository.findByCriteria(punish);
    assertNotNull(result);
    assertThat(result.get(0).getEmployee().getApplicant().getFirstNameEN(), is("Anat"));
    assertThat(result.get(0).getDescription(), is("DESC"));
    assertThat(result.get(0).getPenalty(), is("PENALTY"));

  }

  @Test
  public void testSearchPunishWithPunishRepositoryShouldReturnListOfPunishDtoOfThatEmployeeId() throws Exception {
    List<PunishDto> result = punishRepository.searchPunish(punish.getEmployee().getId());
    assertNotNull(result);
    assertThat(result.get(0).getDescription(), is("DESC"));
    assertThat(result.get(0).getPenalty(), is("PENALTY"));

  }

}