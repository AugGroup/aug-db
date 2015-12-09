/**
 *
 * @author Preeyaporn
 * @date 7 ก.ย. 2558
 */
package com.aug.hrdb.repositories;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import org.hibernate.SessionFactory;
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
import com.aug.hrdb.repositories.MasRoleRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class MasRoleRepositoryTest {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired 
	private MasRoleRepository masRoleRepository;
	
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
	public void testLoadSessionFactoryShouldPass() throws Exception {
		assertNotNull(sessionFactory);
	}
	
	@Test
	public void testLoadMasRoleRepositoryShouldPass() throws Exception {
		assertNotNull(masRoleRepository);
	}
	
	@Test
	public void testCreateWithMasRoleRepositoryShouldPass() throws Exception {
		
		masRole.setType("test create");
		masRoleRepository.create(masRole);
		Integer insertedId = masRole.getId();
		
		MasRole result = masRoleRepository.find(insertedId);
		
		assertThat(result.getType(), is("test create"));
		
	}
	
	@Test
	public void testFindByIdWithMasRoleRepositoryShouldPass() throws Exception {
		
		masRole.setType("test findById");
		masRoleRepository.create(masRole);
		Integer insertedId = masRole.getId();
		
		MasRole result = masRoleRepository.find(insertedId);
		
		assertThat(result.getType(), is("test findById"));
		
	}
	
	@Test
	public void testFindAllWithMasRoleRepositoryShouldPass() throws Exception {
		
		List<MasRole> masRoles = masRoleRepository.findAll();
		
		masRoleRepository.create(masRole);
		
		List<MasRole> result = masRoleRepository.findAll();
		
		assertThat(result.size(), is(masRoles.size() + 1));
		
	}
	
	@Test
	public void testUpdateWithMasRoleRepositoryShouldPass() throws Exception {
		
		masRoleRepository.create(masRole);
		Integer insertedId = masRole.getId();
		
		MasRole update = masRoleRepository.find(insertedId);
		update.setType("test update");
		masRoleRepository.update(update);
		
		MasRole result = masRoleRepository.find(update.getId());
		
		assertThat(result.getType(), is("test update"));
		
	}
	
	@Test
	public void testDeleteWithMasRoleRepositoryShouldPass() throws Exception {
		
		masRoleRepository.create(masRole);
		Integer insertedId = masRole.getId();
		
		MasRole delete = masRoleRepository.find(insertedId);
		masRoleRepository.delete(delete);
		
		MasRole result = masRoleRepository.find(delete.getId());
		
		assertNull(result);
		
	}
	
	@Test
	public void testDeleteByIdWithMasRoleRepositoryShouldPass() throws Exception {
		
		masRoleRepository.create(masRole);
		Integer insertedId = masRole.getId();
		
		MasRole delete = masRoleRepository.find(insertedId);
		masRoleRepository.deleteById(delete.getId());
		
		MasRole result = masRoleRepository.find(delete.getId());
		
		assertNull(result);
		
	}
	
}