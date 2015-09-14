/**
 *
 * @author Preeyaporn
 * @date 7 ก.ย. 2558
 */
package services;

import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasJoblevel;
import com.aug.hrdb.services.MasJoblevelService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasJoblevelServiceTest {

	@Autowired
	private MasJoblevelService masJoblevelServices;
	
	@Test
	public void create(){

		MasJoblevel masJoblevel = new MasJoblevel();
		masJoblevel.setName("PHP");
		masJoblevel.setCode("004A");
		masJoblevel.setIsActive(true);
		
		masJoblevel.setAuditFlag("C");
		masJoblevel.setCreatedBy(0);
		Calendar cal = Calendar.getInstance();
		masJoblevel.setCreatedTimeStamp(cal.getTime());
		
		masJoblevelServices.create(masJoblevel);
	}
	
//	@Test
//	public void update(){
//
//		MasJoblevel masJoblevel = masJoblevelServices.find(2);
//		masJoblevel.setName("JAVA");
//		masJoblevelServices.update(masJoblevel);
//		
//	}
//	
//	@Test
//	public void delete(){
//
//		MasJoblevel masJoblevel = masJoblevelServices.find(2);
//		masJoblevelServices.delete(masJoblevel);
//		
//	}
//	
//	
//	@Test
//	public void findAll(){
//
//		List<MasJoblevel> masJoblevel = masJoblevelServices.findAll();
//		Assert.assertEquals(14, masJoblevel.size());
//	}
//	
//	
//	@Test
//	public void findbyId(){
//
//		MasJoblevel  masJoblevel = masJoblevelServices.find(2);
//		Assert.assertEquals("Account Manager",masJoblevel.getName());
//		
//	}
	
}
