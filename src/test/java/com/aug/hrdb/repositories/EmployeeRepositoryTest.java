package com.aug.hrdb.repositories;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import com.aug.hrdb.dto.*;
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
public class EmployeeRepositoryTest {

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

  private Employee employee, aim;

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
    aim = new Employee();
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
    employee = new Employee();
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

  }

  @Test
  public void testLoadRepositoriesShouldPass() throws Exception {
    assertNotNull(masCoreSkillRepository);
    assertNotNull(masJobLevelRepository);
    assertNotNull(masDivisionRepository);
    assertNotNull(masTechnologyRepository);
    assertNotNull(employeeRepository);
    assertNotNull(applicantRepository);
    
  }

  @Test
  public void testFindWithEmployeeRepositoryShouldReturnEmployeeThatSetup() throws Exception {
    Employee result = employeeRepository.find(employee.getId());
    assertNotNull(result);
    assertThat(result.getApplicant().getFirstNameEN(), is("Anat"));
    assertThat(result.getEmployeeCode(), is("TEST0001"));

  }

  @Test
  public void testFindAllWithEmployeeRepositoryShouldReturnListOfAllEmployee() throws Exception {
    List<Employee> result = employeeRepository.findAll();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testUpdateWithEmployeeRepositoryShouldReturnEmployeeThatUpdate() throws Exception {
    Employee update = employeeRepository.find(employee.getId());
    assertThat(update.getApplicant().getFirstNameEN(), is("Anat"));
    assertThat(update.getEmployeeCode(), is("TEST0001"));

    update.getApplicant().setFirstNameEN("Anattt");
    employeeRepository.update(update);

    Employee result = employeeRepository.find(update.getId());
    assertThat(result.getApplicant().getFirstNameEN(), is("Anattt"));

  }

  @Test
  public void testDeleteWithEmployeeRepositoryShouldNotFindThatEmployee() throws Exception {
    Employee delete = employeeRepository.find(employee.getId());
    employeeRepository.delete(delete);

    Employee result = employeeRepository.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteByIdWithEmployeeRepositoryShouldNotFindThatEmployee() throws Exception {
    Employee delete = employeeRepository.find(employee.getId());
    employeeRepository.deleteById(delete.getId());

    Employee result = employeeRepository.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testFindByCriteriaWithEmployeeRepositoryShouldReturnListOfEmployeeOfThatFirstNameEn() throws Exception {
    List<Employee> result = employeeRepository.findByCriteria(employee);
    assertNotNull(result);
    assertThat(result.get(0).getApplicant().getFirstNameEN(), is("Anat"));

  }

  @Test
  public void testSearchEmployeeWithEmployeeRepositoryShouldReturnListOfEmployeeListDto() throws Exception {
    List<EmployeeListDto> result = employeeRepository.searchEmployee();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testListEmployeeAimWithEmployeeRepositoryShouldReturnListOfAimEmployeeDto() throws Exception {
    List<AimEmployeeDto> result = employeeRepository.listEmployeeAim();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testSearchEmpIdToAddressWithEmployeeRepositoryShouldReturnLastCreateEmployee() throws Exception {
    Employee result = employeeRepository.searchEmpIdToAddress();
    assertNotNull(result);
    assertThat(result.getApplicant().getFirstNameEN(), is("Anat"));
    assertThat(result.getEmployeeCode(), is("TEST0001"));

  }

  @Test
  public void testReportEmployeeWithEmployeeRepositoryShouldReturnListOfReportEmployeeDTOOfThatName() throws Exception {
    List<ReportEmployeeDto> result = employeeRepository.reportEmployee(employee.getApplicant().getFirstNameEN());
    assertNotNull(result);
    assertThat(result.get(0).getNameEng(), is("Anat"));

  }

  @Test
  public void testReportStatusEmployeeWithEmployeeRepositoryShouldReturnListOfReportStatusEmployeeDtoOfThatStatusStaff() throws Exception {
    List<ReportStatusEmployeeDto> result = employeeRepository.reportStatusEmployee(employee.getMasStaffType().getName());
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(2)));
    assertThat(result.get(0).getStatusStaff(), is("Billable"));

  }

//  wait leave
//  @Test
//  public void testReportLeaveWithEmployeeRepositoryShouldReturnListOfReportLeaveDTOOfThatNameEng() throws Exception {
//
//  }

  @Test
  public void testFindCurrentIdWithEmployeeRepositoryShouldReturnLastCreateEmployee() throws Exception {
    EmployeeIdDto result = employeeRepository.findCurrentId();
    assertNotNull(result);
    assertThat(result.getId(), is(employee.getId()));

  }

//  wait official and site
//  @Test
//  public void testFindEmployeeAndOfficialWithEmployeeRepositoryShouldReturnEmployeeThatId() throws Exception {
//
//  }

  @Test
  public void testFindAimRelateWithEmployeeRepositoryShouldReturnListOfEmployeeOfThatAim() throws Exception {
    List<Employee> result = employeeRepository.findAimRelateWithEmployee(aim.getId());
    assertNotNull(result);
    assertThat(result.get(0).getApplicant().getFirstNameEN(), is("Anat"));
    assertThat(result.get(0).getEmployeeCode(), is("TEST0001"));
  }

  @Test
  public void testFindByNameWithEmployeeRepositoryShouldReturnListOfReportEmployeeDtoOfThatName() throws Exception {
    List<ReportEmployeeDto> result = employeeRepository.findByName(employee);
    assertNotNull(result);
    assertThat(result.get(0).getNameEng(), is("Anat"));
    assertThat(result.get(0).getEmployeeCode(), is("TEST0001"));

  }

//  wait official and site
//  @Test
//  public void testFindByNameStatusWithEmployeeShouldReturnListOfReportStatusEmployeeDtoOfThatName() throws Exception {
//
//  }

//  wait official
//  @Test
//  public void testReportEmployeeCodeWithEmployeeRepositoryShouldReturnListOfReportEmployeeDtoOfThatCode() throws Exception {
//
//  }

//  not clear
//  @Test
//  public void testListEmployeeAimForUpdateWithEmployeeRepositoryShouldReturnListOfAimEmployeeDtoOFThatEmployeeId() throws Exception {
//
//  }

//  not clear
//  @Test
//  public void testSearchEmpForUniqueIdCardWithEmployeeRepositoryShouldReturnListOfEmployeeListDto() throws Exception {
//
//  }


  @Test
  public void testFindEmployeeCodeWithEmployeeRepositoryShouldReturnListOfEmployeeCodeDtoOfThatLocationId() throws Exception {
    List<EmployeeCodeDto> result = employeeRepository.findEmployeeCode(employee.getMasLocation().getId());
    assertNotNull(result);
    assertThat(result.get(0).getEmployeeCode(), is("TEST0001"));

  }

  @Test
  public void testCheckTagWithEmployeeRepositoryShouldReturnListOfDivisionDtoOfThatTag() throws Exception {
    List<DivisionDto> result = employeeRepository.checkTag(employee.getMasDivision().getTag());
    assertNotNull(result);
    assertThat(result.get(0).getTag(), is("B"));

  }

  @Test
  public void testCheckTagDivisionWithEmployeeRepositoryShouldReturnListOfJobLevelDtoOfThatTagDivision() throws Exception {
    List<JoblevelDto> result = employeeRepository.checkTagDivision(employee.getMasDivision().getTag());
    assertNotNull(result);
    assertThat(result.get(0).getTagDivision(), is("B"));

  }

  @Test
  public void testFindByIdDivisionWithEmployeeRepositoryShouldReturnTagOfThatId() throws Exception {
    String result = employeeRepository.findByIdDivision(employee.getMasDivision().getId());
    assertThat(result, is("B"));

  }

}
