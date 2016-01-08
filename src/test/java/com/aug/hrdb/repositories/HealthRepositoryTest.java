package com.aug.hrdb.repositories;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import com.aug.hrdb.dto.HealthDto;
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
public class HealthRepositoryTest {

  @Autowired
  private MasLocationRepository masLocationRepository;

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
  private MasStaffTypeRepository masStaffTypeRepository;

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private HealthRepository healthRepository;

  private Health health;

  @Before
  public void setUp() {
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
    applicant.setFirstNameEN("Anat");
    applicantRepository.create(applicant);

    Applicant applicant2 = new Applicant();
    applicant2.setAuditFlag("C");
    applicant2.setCreatedBy(1);
    applicant2.setCreatedTimeStamp(Calendar.getInstance().getTime());
    applicant2.setCoreSkill(masCoreSkillRepository.find(masCoreSkill.getId()));
    applicant2.setJoblevel(masJobLevelRepository.find(masJobLevel.getId()));
    applicant2.setTechnology(masTechnologyRepository.find(masTechnology.getId()));
    applicant2.setFirstNameEN("Aim");
    applicantRepository.create(applicant2);

    // create mas division
    MasDivision masDivision = new MasDivision();
    masDivision.setAuditFlag("C");
    masDivision.setCreatedBy(1);
    masDivision.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masDivision.setIsActive(true);
    masDivision.setCode("ITS");
    masDivision.setName("Integrate Technology Services");
    masDivision.setTag("B");
    masDivisionRepository.create(masDivision);

    // create staff type
    MasStaffType masStaffType = new MasStaffType();
    masStaffType.setAuditFlag("C");
    masStaffType.setCreatedBy(1);
    masStaffType.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masStaffType.setName("Billable");
    masStaffType.setCode("01A");
    masStaffType.setIsActive(true);
    masStaffTypeRepository.create(masStaffType);

    //create mas location
    MasLocation masLocation = new MasLocation();
    masLocation.setAuditFlag("C");
    masLocation.setCreatedBy(1);
    masLocation.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masLocation.setCode("TH");
    masLocation.setName("Thailand");
    masLocation.setIsActive(true);
    masLocationRepository.create(masLocation);

    // create aim
    Employee aim = new Employee();
    aim.setAuditFlag("C");
    aim.setCreatedBy(1);
    aim.setCreatedTimeStamp(Calendar.getInstance().getTime());
    aim.setEmployeeCode("TEST9999");
    aim.setStatusEmp("Employee");
    aim.setTelHome("02-9999999");
    aim.setApplicant(applicant2);
    aim.setMasDivision(masDivision);
    aim.setMasStaffType(masStaffType);
    aim.setIsManager(1);
    aim.setMasLocation(masLocation);
    employeeRepository.create(aim);

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
    employee.setMasStaffType(masStaffType);
    employee.setAimEmpId(aim);
    employee.setMasLocation(masLocation);
    employeeRepository.create(employee);

    // create health
    health = new Health();
    health.setAuditFlag("C");
    health.setCreatedBy(1);
    health.setCreatedTimeStamp(Calendar.getInstance().getTime());
    health.setCongenitalDisease("Down syndrome");
    health.setGeneticDisease("Cystic fibrosis");
    health.setIntolerance("Penicillin");
    health.setTakeMedicine("Paracetamol");
    health.setEmployee(employee);
    healthRepository.create(health);

  }

  @Test
  public void testLoadRepositoriesShouldPass() throws Exception {
    assertNotNull(masCoreSkillRepository);
    assertNotNull(masJobLevelRepository);
    assertNotNull(masDivisionRepository);
    assertNotNull(masTechnologyRepository);
    assertNotNull(employeeRepository);
    assertNotNull(applicantRepository);
    assertNotNull(healthRepository);
    assertNotNull(masLocationRepository);
    assertNotNull(masStaffTypeRepository);

  }

  @Test
  public void testFindWithHealthRepositoryShouldReturnHealthThatSetup() throws Exception {
    Health result = healthRepository.find(health.getId());
    assertNotNull(result);
    assertThat(result.getCongenitalDisease(), is("Down syndrome"));
    assertThat(result.getGeneticDisease(), is("Cystic fibrosis"));

  }

  @Test
  public void testFindAllWithHealthRepositoryShouldReturnListOfAllHealth() throws Exception {
    List<Health> result = healthRepository.findAll();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testUpdateWithHealthRepositoryShouldReturnHealthThatUpdate() throws Exception {
    Health update = healthRepository.find(health.getId());
    assertThat(update.getCongenitalDisease(), is("Down syndrome"));
    update.setCongenitalDisease("Update");
    healthRepository.update(update);

    Health result = healthRepository.find(update.getId());
    assertThat(result.getCongenitalDisease(), is("Update"));

  }

  @Test
  public void testDeleteWithHealthRepositoryShouldNotFindThatHealth() throws Exception {
    Health delete = healthRepository.find(health.getId());
    healthRepository.delete(delete);

    Health result = healthRepository.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteByIdWithHealthRepositoryShouldNotFindThatHealth() throws Exception {
    Health delete = healthRepository.find(health.getId());
    healthRepository.deleteById(delete.getId());

    Health result = healthRepository.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testListHealthWithHealthRepositoryShouldReturnListOfHealthDtoOfThatEmployeeId() throws Exception {
    List<HealthDto> result = healthRepository.listHealth(health.getEmployee().getId());
    assertNotNull(result);
    assertThat(result.get(0).getCongenitalDisease(), is("Down syndrome"));
    assertThat(result.get(0).getGeneticDisease(), is("Cystic fibrosis"));

  }

  @Test
  public void testFindByEmployeeIdWithHealthRepositoryShouldReturnHealthOfThatEmployeeId() throws Exception {
    Health result = healthRepository.findByEmployeeId(health.getEmployee().getId());
    assertNotNull(result);
    assertThat(result.getCongenitalDisease(), is("Down syndrome"));
    assertThat(result.getGeneticDisease(), is("Cystic fibrosis"));

  }

}