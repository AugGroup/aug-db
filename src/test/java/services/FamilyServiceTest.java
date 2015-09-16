package services;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Hibernate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.FamilyDto;
import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Family;
import com.aug.hrdb.entities.MasRelationType;
import com.aug.hrdb.repositories.FamilyRepository;
import com.aug.hrdb.repositories.MasRelationTypeRepository;
import com.aug.hrdb.services.ApplicantService;
import com.aug.hrdb.services.EmployeeService;
import com.aug.hrdb.services.FamilyService;
import com.aug.hrdb.services.MasRelationTypeService;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class FamilyServiceTest {
	
	
	@Autowired
	FamilyService familyService;
	@Autowired
	private MasRelationTypeService masRelationTypeService;
	@Autowired
	private ApplicantService applicantService;
	
	int id;
	int idMasRelationType;
	
	@Before
	public void setUp() {
		
		 Applicant applicant = new Applicant();
			applicant.setCreatedBy(1);
			applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
			applicant.setAuditFlag("C");
			applicant.setCardId("115310905001-9");
			applicantService.create(applicant);
			int appId = applicant.getId();
	        Applicant applicant1 = applicantService.findById(appId);
	        Hibernate.initialize(applicant1);
	        
	   
	        
	        MasRelationType masRelationType1 = new MasRelationType();
	    	masRelationType1.setRelationType("Parent");
	    	masRelationType1.setAuditFlag("C");
	    	masRelationType1.setCode("REL-03");
	    	masRelationType1.setCreatedBy(1);
	    	masRelationType1.setCreatedTimeStamp(Calendar.getInstance().getTime());
	    	masRelationType1.setIsActive(true);
	    	masRelationTypeService.create(masRelationType1);
	    	
	        idMasRelationType = masRelationType1.getId();
	    	MasRelationType masRelationType = masRelationTypeService.find(idMasRelationType);
	    	
	    	
	    	Family family = new Family();

			family.setFamilyName("Apiva kim");
			family.setGender("Female");
			family.setAge(25);
			family.setMobile("089-085-1022");
			family.setAddress("1/1");
			family.setOccupation("ITS");
			family.setPosition("Programmer");
			family.setApplicant(applicant1);

			family.setMasRelationType(masRelationType);
			
			family.setAuditFlag("C");
			family.setCreatedBy(1);
			family.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
			familyService.create(family);
			id = family.getId();
	}

	@Test
	@Rollback(true)
	public void create() {
	
		Family family = familyService.find(id);
		Assert.assertEquals("Apiva kim", family.getFamilyName());

	}
	
	
	@Test
	@Rollback(true)
	public void update() {
	
	
		Family family = familyService.find(id);
		family.setFamilyName("test");
		family.setAuditFlag("U");
		family.setUpdatedBy(1);
		family.setUpdatedTimeStamp(Calendar.getInstance().getTime());
	
		familyService.update(family);
	
	}
	
	
	
	
	@Test
	@Rollback(true)
	public void delete() {
	
		Family family = familyService.find(id);
		familyService.delete(family);
	
	}
	
	
	
	
	@Test
	public void find() {
	
		Family family = familyService.find(id);
		Assert.assertEquals(id, id);
	}
	
	
	
	
	
	@Test
	
	public void findAll() {
	
		List<Family> family = familyService.findAll();
	}
	
	
	
	
	@Test
	@Rollback(true)
	public void deleteByNameQuery(){
		
		Family family = familyService.find(id);
		FamilyDto familyDto = new FamilyDto();
		familyDto.setId(family.getId());
		familyService.deleteByNameQuery(familyDto);
		
	}
	
	
	
	
	@Test
	@Rollback(true)
	public void updateByNameQuery(){
		
		Family family = familyService.find(id);
		FamilyDto familyDto = new FamilyDto();
		familyDto.setId(family.getId());
		familyDto.setFamilyName("test family data");
		familyDto.setAge(family.getAge());
		familyDto.setAddress(family.getAddress());
		familyDto.setMasRelationTypeId(family.getMasRelationType().getId());
		familyDto.setMobile(family.getMobile());
		familyDto.setPosition(family.getPosition());
		familyDto.setOccupation(family.getOccupation());
		familyDto.setGender(family.getGender());
		familyService.updateByNameQuery(familyDto);
	
	}
	
	
	
	@Test
	@Rollback(true)
	public void createFindMasRelationAndEmployee(){
		
		FamilyDto familyDto = new FamilyDto();
		familyDto.setFamilyName("test create data");
		familyDto.setAge(25);
		familyDto.setAddress("HOME");
		familyDto.setMasRelationTypeId(1);
		familyDto.setMobile("089-085-1022");
		familyDto.setPosition("PROGRAMER");
		familyDto.setOccupation("ITS");
		familyDto.setGender("Female");
		familyService.createFindMasRelationAndEmployee(familyDto);

		
	}
	

}
