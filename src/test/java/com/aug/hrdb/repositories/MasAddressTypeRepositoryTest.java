/**
 *
 * @author natechanok
 * @date Sep 4, 2015
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

import com.aug.hrdb.entities.MasAddressType;
import com.aug.hrdb.repositories.MasAddressTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@TransactionConfiguration
@Transactional
public class MasAddressTypeRepositoryTest {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private MasAddressTypeRepository masAddressTypeRepository;
	
	MasAddressType masAddressType;
	int id;
	
	
	@Before
	public void setUp() throws Exception {
		
		masAddressType = new MasAddressType();
		masAddressType.setName("Present Address");
		masAddressType.setCode("B02");
		masAddressType.setIsActive(true);
		masAddressType.setAuditFlag("C");
		masAddressType.setCreatedBy(1);
		masAddressType.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testLoadSessionFactoryShouldPass() throws Exception {
		assertNotNull(sessionFactory);
	}
	
	@Test
	public void testLoadMasAddressRepositoryShouldPass() throws Exception {
		assertNotNull(masAddressType);
	}
	
	@Test
	public void testCreateWithMasAddressTypeRepositoryShouldPass() throws Exception {
		
		masAddressType.setName("test create");
		masAddressTypeRepository.create(masAddressType);
		Integer insertId = masAddressType.getId();
		
		MasAddressType result = masAddressTypeRepository.find(insertId);
		
		assertThat(result.getName(), is("test create"));
		
	}
	
	@Test
	public void testFindWithMasAddressTypeRepositoryShouldPass() throws Exception {
		
		masAddressType.setName("test find");
		masAddressTypeRepository.create(masAddressType);
		Integer insertId = masAddressType.getId();
		
		MasAddressType result = masAddressTypeRepository.find(insertId);
		
		assertThat(result.getName(), is("test find"));
		
	}
	
	@Test
	public void testFindAllWithMasAddresstypeRepositoryShouldPass() throws Exception {
		
		List<MasAddressType> findAll = masAddressTypeRepository.findAll();
		
		masAddressTypeRepository.create(masAddressType);
				
		List<MasAddressType> result = masAddressTypeRepository.findAll();
		
		assertThat(result.size(), is(findAll.size() + 1));
		
	}
	
	@Test
	public void testFindByCriteriaWithMasAddressTypeRepositoryShouldPass() throws Exception {
		
		masAddressType.setName("find criteria");
		masAddressTypeRepository.create(masAddressType);
		
		List<MasAddressType> result = masAddressTypeRepository.findByCriteria(masAddressType);

		assertThat(result.size(), is(1));
		
	}
	
	@Test
	public void testUpdateWithMasAddressTypeRepositoryShouldPass() throws Exception {
		
		masAddressTypeRepository.create(masAddressType);
		Integer insertId = masAddressType.getId();
		
		MasAddressType update = masAddressTypeRepository.find(insertId);
		update.setName("update address");
		masAddressTypeRepository.update(update);
		
		MasAddressType result = masAddressTypeRepository.find(update.getId());
		
		assertThat(result.getName(), is("update address"));
		
	}
	
	@Test
	public void testDeleteWithMasAddressTypeRepositoryShouldPass() throws Exception {
		
		masAddressTypeRepository.create(masAddressType);
		Integer insertId = masAddressType.getId();
		
		masAddressTypeRepository.delete(masAddressType);
		
		MasAddressType result = masAddressTypeRepository.find(insertId);

		assertNull(result);
		
	}
	
	@Test
	public void testDeleteByIdWithMasAddressTypeRepositoryShouldPass() throws Exception {
		
		masAddressTypeRepository.create(masAddressType);
		Integer insertId = masAddressType.getId();
		
		masAddressTypeRepository.deleteById(insertId);
		
		MasAddressType result = masAddressTypeRepository.find(insertId);

		assertNull(result);
		
	}
	
}




















