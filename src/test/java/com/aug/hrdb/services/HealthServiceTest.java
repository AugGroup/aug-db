package com.aug.hrdb.services;

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
public class HealthServiceTest {

  @Autowired
  private MasLocationService masLocationService;

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
  private MasStaffTypeService masStaffTypeService;

  @Autowired
  private EmployeeService employeeService;

  @Autowired
  private HealthService healthService;

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
    applicant.setFirstNameEN("Anat");
    applicantService.create(applicant);

    Applicant applicant2 = new Applicant();
    applicant2.setAuditFlag("C");
    applicant2.setCreatedBy(1);
    applicant2.setCreatedTimeStamp(Calendar.getInstance().getTime());
    applicant2.setCoreSkill(masCoreSkillService.findById(masCoreSkill.getId()));
    applicant2.setJoblevel(masJobLevelService.findById(masJobLevel.getId()));
    applicant2.setTechnology(masTechnologyService.findById(masTechnology.getId()));
    applicant2.setFirstNameEN("Aim");
    applicantService.create(applicant2);

    // create mas division
    MasDivision masDivision = new MasDivision();
    masDivision.setAuditFlag("C");
    masDivision.setCreatedBy(1);
    masDivision.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masDivision.setIsActive(true);
    masDivision.setCode("ITS");
    masDivision.setName("Integrate Technology Services");
    masDivision.setTag("B");
    masDivisionService.create(masDivision);

    // create staff type
    MasStaffType masStaffType = new MasStaffType();
    masStaffType.setAuditFlag("C");
    masStaffType.setCreatedBy(1);
    masStaffType.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masStaffType.setName("Billable");
    masStaffType.setCode("01A");
    masStaffType.setIsActive(true);
    masStaffTypeService.create(masStaffType);

    //create mas location
    MasLocation masLocation = new MasLocation();
    masLocation.setAuditFlag("C");
    masLocation.setCreatedBy(1);
    masLocation.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masLocation.setCode("TH");
    masLocation.setName("Thailand");
    masLocation.setIsActive(true);
    masLocationService.create(masLocation);

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
    employeeService.create(aim);

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
    employeeService.create(employee);

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
    healthService.create(health);

  }

  @Test
  public void testLoadServicesShouldPass() throws Exception {
    assertNotNull(masCoreSkillService);
    assertNotNull(masJobLevelService);
    assertNotNull(masDivisionService);
    assertNotNull(masTechnologyService);
    assertNotNull(employeeService);
    assertNotNull(applicantService);
    assertNotNull(healthService);
    assertNotNull(masLocationService);
    assertNotNull(masStaffTypeService);

  }

  @Test
  public void testFindWithHealthServiceShouldReturnHealthThatSetup() throws Exception {
    Health result = healthService.find(health.getId());
    assertNotNull(result);
    assertThat(result.getCongenitalDisease(), is("Down syndrome"));
    assertThat(result.getGeneticDisease(), is("Cystic fibrosis"));

  }

  @Test
  public void testFindAllWithHealthServiceShouldReturnListOfAllHealth() throws Exception {
    List<Health> result = healthService.findAll();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testUpdateWithHealthServiceShouldReturnHealthThatUpdate() throws Exception {
    Health update = healthService.find(health.getId());
    assertThat(update.getCongenitalDisease(), is("Down syndrome"));
    update.setCongenitalDisease("Update");
    healthService.update(update);

    Health result = healthService.find(update.getId());
    assertThat(result.getCongenitalDisease(), is("Update"));

  }

  @Test
  public void testDeleteWithHealthServiceShouldNotFindThatHealth() throws Exception {
    Health delete = healthService.find(health.getId());
    healthService.delete(delete);

    Health result = healthService.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteByIdWithHealthServiceShouldNotFindThatHealth() throws Exception {
    Health delete = healthService.find(health.getId());
    healthService.deleteById(delete.getId());

    Health result = healthService.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testFindByIdReturnToDtoWithHealthServiceShouldReturnHealthDtoOfThatHealthId() throws Exception {
    HealthDto result = healthService.findByIdReturnToDto(health.getId());
    assertNotNull(result);
    assertThat(result.getCongenitalDisease(), is("Down syndrome"));
    assertThat(result.getGeneticDisease(), is("Cystic fibrosis"));

  }

  @Test
  public void testFindByEmployeeIdWithHealthServiceShouldReturnHealthDtoOfThatEmployeeId() throws Exception {
    HealthDto result = healthService.findByEmployeeId(health.getEmployee().getId());
    assertNotNull(result);
    assertThat(result.getCongenitalDisease(), is("Down syndrome"));
    assertThat(result.getGeneticDisease(), is("Cystic fibrosis"));

  }

  @Test
  public void testCreateSetDtoToEntityWithHealthServiceShouldReturnHealthOfThatHealthDto() throws Exception {
    HealthDto healthDto = healthService.findByIdReturnToDto(health.getId());
    assertThat(healthDto.getCongenitalDisease(), is("Down syndrome"));
    assertThat(healthDto.getGeneticDisease(), is("Cystic fibrosis"));

    Health result = healthService.createSetDtoToEntity(healthDto);
    assertThat(result.getCongenitalDisease(), is("Down syndrome"));
    assertThat(result.getGeneticDisease(), is("Cystic fibrosis"));

  }

  @Test
  public void testUpdateSetDtoToEntityWithHealthServiceShouldPass() throws Exception {
    HealthDto update = healthService.findByIdReturnToDto(health.getId());
    assertThat(update.getCongenitalDisease(), is("Down syndrome"));
    assertThat(update.getGeneticDisease(), is("Cystic fibrosis"));

    update.setCongenitalDisease("Update cog");
    healthService.updateSetDtoToEntity(update);

    Health result = healthService.find(update.getId());
    assertThat(result.getCongenitalDisease(), is("Update cog"));

  }

}