package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.CertificationDto;
import com.aug.hrdb.entities.Certification;
import com.aug.hrdb.repositories.CertificationRepository;
import com.aug.hrdb.services.CertificationService;

@Service(value = "certificationService")
@Transactional
public class CertificationServiceImpl implements CertificationService {

	@Autowired
	private CertificationRepository certificationRepository;

	@Override
	public void create(Certification certification) {
		certificationRepository.create(certification);		
	}

	@Override
	public Certification findById(Integer id) {
		return certificationRepository.find(id);
	}

	@Override
	public void update(Certification certification) {
		certificationRepository.update(certification);
	}

	@Override
	public void deleteById(Integer id) {
		certificationRepository.deleteById(id);
	}

	@Override
	public void delete(Certification certification) {
		certificationRepository.delete(certification);
	}

	@Override
	public List<Certification> findAll() {
		return certificationRepository.findAll();
	}

	@Override
	public List<CertificationDto> findCertificateById(Integer id) {
		List<CertificationDto> certificates = certificationRepository.findCertificateById(id);
		return certificates;
	}

	@Override
	public CertificationDto findCertificate(Integer id) {
		CertificationDto certificate = certificationRepository.findCertificate(id);
		return certificate;
	}

	@Override
	public List<CertificationDto> searchCertification(Integer id) {
		return certificationRepository.searchCertification(id);
	}
}
