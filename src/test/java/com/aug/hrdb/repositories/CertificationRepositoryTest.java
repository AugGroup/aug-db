package com.aug.hrdb.repositories;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import com.aug.hrdb.dto.CertificationDto;
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
public class CertificationRepositoryTest {

  @Autowired
  private MasCoreSkillRepository masCoreSkillRepository;

  @Autowired
  private MasJobLevelRepository masJobLevelRepository;

  @Autowired
  private MasTechnologyRepository masTechnologyRepository;

  @Autowired
  private ApplicantRepository applicantRepository;

  @Autowired
  private CertificationRepository certificationRepository;

  private Certification certification;

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
    applicantRepository.create(applicant);

    // create certification
    certification = new Certification();
    certification.setAuditFlag("C");
    certification.setCreatedBy(1);
    certification.setCreatedTimeStamp(Calendar.getInstance().getTime());
    certification.setApplicant(applicant);
    certification.setName("J2EE");
    certificationRepository.create(certification);

  }

  @Test
  public void testLoadRepositoriesShouldPass() throws Exception {
    assertNotNull(masCoreSkillRepository);
    assertNotNull(masJobLevelRepository);
    assertNotNull(masTechnologyRepository);
    assertNotNull(applicantRepository);
    assertNotNull(certificationRepository);

  }

  @Test
  public void testFindWithCertificationRepositoryShouldReturnCertificationThatSetup() throws Exception {
    Certification result = certificationRepository.find(certification.getId());
    assertNotNull(result);
    assertThat(result.getName(), is("J2EE"));

  }

  @Test
  public void testFindAllWithCertificationRepositoryShouldReturnListOfAllCertification() throws Exception {
    List<Certification> result = certificationRepository.findAll();
    assertNotNull(result);
    assertThat(result.size(), is(new GreaterOrEqual<>(1)));

  }

  @Test
  public void testUpdateWithCertificationRepositoryShouldReturnCertificationThatUpdate() throws Exception {
    Certification update = certificationRepository.find(certification.getId());
    assertThat(update.getName(), is("J2EE"));
    update.setName("Master J2EE");
    certificationRepository.update(update);

    Certification result = certificationRepository.find(update.getId());
    assertThat(result.getName(), is("Master J2EE"));

  }

  @Test
  public void testDeleteWithCertificationRepositoryShouldNotFindCertificationThatDelete() throws Exception {
    Certification delete = certificationRepository.find(certification.getId());
    certificationRepository.delete(delete);

    Certification result = certificationRepository.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testDeleteByIdWithCertificationRepositoryShouldNotFindCertificationThatDelete() throws Exception {
    Certification delete = certificationRepository.find(certification.getId());
    certificationRepository.deleteById(delete.getId());

    Certification result = certificationRepository.find(delete.getId());
    assertNull(result);

  }

  @Test
  public void testFindCertificateByIdWithCertificationRepositoryShouldReturnListOfCertificationThatHaveSetupApplicantId() throws Exception {
    List<CertificationDto> result = certificationRepository.findCertificateById(certification.getApplicant().getId());
    assertNotNull(result);
    assertThat(result.get(0).getName(), is("J2EE"));

  }

  @Test
  public void testFindCertificateWithCertificationRepositoryShouldReturnThatCertification() throws Exception {
    CertificationDto result = certificationRepository.findCertificate(certification.getId());
    assertNotNull(result);
    assertThat(result.getName(), is("J2EE"));

  }

  @Test
  public void testSearchCertificationWithCertificationRepositoryShouldReturnListOfCertificationThatHaveSetupApplicantId() throws Exception {
    List<CertificationDto> result = certificationRepository.searchCertification(certification.getApplicant().getId());
    assertNotNull(result);
    assertThat(result.get(0).getName(), is("J2EE"));
  }

}
