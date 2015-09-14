/**
 *
 * @author natechanok
 * @date Sep 11, 2015
 */

package services;

import java.util.Calendar;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.MasAddressType;
import com.aug.hrdb.entities.MasProvince;
import com.aug.hrdb.repositories.MasProvinceRepository;
import com.aug.hrdb.services.MasProvinceService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class MasProvinceServiceTest {

	
		@Autowired private MasProvinceService masProvinceService;
		
		/*@Test
		@Rollback(false)
		public void createMasProvince(){
			
			MasProvince masProvince = new MasProvince();
			masProvince.setName("Bangkok");
			masProvince.setCode("PRO-01");
			masProvince.setIsActive(true);
			masProvince.setAuditFlag("C");
			masProvince.setCreatedBy(1);
			masProvince.setCreatedTimeStamp(Calendar.getInstance().getTime());
			
			masProvinceService.create(masProvince);
			
			
			
			MasProvince masProvince1 = new MasProvince();
			masProvince1.setName("trad");
			masProvince1.setCode("PRO-02");
			masProvince1.setIsActive(true);
			masProvince1.setAuditFlag("C");
			masProvince1.setCreatedBy(1);
			masProvince1.setCreatedTimeStamp(Calendar.getInstance().getTime());
			
			
			masProvinceService.create(masProvince1);
		}*/
		
		/*@Test
		@Rollback(false)
		public void updateMasProvince(){
			
			MasProvince masProvince=(MasProvince) masProvinceService.find(8);
			//System.out.println("id: "+masProvince.getId());
			masProvince.setName("changmai");
			masProvinceService.update(masProvince);
			
			
		}*/
		
		/*@Test
		@Rollback(false)
		public void deleteMasProvince(){
			
			MasProvince masProvince = (MasProvince) masProvinceService.find(10);
			masProvinceService.delete(masProvince);
		}*/

		/*@Test
		@Rollback(false)
		public void findAllProvince(){

			List<MasProvince> province = masProvinceService.findAll();
			Assert.assertEquals(78, province.size());
		}*/
		
		
		
		@Test
		public void findbyIdProvince(){

			MasProvince masProvince =(MasProvince) masProvinceService.find(15);
			int id = masProvince.getId();
			Assert.assertEquals(15,id);
			
			
			
		}

}
