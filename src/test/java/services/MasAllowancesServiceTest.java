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

import com.aug.hrdb.entities.MasAllowances;
import com.aug.hrdb.services.MasAllowancesService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasAllowancesServiceTest {

	@Autowired
	private MasAllowancesService masAllowancesService;
	
	
	
int id;
	
	@Before
	public void setAllowan(){
MasAllowances masAllowances = new MasAllowances();
		
		masAllowances.setAllowances_type("Mother");
		masAllowances.setAmount_allowances(40000d);
		masAllowances.setCode("004A");
		masAllowances.setIsactive(true);
		
		masAllowances.setAuditFlag("C");
		masAllowances.setCreatedBy(1);
		masAllowances.setCreatedTimeStamp(Calendar.getInstance().getTime());

		masAllowancesService.create(masAllowances);
		id = masAllowances.getId();
		
	}
	
	
	@Test
	@Rollback(true)
	public void create(){

		MasAllowances masAllowances = new MasAllowances();
		masAllowances.setAllowances_type("Mother");
		masAllowances.setAmount_allowances(40000d);
		masAllowances.setCode("004A");
		masAllowances.setIsactive(true);
		
		masAllowances.setAuditFlag("C");
		masAllowances.setCreatedBy(0);
		Calendar cal = Calendar.getInstance();
		masAllowances.setCreatedTimeStamp(cal.getTime());
		
		masAllowancesService.create(masAllowances);
	}
	
	@Test
	@Rollback(true)
	public void update(){

		MasAllowances masAllowances = masAllowancesService.find(2);
		masAllowances.setAllowances_type("Father");
		masAllowancesService.update(masAllowances);
		
	}
	
	@Test
	@Rollback(true)
	public void delete(){

		MasAllowances masAllowances = masAllowancesService.find(2);
		masAllowancesService.delete(masAllowances);
		
	}
	
	
	@Test
	@Rollback(true)
	public void findAll(){

		List<MasAllowances> masAllowances = masAllowancesService.findAll();
		
	}
	
	
	@Test
	@Rollback(true)
	public void findbyId(){

		MasAllowances  masAllowances = masAllowancesService.find(id);
		int id = masAllowances.getId();
		Assert.assertEquals(id,id);
		
	}
}
