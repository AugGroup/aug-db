package com.aug.hrdb.services;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import com.aug.hrdb.dto.ProbationDto;
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
public class ProbationServiceTest {

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
  private ProbationService probationService;

  private Probation probation;

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

    //create probation
    probation = new Probation();
    probation.setAuditFlag("C");
    probation.setCreatedBy(1);
    probation.setCreatedTimeStamp(Calendar.getInstance().getTime());
    probation.setDateFrom(Calendar.getInstance().getTime());
    probation.setDateTo(Calendar.getInstance().getTime());
    probation.setStatus("status");
    probation.setEmployee(employee);
    probationService.create(probation);

  }

  @Test
  public void testLoadRepositoriesShouldPass() throws Exception {
    assertNotNull(probationService);
    assertNotNull(masCoreSkillService);
    assertNotNull(masJobLevelService);
    assertNotNull(masDivisionService);
    assertNotNull(masTechnologyService);
    assertNotNull(employeeService);
    assertNotNull(applicantService);

  }

  @Test
  public void testFindWithProbationServiceShouldReturnProbationThatSetup() throws Exception {
    Probation result = probationService.find(probation.getId());
    assertNotNull(result);
    assertThat(result.getEmployee().getApplicant().getFirstNameEN(), is("Anat"));
    assertThat(result.getStatus(), is("status"));

  }

  @Test
  public void testFindAllWithProbationServiceShouldReturnListOfAllProbation() throws Exception {
    List<Probation> result = probationService.findAll();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testUpdateWithProbationServiceShouldReturnProbationThatUpdate() throws Exception {
    Probation update = probationService.find(probation.getId());
    assertThat(update.getEmployee().getApplicant().getFirstNameEN(), is("Anat"));
    assertThat(update.getStatus(), is("status"));

    update.setStatus("status update");
    probationService.update(update);

    Probation result = probationService.find(update.getId());
    assertThat(result.getStatus(), is("status update"));

  }

  @Test
  public void testDeleteWithProbationServiceShouldNotFindThatProbation() throws Exception {
    Probation delete = probationService.find(probation.getId());
    probationService.delete(delete);

    Probation result = probationService.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteByIdWithProbationServiceShouldNotFindThatProbation() throws Exception {
    Probation delete = probationService.find(probation.getId());
    probationService.deleteById(delete.getId());

    Probation result = probationService.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testSearchProbationWithProbationServiceShouldReturnListOfProbationDtoOfThatEmployeeId() throws Exception {
    List<ProbationDto> result = probationService.searchProbation(probation.getEmployee().getId());
    assertNotNull(result);
    assertThat(result.get(0).getStatus(), is("status"));
    assertThat(result.get(0).getEmployeeCode(), is(probation.getEmployee().getEmployeeCode()));

  }

}