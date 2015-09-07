package services;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Health;
import com.aug.hrdb.services.HealthService;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class HealthServiceTest {
	
	@Autowired
	private HealthService healthService;
	
	
	@Test
	@Rollback(false)
	public void create() {
	
		Health health = new Health();
		health.setCongenitalDisease("Yes");
		health.setCongenitalDiseaseExplain("Hypertension"); //ความดัน
		health.setCongenitalDiseaseExplain2("Allergy"); //ภูมิแพ้
		health.setCongenitalDiseaseExplain2("asthma"); //หอบหืด
		health.setGeneticDisease("Yes");
		health.setGeneticDiseaseExplain("Hypertension");
		//health.setGeneticDiseaseExplain2("Allergy");
		//health.setGeneticDiseaseExplain3("asthma");
		health.setIntolerance("Yes");
		health.setIntoleranceExplain("CPM");
		health.setTakeMedicine("Yes");
		health.setTakeMedicineExplain("amoxilin");
		health.setAuditFlag("C");
		health.setCreatedBy(1);
		health.setCreatedTimeStamp(Calendar.getInstance().getTime());
		healthService.create(health);
		
		
		
		
		Health health2 = new Health();
		health2.setCongenitalDisease("Yes");
		health2.setCongenitalDiseaseExplain("Hypertension"); //ความดัน
		health2.setCongenitalDiseaseExplain2("Allergy"); //ภูมิแพ้
		health2.setGeneticDisease("Yes");
		health2.setGeneticDiseaseExplain("Allergy");
		health2.setIntolerance("Yes");
		health2.setIntoleranceExplain("CPM");
		health2.setTakeMedicine("Yes");
		health2.setTakeMedicineExplain("amoxilin");
		health2.setAuditFlag("C");
		health2.setCreatedBy(1);
		health2.setCreatedTimeStamp(Calendar.getInstance().getTime());	
		healthService.create(health2);
	
	}
	
	
	
	
	@Test
	@Rollback(false)
	public void update() {
	
		Health health = healthService.find(4);
		health.setCongenitalDiseaseExplain("heart disease");
		health.setAuditFlag("U");
		health.setUpdatedBy(1);
		health.setUpdatedTimeStamp(Calendar.getInstance().getTime());
		healthService.update(health);
		
	}

	
	
	@Test
	@Rollback(false)
	public void delete() {
	
		Health health = healthService.find(4);
		healthService.delete(health);
		
	}
	
	
	
	@Test
	public void find() {
	
		Health health = healthService.find(3);
		int id = health.getId().intValue();
		Assert.assertEquals(3, id);
	}
	
	
	
	
	
	@Test
	public void findAll() {
	
		List<Health> health = healthService.findAll();
		Assert.assertEquals(2, health.size());
		
		for(int i=0;i<health.size();i++){		
			System.out.println("id: "+health.get(i).getId());
		}
	
	
	}


	

}
