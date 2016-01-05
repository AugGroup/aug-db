package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.dto.CertificationDto;
import com.aug.hrdb.entities.Certification;

public interface CertificationService {

	void create(Certification certification);
	Certification findById(Integer id);
	void update(Certification certification);
	void deleteById(Integer id);
	void delete(Certification certification);
	List<Certification> findAll();
	List<CertificationDto> findCertificateById(Integer id);
	CertificationDto findCertificate(Integer id);
	List<CertificationDto> searchCertification(Integer id);
	
}
