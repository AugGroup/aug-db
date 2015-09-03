package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.CertificationDTO;
import com.aug.hrdb.entities.Certification;
import com.aug.hrdb.repositories.CertificationRepository;
import com.aug.hrdb.services.CertificationService;

//@Service(value = "certificationService")
//@Transactional
//public class CertificationServiceImpl implements CertificationService {
//	@Autowired
//	private CertificationRepository certificationRepository;
//	@Override
//	public void create(Certification certification) {
//		certificationRepository.insert(certification);		
//	}
//
//	@Override
//	public Certification findById(Integer id) {
//		return certificationRepository.findById(id);
//	}
//
//	@Override
//	public void update(Certification certification) {
//		certificationRepository.update(certification);
//	}
//
//	@Override
//	public void deleteById(Integer id) {
//		certificationRepository.deleteById(id);
//		
//	}
//
//	@Override
//	public void delete(Certification certification) {
//		certificationRepository.delete(certification);
//		
//	}
//
//	@Override
//	public List<Certification> findAll() {
//		return certificationRepository.findAll();
//	}
//
//	@Override
//	public List<CertificationDTO> findCertificateById(Integer id) {
//		List<CertificatedDTO> certificates = certificationRepository.findCertificateById(id);
//		return certificates;
//	}
//
//	@Override
//	public CertificationDTO findCertificate(Integer id) {
//		CertificationDTO certificate = certificationRepository.findCertificate(id);
//		return certificate;
//	}
//}
