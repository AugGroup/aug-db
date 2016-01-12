package com.aug.hrdb.repositories;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

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

import java.util.Calendar;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class ProbationRepositoryTest {

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
  private ProbationRepository probationRepository;

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

    //create probation
    probation = new Probation();
    probation.setAuditFlag("C");
    probation.setCreatedBy(1);
    probation.setCreatedTimeStamp(Calendar.getInstance().getTime());
    probation.setDateFrom(Calendar.getInstance().getTime());
    probation.setDateTo(Calendar.getInstance().getTime());
    probation.setStatus("status");
    probation.setEmployee(employee);
    probationRepository.create(probation);

  }

  @Test
  public void testLoadRepositoriesShouldPass() throws Exception {
    assertNotNull(probationRepository);
    assertNotNull(masCoreSkillRepository);
    assertNotNull(masJobLevelRepository);
    assertNotNull(masDivisionRepository);
    assertNotNull(masTechnologyRepository);
    assertNotNull(employeeRepository);
    assertNotNull(applicantRepository);

  }

  @Test
  public void testFindWithProbationRepositoryShouldReturnProbationThatSetup() throws Exception {
    Probation result = probationRepository.find(probation.getId());
    assertNotNull(result);
    assertThat(result.getEmployee().getApplicant().getFirstNameEN(), is("Anat"));
    assertThat(result.getStatus(), is("status"));

  }

  @Test
  public void testFindAllWithProbationRepositoryShouldReturnListOfAllProbation() throws Exception {
    List<Probation> result = probationRepository.findAll();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testUpdateWithProbationRepositoryShouldReturnProbationThatUpdate() throws Exception {
    Probation update = probationRepository.find(probation.getId());
    assertThat(update.getEmployee().getApplicant().getFirstNameEN(), is("Anat"));
    assertThat(update.getStatus(), is("status"));

    update.setStatus("status update");
    probationRepository.update(update);

    Probation result = probationRepository.find(update.getId());
    assertThat(result.getStatus(), is("status update"));

  }

  @Test
  public void testDeleteWithProbationRepositoryShouldNotFindThatProbation() throws Exception {
    Probation delete = probationRepository.find(probation.getId());
    probationRepository.delete(delete);

    Probation result = probationRepository.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteByIdWithProbationRepositoryShouldNotFindThatProbation() throws Exception {
    Probation delete = probationRepository.find(probation.getId());
    probationRepository.deleteById(delete.getId());

    Probation result = probationRepository.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testSearchProbationWithProbationRepositoryShouldReturnListOfProbationDtoOfThatEmployeeId() throws Exception {
    List<ProbationDto> result = probationRepository.searchProbation(probation.getEmployee().getId());
    assertNotNull(result);
    assertThat(result.get(0).getStatus(), is("status"));
    assertThat(result.get(0).getEmployeeCode(), is(probation.getEmployee().getEmployeeCode()));

  }

}