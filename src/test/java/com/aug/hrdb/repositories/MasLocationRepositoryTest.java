/**
 *

 * @author Pranrajit
 * @date 4 ก.ย. 2558
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

import com.aug.hrdb.entities.MasLocation;
import com.aug.hrdb.repositories.MasLocationRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class MasLocationRepositoryTest {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired 
	private MasLocationRepository masLocationRepository;
	
	private MasLocation masLocation;
	
	@Before
	public void setUp() throws Exception {
		
		masLocation = new MasLocation();
		masLocation.setName("test");
		masLocation.setCode("test01");
		masLocation.setIsActive(true);
		masLocation.setAuditFlag("C");
		masLocation.setCreatedBy(1);
		masLocation.setCreatedTimeStamp(Calendar.getInstance().getTime());	
		
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testLoadSessionFactoryShouldPass() throws Exception {
		assertNotNull(sessionFactory);
	}
	
	@Test
	public void testLoadMasLocationRepositoryShouldPass() throws Exception {
		assertNotNull(masLocationRepository);
	}
	
	@Test
	public void testCreateWithMasLocationRepositoryShouldPass() throws Exception {
		
		masLocation.setName("test create");
		masLocationRepository.create(masLocation);
		Integer insertedId = masLocation.getId();
		
		MasLocation result = masLocationRepository.find(insertedId);
		
		assertThat(result.getName(), is("test create"));
		
	}
	
	@Test
	public void testFindByIdWithMasLocationRepositoryShouldPass() throws Exception {
		
		masLocation.setName("test findById");
		masLocationRepository.create(masLocation);
		Integer insertedId = masLocation.getId();
		
		MasLocation result = masLocationRepository.find(insertedId);
		
		assertThat(result.getName(), is("test findById"));
		
	}
	
	@Test
	public void testFindAllWithMasLocationRepositoryShouldPass() throws Exception {
		
		List<MasLocation> masLocations = masLocationRepository.findAll();
		
		masLocationRepository.create(masLocation);
		
		List<MasLocation> result = masLocationRepository.findAll();
		
		assertThat(result.size(), is(masLocations.size() + 1));
		
	}
	
	@Test
	public void testFindByCriteriaWithMasLocationRepositoryShouldPass() throws Exception {
		
		masLocation.setName("test findByCriteria");
		masLocationRepository.create(masLocation);
		
		List<MasLocation> result = masLocationRepository.findByCriteria(masLocation);
		
		assertThat(result.size(), is(1));
		
	}
	
	@Test
	public void testFindByLocationCodeWithMasLocationRepositoryShouldPass() throws Exception {
		
		masLocation.setCode("test findByCode");
		masLocationRepository.create(masLocation);
		Integer insertedId = masLocation.getId();
		
		MasLocation result = masLocationRepository.find(insertedId);
		
		assertThat(result.getCode(), is("test findByCode"));
		
	}
	
	@Test
	public void testUpdateWithMasLocationRepositoryShouldPass() throws Exception {
		
		masLocationRepository.create(masLocation);
		Integer insertedId = masLocation.getId();
		
		MasLocation update = masLocationRepository.find(insertedId);
		update.setName("test update");
		masLocationRepository.update(update);
		
		MasLocation result = masLocationRepository.find(update.getId());
		
		assertThat(result.getName(), is("test update"));
		
	}
	
	@Test
	public void testDeleteWithMasLocationRepositoryShouldPass() throws Exception {
		
		masLocationRepository.create(masLocation);
		Integer insertedId = masLocation.getId();
		
		MasLocation delete = masLocationRepository.find(insertedId);
		masLocationRepository.delete(delete);
		
		MasLocation result = masLocationRepository.find(delete.getId());
		
		assertNull(result);
		
	}
	
	@Test
	public void testDeleteByIdWithMasLocationRepositoryShouldPass() throws Exception {
		
		masLocationRepository.create(masLocation);
		Integer insertedId = masLocation.getId();
		
		MasLocation delete = masLocationRepository.find(insertedId);
		masLocationRepository.deleteById(delete.getId());
		
		MasLocation result = masLocationRepository.find(delete.getId());
		
		assertNull(result);
		
	}
		
}