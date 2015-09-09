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
import com.aug.hrdb.entities.Language;
import com.aug.hrdb.services.LanguageService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class LanguageServiceTest {

	@Autowired LanguageService languageService;
	
	@Test
	@Rollback(false)
	public void create() {
		Language language=new Language();
		language.setNameLanguage("Thai");
		 language.setSpeaking("good");
		 language.setReading("good");
		 language.setWriting("good");
		 language.setUnderstanding("good");
		 language.setAuditFlag("C");
		 language.setCreatedBy(1);
		 language.setCreatedTimeStamp(Calendar.getInstance().getTime());
		 languageService.create(language);
		
	}
	
	
	/*@Test
	@Rollback(false)
	public void update() {
		Language skillLanguage=languageService.find(2);
		 skillLanguage.setNameLanguage("Thai");
		 skillLanguage.setSpeaking("well");
		 skillLanguage.setReading("well");
		 skillLanguage.setWriting("well");
		 skillLanguage.setUnderstanding("well");
		 languageService.create(skillLanguage);
	}
	*/
	
	/*@Test
	@Rollback(false)
	public void delete() {
		Language skillLanguage=languageService.find(2);
		languageService.delete(skillLanguage);
	}*/
	
	
	/*@Test
	@Rollback(false)
	public void findAll() {
		List<Language>skillLanguage=languageService.findAll();
		Assert.assertEquals(1, skillLanguage.size());
	}*/
	
	
	/*@Test
	@Rollback(false)
	public void findById() {

		Language skillLanguage =(Language) languageService.find(2);
		int id = skillLanguage.getId();
		Assert.assertEquals(2,id);
	}*/
	
}
