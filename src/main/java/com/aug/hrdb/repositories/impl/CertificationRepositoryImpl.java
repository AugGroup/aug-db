package com.aug.hrdb.repositories.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.dto.CertificationDTO;
import com.aug.hrdb.entities.Certification;
import com.aug.hrdb.repositories.CertificationRepository;

@Repository(value = "certificationRepository")
public class CertificationRepositoryImpl extends GenericRepositoryImpl<Certification, Serializable> implements CertificationRepository {

	public CertificationRepositoryImpl(Class<Certification> entityClass) {
		super(entityClass);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<CertificationDTO> findCertificateById(Integer id) {
		Query query = getCurrentSession().getNamedQuery("SEARCH_CERTIFICATE");
		query.setParameter("ID", id);
		List<CertificationDTO> result = query.list();
		System.out.println("QUERYADDRESS :: " + result);
		return result;
	}

	@Override
	public CertificationDTO findCertificate(Integer id) {
		Query query = getCurrentSession().getNamedQuery("SEARCH_CERTIFICATE_ID");
		query.setParameter("ID", id);
		List<CertificationDTO> result = query.list();
		CertificationDTO app = result.get(0);
		return app;
	}
	
}
