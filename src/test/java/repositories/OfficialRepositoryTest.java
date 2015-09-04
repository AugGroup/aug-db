/**
 *
 * @author natechanok
 * @date Sep 4, 2015
 */

package repositories;

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
import com.aug.hrdb.repositories.OfficialRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class OfficialRepositoryTest {
	
	@Autowired
	private OfficialRepository officialRepository;
	
	@Test
	@Rollback(false)
	public void create() {
		
		Official official = new Official();
	    Calendar cal = Calendar.getInstance();
		official.setOfficialDate(cal.getTime());
		official.setStartWorkDate(cal.getTime());
		official.setEndWorkDate(cal.getTime());
		official.setPositionAppliedFor("Programmer");
		official.setSalaryExpected("500000000");
		official.setProbationDate(cal.getTime());
		
		
		officialRepository.create(official);
		
		
	}
	
	@Test
	@Rollback(false)
	public void updateOfficial() {
		
		Official official = (Official) officialRepository.getCurrentSession().get(Official.class, 1);
		official.setPositionAppliedFor("BBA");
		officialRepository.update(official);
	}
	
	@Test
	@Rollback(false)
	public void deleteOfficial() {
		
		Official official = (Official) officialRepository.getCurrentSession().get(Official.class, 1);
		officialRepository.delete(official);
	}
	
	/*@Test
	public void findByIdOfficial(){
		
		Official official = (Official) officialRepository.getCurrentSession().get(Official.class, 1);		
		int id = official.getId();
		Assert.assertEquals(1, id);
		
	}
	
	@Test
	@Rollback(false)
	public void findAllOfficial(){
		
		
		List<Official> addressesList = officialRepository.findAll();
		Assert.assertEquals(1, addressesList.size());
	}
	*/

}
