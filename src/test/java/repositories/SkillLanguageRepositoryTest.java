/**
 *
 * @author Pranrajit
 * @date 4 ก.ย. 2558
 */
package repositories;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


import com.aug.hrdb.entities.SkillLanguage;
import com.aug.hrdb.repositories.SkillLanguageRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class SkillLanguageRepositoryTest {
	
	 @Autowired SkillLanguageRepository skillLanguageRepository;
	 
	 @Test
	 @Rollback(false)
		public void createSkillLanguage(){
		 SkillLanguage skillLanguage=new SkillLanguage();
		 skillLanguage.setNameLanguage("Thai");
		 skillLanguage.setSpeaking("good");
		 skillLanguage.setReading("good");
		 skillLanguage.setWriting("good");
		 skillLanguage.setUnderstanding("good");
		 skillLanguage.setAuditFlag("C");
		 skillLanguage.setCreatedBy(1);
		 skillLanguage.setCreatedTimeStamp(Calendar.getInstance().getTime());
		 skillLanguageRepository.getCurrentSession().save(skillLanguage);
		 
	 }
	 
	 /*@Test
	 @Rollback(false)
		public void updateSkillLanguage(){
		 SkillLanguage skillLanguage=(SkillLanguage)skillLanguageRepository.getCurrentSession().get(SkillLanguage.class, 1);
		 skillLanguage.setNameLanguage("Thai");
		 skillLanguage.setSpeaking("well");
		 skillLanguage.setReading("well");
		 skillLanguage.setWriting("well");
		 skillLanguage.setUnderstanding("well");
		 skillLanguageRepository.getCurrentSession().update(skillLanguage);
	 }
	 */
	 
	/* @Test
	 @Rollback(false)
		public void deleteSkillLanguage(){
		 SkillLanguage skillLanguage=(SkillLanguage)skillLanguageRepository.getCurrentSession().get(SkillLanguage.class, 1);
		 skillLanguageRepository.getCurrentSession().delete(skillLanguage);
		 
	 }*/
	 
	/* 
	 @SuppressWarnings({ "deprecation", "unchecked" })
	@Test
		public void listSkillLanguage(){
			
			Criteria c = skillLanguageRepository.getCurrentSession().createCriteria(SkillLanguage.class);
			List<SkillLanguage> SkillLanList = c.list();
			Assert.assertEquals(1, SkillLanList.size());
			
		}*/
		
		/*@SuppressWarnings({ "unchecked", "deprecation" })
		@Test
		public void findAllSkillLsn(){
			
			Criteria c = skillLanguageRepository.getCurrentSession().createCriteria(Leave.class);
			List<SkillLanguage> SkillLanList = c.list();
			Assert.assertEquals(2, SkillLanList.size());
			
			
		}
	 */
	 
	 

}
