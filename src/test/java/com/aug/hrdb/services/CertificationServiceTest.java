package com.aug.hrdb.services;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class CertificationServiceTest {

	@Autowired
	private MasCoreSkillService masCoreSkillService;

	@Autowired
	private MasJobLevelService masJobLevelService;

	@Autowired
	private MasTechnologyService masTechnologyService;

	@Autowired
	private ApplicantService applicantService;

	@Autowired
	private CertificationService certificationService;

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

		// create certification
		certification = new Certification();
		certification.setAuditFlag("C");
		certification.setCreatedBy(1);
		certification.setCreatedTimeStamp(Calendar.getInstance().getTime());
		certification.setApplicant(applicant);
		certification.setName("J2EE");
		certificationService.create(certification);

	}

	@Test
	public void testLoadServicesShouldPass() throws Exception {
		assertNotNull(masCoreSkillService);
		assertNotNull(masJobLevelService);
		assertNotNull(masTechnologyService);
		assertNotNull(applicantService);
		assertNotNull(certificationService);

	}

	@Test
	public void testFindWithCertificationServiceShouldReturnCertificationThatSetup() throws Exception {
		Certification result = certificationService.findById(certification.getId());
		assertNotNull(result);
		assertThat(result.getName(), is("J2EE"));

	}

	@Test
	public void testFindAllWithCertificationServiceShouldReturnListOfAllCertification() throws Exception {
		List<Certification> result = certificationService.findAll();
		assertNotNull(result);
		assertThat(result.size(), is(new GreaterOrEqual<>(1)));

	}

	@Test
	public void testUpdateWithCertificationServiceShouldReturnCertificationThatUpdate() throws Exception {
		Certification update = certificationService.findById(certification.getId());
		assertThat(update.getName(), is("J2EE"));
		update.setName("Master J2EE");
		certificationService.update(update);

		Certification result = certificationService.findById(update.getId());
		assertThat(result.getName(), is("Master J2EE"));

	}

	@Test
	public void testDeleteWithCertificationServiceShouldNotFindCertificationThatDelete() throws Exception {
		Certification delete = certificationService.findById(certification.getId());
		certificationService.delete(delete);

		Certification result = certificationService.findById(delete.getId());
		assertNull(result);

	}

	@Test
	public void testDeleteByIdWithCertificationServiceShouldNotFindCertificationThatDelete() throws Exception {
		Certification delete = certificationService.findById(certification.getId());
		certificationService.deleteById(delete.getId());

		Certification result = certificationService.findById(delete.getId());
		assertNull(result);

	}

	@Test
	public void testFindCertificateByIdWithCertificationServiceShouldReturnListOfCertificationThatHaveSetupApplicantId() throws Exception {
		List<CertificationDto> result = certificationService.findCertificateById(certification.getApplicant().getId());
		assertNotNull(result);
		assertThat(result.get(0).getName(), is("J2EE"));

	}

	@Test
	public void testFindCertificateWithCertificationServiceShouldReturnThatCertification() throws Exception {
		CertificationDto result = certificationService.findCertificate(certification.getId());
		assertNotNull(result);
		assertThat(result.getName(), is("J2EE"));

	}

	@Test
	public void testSearchCertificationWithCertificationServiceShouldReturnListOfCertificationThatHaveSetupApplicantId() throws Exception {
		List<CertificationDto> result = certificationService.searchCertification(certification.getApplicant().getId());
		assertNotNull(result);
		assertThat(result.get(0).getName(), is("J2EE"));
	}

}
