package services;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasStaffType;
import com.aug.hrdb.services.MasStaffTypeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasStaffTypeServiceTest {
	
	@Autowired 
	private MasStaffTypeService masStaffTypeService;
	
	
	@Test
	@Rollback(false)
	public void create() {

		MasStaffType masStaffType = new MasStaffType();
		masStaffType.setName("Augmentis");
		masStaffType.setAuditFlag("C");
		masStaffType.setCode("STAFF-01");
		masStaffType.setCreatedBy(1);
		masStaffType.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masStaffType.setIsActive(true);
		
		
		masStaffTypeService.create(masStaffType);

	}

}
