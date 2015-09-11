/**
 *
 * @author Pranrajit
 * @date 4 ก.ย. 2558
 */
package repositories;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.junit.Assert;
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
import com.aug.hrdb.repositories.LanguageRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class SkillLanguageRepositoryTest {
	
	 @Autowired LanguageRepository languageRepository;
	 
	 @Test
	 @Rollback(false)
		public void createSkillLanguage(){
		
		Applicant applicant = new Applicant();
		applicant.setId(1);
		 
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
		 languageRepository.getCurrentSession().save(language);
		 
	 }
	 
	 /*@Test
	 @Rollback(false)
		public void updateSkillLanguage(){
		 Language skillLanguage=(Language)languageRepository.getCurrentSession().get(Language.class, 1);
		 skillLanguage.setNameLanguage("Thai");
		 skillLanguage.setSpeaking("well");
		 skillLanguage.setReading("well");
		 skillLanguage.setWriting("well");
		 skillLanguage.setUnderstanding("well");
		 languageRepository.getCurrentSession().update(skillLanguage);
	 }
	 */
	 
	/* @Test
	 @Rollback(false)
		public void deleteSkillLanguage(){
		 Language skillLanguage=(Language)languageRepository.getCurrentSession().get(Language.class, 1);
		 languageRepository.getCurrentSession().delete(skillLanguage);
		 
	 }*/
	 
	 /*
	 @SuppressWarnings({ "unchecked" })
	@Test
		public void listSkillLanguage(){
			
			Criteria c = languageRepository.getCurrentSession().createCriteria(Language.class);
			List<Language> SkillLanList = c.list();
			Assert.assertEquals(1, SkillLanList.size());
			
		}*/
		
		/*@SuppressWarnings({ "unchecked", "deprecation" })
		@Test
		public void findAllSkillLsn(){
			
			Criteria c = languageRepository.getCurrentSession().createCriteria(Language.class);
			List<Language> SkillLanList = c.list();
			Assert.assertEquals(1, SkillLanList.size());
			
			
		}
	 
	 */
	 

}
