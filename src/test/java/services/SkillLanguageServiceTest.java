/**
 *
 * @author Pranrajit
 * @date 4 ก.ย. 2558
 */
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
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Ability;
import com.aug.hrdb.entities.SkillLanguage;
import com.aug.hrdb.services.SkillLanguageService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class SkillLanguageServiceTest {

	@Autowired SkillLanguageService skillLanguageService;
	
	@Test
	@Rollback(false)
	public void create() {
		SkillLanguage skillLanguage=new SkillLanguage();
		skillLanguage.setNameLanguage("Thai");
		 skillLanguage.setSpeaking("good");
		 skillLanguage.setReading("good");
		 skillLanguage.setWriting("good");
		 skillLanguage.setUnderstanding("good");
		 skillLanguage.setAuditFlag("C");
		 skillLanguage.setCreatedBy(1);
		 skillLanguage.setCreatedTimeStamp(Calendar.getInstance().getTime());
		 skillLanguageService.create(skillLanguage);
		
	}
	
	
	/*@Test
	@Rollback(false)
	public void update() {
		SkillLanguage skillLanguage=skillLanguageService.find(2);
		 skillLanguage.setNameLanguage("Thai");
		 skillLanguage.setSpeaking("well");
		 skillLanguage.setReading("well");
		 skillLanguage.setWriting("well");
		 skillLanguage.setUnderstanding("well");
		 skillLanguageService.create(skillLanguage);
	}
	*/
	
	/*@Test
	@Rollback(false)
	public void delete() {
		SkillLanguage skillLanguage=skillLanguageService.find(2);
		skillLanguageService.delete(skillLanguage);
	}*/
	
	
	/*@Test
	@Rollback(false)
	public void findAll() {
		List<SkillLanguage>skillLanguage=skillLanguageService.findAll();
		Assert.assertEquals(1, skillLanguage.size());
	}*/
	
	
	/*@Test
	@Rollback(false)
	public void findById() {

		SkillLanguage skillLanguage =(SkillLanguage) skillLanguageService.find(2);
		int id = skillLanguage.getId();
		Assert.assertEquals(2,id);
	}*/
	
}
