package com.aug.hrdb.repositories;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

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

import java.util.Calendar;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class LoginRepositoryTest {

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
  private MasLocationRepository masLocationRepository;

  @Autowired
  private LoginRepository loginRepository;

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
    applicant.setEmail("anat@testmail.com");
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

    //create mas location
    MasLocation masLocation = new MasLocation();
    masLocation.setAuditFlag("C");
    masLocation.setCreatedBy(1);
    masLocation.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masLocation.setCode("TH");
    masLocation.setName("Thailand");
    masLocation.setIsActive(true);
    masLocationRepository.create(masLocation);

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
    employeeRepository.create(employee);

    login = new Login();
    login.setAuditFlag("C");
    login.setCreatedBy(1);
    login.setCreatedTimeStamp(Calendar.getInstance().getTime());
    login.setUsername("test");
    login.setPassword("P@ssWord");
    login.setEmployee(employee);
    login.setMasLocation(employee.getMasLocation());
    loginRepository.create(login);

  }

  @Test
  public void testLoadRepositoriesShouldPass() throws Exception {
    assertNotNull(masCoreSkillRepository);
    assertNotNull(masJobLevelRepository);
    assertNotNull(masDivisionRepository);
    assertNotNull(masTechnologyRepository);
    assertNotNull(employeeRepository);
    assertNotNull(applicantRepository);
    assertNotNull(loginRepository);

  }

  @Test
  public void testFindWithLoginRepositoryShouldReturnLoginThatSetup() throws Exception {
    Login result = loginRepository.find(login.getId());
    assertNotNull(result);
    assertThat(result.getUsername(), is("test"));
    assertThat(result.getPassword(), is("P@ssWord"));

  }

  @Test
  public void testFindAllWithLoginRepositoryShouldReturnListOfAllLogin() throws Exception {
    List<Login> result = loginRepository.findAll();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testUpdateWithLoginRepositoryShouldReturnLoginThatUpdate() throws Exception {
    Login update = loginRepository.find(login.getId());
    assertThat(update.getUsername(), is("test"));
    assertThat(update.getPassword(), is("P@ssWord"));

    update.setPassword("passVVord");
    loginRepository.update(update);

    Login result = loginRepository.find(update.getId());
    assertThat(result.getPassword(), is("passVVord"));

  }

  @Test
  public void testDeleteWithLoginRepositoryShouldNotFindThatLogin() throws Exception {
    Login delete = loginRepository.find(login.getId());
    loginRepository.delete(delete);

    Login result = loginRepository.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteByIdWithLoginRepositoryShouldNotFindThatLogin() throws Exception {
    Login delete = loginRepository.find(login.getId());
    loginRepository.deleteById(delete.getId());

    Login result = loginRepository.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testFindByUserNameWithLoginRepositoryShouldReturnLoginOfThatUsername() throws Exception {
    Login result = loginRepository.findByUserName(login.getUsername());
    assertNotNull(result);
    assertThat(result.getPassword(), is("P@ssWord"));
    
  }

  @Test
  public void testSearchEmpIdToLoginWithLoginRepositoryShouldReturnLoginOfThatLastLogin() throws Exception {
    Login result = loginRepository.searchEmpIdToLogin();
    assertNotNull(result);
    assertThat(result.getUsername(), is("test"));
    assertThat(result.getPassword(), is("P@ssWord"));

  }

  @Test
  public void testFindPasswordByEmailWithLoginRepositoryShouldReturnLoginForgotDtoOfThatEmail() throws Exception {
    LoginForgotDto result = loginRepository.findPasswordByEmail("anat@testmail.com");
    assertNotNull(result);
    assertThat(result.getUsername(), is("test"));
    assertThat(result.getPassword(), is("P@ssWord"));

  }

}