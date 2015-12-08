/**
 *
 * @author Preeyaporn
 * @date 7 ก.ย. 2558
 */
package com.aug.hrdb.services;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.aug.hrdb.entities.MasAllowance;
import com.aug.hrdb.services.MasAllowanceService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@TransactionConfiguration
public class MasAllowanceServiceTest {

	@Autowired
	private MasAllowanceService masAllowanceService;

	private MasAllowance masAllowance;
	
	@Before
	public void setUp() throws Exception {
		
		masAllowance = new MasAllowance();
		masAllowance.setAllowance_type("test");
		masAllowance.setAmount_allowances(40000d);
		masAllowance.setCode("004A");
		masAllowance.setIsactive(true);
		masAllowance.setAuditFlag("C");
		masAllowance.setCreatedBy(1);
		masAllowance.setCreatedTimeStamp(Calendar.getInstance().getTime());
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testLoadmasAllowanceServiceShouldPass() throws Exception {
		assertNotNull(masAllowanceService);
	}
	
	@Test
	public void testCreateWithMasAllowanceServiceShouldPass() throws Exception {
		
		masAllowance.setAllowance_type("test create");
		masAllowanceService.create(masAllowance);
		Integer insertedId = masAllowance.getId();
		
		MasAllowance result = masAllowanceService.find(insertedId);
		
		assertThat(result.getAllowance_type(), is("test create"));
		
	}
	
	@Test
	public void testFindByIdWithMasAllowanceServiceShouldPass() throws Exception {
		
		masAllowance.setAllowance_type("test findById");
		masAllowanceService.create(masAllowance);
		Integer insertedId = masAllowance.getId();
		
		MasAllowance result = masAllowanceService.find(insertedId);
		
		assertThat(result.getAllowance_type(), is("test findById"));
		
	}
	
	@Test
	public void testFindAllWithMasAllowanceServiceShouldPass() throws Exception {
		
		List<MasAllowance> masAllowances = masAllowanceService.findAll();
		
		masAllowanceService.create(masAllowance);
		
		List<MasAllowance> result = masAllowanceService.findAll();
		
		assertThat(result.size(), is(masAllowances.size() + 1));
		
	}
	
	@Test
	public void testUpdateWithMasAllowanceServiceShouldPass() throws Exception {
		
		masAllowanceService.create(masAllowance);
		Integer insertedId = masAllowance.getId();
		
		MasAllowance update = masAllowanceService.find(insertedId);
		update.setAllowance_type("test update");
		masAllowanceService.update(update);
		
		MasAllowance result = masAllowanceService.find(update.getId());
				
		assertThat(result.getAllowance_type(), is("test update"));
		
	}
	
	@Test
	public void testDeleteWithMasAllowanceServiceShouldPass() throws Exception {
		
		masAllowanceService.create(masAllowance);
		Integer insertedId = masAllowance.getId();
		
		MasAllowance delete = masAllowanceService.find(insertedId);
		masAllowanceService.delete(delete);
		
		MasAllowance result = masAllowanceService.find(delete.getId());
		
		assertNull(result);
		
	}
	
	@Test
	public void testDeleteByIdWithMasAllowanceServiceShouldPass() throws Exception {
		
		masAllowanceService.create(masAllowance);
		Integer insertedId = masAllowance.getId();
		
		masAllowanceService.deleteById(insertedId);
		
		MasAllowance result = masAllowanceService.find(insertedId);
		
		assertNull(result);
		
	}
}
