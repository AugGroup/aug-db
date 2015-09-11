package repositories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.junit.Ignore;
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
	@Ignore
	@Rollback(false)
	public void insertExperienceRepositoryTest() throws ParseException {
		SimpleDateFormat dateFmt = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
		Experience experience = new Experience();

		experience.setAddress("ExperienceAddressTest");
		experience.setTypeOfBusiness("TypeTest");
		experience.setCompanyName("companyNameTest");
		experience.setDateFrom(dateFmt.parse("04/01/2015"));
		experience.setDateTo(dateFmt.parse("04/09/2015"));
		experience.setPosition("positionTest");
		experience.setReason("reasonTest");
		experience.setReference("referenceTest");
		experience.setResponsibility("responsibilityTest");
		experience.setSalary(20000);
		experience.setAuditFlag("C");
		experience.setCreatedBy(1);
		experience.setCreatedTimeStamp(Calendar.getInstance().getTime());

		experienceRepository.getCurrentSession().save(experience);
		System.out.println("ExperienceRepositoryTest : " + experience.getDateTo());
	}

	@Test
	@Rollback(false)
	public void findByIdExperienceRepositoryTest() {
		Experience experience = experienceRepository.find(1);
		System.out.println("Experience Address : "+experience.getAddress());

	}
	@Test
	@Rollback(false)
	public void findAllExperienceRepositoryTest() {
		List<Experience> experience = experienceRepository.findAll();
		//System.out.println("Experience Address : "+experience.getAddress());

	}
	
	@Test
	@Rollback(false)
	public void updateExperienceRepositoryTest() {
		Experience experience = experienceRepository.find(1);
		experience.setCompanyName("companyNameUpdateTest ");
		experience.setAuditFlag("U");
		experience.setCreatedBy(1);
		experience.setCreatedTimeStamp(Calendar.getInstance().getTime());
		experienceRepository.update(experience);
		System.out.println("Experience Name : " + experience.getCompanyName());

	}
	
	@Test
	@Ignore
	@Rollback(false)
	public void deleteByIdExperienceRepositoryTest() {
		//Experience experience = experienceRepository.find(5);
		experienceRepository.deleteById(5);
		System.out.println("Delete Experience : " + experienceRepository.find(5));
	}

}
