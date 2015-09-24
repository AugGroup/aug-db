package services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.repositories.CertificationRepository;
import com.aug.hrdb.services.CertificationDtoService;

/**
 *
 * @author natechanok
 * @date Sep 24, 2015
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class CertificationDtoTest {
	
	@Autowired
	private CertificationRepository cerService;
	
	
	@Test
	public void test(){
		cerService.searchCertification(1);
	}

}
