package com.aug.hrdb.services;

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
import com.aug.hrdb.services.AugRequestService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-bean-db-test.xml")
@Transactional
public class AugRequestServiceTest {
	
	@Autowired
	private AugRequestService augRequestService;

	@Before
	public void setupAugRequest() throws ParseException{
		AugRequest augRequest = new AugRequest();
		
		SimpleDateFormat dateFmt = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
		/*augRequest.setApproveDate(dateFmt.parse("16/09/2015"));*/
		augRequest.setAuditFlag("C");
		augRequest.setCreatedBy(1);
		augRequest.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
		augRequestService.create(augRequest);
		
	}
	
	@Test
	@Rollback
	public void createServiceTest() throws ParseException {
		AugRequest augRequest = new AugRequest();
		
		SimpleDateFormat dateFmt = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
		/*augRequest.setApproveDate(dateFmt.parse("16/09/2015"));*/
		augRequest.setAuditFlag("C");
		augRequest.setCreatedBy(1);
		augRequest.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
		augRequestService.create(augRequest);
		
	}
	
	@Test
	@Rollback
	public void findByIdAugRequestServiceTest() {
		AugRequest augRequest = augRequestService.findById(1);
		assertNotNull(augRequest);
	}
	
	@Test
	@Rollback
	public void updateAugRequestServiceTest() throws ParseException{
		AugRequest augRequest = augRequestService.findById(1);
		
		SimpleDateFormat dateFmt = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
	/*	augRequest.setApproveDate(dateFmt.parse("10/09/2015"));*/
		
		augRequestService.update(augRequest);
	}
	
	@Test
	@Rollback
	public void deleteAugRequestServiceTest() {
		AugRequest augRequest = augRequestService.findById(1);
		augRequestService.delete(augRequest);
	}
	
	@Test
	@Rollback
	public void deleteByIdAugRequestServiceTest() {
		augRequestService.deleteById(1);
	}
}
