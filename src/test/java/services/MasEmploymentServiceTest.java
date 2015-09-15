/**
 *
 * @author natechanok
 * @date Sep 4, 2015
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

import com.aug.hrdb.entities.MasEmployment;
import com.aug.hrdb.services.MasEmploymentService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasEmploymentServiceTest {
	
	@Autowired
	private MasEmploymentService masEmploymentService;
	
	@Before
	public void setUp(){
		MasEmployment masEmployment = new MasEmployment();
		masEmployment.setName("BBBBB");
		masEmployment.setCode("B05");
		masEmployment.setIsActive(true);
		masEmployment.setAuditFlag("C");
		masEmployment.setCreatedBy(1);
		masEmployment.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
		masEmploymentService.create(masEmployment);
		
		MasEmployment masEmployment1 = new MasEmployment();
		masEmployment1.setName("BBBBB");
		masEmployment1.setCode("B05");
		masEmployment1.setIsActive(true);
		masEmployment1.setAuditFlag("C");
		masEmployment1.setCreatedBy(1);
		masEmployment1.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
		masEmploymentService.create(masEmployment1);
		
	}
	
	@Test
	@Rollback(true)
	public void create() {
		
		MasEmployment masEmployment = new MasEmployment();
		masEmployment.setName("WWWWW");
		masEmployment.setCode("001W");
		masEmployment.setIsActive(true);
		masEmployment.setAuditFlag("C");
		masEmployment.setCreatedBy(1);
		masEmployment.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
		masEmploymentService.create(masEmployment);
		
	}
	
	@Test
	@Rollback(true)
	public void update(){
		
		MasEmployment masEmployment = (MasEmployment)masEmploymentService.findById(1);
		masEmployment.setName("BBBBB");
		masEmploymentService.update(masEmployment);
		
	}
	
	@Test
	@Rollback(true)
	public void delete() {
		
		MasEmployment masEmployment = (MasEmployment)masEmploymentService.findById(1);
		masEmploymentService.delete(masEmployment);
		
	}
	
	@Test
	@Rollback(true)
	public void findAll(){
		
		List<MasEmployment> masEmployments = masEmploymentService.findAll();
		Assert.assertEquals(2, masEmployments.size());
		
	}
	
	
	@Test
	@Rollback(true)
	public void findById() {
		
		MasEmployment masEmployment = masEmploymentService.findById(1);	
		int id = masEmployment.getId();
		Assert.assertEquals(1,id);
	}
	
}
