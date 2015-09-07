package repositories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Education;
import com.aug.hrdb.repositories.EducationRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class EducationRepositoryTest {
	
	@Autowired
	private EducationRepository educationRepository;

	@Test
	@Ignore
	@Rollback(false)
	public void insertEducationRepositoryTest() throws ParseException {
		SimpleDateFormat dateFmt = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
		Education education = new Education();

		education.setId(7);
		education.setCertification("TOEIC 430");
		education.setDegree("Master");
		education.setFaculty("Technology and Science");
		education.setGpa(3.0);
		education.setGraduated_date(dateFmt.parse("07/09/2015"));

		educationRepository.getCurrentSession().save(education);
		System.out.println("University : " + education.getUniversity());
	}

	@Test
	@Rollback(false)
	public void findByIdEducationRepositoryTest() {
		Education education = educationRepository.find(3);
		System.out.println("University : "+education.getUniversity());

	}
	
	@Test
	@Rollback(false)
	public void updateEducationRepositoryTest() {
		Education education = educationRepository.find(3);
		education.setMajor("Computer");
		educationRepository.update(education);
		System.out.println("University : " + education.getUniversity());

	}
	
	@Test
	@Rollback(false)
	public void deleteByIdEducationRepositoryTest() {
		Education experience = educationRepository.find(3);
		educationRepository.delete(experience);
		System.out.println("Delete Experience : " + educationRepository.find(3));
	}


}
