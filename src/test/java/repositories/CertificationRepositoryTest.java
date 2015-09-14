package repositories;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Certification;
import com.aug.hrdb.repositories.CertificationRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
public class CertificationRepositoryTest {
		
		@Autowired
		private CertificationRepository certificationRepository;
		
		@Test
		@Transactional
		@Rollback(value = false)
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
		@Rollback(value = false)
		public void testUpdateCertificationRepository() throws Exception {
			Certification certification = certificationRepository.find(5);
			certification.setName(".Net");
			certification.setAuditFlag("U");
			certification.setCreatedBy(2);
			certification.setCreatedTimeStamp(Calendar.getInstance().getTime());
			certificationRepository.update(certification);
		}
		
		@Test
		@Transactional
		@Rollback(value = false)
		public void testDeleteByIdCertificationRepository() throws Exception {
			certificationRepository.deleteById(4);
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
