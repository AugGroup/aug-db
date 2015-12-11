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

import com.aug.hrdb.entities.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@TransactionConfiguration
@Transactional
public class ClientServiceTest {

	@Autowired
	private ClientService clientService;
	
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
	public void testLoadClientServiceShouldPass() throws Exception {
		assertNotNull(clientService);
	}
	
	@Test
	public void testCreateWithClientServiceShouldPass() throws Exception {
		
		client.setName("test create");
		clientService.create(client);
		Integer insertedId = client.getId();
		
		Client result = clientService.findById(insertedId);
		
		assertThat(result.getName(), is("test create"));
		
	}
	
	@Test
	public void testFindByIdWithClientServiceShouldPass() throws Exception {
		
		client.setName("test findById");
		clientService.create(client);
		Integer insertedId = client.getId();
		
		Client result = clientService.findById(insertedId);
		
		assertThat(result.getName(), is("test findById"));
		
	}
	
	@Test
	public void testFindAllWithClientServiceShouldPass() throws Exception {
		
		List<Client> clients = clientService.findAll();
		
		clientService.create(client);
		
		List<Client> result = clientService.findAll();
		
		assertThat(result.size(), is(clients.size() + 1));
		
	}
	
	@Test
	public void testUpdateWithClientServiceShouldPass() throws Exception {
		
		clientService.create(client);
		Integer insertedId = client.getId();
		
		Client update = clientService.findById(insertedId);
		update.setName("test update");
		clientService.update(update);
		
		Client result = clientService.findById(update.getId());
		
		assertThat(result.getName(), is("test update"));
		
	}
	
	@Test
	public void testDeleteWithClientServiceShouldPass() throws Exception {
		
		clientService.create(client);
		Integer insertedId = client.getId();
		
		Client delete = clientService.findById(insertedId);
		clientService.delete(delete);
		
		Client result = clientService.findById(delete.getId());
		
		assertNull(result);
		
	}
	
	@Test
	public void testDeleteByIdWithClientServiceShouldPass() throws Exception {
		
		clientService.create(client);
		Integer insertedId = client.getId();
		
		Client delete = clientService.findById(insertedId);
		clientService.deleteById(delete.getId());
		
		Client result = clientService.findById(delete.getId());
		
		assertNull(result);
		
	}
	
}
