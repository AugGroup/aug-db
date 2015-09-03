package com.aug.hrdb.repositories;

import java.io.Serializable;
import java.util.List;
import com.aug.hrdb.dto.CertificationDto;
import com.aug.hrdb.entities.Certification;

public interface CertificationRepository extends GenericRepository<Certification, Serializable> {
	public List<CertificationDto> findCertificateById(Integer id);
	public CertificationDto findCertificate(Integer id);

}

