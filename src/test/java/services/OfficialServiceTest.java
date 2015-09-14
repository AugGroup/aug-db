/**
 *
 * @author natechanok
 * @date Sep 4, 2015
 */

package services;

import java.util.Calendar;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Official;
import com.aug.hrdb.services.OfficialService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class OfficialServiceTest {

	@Autowired
	private OfficialService officialService;
	
	@Test
	@Rollback(false)
	public void create() {
		
		Official official = new Official();
		Calendar cal = Calendar.getInstance();
		official.setOfficialDate(cal.getTime());
		official.setStartWorkDate(cal.getTime());
		official.setEndWorkDate(cal.getTime());
		official.setPositionAppliedFor("Account");
		official.setSalaryExpected("500000000");
		official.setProbationDate(cal.getTime());
		official.setAuditFlag("C");
		official.setCreatedBy(1);
		official.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
		officialService.create(official);
		
	}
	
	/*@Test
	@Rollback(false)
	public void updateOfficial(){
		
		Official official = (Official)officialService.findById(5);
		official.setPositionAppliedFor("Developper");
		officialService.update(official);
		
	}
	*/

	/*@Test
	@Rollback(false)
	public void deleteOfficial(){
		
		Official official = (Official)officialService.findById(6);
		officialService.delete(official);
	}*/
	
	/*@Test
	@Rollback(false)
	public void findAllOfficial(){

		List<Official> ability = officialService.findAll();
		Assert.assertEquals(3, ability.size());
	}
	*/
	
	
	@Test
	public void findbyIdOfficial(){

		Official official =(Official) officialService.findById(4);
		int id = official.getId();
		Assert.assertEquals(4,id);
		
		
		
	}
}
