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

import com.aug.hrdb.entities.MasDegreeType;
import com.aug.hrdb.repositories.MasDegreeTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-bean-db-test.xml"})
@TransactionConfiguration
@Transactional
public class MasDegreeTypeRepositoryTest {

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired 
	MasDegreeTypeRepository masDegreeTypeRepository;
	
	private MasDegreeType masDegreeType;
	
	@Before
	public void setUp() throws Exception {
		
		masDegreeType = new MasDegreeType();
		masDegreeType.setName("test");
		masDegreeType.setCode("DE-02");
		masDegreeType.setIsactive(true);
		masDegreeType.setAuditFlag("C");
		masDegreeType.setCreatedBy(1);
		masDegreeType.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testLoadSessionFactoryShouldPass() throws Exception {
		assertNotNull(sessionFactory);
	}
	
	@Test
	public void testLoadMasDegreeTypeRepositoryShouldPass() throws Exception {
		assertNotNull(masDegreeTypeRepository);
	}
	
	@Test
	public void testCreateWithMasDegreeTypeRepositoryShouldPass() throws Exception {
		
		masDegreeType.setName("test create");
		masDegreeTypeRepository.create(masDegreeType);
		Integer insertedId = masDegreeType.getId();
		
		MasDegreeType result = masDegreeTypeRepository.find(insertedId);
		
		assertThat(result.getName(), is("test create"));
		
	}
	
	@Test
	public void testFindByIdWithMasDegreeTypeRepositoryShouldPass() throws Exception {
		
		masDegreeType.setName("test findById");
		masDegreeTypeRepository.create(masDegreeType);
		Integer insertedId = masDegreeType.getId();
		
		MasDegreeType result = masDegreeTypeRepository.find(insertedId);
		
		assertThat(result.getName(), is("test findById"));
		
	}
	
	@Test
	public void testFindAllWithMasDegreeTypeRepositoryShouldPass() throws Exception {
		
		List<MasDegreeType> masDegreeTypes = masDegreeTypeRepository.findAll();
		
		masDegreeTypeRepository.create(masDegreeType);
		
		List<MasDegreeType> result = masDegreeTypeRepository.findAll();
		
		assertThat(result.size(), is(masDegreeTypes.size() + 1));
		
	}
	
	@Test
	public void testFindByCriteriaWithMasDegreeTypeRepositoryShouldPass() throws Exception {
		
		masDegreeType.setName("test findByCriteria");
		masDegreeTypeRepository.create(masDegreeType);
		
		List<MasDegreeType> result = masDegreeTypeRepository.findByCriteria(masDegreeType);
		
		assertThat(result.size(), is(1));
		
	}
	
	@Test
	public void testUpdateWithMasDegreeTypeRepositoryShouldPass() throws Exception {
		
		masDegreeTypeRepository.create(masDegreeType);
		Integer insertedId = masDegreeType.getId();
		
		MasDegreeType update = masDegreeTypeRepository.find(insertedId);
		update.setName("test update");
		masDegreeTypeRepository.update(update);
		
		MasDegreeType result = masDegreeTypeRepository.find(update.getId());
		
		assertThat(result.getName(), is("test update"));
		
	}
	
	@Test
	public void testDeleteWithMasDegreeTypeRepositoryShouldPass() throws Exception {
		
		masDegreeTypeRepository.create(masDegreeType);
		Integer insertedId = masDegreeType.getId();
		
		MasDegreeType delete = masDegreeTypeRepository.find(insertedId);
		masDegreeTypeRepository.delete(delete);
		
		MasDegreeType result = masDegreeTypeRepository.find(delete.getId());
		
		assertNull(result);
		
	}
	
	@Test
	public void testDeleteByIdWithMasDegreeTypeRepositoryShouldPass() throws Exception {
		
		masDegreeTypeRepository.create(masDegreeType);
		Integer insertedId = masDegreeType.getId();
		
		MasDegreeType delete = masDegreeTypeRepository.find(insertedId);
		masDegreeTypeRepository.deleteById(delete.getId());
		
		MasDegreeType result = masDegreeTypeRepository.find(delete.getId());
		
		assertNull(result);
		
	}
	
}
