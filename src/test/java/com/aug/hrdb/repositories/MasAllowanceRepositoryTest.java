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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasAllowance;
import com.aug.hrdb.repositories.MasAllowanceRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
@TransactionConfiguration
public class MasAllowanceRepositoryTest {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private MasAllowanceRepository masAllowanceRepository;
	
	MasAllowance masAllowance;
	
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
	public void testLoadSessionFactoryShouldPass() throws Exception {
		assertNotNull(sessionFactory);
	}
	
	@Test
	public void testLoadMassAllowanceRepositoryShouldPass() throws Exception {
		assertNotNull(masAllowanceRepository);
	}
	
	@Test
	public void testCreateWithMasAllowanceRepositoryShouldPass() throws Exception {
		
		masAllowance.setAllowance_type("test create");
		masAllowanceRepository.create(masAllowance);
		Integer insertedId = masAllowance.getId();
		
		MasAllowance result = masAllowanceRepository.find(insertedId);
		
		assertThat(result.getAllowance_type(), is("test create"));		
		
	}
	
	@Test
	public void testFindByIdWithMasAllowanceRepositoryShouldPass() throws Exception {
		
		masAllowance.setAllowance_type("test findById");
		masAllowanceRepository.create(masAllowance);
		Integer insertedId = masAllowance.getId();
		
		MasAllowance result = masAllowanceRepository.find(insertedId);
		
		assertThat(result.getAllowance_type(), is("test findById"));
	}
	
	@Test
	public void testFindAllWithMasAllowanceRepositoryShouldPass() throws Exception {
		
		List<MasAllowance> masAllowances = masAllowanceRepository.findAll();
		
		masAllowanceRepository.create(masAllowance);
		
		List<MasAllowance> result = masAllowanceRepository.findAll();

		assertThat(result.size(), is(masAllowances.size() + 1));
		
	}
	
	@Ignore
	@Test
	public void testFindByCriteriaWithMasAllowanceRepositoryShouldPass() throws Exception {
		
		masAllowance.setAllowance_type("test findByCriteria");
		masAllowanceRepository.create(masAllowance);
		
		List<MasAllowance> result = masAllowanceRepository.findByCriteria(masAllowance);

		assertThat(result.size(), is(1));
		
	}
	
	@Test
	public void testUpdateWithMasAllowanceRepositoryShouldPass() throws Exception {
		
		masAllowanceRepository.create(masAllowance);
		Integer insertedId = masAllowance.getId();
		
		MasAllowance updated = masAllowanceRepository.find(insertedId);
		updated.setAllowance_type("test update");
		masAllowanceRepository.update(updated);
		
		MasAllowance result = masAllowanceRepository.find(updated.getId());

		assertThat(result.getAllowance_type(), is("test update"));
		
	}
	
	@Test
	public void testDeleteWithMasAllowanceRepositoryShouldPass() throws Exception {
		
		masAllowanceRepository.create(masAllowance);
		Integer insertedId = masAllowance.getId();
		
		MasAllowance find = masAllowanceRepository.find(insertedId);
		assertNotNull(find);
		
		masAllowanceRepository.delete(find);
		
		MasAllowance result = masAllowanceRepository.find(find.getId());
		
		assertNull(result);
		
	}
	
	@Test
	public void testDeleteByIdWithMasAllowanceRepositoryShouldPass() throws Exception {
		
		masAllowanceRepository.create(masAllowance);
		Integer insertedId = masAllowance.getId();
		
		MasAllowance find = masAllowanceRepository.find(insertedId);
		assertNotNull(find);
		
		masAllowanceRepository.deleteById(find.getId());
		
		MasAllowance result = masAllowanceRepository.find(find.getId());
		
		assertNull(result);
		
	}
	
}
