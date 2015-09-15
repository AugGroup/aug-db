package services;

import java.util.Calendar;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Reference;
import com.aug.hrdb.services.ApplicantService;
import com.aug.hrdb.services.ReferenceService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@TransactionConfiguration
@Transactional
public class ReferenceServiceTest {
	@Autowired
	private ReferenceService referenceService;
	@Autowired 
	ApplicantService applicantService;

	@Test
	@Rollback(true)
	public void createReference(){
		Reference reference = new Reference();
		reference.setAddress("Bangkok");
		reference.setAuditFlag("C");
		reference.setCreatedBy(1);
		reference.setCreatedTimeStamp(Calendar.getInstance().getTime());
		reference.setName("Jutamas");
		reference.setOccupation("Programmer");
		reference.setTel("0817334542");
		reference.setApplicant(applicantService.findById(1));
		referenceService.create(reference);

	}
	
	@Test
	public void updateReference(){	
		Reference reference = (Reference)referenceService.findById(2);
		reference.setName("Phicha");
		referenceService.update(reference);
	}

	
	
	@Test
	public void deleteReference(){		
		Reference reference = (Reference)referenceService.findById(2);
		referenceService.deleteById(reference.getId());
	}
	
	

	@Test
	public void findAllReference(){		
		List<Reference> references = referenceService.findAll();
		Assert.assertEquals(4, references.size());
		
		
	}
	
	

	@Test
	public void findByIdReference(){	
		Reference reference = (Reference) referenceService.findById(1);	
		int id = reference.getId();
		Assert.assertEquals(1,id);
		
		
	}
}
