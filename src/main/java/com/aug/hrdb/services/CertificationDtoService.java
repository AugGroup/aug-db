/**
 *
 * @author Preeyaporn
 * @date 25 พ.ค. 2558
 */
package com.aug.hrdb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.aug.hrdb.dto.CertificationDto;
import com.aug.hrdb.repositories.CertificationRepository;

@Service("certificationDtoService")
@Transactional
public class CertificationDtoService {

	@Autowired private CertificationRepository certificationRepository;
	
	public List<CertificationDto> searchCertification(Integer id){
		return certificationRepository.searchCertification(id);
	}
}
