package com.aug.hrdb.repositories.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.dto.CertificationDto;
import com.aug.hrdb.entities.Certification;
import com.aug.hrdb.repositories.CertificationRepository;

@Repository(value = "certificationRepository")
public class CertificationRepositoryImpl extends GenericRepositoryImpl<Certification, Serializable> implements CertificationRepository {

	public CertificationRepositoryImpl() {
		super(Certification.class);

	}

	@Override
	public List<CertificationDto> findCertificateById(Integer id) {
		Query query = getCurrentSession().getNamedQuery("SEARCH_CERTIFICATE");
		query.setParameter("ID", id);
		List<CertificationDto> result = query.list();
		System.out.println("QUERYADDRESS :: " + result);
		return result;
	}

	@Override
	public CertificationDto findCertificate(Integer id) {
		Query query = getCurrentSession().getNamedQuery("SEARCH_CERTIFICATE_ID");
		query.setParameter("ID", id);
		List<CertificationDto> result = query.list();
		CertificationDto app = result.get(0);
		return app;
	}


	
	@SuppressWarnings("unchecked")
	public List<CertificationDto> searchCertification(Integer id) {
		Query namedQuery = getCurrentSession().getNamedQuery("searchCertification").setInteger("ID" ,id);
		//namedQuery.executeUpdate();
		List<CertificationDto> cerDto = namedQuery.list();
	     return cerDto;
	}
}
