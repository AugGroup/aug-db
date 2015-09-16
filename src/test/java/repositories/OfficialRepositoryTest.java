/**
 *
 * @author natechanok
 * @date Sep 4, 2015
 */

package repositories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.hibernate.Hibernate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.entities.Official;
import com.aug.hrdb.repositories.ApplicantRepository;
import com.aug.hrdb.repositories.EmployeeRepository;
import com.aug.hrdb.repositories.MasDivisionRepository;
import com.aug.hrdb.repositories.MasJoblevelRepository;
import com.aug.hrdb.repositories.OfficialRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class OfficialRepositoryTest {
	
	@Autowired
	private OfficialRepository officialRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private ApplicantRepository applicantRepository;
	@Autowired
	private MasDivisionRepository masdivisionRepository;
	@Autowired
	private MasJoblevelRepository masjoblevelRepository;
	
	Employee employee;
	
	int idEmployee;
	int id;
	
	@Before
	public void setUp() {
		
	
		Official official = new Official();
	    Calendar cal = Calendar.getInstance();
		official.setOfficialDate(cal.getTime());
		official.setStartWorkDate(cal.getTime());
		official.setEndWorkDate(cal.getTime());
		official.setPositionAppliedFor("Programmers");
		official.setSalaryExpected("500000000");
		official.setProbationDate(cal.getTime());
		official.setAuditFlag("C");
		official.setCreatedBy(1);
		official.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
		officialRepository.create(official);
		id = official.getId();
		
	}
	
	@Test
	@Rollback(true)
	public void create() {
		
		Employee employee = employeeRepository.find(1);
		
		Official official = new Official();
	    Calendar cal = Calendar.getInstance();
		official.setOfficialDate(cal.getTime());
		official.setStartWorkDate(cal.getTime());
		official.setEndWorkDate(cal.getTime());
		official.setPositionAppliedFor("Programmer");
		official.setSalaryExpected("500000000");
		official.setProbationDate(cal.getTime());
		official.setAuditFlag("C");
		official.setCreatedBy(1);
		official.setCreatedTimeStamp(Calendar.getInstance().getTime());
		
		
		
		officialRepository.create(official);
		
		
	}
	
	@Test
	@Rollback(true)
	public void updateOfficial() {
		
		Official official = officialRepository.find(id);
		official.setPositionAppliedFor("BBA");
		officialRepository.update(official);
	}
	
	@Test
	@Rollback(true)
	public void deleteOfficial() {
		
		Official official = (Official) officialRepository.getCurrentSession().get(Official.class, id);
		officialRepository.delete(official);
	}
	
	@Test
	@Rollback(true)
	public void findByIdOfficial(){
		
		Official official = (Official) officialRepository.getCurrentSession().get(Official.class, id);		
		Assert.assertEquals("Programmers", official.getPositionAppliedFor());
		
	}
	
	@Test
	@Rollback(true)
	public void findAllOfficial(){
		
		
		List<Official> officialList = officialRepository.findAll();
	}
	

}
