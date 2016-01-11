package com.aug.hrdb.services;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import com.aug.hrdb.dto.LoginForgotDto;
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
public class LoginServiceTest {


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
  private MasLocationService masLocationService;

  @Autowired
  private LoginService loginService;

  private Login login;

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
    applicant.setEmail("anat@testmail.com");
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

    //create mas location
    MasLocation masLocation = new MasLocation();
    masLocation.setAuditFlag("C");
    masLocation.setCreatedBy(1);
    masLocation.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masLocation.setCode("TH");
    masLocation.setName("Thailand");
    masLocation.setIsActive(true);
    masLocationService.create(masLocation);

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
    employee.setMasLocation(masLocation);
    employeeService.create(employee);

    login = new Login();
    login.setAuditFlag("C");
    login.setCreatedBy(1);
    login.setCreatedTimeStamp(Calendar.getInstance().getTime());
    login.setUsername("test");
    login.setPassword("P@ssWord");
    login.setEmployee(employee);
    login.setMasLocation(employee.getMasLocation());
    loginService.create(login);

  }

  @Test
  public void testLoadRepositoriesShouldPass() throws Exception {
    assertNotNull(masCoreSkillService);
    assertNotNull(masJobLevelService);
    assertNotNull(masDivisionService);
    assertNotNull(masTechnologyService);
    assertNotNull(employeeService);
    assertNotNull(applicantService);
    assertNotNull(loginService);

  }

  @Test
  public void testFindWithLoginServiceShouldReturnLoginThatSetup() throws Exception {
    Login result = loginService.find(login.getId());
    assertNotNull(result);
    assertThat(result.getUsername(), is("test"));
    assertThat(result.getPassword(), is("P@ssWord"));

  }

  @Test
  public void testFindAllWithLoginServiceShouldReturnListOfAllLogin() throws Exception {
    List<Login> result = loginService.findAll();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testUpdateWithLoginServiceShouldReturnLoginThatUpdate() throws Exception {
    Login update = loginService.find(login.getId());
    assertThat(update.getUsername(), is("test"));
    assertThat(update.getPassword(), is("P@ssWord"));

    update.setPassword("passVVord");
    loginService.update(update);

    Login result = loginService.find(update.getId());
    assertThat(result.getPassword(), is("passVVord"));

  }

  @Test
  public void testDeleteWithLoginServiceShouldNotFindThatLogin() throws Exception {
    Login delete = loginService.find(login.getId());
    loginService.delete(delete);

    Login result = loginService.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteByIdWithLoginServiceShouldNotFindThatLogin() throws Exception {
    Login delete = loginService.find(login.getId());
    loginService.deleteById(delete.getId());

    Login result = loginService.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testFindByUserNameWithLoginServiceShouldReturnLoginOfThatUsername() throws Exception {
    Login result = loginService.findByUserName(login.getUsername());
    assertNotNull(result);
    assertThat(result.getPassword(), is("P@ssWord"));

  }

  @Test
  public void testSearchEmpIdToLoginWithLoginServiceShouldReturnLoginOfThatLastLogin() throws Exception {
    Login result = loginService.searchEmpIdToLogin();
    assertNotNull(result);
    assertThat(result.getUsername(), is("test"));
    assertThat(result.getPassword(), is("P@ssWord"));

  }

  @Test
  public void testFindPasswordByEmailWithLoginServiceShouldReturnLoginForgotDtoOfThatEmail() throws Exception {
    LoginForgotDto result = loginService.findPasswordByEmail("anat@testmail.com");
    assertNotNull(result);
    assertThat(result.getUsername(), is("test"));
    assertThat(result.getPassword(), is("P@ssWord"));

  }

}