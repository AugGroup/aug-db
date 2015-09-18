package repositories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.junit.Assert;
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
import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.entities.Family;
import com.aug.hrdb.entities.MasJoblevel;
import com.aug.hrdb.entities.MasRelationType;
import com.aug.hrdb.entities.MasTechnology;
import com.aug.hrdb.repositories.ApplicantRepository;
import com.aug.hrdb.repositories.FamilyRepository;
import com.aug.hrdb.repositories.MasJoblevelRepository;
import com.aug.hrdb.repositories.MasRelationTypeRepository;
import com.aug.hrdb.repositories.MasTechnologyRepository;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class FamilyRepositoryTest {
	
	@Autowired
    FamilyRepository familyRepository;
	@Autowired
	private MasRelationTypeRepository masRelationTypeRepository;
	@Autowired
	private ApplicantRepository applicantRepository;
	@Autowired 
	private MasTechnologyRepository masTechnologyRepository;
	@Autowired
	private MasJoblevelRepository masJoblevelRepository;
	
	private Employee employee;
	int id;
	int idMasRelationType;
	int appId;
	int masjobId;
	int mastec;
	
	
	@Before
	public void setUp() {
		
		MasTechnology masTechnology = new MasTechnology();
		masTechnology.setName("java");
		masTechnology.setCode("001A");
		masTechnology.setIsActive(true);
		masTechnology.setAuditFlag("C");
		masTechnology.setCreatedBy(0);
		Calendar cal = Calendar.getInstance();
		masTechnology.setCreatedTimeStamp(cal.getTime());
		masTechnologyRepository.create(masTechnology);
		mastec=masTechnology.getId();
 		
		MasTechnology mTechnology= masTechnologyRepository.find(mastec);
 		

		MasJoblevel masJoblevel = new MasJoblevel();
		masJoblevel.setName("CEO");
		masJoblevel.setIsActive(true);
		masJoblevel.setCode("01");
		masJoblevel.setAuditFlag("C");
		masJoblevel.setCreatedBy(1);
		masJoblevel.setCreatedTimeStamp(Calendar.getInstance().getTime());
		masJoblevel.setCode("Division-01");

		masJoblevelRepository.create(masJoblevel);
		masjobId=masJoblevel.getId();
		MasJoblevel mJob= masJoblevelRepository.find(masjobId);
		
        Applicant applicant = new Applicant();
		applicant.setCreatedBy(1);
		applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
		applicant.setAuditFlag("C");
		applicant.setCardId("115310905001-9");
		applicant.setTechnology(mTechnology);
		applicant.setJoblevel(mJob);
		applicantRepository.create(applicant);
		int appId = applicant.getId();
        Applicant applicant1 = applicantRepository.find(appId);
        Hibernate.initialize(applicant1);
        
   
        
        MasRelationType masRelationType1 = new MasRelationType();
    	masRelationType1.setRelationType("Parent");
    	masRelationType1.setAuditFlag("C");
    	masRelationType1.setCode("REL-03");
    	masRelationType1.setCreatedBy(1);
    	masRelationType1.setCreatedTimeStamp(Calendar.getInstance().getTime());
    	masRelationType1.setIsActive(true);
    	masRelationTypeRepository.create(masRelationType1);
    	
        idMasRelationType = masRelationType1.getId();
    	MasRelationType masRelationType = masRelationTypeRepository.find(idMasRelationType);
    	
    	
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
	
		familyRepository.create(family);
		id = family.getId();
	}
	
	

	@Test
	@Rollback(true)
	public void create() {
	
		Family family = familyRepository.find(id);
		Assert.assertEquals("Apiva kim", family.getFamilyName());

	
	}
	
	
	
	
	
	
	@Test
	@Rollback(true)
	public void update() {
	
	
		Family family = familyRepository.find(id);
		family.setFamilyName("Augmentis test");
		family.setAuditFlag("U");
		family.setUpdatedBy(1);
		family.setUpdatedTimeStamp(Calendar.getInstance().getTime());
	
		familyRepository.update(family);
	
	}
	
	
	
	
	@Test
	@Rollback(true)
	public void delete() {
	
		Family family = familyRepository.find(id);
		familyRepository.delete(family);
	
	}
	
	
	
	
	@Test
	public void find() {
	
		Family family = familyRepository.find(id);
		Assert.assertEquals(id, id);
	}
	
	
	
	
	
	@Test
	public void findAll() {
	
		List<Family> family = familyRepository.findAll();
	
	}
	
	
	
	@Test
	@Rollback(true)
	public void deleteByNameQuery(){
		
		Family family = familyRepository.find(id);
		FamilyDto familyDto = new FamilyDto();
		familyDto.setId(family.getId());
		familyRepository.deleteByNameQuery(familyDto);
		
	}
	

}
