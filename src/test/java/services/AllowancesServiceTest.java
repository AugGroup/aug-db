/**
 *
 * @author Preeyaporn
 * @date 7 ก.ย. 2558
 */
package services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.entities.Allowances;
import com.aug.hrdb.entities.MasAllowances;
import com.aug.hrdb.repositories.MasAddressTypeRepository;
import com.aug.hrdb.repositories.MasAllowancesRepository;
import com.aug.hrdb.services.AllowancesService;
import com.aug.hrdb.services.MasAllowancesService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-bean-db-test.xml" })
@Transactional
public class AllowancesServiceTest {

	@Autowired
	private AllowancesService allowancesService;
	
	@Autowired
	private MasAllowancesService masAllowancesService;
	
//	@Test
//	public void create() throws ParseException{
//
//		Allowances allowances = new Allowances();
//		
//		allowances.setAmount(6000d);
//		
//		MasAllowances masallowances = masAllowancesService.find(1);
//		allowances.setMasallowances(masallowances);
//		
//		
//		allowancesService.create(allowances);
//	}
//	
//	@Test
//	public void update(){
//
//		Allowances allowances = allowancesService.findById(2);
//		allowances.setAmount(600077d);
//		allowancesService.update(allowances);
//		
//	}
//	
//	@Test
//	public void delete(){
//
//		Allowances allowances = allowancesService.findById(2);
//		allowancesService.delete(allowances);
//		
//	}
	
	
}
