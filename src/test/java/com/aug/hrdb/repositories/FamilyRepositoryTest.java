package com.aug.hrdb.repositories;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import com.aug.hrdb.dto.FamilyDto;
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
public class FamilyRepositoryTest {

  @Autowired
  private MasCoreSkillRepository masCoreSkillRepository;

  @Autowired
  private MasJobLevelRepository masJobLevelRepository;

  @Autowired
  private MasTechnologyRepository masTechnologyRepository;

  @Autowired
  private ApplicantRepository applicantRepository;

  @Autowired
  private MasRelationTypeRepository masRelationTypeRepository;

  @Autowired
  private FamilyRepository familyRepository;

  private Family family;

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


    // create family
    MasRelationType masRelationType = new MasRelationType();
    masRelationType.setAuditFlag("C");
    masRelationType.setCreatedBy(1);
    masRelationType.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masRelationType.setCode("00");
    masRelationType.setIsActive(true);
    masRelationType.setRelationType("Test");
    masRelationTypeRepository.create(masRelationType);

    family = new Family();
    family.setAuditFlag("C");
    family.setCreatedBy(1);
    family.setCreatedTimeStamp(Calendar.getInstance().getTime());
    family.setAddress("Home");
    family.setAge(50);
    family.setFamilyName("Dad");
    family.setGender("Male");
    family.setMobile("087-9876543");
    family.setApplicant(applicant);
    family.setMasRelationType(masRelationType);
    familyRepository.create(family);

  }

  @Test
  public void testLoadRepositoriesShouldPass() throws Exception {
    assertNotNull(familyRepository);
    assertNotNull(masCoreSkillRepository);
    assertNotNull(masJobLevelRepository);
    assertNotNull(masTechnologyRepository);
    assertNotNull(applicantRepository);
    assertNotNull(masRelationTypeRepository);

  }

  @Test
  public void testFindWithFamilyRepositoryShouldReturnFamilyThatSetup() throws Exception {
    Family result = familyRepository.find(family.getId());
    assertNotNull(result);
    assertThat(result.getFamilyName(), is("Dad"));
    assertThat(result.getAge(), is(50));
    assertThat(result.getApplicant().getFirstNameEN(), is("Anat"));

  }

  @Test
  public void testFindAllWithFamilyRepositoryShouldReturnListOfAllFamily() throws Exception {
    List<Family> result = familyRepository.findAll();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testUpdateWithFamilyRepositoryShouldReturnFamilyThatUpdate() throws Exception {
    Family update = familyRepository.find(family.getId());
    assertThat(update.getFamilyName(), is("Dad"));
    assertThat(update.getAge(), is(50));
    assertThat(update.getApplicant().getFirstNameEN(), is("Anat"));
    update.setFamilyName("Mom");
    familyRepository.update(update);

    Family result = familyRepository.find(update.getId());
    assertThat(result.getFamilyName(), is("Mom"));

  }

  @Test
  public void testDeleteWithFamilyRepositoryShouldNotFindThatFamily() throws Exception {
    Family delete = familyRepository.find(family.getId());
    familyRepository.delete(delete);

    Family result = familyRepository.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteByIdWithFamilyRepositoryShouldNotFindThatFamily() throws Exception {
    Family delete = familyRepository.find(family.getId());
    familyRepository.deleteById(delete.getId());

    Family result = familyRepository.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testFindFamilyByApplicantIdWithFamilyRepositoryShouldReturnListOfFamilyOfThatApplicantId() throws Exception {
    List<Family> result = familyRepository.findFamilyByApplicantId(family.getApplicant().getId());
    assertNotNull(result);
    assertThat(result.get(0).getApplicant().getFirstNameEN(), is("Anat"));
    assertThat(result.get(0).getFamilyName(), is("Dad"));
    assertThat(result.get(0).getAge(), is(50));

  }

  @Test
  public void testFindLastFamilyWithFamilyRepositoryShouldReturnLastFamilyOfThatApplicantId() throws Exception {
    Family result = familyRepository.findLastFamily(family.getId());
    assertNotNull(result);
    assertThat(result.getApplicant().getFirstNameEN(), is("Anat"));
    assertThat(result.getFamilyName(), is("Dad"));
    assertThat(result.getAge(), is(50));

  }

  @Test
  public void testFindFamilyListWithFamilyRepositoryShouldReturnListOfFamilyDtoOfThatApplicantId() throws Exception {
    List<FamilyDto> result = familyRepository.findFamilyList(family.getApplicant().getId());
    assertNotNull(result);
    assertThat(result.get(0).getFamilyName(), is("Dad"));
    assertThat(result.get(0).getAge(), is(50));

  }

  @Test
  public void testFindFamilyByIdWithFamilyRepositoryShouldReturnListOfFamilyDtoOfThatApplicantId() throws Exception {
    List<FamilyDto> result = familyRepository.findFamilyById(family.getApplicant().getId());
    assertNotNull(result);
    assertThat(result.get(0).getFamilyName(), is("Dad"));
    assertThat(result.get(0).getAge(), is(50));
    
  }

  @Test
  public void testFindFamilyWithFamilyRepositoryShouldReturnFamilyDtoOfThatFamilyId() throws Exception {
    FamilyDto result = familyRepository.findFamily(family.getId());
    assertNotNull(result);
    assertThat(result.getFamilyName(), is("Dad"));
    assertThat(result.getAge(), is(50));

  }

}