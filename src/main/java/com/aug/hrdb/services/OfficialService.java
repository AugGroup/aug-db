/**
 *
 * @author natechanok
 * @date Apr 30, 2015
 */

package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.dto.OfficialDto;
import com.aug.hrdb.entities.Applicant;
import com.aug.hrdb.entities.Official;


public interface OfficialService {
	public void create(Official official);
	public void update(Official official);
	public void delete(Official official);
	public Official findById(Integer id);
	public List<Official> findAll();
	public List<Official> findByCriteria(Applicant applicant);
	public void deleteById(Integer id);
	public void saveOfficialByNameQuery(OfficialDto officialDto);
	public Official searhEmpIdtoOfficial();
	public void deleteOfficialByNameQuery(Official official); 


}
