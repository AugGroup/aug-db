package repositories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Experience;
import com.aug.hrdb.repositories.ExperienceRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class ExperienceRepositoryTest {

	@Autowired
	private ExperienceRepository experienceRepository;

	@Test
	@Rollback(false)
	public void insertExperience() {
		SimpleDateFormat dateFmt = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
		Experience experience = new Experience();

		experience.setId(1);
		experience.setAddress("ExperienceAddressTest");
		experience.setTypeOfBusiness("TypeTest");
		experience.setCompanyName("companyName");
		// experience.setDateFrom(dateFmt.parse("04/01/2015"));
		// experience.setDateTo(dateFmt.parse("04/09/2015"));
		experience.setPosition("positionTest");

		experienceRepository.getCurrentSession().save(experience);
		
	}
}
