/**
 *
 * @author Pranrajit
 * @date 14 ก.ย. 2558
 */
package services;

import java.util.Calendar;
import java.util.List;






import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
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
	
	int id;
	@Before
	public void setValue(){
		MasLocation masLocation = new MasLocation();
		masLocation.setName("thailand");
		masLocation.setCode("LO-01");
		masLocation.setIsActive(true);
		masLocation.setAuditFlag("C");
		masLocation.setCreatedBy(1);
		masLocation.setCreatedTimeStamp(Calendar.getInstance().getTime());	
		masLocationService.create(masLocation);
	    
	    
	    MasLocation masLocation1 = new MasLocation();
		masLocation1.setName("thailand");
		masLocation1.setCode("LO-01");
		masLocation1.setIsActive(true);
		masLocation1.setAuditFlag("C");
		masLocation1.setCreatedBy(1);
		masLocation1.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
		masLocationService.create(masLocation1);
		 id = masLocation1.getId();
	}
	
	@Test
	@Rollback(true)
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

	
	
	@Test
	@Rollback(true)
	public void update(){
		MasLocation masLocation=(MasLocation)masLocationService.find(1);
		masLocation.setName("SG");
		masLocationService.update(masLocation);
		
	}
	
	@Test
	@Rollback(true)
	public void delete(){

		MasLocation masLocation=masLocationService.find(3);
		masLocationService.delete(masLocation);
	}
	
	
	@Test
	@Rollback(true)
	public void findAll(){
		List<MasLocation>masLocations=masLocationService.findAll();
	
	}
	
	
	@Test
	@Rollback(true)
	public void findById(){
		MasLocation masLocation=masLocationService.find(id);
		int id = masLocation.getId();
		Assert.assertEquals(id,id);
	}
}
