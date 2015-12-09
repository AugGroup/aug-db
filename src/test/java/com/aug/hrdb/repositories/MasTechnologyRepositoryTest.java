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

import com.aug.hrdb.entities.MasTechnology;
import com.aug.hrdb.repositories.MasTechnologyRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class MasTechnologyRepositoryTest {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private MasTechnologyRepository masTechnologyRepository;
	
	private MasTechnology masTechnology;
	
	@Before
	public void setUp() throws Exception {
		
		masTechnology = new MasTechnology();
		masTechnology.setName("test");
		masTechnology.setCode("004A");
		masTechnology.setIsActive(true);
		masTechnology.setAuditFlag("C");
		masTechnology.setCreatedBy(0);
		masTechnology.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testLoadSessionFactoryShouldPass() throws Exception {
		assertNotNull(sessionFactory);
	}
	
	@Test
	public void testLoadMasTechnologyRepositoryShouldPass() throws Exception {
		assertNotNull(masTechnologyRepository);
	}
	
	@Test
	public void testCreateWithMasTechnologyRepositoryShouldPass() throws Exception {
		
		masTechnology.setName("test create");
		masTechnologyRepository.create(masTechnology);
		Integer insertedId = masTechnology.getId();
		
		MasTechnology result = masTechnologyRepository.find(insertedId);
		
		assertThat(result.getName(), is("test create"));
		
	}
	
	@Test
	public void testFindByIdWithMasTechnologyRepositoryShouldPass() throws Exception {
		
		masTechnology.setName("test findById");
		masTechnologyRepository.create(masTechnology);
		Integer insertedId = masTechnology.getId();
		
		MasTechnology result = masTechnologyRepository.find(insertedId);
		
		assertThat(result.getName(), is("test findById"));
		
	}
	
	@Test
	public void testFindAllWithMasTechnologyRepositoryShouldPass() throws Exception {
		
		List<MasTechnology> masTechnologys = masTechnologyRepository.findAll();
		
		masTechnologyRepository.create(masTechnology);
		
		List<MasTechnology> result = masTechnologyRepository.findAll();
		
		assertThat(result.size(), is(masTechnologys.size() + 1));
		
	}
	
	@Test
	public void testUpdateWithMasTechnologyRepositoryShouldPass() throws Exception {
		
		masTechnologyRepository.create(masTechnology);
		Integer insertedId = masTechnology.getId();
		
		MasTechnology update = masTechnologyRepository.find(insertedId);
		update.setName("test update");
		masTechnologyRepository.update(update);
		
		MasTechnology result = masTechnologyRepository.find(update.getId());
		
		assertThat(result.getName(), is("test update"));
		
	}
	
	@Test
	public void testDeleteWithMasTechnologyRepositoryShouldPass() throws Exception {
		
		masTechnologyRepository.create(masTechnology);
		Integer insertedId = masTechnology.getId();
		
		MasTechnology delete = masTechnologyRepository.find(insertedId);
		masTechnologyRepository.delete(delete);
		
		MasTechnology result = masTechnologyRepository.find(delete.getId());
		
		assertNull(result);
		
	}
	
	@Test
	public void testDeleteByIdWithMasTechnologyRepositoryShouldPass() throws Exception {
		
		masTechnologyRepository.create(masTechnology);
		Integer insertedId = masTechnology.getId();
		
		MasTechnology delete = masTechnologyRepository.find(insertedId);
		masTechnologyRepository.deleteById(delete.getId());
		
		MasTechnology result = masTechnologyRepository.find(delete.getId());
		
		assertNull(result);
		
	}

}