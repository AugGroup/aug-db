package services;

import org.junit.Test;

import java.util.Calendar;
import java.util.List;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasSpecialty;
import com.aug.hrdb.services.EmployeeService;
import com.aug.hrdb.services.MasSpecialtyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasSpecialtyServiceTest {

	@Autowired
	private MasSpecialtyService masSpecialtyService;
	@Autowired
	private EmployeeService EmployeeService;
	
	@Test
	@Rollback(false)
	public void createDataMasSpecialty(){
		MasSpecialty masSpecialty=new MasSpecialty();
		masSpecialty.setName("Java");
		masSpecialty.setCode("01");
		masSpecialty.setIsActive(true);
		masSpecialty.setAuditFlag("C");
		masSpecialty.setCreatedBy(1);	
		masSpecialty.setCreatedTimeStamp(Calendar.getInstance().getTime());
	    masSpecialtyService.create(masSpecialty);
	}
	
	
//	@Test
//	@Rollback(false)
//	public void updateDataMasSpecialty(){
//		
//		MasSpecialty masSpecialty = (MasSpecialty)masSpecialtyService.findById(1);
//		masSpecialty.setName(".net");
//		masSpecialty.setCode("02");
//		masSpecialty.setIsActive(true);
//		masSpecialty.setAuditFlag("C");
//		masSpecialty.setCreatedBy(1);	
//		masSpecialty.setCreatedTimeStamp(Calendar.getInstance().getTime());
//		masSpecialtyService.update(masSpecialty);
//	}
//	
	
//	@Test
//	public void deleteDataMasSpecialty(){
//		MasSpecialty reward=masSpecialtyService.findById(1);
//		masSpecialtyService.delete(reward);
//	}
	
	
	
//	@Test
//	public void findAllDataMasSpecialty(){
//
//		List<MasSpecialty> ability = masSpecialtyService.findAll();
//		Assert.assertEquals(3, ability.size());
//	}
	
	
//	@Test
//	public void findDatabyIdMasSpecialty(){
//
//		MasSpecialty masSpecialty =(MasSpecialty) masSpecialtyService.findById(2);
//		int id = masSpecialty.getId();
//		Assert.assertEquals(2,id);
//
//	}
	
}
