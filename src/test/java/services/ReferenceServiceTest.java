package services;

import java.util.Calendar;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Reference;
import com.aug.hrdb.services.ReferenceService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@TransactionConfiguration
@Transactional
public class ReferenceServiceTest {
	@Autowired
	private ReferenceService referenceService;

	@Test
	@Rollback(true)
	public void createReferenceShouldSuccess(){
		Reference reference = new Reference();
		reference.setAddress("Bangkok");
		reference.setAuditFlag("C");
		reference.setCreatedBy(1);
		reference.setCreatedTimeStamp(Calendar.getInstance().getTime());
		reference.setName("Jutamas");
		reference.setOccupation("Programmer");
		reference.setTel("0817334542");
		referenceService.create(reference);

	}

    @Test(expected = ConstraintViolationException.class)
    @Rollback(true)
    public void createReferenceWithoutRequiredFieldShouldFailed(){
        Reference reference = new Reference();
        reference.setName("Phicha");

        referenceService.create(reference);
    }
	
	

//
//	@Test
//	@Rollback(false)
//	public void updateReference(){
//		
//		Reference reference = (Reference)referenceService.find(7);
//		reference.setName("Phiicha");
//		referenceService.update(reference);
//	}

	
	
//	@Test
//	@Rollback(false)
//	public void deleteReference(){
//		
//		Reference reference = (Reference)referenceService.find(7);
//		referenceService.deleteById(reference);
//	}
//	
	

//	@Test
//	public void findAllReference(){
//		
//		List<Reference> references = referenceService.findAll();
//		Assert.assertEquals(18, references.size());
//		
//		
//	}
	
	
//
//	@Test
//	public void findByIdReference(){
//		
//		Reference reference = (Reference)referenceService.find(19);	
//		int id = reference.getId();
//		Assert.assertEquals(19,id);
//		
//		
//	}
}
