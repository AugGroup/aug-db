package services;

import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Hibernate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Certification;
import com.aug.hrdb.entities.MasJoblevel;
import com.aug.hrdb.entities.MasTechnology;
import com.aug.hrdb.repositories.MasDivisionRepository;
import com.aug.hrdb.repositories.MasJoblevelRepository;
import com.aug.hrdb.services.ApplicantService;
import com.aug.hrdb.services.CertificationService;
import com.aug.hrdb.services.MasDivisionService;
import com.aug.hrdb.services.MasJoblevelService;
import com.aug.hrdb.services.MasTechnologyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
public class CertificationServiceTest {
	
	@Autowired
	private CertificationService certificationService;
	
	@Autowired
	private ApplicantService applicantService;
	
	@Autowired
	private MasJoblevelService masJoblevelService;
	@Autowired
	private MasTechnologyService masTechnologyService;
	@Before
	public void setCertificationService() throws ParseException {
        
        Applicant applicant = new Applicant();
        applicant.setCardId("115310905001-9");
        applicant.setFirstNameTH("อรอนงค์");
        applicant.setFirstNameEN("Ornanong");
        applicant.setNickNameEN("nong");
        applicant.setNickNameTH("นงค์");
        applicant.setLastNameEN("Namlongnamken");
        applicant.setLastNameTH("น้ำลงน้ำขึ้น");
		applicant.setCreatedBy(1);
		applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
		applicant.setAuditFlag("C");
		applicant.setCardId("115310905001-9");
		
		MasJoblevel masJoblevel = new MasJoblevel();
		masJoblevel.setName("CEO");
		masJoblevel.setIsActive(true);
		masJoblevel.setCode("01");
		masJoblevel.setAuditFlag("C");
		masJoblevel.setCreatedBy(1);
		masJoblevel.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masJoblevel.setCode("Division-01");

		masJoblevelService.create(masJoblevel);
		MasJoblevel mJoblevel= masJoblevelService.find(1);

		MasTechnology masTechnology = new MasTechnology();
		masTechnology.setName("java");
		masTechnology.setCode("001A");
		masTechnology.setIsActive(true);
		masTechnology.setAuditFlag("C");
		masTechnology.setCreatedBy(0);
		Calendar cal = Calendar.getInstance();
		masTechnology.setCreatedTimeStamp(cal.getTime());
		masTechnologyService.create(masTechnology);
		
		MasTechnology mTechnology= masTechnologyService.find(1);
		
		applicant.setJoblevel(mJoblevel);
		applicant.setTechnology(mTechnology);
		applicantService.create(applicant);
		
	    Applicant applicant1 =  applicantService.findById(1);
	    Certification certification = new Certification();
		certification.setName("SAP");
		certification.setAuditFlag("C");
		certification.setCreatedBy(1);
		certification.setCreatedTimeStamp(Calendar.getInstance().getTime());
		certificationService.create(certification);
	}
	
	@Test
	@Transactional
	@Rollback(value = true)
	public void testInsertCertificationService() throws Exception {
		Certification certification = new Certification();
		certification.setName("Java");
		certification.setAuditFlag("C");
		certification.setCreatedBy(1);
		certification.setCreatedTimeStamp(Calendar.getInstance().getTime());
		certificationService.create(certification);
	}
	
	@Test
	@Transactional
	@Rollback(value = true)
	public void testUpdateCertificationService() throws Exception {
		Certification certification = certificationService.findById(3);
		certification.setName(".Net");
		certification.setAuditFlag("U");
		certification.setCreatedBy(1);
		certification.setCreatedTimeStamp(Calendar.getInstance().getTime());
		certificationService.update(certification);
	}
	
	@Test
	@Transactional
	@Rollback(value = true)
	public void testDeleteByIdCertificationService() throws Exception {
		certificationService.deleteById(2);
	}
	
	@Test
	@Transactional
	@Rollback(value = true)
	public void testDeleteCertificateService() throws Exception {
		Certification certification = certificationService.findById(3);
		certificationService.delete(certification);			
	}

	@Test
	@Transactional
	public void testFindByIdCertificateService() throws Exception {
		Certification certification = certificationService.findById(1);
		assertNotNull(certification.getName());
		
	}

	@Test
	@Transactional
	public void testFindAllCertificateService() throws Exception {
		List<Certification> certifications = certificationService.findAll();
		for (Certification certification : certifications)
			System.out.println("certification : "
					+ certification.getName());
	}
	
	

}
