package com.aug.hrdb.repositories;

import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.AugRequest;
import com.aug.hrdb.repositories.AugRequestRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class AugRequestRepositoryTest {
	
	@Autowired
	private AugRequestRepository augRequestRepository;
	
	@Before
	public void setupAugRequest() throws ParseException {
		SimpleDateFormat dateFmt = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
		AugRequest augRequest = new AugRequest();
		/*augRequest.setApproveDate(dateFmt.parse("04/09/2015"));*/
		augRequest.setAuditFlag("C");
		augRequest.setCreatedBy(1);
		augRequest.setCreatedTimeStamp(Calendar.getInstance().getTime());

		augRequestRepository.create(augRequest);
	}
	
	@Test
	@Rollback
	public void createAugRequestRepositoryTest() throws ParseException {
		SimpleDateFormat dateFmt = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
		AugRequest augRequest = new AugRequest();
		/*augRequest.setApproveDate(dateFmt.parse("04/09/2015"));*/
		augRequest.setAuditFlag("C");
		augRequest.setCreatedBy(1);
		augRequest.setCreatedTimeStamp(Calendar.getInstance().getTime());
	}
	
	@Test
	@Rollback
	public void findByIdAugRequestRepositoryTest() {
		AugRequest augRequest = augRequestRepository.find(1);
		assertNotNull(augRequest);
	}
	
	@Test
	@Rollback
	public void updateAugRequestRepositoryTest() throws ParseException {
		AugRequest augRequest = augRequestRepository.find(1);
		SimpleDateFormat dateFmt = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
		/*augRequest.setApproveDate(dateFmt.parse("07/09/2015"));*/
		augRequest.setAuditFlag("C");
		augRequest.setCreatedBy(1);
		augRequest.setCreatedTimeStamp(Calendar.getInstance().getTime());
		augRequestRepository.update(augRequest);

	}
	
	@Test
	@Rollback
	public void deleteRepositoryTest() {
		AugRequest augRequest = augRequestRepository.find(1);
		augRequestRepository.delete(augRequest);
	}
	
	@Test
	@Rollback
	public void deleteByIdRepositoryTest() {
		augRequestRepository.deleteById(1);
	}

}
