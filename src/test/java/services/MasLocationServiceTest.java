/**
 *
 * @author Pranrajit
 * @date 14 ก.ย. 2558
 */
package services;

import java.util.Calendar;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasLocation;
import com.aug.hrdb.services.MasLocationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasLocationServiceTest {
	@Autowired MasLocationService masLocationService;
	
	@Test
	public void create(){
		MasLocation masLocation=new MasLocation();
		masLocation.setName("Thailand");
		masLocation.setCode("LO-01");
		masLocation.setIsActive(true);
		masLocation.setAuditFlag("c");
		masLocation.setCreatedBy(1);
		masLocation.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masLocationService.create(masLocation);
		
	}

	
	
	/*@Test
	public void update(){
		MasLocation masLocation=(MasLocation)masLocationService.find(1);
		masLocation.setName("SG");
		masLocationService.update(masLocation);
		
	}*/
	
/*	@Test
	public void delete(){

		MasLocation masLocation=masLocationService.find(1);
		masLocationService.delete(masLocation);
	}*/
	
/*	@SuppressWarnings("deprecation")
	@Test
	public void findAll(){
		List<MasLocation>masLocations=masLocationService.findAll();
		Assert.assertEquals(4,masLocations.size());
	}
	*/
	/*@SuppressWarnings("deprecation")
	@Test
	public void findById(){
		MasLocation masLocation=masLocationService.find(1);
		int id = masLocation.getId();
		Assert.assertEquals(1,id);
	}*/
}
