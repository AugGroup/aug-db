package services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aug.hrdb.entities.Experience;
import com.aug.hrdb.services.ExperienceService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
public class ExperienceServiceTest {

	@Autowired
	private ExperienceService experienceService;

	@Test
	@Rollback(false)
	public void insertExperienceServiceTest() throws ParseException {
		SimpleDateFormat dateFmt = new SimpleDateFormat("dd/MM/yyyy",
				Locale.ENGLISH);
		Experience experience = new Experience();

		experience.setId(1);
		experience.setAddress("ExperienceAddressTest");
		experience.setTypeOfBusiness("TypeTest");
		experience.setCompanyName("companyNameTest");
		experience.setDateFrom(dateFmt.parse("04/01/2015"));
		experience.setDateTo(dateFmt.parse("04/09/2015"));
		experience.setPosition("positionTest");
		experience.setReason("reasonTest");
		experience.setReference("referenceTest");
		experience.setResponsibility("responsibilityTest");
		experience.setSalary(40000);

		experienceService.create(experience);
		System.out.println("ExperienceServiceTest " + experience.getDateTo());
	}
	
	@Test
	@Rollback(false)
	public void findByIdExperienceServiceTest() {
		Experience experience = experienceService.findById(1);
		System.out.println("Experience Address : "+experience.getAddress());

	}
	
	@Test
	@Rollback(false)
	public void updateExperienceServiceTest() {
		Experience experience = experienceService.findById(1);
		experience.setCompanyName("companyNameUpdateServiceTest ");
		experienceService.update(experience);
		System.out.println("Experience Name : " + experience.getCompanyName());

	}
	
	@Test
	@Rollback(false)
	public void deleteByIdExperienceServiceTest() {
		Experience experience =  experienceService.findById(5);
		experienceService.delete(experience);
		System.out.println("Delete Experience : " + experienceService.findById(5));
	}


}
