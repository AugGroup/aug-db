package com.aug.hrdb.services;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class EmployeeServiceTest {

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
    masCoreSkillService.create(masCoreSkill);

    MasJobLevel masJobLevel = new MasJobLevel();
    masJobLevel.setAuditFlag("C");
    masJobLevel.setCreatedBy(1);
    masJobLevel.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masJobLevel.setIsActive(true);
    masJobLevel.setCode("C");
    masJobLevel.setTagDivision("B");
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
    applicant.setImage("image.png");
    applicantService.create(applicant);

    Applicant applicant2 = new Applicant();
    applicant2.setAuditFlag("C");
    applicant2.setCreatedBy(1);
    applicant2.setCreatedTimeStamp(Calendar.getInstance().getTime());
    applicant2.setCoreSkill(masCoreSkillService.findById(masCoreSkill.getId()));
    applicant2.setJoblevel(masJobLevelService.findById(masJobLevel.getId()));
    applicant2.setTechnology(masTechnologyService.findById(masTechnology.getId()));
    applicant2.setFirstNameEN("Aim");
    applicant2.setImage("image.png");
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
    employeeService.create(aim);

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
    employeeService.create(employee);

  }

  @Test
  public void testLoadServicesShouldPass() throws Exception {
    assertNotNull(masCoreSkillService);
    assertNotNull(masJobLevelService);
    assertNotNull(masDivisionService);
    assertNotNull(masTechnologyService);
    assertNotNull(employeeService);
    assertNotNull(applicantService);

  }

  @Test
  public void testFindWithEmployeeServiceShouldReturnEmployeeThatSetup() throws Exception {
    Employee result = employeeService.findById(employee.getId());
    assertNotNull(result);
    assertThat(result.getApplicant().getFirstNameEN(), is("Anat"));
    assertThat(result.getEmployeeCode(), is("TEST0001"));

  }

  @Test
  public void testFindAllWithEmployeeServiceShouldReturnListOfAllEmployee() throws Exception {
    List<Employee> result = employeeService.findAll();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testUpdateWithEmployeeServiceShouldReturnEmployeeThatUpdate() throws Exception {
    Employee update = employeeService.findById(employee.getId());
    assertThat(update.getApplicant().getFirstNameEN(), is("Anat"));
    assertThat(update.getEmployeeCode(), is("TEST0001"));

    update.getApplicant().setFirstNameEN("Anattt");
    employeeService.update(update);

    Employee result = employeeService.findById(update.getId());
    assertThat(result.getApplicant().getFirstNameEN(), is("Anattt"));

  }

  @Test
  public void testDeleteWithEmployeeServiceShouldNotFindThatEmployee() throws Exception {
    Employee delete = employeeService.findById(employee.getId());
    employeeService.delete(delete);

    Employee result = employeeService.findById(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteByIdWithEmployeeServiceShouldNotFindThatEmployee() throws Exception {
    Employee delete = employeeService.findById(employee.getId());
    employeeService.deleteById(delete.getId());

    Employee result = employeeService.findById(delete.getId());
    assertNull(result);

  }

  @Test
  public void testFindByCriteriaWithEmployeeServiceShouldReturnListOfEmployeeOfThatFirstNameEn() throws Exception {
    List<Employee> result = employeeService.findByCriteria(employee);
    assertNotNull(result);
    assertThat(result.get(0).getApplicant().getFirstNameEN(), is("Anat"));

  }

  @Test
  public void testSearchEmployeeWithEmployeeServiceShouldReturnListOfEmployeeListDto() throws Exception {
    List<EmployeeListDto> result = employeeService.searchEmployee();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testListEmployeeAimWithEmployeeServiceShouldReturnListOfAimEmployeeDto() throws Exception {
    List<AimEmployeeDto> result = employeeService.listEmployeeAim();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testSearchEmpIdToAddressWithEmployeeServiceShouldReturnLastCreateEmployee() throws Exception {
    Employee result = employeeService.searchEmpIdToAddress();
    assertNotNull(result);
    assertThat(result.getApplicant().getFirstNameEN(), is("Anat"));
    assertThat(result.getEmployeeCode(), is("TEST0001"));

  }

  @Test
  public void testReportEmployeeWithEmployeeServiceShouldReturnListOfReportEmployeeDTOOfThatName() throws Exception {
    List<ReportEmployeeDto> result = employeeService.reportEmployee(employee.getApplicant().getFirstNameEN());
    assertNotNull(result);
    assertThat(result.get(0).getNameEng(), is("Anat"));

  }

  @Test
  public void testReportStatusEmployeeWithEmployeeServiceShouldReturnListOfReportStatusEmployeeDtoOfThatStatusStaff() throws Exception {
    List<ReportStatusEmployeeDto> result = employeeService.reportStatusEmployee(employee.getMasStaffType().getName());
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(2)));
    assertThat(result.get(0).getStatusStaff(), is("Billable"));

  }

//  wait leave
//  @Test
//  public void testReportLeaveWithEmployeeServiceShouldReturnListOfReportLeaveDTOOfThatNameEng() throws Exception {
//
//  }

  @Test
  public void testFindCurrentIdWithEmployeeServiceShouldReturnLastCreateEmployee() throws Exception {
    EmployeeIdDto result = employeeService.findCurrentId();
    assertNotNull(result);
    assertThat(result.getId(), is(employee.getId()));

  }

//  wait official and site
//  @Test
//  public void testFindEmployeeAndOfficialWithEmployeeServiceShouldReturnEmployeeThatId() throws Exception {
//
//  }

  @Test
  public void testFindAimRelateWithEmployeeServiceShouldReturnListOfEmployeeOfThatAim() throws Exception {
    List<Employee> result = employeeService.findAimRelateWithEmployee(aim.getId());
    assertNotNull(result);
    assertThat(result.get(0).getApplicant().getFirstNameEN(), is("Anat"));
    assertThat(result.get(0).getEmployeeCode(), is("TEST0001"));
  }

  @Test
  public void testFindByNameWithEmployeeServiceShouldReturnListOfReportEmployeeDtoOfThatName() throws Exception {
    List<ReportEmployeeDto> result = employeeService.findByName(employee);
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
//  public void testReportEmployeeCodeWithEmployeeServiceShouldReturnListOfReportEmployeeDtoOfThatCode() throws Exception {
//
//  }

//  not clear
//  @Test
//  public void testListEmployeeAimForUpdateWithEmployeeServiceShouldReturnListOfAimEmployeeDtoOFThatEmployeeId() throws Exception {
//
//  }

//  not clear
//  @Test
//  public void testSearchEmpForUniqueIdCardWithEmployeeServiceShouldReturnListOfEmployeeListDto() throws Exception {
//
//  }


  @Test
  public void testFindEmployeeCodeWithEmployeeServiceShouldReturnListOfEmployeeCodeDtoOfThatLocationId() throws Exception {
    List<EmployeeCodeDto> result = employeeService.findEmployeeCode(employee.getMasLocation().getId());
    assertNotNull(result);
    assertThat(result.get(0).getEmployeeCode(), is("TEST0001"));

  }

  @Test
  public void testCheckTagWithEmployeeServiceShouldReturnListOfDivisionDtoOfThatTag() throws Exception {
    List<DivisionDto> result = employeeService.checkTag(employee.getMasDivision().getTag());
    assertNotNull(result);
    assertThat(result.get(0).getTag(), is("B"));

  }

  @Test
  public void testCheckTagDivisionWithEmployeeServiceShouldReturnListOfJobLevelDtoOfThatTagDivision() throws Exception {
    List<JoblevelDto> result = employeeService.checkTagDivision(employee.getApplicant().getJobLevel().getTagDivision());
    assertNotNull(result);
    assertThat(result.get(0).getTagDivision(), is("B"));

  }

  @Test
  public void testFindByIdDivisionWithEmployeeServiceShouldReturnTagOfThatId() throws Exception {
    String result = employeeService.findByIdDivision(employee.getMasDivision().getId());
    assertThat(result, is("B"));

  }

  @Test
  public void testFindEmployeeByEmployeeIdWithSetToDtoWithEmployeeServiceShouldReturnEmployeeDtoOfThatId() throws Exception {
    EmployeeDto result = employeeService.findEmployeeByEmployeeIdWithSetToDto(employee.getId());
    assertNotNull(result);
    assertThat(result.getNameEng(), is("Anat"));

  }

//  wait official
//  @Test
//  public void testUpdateEmployeeAndReturnIdShouldReturnEmployeeOfThatEmployeeDto() throws Exception {
//    EmployeeDto employeeDto = employeeService.findEmployeeByEmployeeIdWithSetToDto(employee.getId());
//    Employee result = employeeService.updateEmployeeAndReturnId(employeeDto);
//    assertNotNull(result);
//    assertThat(result.getApplicant().getFirstNameEN(), is("Anat"));
//
//  }

//  wait official and leaves
//  @Test
//  public void testFindAndInitializeOfficialWithEmployeeServiceShouldReturnEmployeeOfThatId() throws Exception {
//
//  }

//  wait fix
//  @Test
//  public void testGenerateEmployeeCodeWithEmployeeServiceShouldReturnNewEmployeeCode() throws Exception {
//    EmployeeDto employeeDto = employeeService.findEmployeeByEmployeeIdWithSetToDto(employee.getId());
//    String result = employeeService.generateEmployeeCode(employeeDto);
//    assertThat(Integer.parseInt(result), is(Integer.parseInt(employeeDto.getEmployeeCode()) + 1));
//
//  }

//  wait fix
//  @Test
//  public void testGenerateEmployeeCodeFixDataWithEmployeeServiceShouldReturnNewEmployeeCode() throws Exception {
//
//  }

}