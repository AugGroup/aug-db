/**
 *
 * @author natechanok
 * @date Apr 30, 2015
 */

package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.dto.OfficialDto;
import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Employee;
import com.aug.hrdb.entities.Official;


public interface OfficialRepository extends GenericRepository<Official,Integer>{

	List<Official> findByCriteria(Applicant applicant);
	
	public List<OfficialDto> searchOfficial();
	public void saveOfficialByNameQuery(OfficialDto officialDto);
	public Official searhEmpIdtoOfficial();
	public void updateOfficialByNameQuery(OfficialDto officialDto);
	public void deleteOfficialByNameQuery(Official official); 
	
	

}
