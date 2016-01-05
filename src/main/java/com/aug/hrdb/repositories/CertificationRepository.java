package com.aug.hrdb.repositories;

import java.io.Serializable;
import java.util.List;

import com.aug.hrdb.dto.CertificationDto;
import com.aug.hrdb.entities.Certification;

public interface CertificationRepository extends GenericRepository<Certification, Serializable> {

	List<CertificationDto> findCertificateById(Integer id);
	CertificationDto findCertificate(Integer id);
	List<CertificationDto> searchCertification(Integer id);

}

