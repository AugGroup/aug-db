/**
 * @author Pranrajit
 * @date 4 ก.ย. 2558
 */
package com.aug.hrdb.services;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import com.aug.hrdb.dto.LanguageDto;
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
public class LanguageServiceTest {

  @Autowired
  private MasCoreSkillService masCoreSkillService;

  @Autowired
  private MasJobLevelService masJobLevelService;

  @Autowired
  private MasTechnologyService masTechnologyService;

  @Autowired
  private ApplicantService applicantService;

  @Autowired
  private MasDivisionService masDivisionService;

  @Autowired
  private EmployeeService employeeService;

  @Autowired
  private LanguageService languageService;

  private Language language;

  private Employee employee;

  @Before
  public void setAbility() {
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
    employee = new Employee();
    employee.setAuditFlag("C");
    employee.setCreatedBy(1);
    employee.setCreatedTimeStamp(Calendar.getInstance().getTime());
    employee.setEmployeeCode("TEST0001");
    employee.setStatusEmp("Employee");
    employee.setTelHome("02-9998877");
    employee.setApplicant(applicant);
    employee.setMasDivision(masDivision);
    employeeService.create(employee);

    // create language
    language = new Language();
    language.setAuditFlag("C");
    language.setCreatedBy(1);
    language.setCreatedTimeStamp(Calendar.getInstance().getTime());
    language.setNameLanguage("English");
    language.setApplicant(applicant);
    languageService.create(language);

  }

  @Test
  public void testLoadServicesShouldPass() throws Exception {
    assertNotNull(languageService);
    assertNotNull(masCoreSkillService);
    assertNotNull(masJobLevelService);
    assertNotNull(masTechnologyService);
    assertNotNull(applicantService);

  }

  @Test
  public void testFindWithLanguageServiceShouldReturnLanguageThatSetup() throws Exception {
    Language result = languageService.find(language.getId());
    assertNotNull(result);
    assertThat(result.getNameLanguage(), is("English"));

  }

  @Test
  public void testFindAllWithLanguageServiceShouldReturnListOfAllLanguage() throws Exception {
    List<Language> result = languageService.findAll();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testUpdateWithLanguageServiceShouldReturnLanguageThatUpdate() throws Exception {
    Language update = languageService.find(language.getId());
    assertThat(update.getNameLanguage(), is("English"));

    update.setNameLanguage("Chinese");
    languageService.update(update);

    Language result = languageService.find(update.getId());
    assertThat(result.getNameLanguage(), is("Chinese"));

  }

  @Test
  public void testDeleteWithLanguageServiceShouldNotFindThatLanguage() throws Exception {
    Language delete = languageService.find(language.getId());
    languageService.delete(delete);

    Language result = languageService.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteByIdWithLanguageServiceShouldNotFindThatLanguage() throws Exception {
    Language delete = languageService.find(language.getId());
    languageService.deleteById(delete.getId());

    Language result = languageService.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testFindLanguagesByIdWithLanguageServiceShouldReturnListOfLanguageDtoOfThatApplicantId() throws Exception {
    List<LanguageDto> result = languageService.findLanguagesById(language.getApplicant().getId());
    assertNotNull(result);
    assertThat(result.get(0).getNameLanguage(), is("English"));

  }

  @Test
  public void testFindByLanguagesIdWithLanguageServiceShouldReturnLanguageDtoOfThaLanguageId() throws Exception {
    LanguageDto result = languageService.findByLanguagesId(language.getId());
    assertNotNull(result);
    assertThat(result.getNameLanguage(), is("English"));

  }

  @Test
  public void testListLanguageByEmployeeWithLanguageServiceShouldReturnListOfLanguageDtoOfThatApplicantId() throws Exception {
    List<LanguageDto> result = languageService.listLanguageByEmployee(language.getApplicant().getId());
    assertNotNull(result);
    assertThat(result.get(0).getNameLanguage(), is("English"));

  }

  @Test
  public void testFindIdJoinEmployeeWithLanguageServiceShouldReturnLanguageOfThaLanguageId() throws Exception {
    Language result = languageService.findIdJoinEmployee(language.getId());
    assertNotNull(result);
    assertThat(result.getNameLanguage(), is("English"));

  }

  @Test
  public void testCheckLanguageNameWithLanguageServiceShouldReturnBoolean() throws Exception {
    Boolean result = languageService.checkLanguageName(language.getApplicant().getId(), language.getNameLanguage());
    assertThat(result, is(false));

    Boolean result2 = languageService.checkLanguageName(language.getApplicant().getId(), "Chinese");
    assertThat(result2, is(true));

  }

  @Test
  public void testSaveByFindEmployeeWithLanguageServiceShouldPass() throws Exception {
    LanguageDto languageDto = languageService.findByLanguagesId(language.getId());
    languageService.saveByFindEmployee(employee.getId(), languageDto);

  }

  @Test
  public void testFindLanguageEmployeeByIdWithLanguageServiceShouldReturnLanguageDtoOfThatLanguageId() throws Exception {
    LanguageDto result = languageService.findLanguageEmployeeById(language.getId());
    assertNotNull(result);
    assertThat(result.getNameLanguage(), is("English"));

  }

  @Test
  public void testUpdateSetLanguageWithLanguageServiceShouldPass() throws Exception {
    LanguageDto languageDto = languageService.findByLanguagesId(language.getId());
    assertNotNull(languageDto);
    assertThat(languageDto.getNameLanguage(), is("English"));

    languageDto.setNameLanguage("Chinese");
    languageService.updateSetLanguage(languageDto);

    Language result = languageService.find(languageDto.getId());
    assertNotNull(result);
    assertThat(result.getNameLanguage(), is("Chinese"));

  }

}