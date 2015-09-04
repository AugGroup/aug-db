package services;

import org.junit.Test;

import java.util.List;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasSpecialty;
import com.aug.hrdb.services.MasSpecialtyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasSpecialtyServiceTest {

	@Autowired
	private MasSpecialtyService masSpecialtyService;
	
	@Test
	@Rollback(false)
	public void createDataMasSpecialty(){
		MasSpecialty masSpecialty=new MasSpecialty();
   //	masSpecialty.setEmployee(null);
		masSpecialty.setName("Java");
		masSpecialty.setCode("01");
		masSpecialty.setIsActive(true);
	    masSpecialtyService.create(masSpecialty);
	}
	
	
//	@Test
//	@Rollback(false)
//	public void updateDataMasSpecialty(){
//		
//		MasSpecialty masSpecialty = masSpecialtyService.findById(1);
//		masSpecialty.setName(".net");
//		masSpecialty.setCode("02");
//		masSpecialty.setIsActive(true);
//		masSpecialtyService.update(masSpecialty);
//	}
	
	
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
