/**
 *
 * @author natechanok
 * @date May 28, 2015
 */

package com.aug.hrdb.dto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.OfficialDto;
import com.aug.hrdb.repositories.OfficialRepository;


@Service("officialDtoService")
@Transactional
public class OfficialDtoService {
	
	@Autowired private OfficialRepository officialResp;
	
	public List<OfficialDto> searchOfficial(){
		return officialResp.searchOfficial();
	}

}
