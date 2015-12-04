/**
 *
 * @author Preeyaporn
 * @date 7 ก.ย. 2558
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

import com.aug.hrdb.entities.MasJobLevel;
import com.aug.hrdb.services.MasJoblevelService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasJoblevelServiceTest {

	@Autowired
	private MasJoblevelService masJoblevelServices;
	
	int id;
	@Before
	public void setJob(){
		MasJobLevel masJoblevel = new MasJobLevel();
		masJoblevel.setName("PHP");
		masJoblevel.setCode("004A");
		masJoblevel.setIsActive(true);
		
		masJoblevel.setAuditFlag("C");
		masJoblevel.setCreatedBy(0);
		Calendar cal = Calendar.getInstance();
		masJoblevel.setCreatedTimeStamp(cal.getTime());
		
		masJoblevelServices.create(masJoblevel);
		
		id = masJoblevel.getId();
	}
	
	
	@Test
	@Rollback(true)
	public void create(){

		MasJobLevel masJoblevel = new MasJobLevel();
		masJoblevel.setName("PHP");
		masJoblevel.setCode("004A");
		masJoblevel.setIsActive(true);
		
		masJoblevel.setAuditFlag("C");
		masJoblevel.setCreatedBy(0);
		Calendar cal = Calendar.getInstance();
		masJoblevel.setCreatedTimeStamp(cal.getTime());
		
		masJoblevelServices.create(masJoblevel);
	}
	
	@Test
	@Rollback(true)
	public void update(){

		MasJobLevel masJoblevel = masJoblevelServices.find(id);
		masJoblevel.setName("JAVA");
		masJoblevelServices.update(masJoblevel);
		
	}
	
	@Test
	@Rollback(true)
	public void delete(){

		MasJobLevel masJoblevel = masJoblevelServices.find(id);
		masJoblevelServices.delete(masJoblevel);
		
	}
	
	
	@Test
	@Rollback(true)
	public void findAll(){

		List<MasJobLevel> masJoblevel = masJoblevelServices.findAll();
		
	}
	
	
	@Test
	@Rollback(true)
	public void findbyId(){

		MasJobLevel  masJoblevel = masJoblevelServices.find(id);
		int id = masJoblevel.getId();
		Assert.assertEquals(id,id);
	}
	
}
