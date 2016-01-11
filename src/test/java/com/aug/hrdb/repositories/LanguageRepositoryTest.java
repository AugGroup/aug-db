/**
 * @author Pranrajit
 * @date 4 ก.ย. 2558
 */
package com.aug.hrdb.repositories;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class LanguageRepositoryTest {

  @Autowired
  private MasCoreSkillRepository masCoreSkillRepository;

  @Autowired
  private MasJobLevelRepository masJobLevelRepository;

  @Autowired
  private MasTechnologyRepository masTechnologyRepository;

  @Autowired
  private ApplicantRepository applicantRepository;

  @Autowired
  private  MasDivisionRepository masDivisionRepository;

  @Autowired
  private  EmployeeRepository employeeRepository;

  @Autowired
  private LanguageRepository languageRepository;

  private Language language;

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

    // create language
    language = new Language();
    language.setAuditFlag("C");
    language.setCreatedBy(1);
    language.setCreatedTimeStamp(Calendar.getInstance().getTime());
    language.setNameLanguage("English");
    language.setApplicant(applicant);
    languageRepository.create(language);

  }

  @Test
  public void testLoadRepositoriesShouldPass() throws Exception {
    assertNotNull(languageRepository);
    assertNotNull(masCoreSkillRepository);
    assertNotNull(masJobLevelRepository);
    assertNotNull(masTechnologyRepository);
    assertNotNull(applicantRepository);

  }

  @Test
  public void testFindWithLanguageRepositoryShouldReturnLanguageThatSetup() throws Exception {
    Language result = languageRepository.find(language.getId());
    assertNotNull(result);
    assertThat(result.getNameLanguage(), is("English"));

  }

  @Test
  public void testFindAllWithLanguageRepositoryShouldReturnListOfAllLanguage() throws Exception {
    List<Language> result = languageRepository.findAll();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testUpdateWithLanguageRepositoryShouldReturnLanguageThatUpdate() throws Exception {
    Language update = languageRepository.find(language.getId());
    assertThat(update.getNameLanguage(), is("English"));

    update.setNameLanguage("Chinese");
    languageRepository.update(update);

    Language result = languageRepository.find(update.getId());
    assertThat(result.getNameLanguage(), is("Chinese"));

  }

  @Test
  public void testDeleteWithLanguageRepositoryShouldNotFindThatLanguage() throws Exception {
    Language delete = languageRepository.find(language.getId());
    languageRepository.delete(delete);

    Language result = languageRepository.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteByIdWithLanguageRepositoryShouldNotFindThatLanguage() throws Exception {
    Language delete = languageRepository.find(language.getId());
    languageRepository.deleteById(delete.getId());

    Language result = languageRepository.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testFindLanguagesByIdWithLanguageRepositoryShouldReturnListOfLanguageDtoOfThatApplicantId() throws Exception {
    List<LanguageDto> result = languageRepository.findLanguagesById(language.getApplicant().getId());
    assertNotNull(result);
    assertThat(result.get(0).getNameLanguage(), is("English"));

  }

  @Test
  public void testFindByLanguagesIdWithLanguageRepositoryShouldReturnLanguageDtoOfThaLanguageId() throws Exception {
    LanguageDto result = languageRepository.findByLanguagesId(language.getId());
    assertNotNull(result);
    assertThat(result.getNameLanguage(), is("English"));

  }

  @Test
  public void testListLanguageByEmployeeWithLanguageRepositoryShouldReturnListOfLanguageDtoOfThatApplicantId() throws Exception {
    List<LanguageDto> result = languageRepository.listLanguageByEmployee(language.getApplicant().getId());
    assertNotNull(result);
    assertThat(result.get(0).getNameLanguage(), is("English"));

  }

  @Test
  public void testFindIdJoinEmployeeWithLanguageRepositoryShouldReturnLanguageOfThaLanguageId() throws Exception {
    Language result = languageRepository.findIdJoinEmployee(language.getId());
    assertNotNull(result);
    assertThat(result.getNameLanguage(), is("English"));

  }

  @Test
  public void testCheckLanguageNameWithLanguageRepositoryShouldReturnBoolean() throws Exception {
    Boolean result = languageRepository.checkLanguageName(language.getApplicant().getId(), language.getNameLanguage());
    assertThat(result, is(false));

    Boolean result2 = languageRepository.checkLanguageName(language.getApplicant().getId(), "Chinese");
    assertThat(result2, is(true));

  }

}