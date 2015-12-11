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

import com.aug.hrdb.entities.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@TransactionConfiguration
@Transactional
public class ClientRepositoryTest {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private ClientRepository clientRepository;
	
	private Client client;
	
	@Before
	public void setUp() throws Exception {
		
		client = new Client();
		client.setName("test");
		client.setAuditFlag("C");
		client.setCreatedBy(0);
		client.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testLoadSessionFactoryShouldPass() throws Exception {
		assertNotNull(sessionFactory);
	}
	
	@Test
	public void testLoadClientRepositoryShouldPass() throws Exception {
		assertNotNull(clientRepository);
	}
	
	@Test
	public void testCreateWithClientRepositoryShouldPass() throws Exception {
		
		client.setName("test create");
		clientRepository.create(client);
		Integer insertedId = client.getId();
		
		Client result = clientRepository.find(insertedId);
		
		assertThat(result.getName(), is("test create"));
		
	}
	
	@Test
	public void testFindByIdWithClientRepositoryShouldPass() throws Exception {
		
		client.setName("test findById");
		clientRepository.create(client);
		Integer insertedId = client.getId();
		
		Client result = clientRepository.find(insertedId);
		
		assertThat(result.getName(), is("test findById"));
		
	}
	
	@Test
	public void testFindAllWithClientRepositoryShouldPass() throws Exception {
		
		List<Client> clients = clientRepository.findAll();
		
		clientRepository.create(client);
		
		List<Client> result = clientRepository.findAll();
		
		assertThat(result.size(), is(clients.size() + 1));
		
	}
	
	@Test
	public void testUpdateWithClientRepositoryShouldPass() throws Exception {
		
		clientRepository.create(client);
		Integer insertedId = client.getId();
		
		Client update = clientRepository.find(insertedId);
		update.setName("test update");
		clientRepository.update(update);
		
		Client result = clientRepository.find(update.getId());
		
		assertThat(result.getName(), is("test update"));
		
	}
	
	@Test
	public void testDeleteWithClientRepositoryShouldPass() throws Exception {
		
		clientRepository.create(client);
		Integer insertedId = client.getId();
		
		Client delete = clientRepository.find(insertedId);
		clientRepository.delete(delete);
		
		Client result = clientRepository.find(delete.getId());
		
		assertNull(result);
		
	}
	
	@Test
	public void testDeleteByIdWithClientRepositoryShouldPass() throws Exception {
		
		clientRepository.create(client);
		Integer insertedId = client.getId();
		
		Client delete = clientRepository.find(insertedId);
		clientRepository.deleteById(delete.getId());
		
		Client result = clientRepository.find(delete.getId());
		
		assertNull(result);
		
	}
	
}
