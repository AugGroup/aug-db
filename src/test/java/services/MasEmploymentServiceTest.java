/**
 *
 * @author natechanok
 * @date Sep 4, 2015
 */

package services;

import java.util.List;

import org.junit.Assert;
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
	

	@Test
	@Rollback(false)
	public void create() {
		
		MasEmployment masEmployment = new MasEmployment();
		masEmployment.setName("WWWWW");
		masEmployment.setCode("001W");
		masEmployment.setIsActive(true);
		
		masEmploymentService.create(masEmployment);
		
	}
	
	@Test
	@Rollback(false)
	public void update(){
		
		MasEmployment masEmployment = (MasEmployment)masEmploymentService.findById(1);
		masEmployment.setName("BBBBB");
		masEmploymentService.update(masEmployment);
		
	}
	
	@Test
	@Rollback(false)
	public void delete() {
		
		MasEmployment masEmployment = (MasEmployment)masEmploymentService.findById(1);
		masEmploymentService.delete(masEmployment);
		
	}
	
	@Test
	@Rollback(false)
	public void findAll(){
		
		List<MasEmployment> masEmployments = masEmploymentService.findAll();
		Assert.assertEquals(1, masEmployments.size());
		
	}
	
	
	@Test
	@Rollback(false)
	public void findById() {
		
		MasEmployment masEmployment = masEmploymentService.findById(1);	
		int id = masEmployment.getId();
		Assert.assertEquals(1,id);
	}
	
}
