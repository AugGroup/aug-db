package com.aug.hrdb.services;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

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

import com.aug.hrdb.dto.FamilyDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class FamilyServiceTest {

  @Autowired
  private MasCoreSkillService masCoreSkillService;

  @Autowired
  private MasJobLevelService masJobLevelService;

  @Autowired
  private MasTechnologyService masTechnologyService;

  @Autowired
  private ApplicantService applicantService;

  @Autowired
  private MasRelationTypeService masRelationTypeService;

  @Autowired
  private FamilyService familyService;

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


    // create family
    MasRelationType masRelationType = new MasRelationType();
    masRelationType.setAuditFlag("C");
    masRelationType.setCreatedBy(1);
    masRelationType.setCreatedTimeStamp(Calendar.getInstance().getTime());
    masRelationType.setCode("00");
    masRelationType.setIsActive(true);
    masRelationType.setRelationType("Test");
    masRelationTypeService.create(masRelationType);

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
    familyService.create(family);

  }

  @Test
  public void testLoadServicesShouldPass() throws Exception {
    assertNotNull(familyService);
    assertNotNull(masCoreSkillService);
    assertNotNull(masJobLevelService);
    assertNotNull(masTechnologyService);
    assertNotNull(applicantService);
    assertNotNull(masRelationTypeService);

  }

  @Test
  public void testFindWithFamilyServiceShouldReturnFamilyThatSetup() throws Exception {
    Family result = familyService.find(family.getId());
    assertNotNull(result);
    assertThat(result.getFamilyName(), is("Dad"));
    assertThat(result.getAge(), is(50));
    assertThat(result.getApplicant().getFirstNameEN(), is("Anat"));

  }

  @Test
  public void testFindAllWithFamilyServiceShouldReturnListOfAllFamily() throws Exception {
    List<Family> result = familyService.findAll();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testUpdateWithFamilyServiceShouldReturnFamilyThatUpdate() throws Exception {
    Family update = familyService.find(family.getId());
    assertThat(update.getFamilyName(), is("Dad"));
    assertThat(update.getAge(), is(50));
    assertThat(update.getApplicant().getFirstNameEN(), is("Anat"));
    update.setFamilyName("Mom");
    familyService.update(update);

    Family result = familyService.find(update.getId());
    assertThat(result.getFamilyName(), is("Mom"));

  }

  @Test
  public void testDeleteWithFamilyServiceShouldNotFindThatFamily() throws Exception {
    Family delete = familyService.find(family.getId());
    familyService.delete(delete);

    Family result = familyService.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteByIdWithFamilyServiceShouldNotFindThatFamily() throws Exception {
    Family delete = familyService.find(family.getId());
    familyService.deleteById(delete.getId());

    Family result = familyService.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testFindFamilyByApplicantIdWithFamilyServiceShouldReturnListOfFamilyOfThatApplicantId() throws Exception {
    List<Family> result = familyService.findFamilyByApplicantId(family.getApplicant().getId());
    assertNotNull(result);
    assertThat(result.get(0).getApplicant().getFirstNameEN(), is("Anat"));
    assertThat(result.get(0).getFamilyName(), is("Dad"));
    assertThat(result.get(0).getAge(), is(50));

  }

  @Test
  public void testFindLastFamilyWithFamilyServiceShouldReturnLastFamilyOfThatApplicantId() throws Exception {
    Family result = familyService.findLastFamily(family.getId());
    assertNotNull(result);
    assertThat(result.getApplicant().getFirstNameEN(), is("Anat"));
    assertThat(result.getFamilyName(), is("Dad"));
    assertThat(result.getAge(), is(50));

  }

  @Test
  public void testFindFamilyListWithFamilyServiceShouldReturnListOfFamilyDtoOfThatApplicantId() throws Exception {
    List<FamilyDto> result = familyService.findFamilyList(family.getApplicant().getId());
    assertNotNull(result);
    assertThat(result.get(0).getFamilyName(), is("Dad"));
    assertThat(result.get(0).getAge(), is(50));

  }

  @Test
  public void testFindFamilyByIdWithFamilyServiceShouldReturnListOfFamilyDtoOfThatApplicantId() throws Exception {
    List<FamilyDto> result = familyService.findFamilyById(family.getApplicant().getId());
    assertNotNull(result);
    assertThat(result.get(0).getFamilyName(), is("Dad"));
    assertThat(result.get(0).getAge(), is(50));

  }

  @Test
  public void testFindFamilyWithFamilyServiceShouldReturnFamilyDtoOfThatFamilyId() throws Exception {
    FamilyDto result = familyService.findFamily(family.getId());
    assertNotNull(result);
    assertThat(result.getFamilyName(), is("Dad"));
    assertThat(result.getAge(), is(50));

  }

  @Test
  public void testCreateFindMasRelationAndEmployeeWithFamilyServiceShouldPass() throws Exception {
    FamilyDto familyDto = familyService.findFamily(family.getId());
    familyService.createFindMasRelationAndEmployee(familyDto);

    Family result = familyService.find(family.getId());
    assertNotNull(result);
    assertThat(result.getFamilyName(), is("Dad"));
    assertThat(result.getAge(), is(50));
    assertThat(result.getApplicant().getFirstNameEN(), is("Anat"));

  }

  @Test
  public void testUpdateFindMasRelationAndEmployeeWithFamilyServiceShouldPass() throws Exception {
    FamilyDto familyDto = familyService.findFamily(family.getId());
    assertThat(familyDto.getFamilyName(), is("Dad"));
    familyDto.setFamilyName("Update");
    familyService.updateFindMasRelationAndEmployee(familyDto);

    Family result = familyService.find(family.getId());
    assertNotNull(result);
    assertThat(result.getFamilyName(), is("Update"));
    assertThat(result.getAge(), is(50));
    assertThat(result.getApplicant().getFirstNameEN(), is("Anat"));

  }

}