package repositories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.entities.MasDivision;
import com.aug.hrdb.entities.MasJobLevel;
import com.aug.hrdb.entities.MasTechnology;
import com.aug.hrdb.entities.Probation;
import com.aug.hrdb.entities.Reference;
import com.aug.hrdb.repositories.ApplicantRepository;
import com.aug.hrdb.repositories.EmployeeRepository;
import com.aug.hrdb.repositories.MasDivisionRepository;
import com.aug.hrdb.repositories.MasJoblevelRepository;
import com.aug.hrdb.repositories.MasTechnologyRepository;
import com.aug.hrdb.repositories.ReferenceRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class ReferenceRepositoryTest {
	@Autowired private ReferenceRepository referenceRepository;
	@Autowired private ApplicantRepository applicantRepository;
	@Autowired private EmployeeRepository employeeRepository;
	@Autowired private MasJoblevelRepository masJoblevelRepository;
	@Autowired private MasTechnologyRepository masTechnologyRepository;
	
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

		masJoblevelRepository.create(masJoblevel);
		masJoblevelRepository.find(1);
		applicant.setJoblevel(masJoblevel);

		MasTechnology masTech = new MasTechnology();
		masTech.setName("Java");
		masTech.setCode("001A");
		masTech.setIsActive(true);
		masTech.setAuditFlag("C");
		masTech.setCreatedBy(0);
		Calendar cal = Calendar.getInstance();
		masTech.setCreatedTimeStamp(cal.getTime());
		masTechnologyRepository.create(masTech);
		applicant.setTechnology(masTech);
		
		applicantRepository.create(applicant);
        		
		Applicant applicant1 =  applicantRepository.find(1);
        
		Reference reference = new Reference();
		reference.setAddress("Bangkok");
		reference.setAuditFlag("C");
		reference.setCreatedBy(1);
		reference.setCreatedTimeStamp(Calendar.getInstance().getTime());
		reference.setName("Jutamas");
		reference.setOccupation("Programmer");
		reference.setTel("0817334542");
		reference.setApplicant(applicant1);
		referenceRepository.create(reference);
		
		id=reference.getId();
	}
	
	@Test
	@Rollback(true)
	public void create(){
		Reference reference = new Reference();
		reference.setAddress("Bangkok");
		reference.setAuditFlag("C");
		reference.setCreatedBy(1);
		reference.setCreatedTimeStamp(Calendar.getInstance().getTime());
		reference.setName("Jutamas");
		reference.setOccupation("Programmer");
		reference.setTel("0817334542");
		Applicant applicant = applicantRepository.find(1);
		reference.setApplicant(applicant);
		referenceRepository.create(reference);
	}

	@Test
	public void update(){
		Reference reference = (Reference) referenceRepository.getCurrentSession().get(Reference.class,id);
		reference.setOccupation("HR");
		referenceRepository.getCurrentSession().update(reference);
	}
	
	@Test
	public void delete(){
		Reference reference = (Reference) referenceRepository.getCurrentSession().get(Reference.class,id);
		referenceRepository.getCurrentSession().delete(reference);
	}
	
	@Test
	public void findById(){
		Reference reference = (Reference) referenceRepository.getCurrentSession().get(Reference.class,id);
		int idRef = reference.getId();
		Assert.assertEquals(id, idRef);
	}
	
	@Test
	public void findAll(){	
		List<Reference> references = referenceRepository.findAll();
		Assert.assertEquals(5, references.size());
	}
}
