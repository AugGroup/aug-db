package com.aug.hrdb.repositories;

import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
import com.aug.hrdb.entities.MasJobLevel;
import com.aug.hrdb.entities.MasTechnology;
import com.aug.hrdb.repositories.ApplicantRepository;
import com.aug.hrdb.repositories.CertificationRepository;
import com.aug.hrdb.repositories.EmployeeRepository;
import com.aug.hrdb.repositories.MasJoblevelRepository;
import com.aug.hrdb.repositories.MasTechnologyRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
public class CertificationRepositoryTest {
		
		@Autowired
		private CertificationRepository certificationRepository;
		@Autowired
		private EmployeeRepository employeeRepository;
		@Autowired
		private ApplicantRepository applicantRepository;
		@Autowired
		private MasJoblevelRepository masJoblevelRepository;
		@Autowired
		private MasTechnologyRepository masTechnologyRepository;
		
		@Before
		public void setCertificationRepository() throws ParseException {
	        
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
			
			MasJobLevel masJoblevel = new MasJobLevel();
			masJoblevel.setName("CEO");
			masJoblevel.setIsActive(true);
			masJoblevel.setCode("01");
			masJoblevel.setAuditFlag("C");
			masJoblevel.setCreatedBy(1);
			masJoblevel.setCreatedTimeStamp(Calendar.getInstance().getTime());
			masJoblevel.setCode("Division-01");

			masJoblevelRepository.create(masJoblevel);
			MasJobLevel mJoblevel= masJoblevelRepository.find(1);

			MasTechnology masTechnology = new MasTechnology();
			masTechnology.setName("java");
			masTechnology.setCode("001A");
			masTechnology.setIsActive(true);
			masTechnology.setAuditFlag("C");
			masTechnology.setCreatedBy(0);
			Calendar cal = Calendar.getInstance();
			masTechnology.setCreatedTimeStamp(cal.getTime());
			masTechnologyRepository.create(masTechnology);
			
			MasTechnology mTechnology= masTechnologyRepository.find(1);
			
			applicant.setJoblevel(mJoblevel);
			applicant.setTechnology(mTechnology);
			applicantRepository.create(applicant);
			
		    Applicant applicant1 =  applicantRepository.find(1);
		    Certification certification = new Certification();
			certification.setName("SAP");
			certification.setAuditFlag("C");
			certification.setCreatedBy(1);
			certification.setCreatedTimeStamp(Calendar.getInstance().getTime());
			certificationRepository.create(certification);
		}
		
		@Test
		@Transactional
		@Rollback(value = true)
		public void testInsertCertificationRepository() throws Exception {
			Certification certification = new Certification();
			certification.setName("Java");
			certification.setAuditFlag("C");
			certification.setCreatedBy(1);
			certification.setCreatedTimeStamp(Calendar.getInstance().getTime());
			certificationRepository.create(certification);
		}
		
		@Test
		@Transactional
		@Rollback(value = true)
		public void testUpdateCertificationRepository() throws Exception {
			Certification certification = certificationRepository.find(1);
			certification.setName(".Net");
			certification.setAuditFlag("U");
			certification.setCreatedBy(2);
			certification.setCreatedTimeStamp(Calendar.getInstance().getTime());
			certificationRepository.update(certification);
		}
		
		@Test
		@Transactional
		@Rollback(value = true)
		public void testDeleteByIdCertificationRepository() throws Exception {
			certificationRepository.deleteById(2);
		}

		@Test
		@Transactional
		@Rollback(value = true)
		public void testDeleteCertificateRepository() throws Exception {
			Certification certification = certificationRepository.find(3);
			certificationRepository.delete(certification);			
		}
		@Test
		@Transactional
		public void testFindByIdCertificateRepository() throws Exception {
			Certification certification = certificationRepository.find(3);
			assertNotNull(certification.getName());
			
		}

		@Test
		@Transactional
		public void testFindAllCertificateRepository() throws Exception {
			List<Certification> certifications = certificationRepository.findAll();
			for (Certification certification : certifications)
				System.out.println("certification : "
						+ certification.getName());
		}
}
