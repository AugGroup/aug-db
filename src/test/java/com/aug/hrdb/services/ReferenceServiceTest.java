package com.aug.hrdb.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.MasJobLevel;
import com.aug.hrdb.entities.MasTechnology;
import com.aug.hrdb.entities.Reference;
import com.aug.hrdb.services.ApplicantService;
import com.aug.hrdb.services.EmployeeService;
import com.aug.hrdb.services.MasJoblevelService;
import com.aug.hrdb.services.MasTechnologyService;
import com.aug.hrdb.services.ReferenceService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@TransactionConfiguration
@Transactional
public class ReferenceServiceTest {
	@Autowired private ReferenceService referenceService;
	@Autowired private ApplicantService applicantService;
	@Autowired private EmployeeService employeeService;
	@Autowired private MasJoblevelService masJoblevelService;
	@Autowired private MasTechnologyService masTechnologyService;
	
	SimpleDateFormat dateFmt = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
	int id;
	
	@Before
	public void setReference() throws ParseException{

        Applicant applicant = new Applicant();
		applicant.setCreatedBy(1);
		applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
		applicant.setAuditFlag("C");
		applicant.setCardId("115310905001-9");
		
		MasJobLevel masJoblevel = new MasJobLevel();
		masJoblevel.setName("CEO");
		masJoblevel.setIsActive(true);
		masJoblevel.setCode("01");
		masJoblevel.setAuditFlag("C");
		masJoblevel.setCreatedBy(1);
		masJoblevel.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masJoblevel.setCode("Division-01");

		masJoblevelService.create(masJoblevel);
		masJoblevelService.find(1);
		applicant.setJoblevel(masJoblevel);

		MasTechnology masTech = new MasTechnology();
		masTech.setName("Java");
		masTech.setCode("001A");
		masTech.setIsActive(true);
		masTech.setAuditFlag("C");
		masTech.setCreatedBy(0);
		Calendar cal = Calendar.getInstance();
		masTech.setCreatedTimeStamp(cal.getTime());
		masTechnologyService.create(masTech);
		applicant.setTechnology(masTech);
		
		applicantService.create(applicant);
        		
		Applicant applicant1 =  applicantService.findById(1);
        
		Reference reference = new Reference();
		reference.setAddress("Bangkok");
		reference.setAuditFlag("C");
		reference.setCreatedBy(1);
		reference.setCreatedTimeStamp(Calendar.getInstance().getTime());
		reference.setName("Jutamas");
		reference.setOccupation("Programmer");
		reference.setTel("0817334542");
		reference.setApplicant(applicant1);
		referenceService.create(reference);
		
		id=reference.getId();
	}
	
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
		Reference reference = (Reference)referenceService.findById(id);
		reference.setName("Phicha");
		referenceService.update(reference);
	}

	
	
	@Test
	public void deleteReference(){		
		Reference reference = (Reference)referenceService.findById(id);
		referenceService.deleteById(reference.getId());
	}
	
	

	@Test
	public void findAllReference(){		
		List<Reference> references = referenceService.findAll();
		Assert.assertEquals(5, references.size());
		
		
	}
	
	

	@Test
	public void findByIdReference(){	
		Reference reference = (Reference) referenceService.findById(id);	
		int idRef = reference.getId();
		Assert.assertEquals(id,idRef);
		
		
	}
}
