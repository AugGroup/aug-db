/**
 *
 * @author natechanok
 * @date Apr 30, 2015
 */

package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.OfficialDto;
import com.aug.hrdb.entities.Official;
import com.aug.hrdb.repositories.OfficialRepository;
import com.aug.hrdb.services.OfficialService;

@Service("officialService")
@Transactional
public class OfficialServiceImpl implements OfficialService{

	@Autowired
	private OfficialRepository officialResp;
	
	
	@Override
	public void create(Official official) {
		officialResp.create(official);
		
		
	}

	@Override
	public void update(Official official) {
		officialResp.update(official);
	}

	@Override
	public void delete(Official official) {
		officialResp.delete(official);
	}

	

	@Override
	public List<Official> findAll() {
		return officialResp.findAll();
	}

	@Override
	public List<Official> findByCriteria(Official official) {
		return officialResp.findByCriteria(official);
	}

	@Override
	public void deleteById(Integer id) {
		 officialResp.deleteById(id);
	}

	@Override
	public Official findById(Integer id) {
		return officialResp.find(id);
	}

	@Override
	public void saveOfficialByNameQuery(OfficialDto officialDto) {
		
		officialResp.saveOfficialByNameQuery(officialDto);
		
	}

	@Override
	public Official searhEmpIdtoOfficial() {
		
		return officialResp.searhEmpIdtoOfficial();
	}

	@Override
	public void deleteOfficialByNameQuery(Official official) {
		// TODO Auto-generated method stub
		officialResp.deleteOfficialByNameQuery(official);
		
	}

	

}
