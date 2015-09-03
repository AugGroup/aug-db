package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.dto.CertificationDTO;
import com.aug.hrdb.entities.Certification;

public interface CertificationService {
	public void create(Certification certification);

	public Certification findById(Integer id);

	public void update(Certification certification);

	public void deleteById(Integer id);
	
	public void delete(Certification certification);

	public List<Certification> findAll();
	
	public List<CertificationDTO> findCertificateById(Integer id);

	public CertificationDTO findCertificate(Integer id);
	
}
