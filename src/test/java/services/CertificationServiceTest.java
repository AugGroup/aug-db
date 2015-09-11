package services;

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
import com.aug.hrdb.services.CertificationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
public class CertificationServiceTest {
	
	@Autowired
	private CertificationService certificationService;
	
	@Test
	@Transactional
	@Rollback(value = false)
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
	@Rollback(value = false)
	public void testUpdateCertificationService() throws Exception {
		Certification certification = certificationService.findById(5);
		certification.setName(".Net");
		certification.setAuditFlag("U");
		certification.setCreatedBy(1);
		certification.setCreatedTimeStamp(Calendar.getInstance().getTime());
		certificationService.update(certification);
	}
	
	@Test
	@Transactional
	@Rollback(value = false)
	public void testDeleteByIdCertificationService() throws Exception {
		certificationService.deleteById(4);
	}

	@Test
	@Transactional
	public void testFindByIdCertificateService() throws Exception {
		Certification certification = certificationService.findById(5);
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
