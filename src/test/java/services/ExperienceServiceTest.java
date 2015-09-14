package services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import org.junit.Ignore;
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
	@Ignore
	@Rollback(false)
	public void insertExperienceServiceTest() throws ParseException {
		SimpleDateFormat dateFmt = new SimpleDateFormat("dd/MM/yyyy",
				Locale.ENGLISH);
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
		experience.setSalary(40000);
		
		experience.setAuditFlag("C");
		experience.setCreatedBy(1);
		experience.setCreatedTimeStamp(Calendar.getInstance().getTime());

		experienceService.create(experience);
		System.out.println("ExperienceServiceTest " + experience.getDateTo());
	}
	
	@Test
	@Ignore
	@Rollback(false)
	public void findByIdExperienceServiceTest() {
		Experience experience = experienceService.findById(1);
		System.out.println("Experience Address : "+experience.getAddress());

	}
	
	@Test
	@Ignore
	@Rollback(false)
	public void updateExperienceServiceTest() {
		Experience experience = experienceService.findById(4);
		experience.setCompanyName("companyNameUpdateServiceTest ");
		experience.setAuditFlag("U");
		experience.setCreatedBy(1);
		experience.setCreatedTimeStamp(Calendar.getInstance().getTime());
		experienceService.update(experience);
		System.out.println("Experience Name : " + experience.getId());

	}
	
	@Test
	@Ignore
	@Rollback(false)
	public void deleteByIdExperienceServiceTest() {
		//Experience experience =  experienceService.findById(5);
		experienceService.deleteById(7);
		System.out.println("Delete Experience : " + experienceService.findById(5));
	}


}
