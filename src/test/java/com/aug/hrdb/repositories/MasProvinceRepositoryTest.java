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

import com.aug.hrdb.entities.MasProvince;
import com.aug.hrdb.repositories.MasProvinceRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class MasProvinceRepositoryTest {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired 
	MasProvinceRepository masProvinceRepository;
	
	private MasProvince masProvince;
	
	@Before
	public void setUp() throws Exception {
		
		masProvince = new MasProvince();
		masProvince.setName("test");
		masProvince.setCode("PRO-01");
		masProvince.setIsActive(true);
		masProvince.setAuditFlag("C");
		masProvince.setCreatedBy(1);
		masProvince.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testLoadSessionFactoryShouldPass() throws Exception {
		assertNotNull(sessionFactory);
	}
	
	@Test
	public void testLoadMasProvinceRepositoryShouldPass() throws Exception {
		assertNotNull(masProvinceRepository);
	}
	
	@Test
	public void testCreateWithMasProvinceRepositoryShouldPass() throws Exception {
		
		masProvince.setName("test create");
		masProvinceRepository.create(masProvince);
		Integer insertedId = masProvince.getId();
		
		MasProvince result = masProvinceRepository.find(insertedId);
		
		assertThat(result.getName(), is("test create"));
		
	}
	
	@Test
	public void testFindByIdWithMasProvinceRepositoryShouldPass() throws Exception {
		
		masProvince.setName("test findById");
		masProvinceRepository.create(masProvince);
		Integer insertedId = masProvince.getId();
		
		MasProvince result = masProvinceRepository.find(insertedId);
		
		assertThat(result.getName(), is("test findById"));
		
	}
	
	@Test
	public void testFindAllWithMasProvinceRepositoryShouldPass() throws Exception {
		
		List<MasProvince> masProvinces = masProvinceRepository.findAll();
		
		masProvinceRepository.create(masProvince);
		
		List<MasProvince> result = masProvinceRepository.findAll();
		
		assertThat(result.size(), is(masProvinces.size() + 1));
		
	}
	
	@Test
	public void testFindByLocationCodeWithMasProvinceRepositoryShouldPass() throws Exception {
		
		masProvince.setCode("test findByCode");
		masProvinceRepository.create(masProvince);
		Integer insertedId = masProvince.getId();
		
		MasProvince result = masProvinceRepository.find(insertedId);
		
		assertThat(result.getCode(), is("test findByCode"));
		
	}
	
	@Test
	public void testUpdateWithMasProvinceRepositoryShouldPass() throws Exception {
		
		masProvinceRepository.create(masProvince);
		Integer insertedId = masProvince.getId();
		
		MasProvince update = masProvinceRepository.find(insertedId);
		update.setName("test update");
		masProvinceRepository.update(update);
		
		MasProvince result = masProvinceRepository.find(update.getId());
		
		assertThat(result.getName(), is("test update"));
		
	}
	
	@Test
	public void testDeleteWithMasProvinceRepositoryShouldPass() throws Exception {
		
		masProvinceRepository.create(masProvince);
		Integer insertedId = masProvince.getId();
		
		MasProvince delete = masProvinceRepository.find(insertedId);
		masProvinceRepository.delete(delete);
		
		MasProvince result = masProvinceRepository.find(delete.getId());
		
		assertNull(result);
		
	}
	
	@Test
	public void testDeleteByIdWithMasProvinceRepositoryShouldPass() throws Exception {
		
		masProvinceRepository.create(masProvince);
		Integer insertedId = masProvince.getId();
		
		MasProvince delete = masProvinceRepository.find(insertedId);
		masProvinceRepository.deleteById(delete.getId());
		
		MasProvince result = masProvinceRepository.find(delete.getId());
		
		assertNull(result);
		
	}
	
}