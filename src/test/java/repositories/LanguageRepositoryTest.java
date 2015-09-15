/**
 *
 * @author Pranrajit
 * @date 4 ก.ย. 2558
 */
package repositories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
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












import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.entities.Language;
import com.aug.hrdb.entities.Leave;
import com.aug.hrdb.entities.MasDivision;
import com.aug.hrdb.entities.MasJoblevel;
import com.aug.hrdb.repositories.ApplicantRepository;
import com.aug.hrdb.repositories.EmployeeRepository;
import com.aug.hrdb.repositories.LanguageRepository;
import com.aug.hrdb.repositories.MasDivisionRepository;
import com.aug.hrdb.repositories.MasJoblevelRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class LanguageRepositoryTest {
	
	 @Autowired LanguageRepository languageRepository;
	 @Autowired EmployeeRepository employeeRepository;
	 @Autowired MasJoblevelRepository massJoblevelRepository;
	 @Autowired ApplicantRepository applicantRepository;
	 @Autowired MasDivisionRepository masDivisionRepository;
		
	 
	 
	 private	 Employee employee;
		int id;
		
		@Before
		public void setAbility() {
			employee = new Employee();
	        employee.setIdCard("115310905001-9");
	        employee.setNameThai("อภิวาท์");
	        employee.setNameEng("apiva");
	        employee.setNicknameThai("va");
	        employee.setNicknameEng("va");
	        employee.setSurnameThai("กิมเกถนอม");
	        employee.setSurnameEng("kimkatanom");
	        
	        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    	String dateInString = "31-08-1982";
	    	Date date = null;
			try {
				date = sdf.parse(dateInString);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        
			employee.setDateOfBirth(date);
	        employee.setEmail("test@gmail.com");
	        employee.setEmergencyContact("mom");
	        employee.setEmployeeCode("EMP-22");
	        employee.setStatusemp("Employee");
	        employee.setTelHome("089-0851022");
	        employee.setTelMobile("089-0851022");
	        employee.setEmergencyContactPhoneNumber("089-085-1022");
	        employee.setAuditFlag("C");
	        employee.setCreatedBy(1);
	        employee.setCreatedTimeStamp(Calendar.getInstance().getTime());
	        
	        Applicant applicant = new Applicant();
			applicant.setCreatedBy(1);
			applicant.setCreatedTimeStamp(Calendar.getInstance().getTime());
			applicant.setAuditFlag("C");
			applicant.setCardId("115310905001-9");
			applicantRepository.create(applicant);
			
	        Applicant applicant1 = applicantRepository.find(1);
	        Hibernate.initialize(applicant1);
	        
	        
	       
	        
	        employee.setApplicant(applicant1);
	         
	    
		
			MasDivision masDivision = new MasDivision();
			masDivision.setName("CEO");
			masDivision.setIsActive(true);
			masDivision.setCode("01");
			masDivision.setAuditFlag("C");
			masDivision.setCreatedBy(1);
			masDivision.setCreatedTimeStamp(Calendar.getInstance().getTime());
			masDivision.setCode("Division-01");
			
			masDivisionRepository.create(masDivision);
			masDivisionRepository.find(1);
			employee.setMasDivision(masDivision);
			

			MasJoblevel masJoblevel = new MasJoblevel();
			masJoblevel.setName("CEO");
			masJoblevel.setIsActive(true);
			masJoblevel.setCode("01");
			masJoblevel.setAuditFlag("C");
			masJoblevel.setCreatedBy(1);
			masJoblevel.setCreatedTimeStamp(Calendar.getInstance().getTime());
			masJoblevel.setCode("Division-01");

			massJoblevelRepository.create(masJoblevel);
			massJoblevelRepository.find(1);		
			employee.setMasJoblevel(masJoblevel);
			employeeRepository.create(employee);
			
			
			
			 Applicant applicant2=applicantRepository.find(1);
			 
			 Language language=new Language();
			 language.setNameLanguage("Thai");
			 language.setSpeaking("good");
			 language.setReading("good");
			 language.setWriting("good");
			 language.setUnderstanding("good");
			 language.setAuditFlag("C");
			 language.setCreatedBy(1);
			 language.setCreatedTimeStamp(Calendar.getInstance().getTime());
			 language.setApplicant(applicant2);
			 languageRepository.create(language);
				id = language.getId();
			    System.out.println("id: "+id);
		}
	 
	 
	 
	 @Test
	 @Rollback(true)
		public void createSkillLanguage(){
		 Applicant applicant=applicantRepository.find(1);
		 
		 Language language=new Language();
		 language.setNameLanguage("Thai");
		 language.setSpeaking("good");
		 language.setReading("good");
		 language.setWriting("good");
		 language.setUnderstanding("good");
		 language.setAuditFlag("C");
		 language.setCreatedBy(1);
		 language.setCreatedTimeStamp(Calendar.getInstance().getTime());
		 language.setApplicant(applicant);
		 languageRepository.create(language);
		 
	 }
	 
	 @Test
	 @Rollback(true)
		public void updateSkillLanguage(){
		 Language skillLanguage=(Language)languageRepository.getCurrentSession().get(Language.class,id);
		 skillLanguage.setNameLanguage("Thai");
		 skillLanguage.setSpeaking("well");
		 skillLanguage.setReading("well");
		 skillLanguage.setWriting("well");
		 skillLanguage.setUnderstanding("well");
		 languageRepository.update(skillLanguage);
	 }
	 
	 
	 @Test
	 @Rollback(true)
		public void deleteSkillLanguage(){
		 Language skillLanguage=(Language)languageRepository.getCurrentSession().get(Language.class, id);
		 languageRepository.delete(skillLanguage);
		 
	 }
	 
	 
	@Test
		public void listSkillLanguage(){
			
			Criteria c = languageRepository.getCurrentSession().createCriteria(Language.class);
			List<Language> SkillLanList = c.list();
			Assert.assertEquals(5, SkillLanList.size());
			
		}
		
		
		@Test
		public void findAllSkillLsn(){
			
			Criteria c = languageRepository.getCurrentSession().createCriteria(Language.class);
			List<Language> SkillLanList = c.list();
			
			
			
		}
	 
	 
	 

}
