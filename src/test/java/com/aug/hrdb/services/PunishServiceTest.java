package com.aug.hrdb.services;

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
public class PunishServiceTest {

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
  private PunishService punishService;

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

    punish = new Punish();
    punish.setAuditFlag("C");
    punish.setCreatedBy(1);
    punish.setCreatedTimeStamp(Calendar.getInstance().getTime());
    punish.setDatePunish(Calendar.getInstance().getTime());
    punish.setDescription("DESC");
    punish.setPenalty("PENALTY");
    punish.setEmployee(employee);
    punishService.create(punish);

  }

  @Test
  public void testLoadServicesShouldPass() throws Exception {
    assertNotNull(punishService);
    assertNotNull(masCoreSkillService);
    assertNotNull(masJobLevelService);
    assertNotNull(masDivisionService);
    assertNotNull(masTechnologyService);
    assertNotNull(employeeService);
    assertNotNull(applicantService);

  }

  @Test
  public void testFindWithPunishServiceShouldReturnPunishThatSetup() throws Exception {
    Punish result = punishService.findById(punish.getId());
    assertNotNull(result);
    assertThat(result.getEmployee().getApplicant().getFirstNameEN(), is("Anat"));
    assertThat(result.getDescription(), is("DESC"));
    assertThat(result.getPenalty(), is("PENALTY"));

  }

  @Test
  public void testFindAllWithPunishServiceShouldReturnListOfAllPunish() throws Exception {
    List<Punish> result = punishService.findAll();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testUpdateWithPunishServiceShouldReturnPunishThatUpdate() throws Exception {
    Punish update = punishService.findById(punish.getId());
    assertThat(update.getDescription(), is("DESC"));
    assertThat(update.getPenalty(), is("PENALTY"));

    update.setDescription("UPDATE DESC");
    punishService.update(update);

    Punish result = punishService.findById(update.getId());
    assertThat(result.getDescription(), is("UPDATE DESC"));

  }

  @Test
  public void testDeleteWithPunishServiceShouldNotFindThatPunish() throws Exception {
    Punish delete = punishService.findById(punish.getId());
    punishService.delete(delete);

    Punish result = punishService.findById(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteByIdWithPunishServiceShouldNotFindThatPunish() throws Exception {
    Punish delete = punishService.findById(punish.getId());
    punishService.deleteById(delete.getId());

    Punish result = punishService.findById(delete.getId());
    assertNull(result);

  }

  @Test
  public void testFindByCriteriaWithPunishServiceShouldReturnListOfPunishOfThatDescription() throws Exception {
    List<Punish> result = punishService.findByCriteria(punish);
    assertNotNull(result);
    assertThat(result.get(0).getEmployee().getApplicant().getFirstNameEN(), is("Anat"));
    assertThat(result.get(0).getDescription(), is("DESC"));
    assertThat(result.get(0).getPenalty(), is("PENALTY"));

  }

  @Test
  public void testSearchPunishWithPunishServiceShouldReturnListOfPunishDtoOfThatEmployeeId() throws Exception {
    List<PunishDto> result = punishService.searchPunish(punish.getEmployee().getId());
    assertNotNull(result);
    assertThat(result.get(0).getDescription(), is("DESC"));
    assertThat(result.get(0).getPenalty(), is("PENALTY"));

  }

}