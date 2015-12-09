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
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasRole;
import com.aug.hrdb.services.MasRoleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class MasRoleServiceTest {

	@Autowired 
	private MasRoleService masRoleService;
	
	private MasRole masRole;
	
	@Before
	public void setUp() throws Exception {
		
		masRole = new MasRole();
		masRole.setType("test");
		masRole.setIsActive(true);
		masRole.setAuditFlag("C");
		masRole.setCreatedBy(1);
		masRole.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testLoadMasRoleServiceShouldPass() throws Exception {
		assertNotNull(masRoleService);
	}
	
	@Test
	public void testCreateWithMasRoleServiceShouldPass() throws Exception {
		
		masRole.setType("test create");
		masRoleService.create(masRole);
		Integer insertedId = masRole.getId();
		
		MasRole result = masRoleService.findById(insertedId);
		
		assertThat(result.getType(), is("test create"));
		
	}
	
	@Test
	public void testFindByIdWithMasRoleServiceShouldPass() throws Exception {
		
		masRole.setType("test findById");
		masRoleService.create(masRole);
		Integer insertedId = masRole.getId();
		
		MasRole result = masRoleService.findById(insertedId);
		
		assertThat(result.getType(), is("test findById"));
		
	}
	
	@Test
	public void testFindAllWithMasRoleServiceShouldPass() throws Exception {
		
		List<MasRole> masRoles = masRoleService.findAll();
		
		masRoleService.create(masRole);
		
		List<MasRole> result = masRoleService.findAll();
		
		assertThat(result.size(), is(masRoles.size() + 1));
		
	}
	
	@Test
	public void testUpdateWithMasRoleServiceShouldPass() throws Exception {
		
		masRoleService.create(masRole);
		Integer insertedId = masRole.getId();
		
		MasRole update = masRoleService.findById(insertedId);
		update.setType("test update");
		masRoleService.update(update);
		
		MasRole result = masRoleService.findById(update.getId());
		
		assertThat(result.getType(), is("test update"));
		
	}
	
	@Test
	public void testDeleteWithMasRoleServiceShouldPass() throws Exception {
		
		masRoleService.create(masRole);
		Integer insertedId = masRole.getId();
		
		MasRole delete = masRoleService.findById(insertedId);
		masRoleService.delete(delete);
		
		MasRole result = masRoleService.findById(delete.getId());
		
		assertNull(result);
		
	}
	
	@Test
	public void testDeleteByIdWithMasRoleServiceShouldPass() throws Exception {
		
		masRoleService.create(masRole);
		Integer insertedId = masRole.getId();
		
		MasRole delete = masRoleService.findById(insertedId);
		masRoleService.deleteById(delete.getId());
		
		MasRole result = masRoleService.findById(delete.getId());
		
		assertNull(result);
		
	}
	
}