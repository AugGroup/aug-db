package com.aug.hrdb.repositories;

import java.io.Serializable;
import java.util.List;
import com.aug.hrdb.dto.CertificationDTO;
import com.aug.hrdb.entities.Certification;

public interface CertificationRepository extends GenericRepository<Certification, Serializable> {
	public List<CertificationDTO> findCertificateById(Integer id);
	public CertificationDTO findCertificate(Integer id);

}

