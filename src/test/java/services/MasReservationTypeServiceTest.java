package services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasReservationType;
import com.aug.hrdb.services.MasReservationTypeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@TransactionConfiguration
@Transactional
public class MasReservationTypeServiceTest {
	@Autowired
	private MasReservationTypeService masReservationTypeService;
	
	int id;
	
	private MasReservationType masReservationType;
	
	@Before
	public void setUp() {
		masReservationType = new MasReservationType();
		masReservationType.setName("meeting");
		masReservationType.setCode("01");
		masReservationType.setIsactive(true);
		masReservationType.setAuditFlag("C");
		masReservationType.setCreatedBy(1);
		masReservationType.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
		masReservationTypeService.create(masReservationType);
		id = masReservationType.getId();
	}
	

	@Test
	public void testInsertMasReservationTypeService() throws Exception { 
		
		MasReservationType result = masReservationTypeService.findById(id);
		assertThat(result.getName(), is("meeting"));
		assertThat(result.getCode(), is("01"));
		assertThat(result.getAuditFlag(), is("C"));
				
	}
	
	@Test
	public void testUpdateMasReservationTypeService() throws Exception {
		MasReservationType updateMasReservationType = masReservationTypeService.findById(id);
		updateMasReservationType.setName("update");
		masReservationTypeService.update(updateMasReservationType);
		
		MasReservationType result = masReservationTypeService.findById(id);
		assertThat(result.getName(), is("update"));
				
	}
	
	@Test
	public void testDeleteByIdMasReservationTypeService() throws Exception {
		
		masReservationTypeService.deleteById(id);
		MasReservationType result = masReservationTypeService.findById(id);
		assertNull(result);
	}
	
	@Test
	
	public void testDeleteMasReservationTypeService() throws Exception {

		masReservationTypeService.delete(masReservationType);
		MasReservationType result = masReservationTypeService.findById(id);

		assertNull(result);
	}
	@Test
	public void testFindByIdMasReservationTypeService() throws Exception {
		
		MasReservationType result = masReservationTypeService.findById(id);
		assertThat(result.getName(),is("meeting"));

		
	}
	@Test
	public void testfindAllMasReservationTypeService(){	
		
		List<MasReservationType> masReservationTypes = masReservationTypeService.findAll();
		Assert.assertEquals(4, masReservationTypes.size());
	}
}
