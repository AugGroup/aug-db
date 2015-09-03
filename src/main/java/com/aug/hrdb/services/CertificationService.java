package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.dto.CertificationDto;
import com.aug.hrdb.entities.Certification;

public interface CertificationService {
	public void create(Certification certification);

	public Certification findById(Integer id);

	public void update(Certification certification);

	public void deleteByApplicantId(Integer id);
	
	public void delete(Certification certification);

	public List<Certification> findAll();
	
	public List<CertificationDto> findCertificateById(Integer id);

	public CertificationDto findCertificate(Integer id);
	
}
