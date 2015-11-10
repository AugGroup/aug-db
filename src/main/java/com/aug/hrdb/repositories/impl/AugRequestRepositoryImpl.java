package com.aug.hrdb.repositories.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.dto.AugRequestDto;
import com.aug.hrdb.entities.AugRequest;
import com.aug.hrdb.repositories.AugRequestRepository;
import com.aug.hrdb.repositories.impl.GenericRepositoryImpl;

/**
*
* @author Supannika Pattanodom
*/
@Repository(value = "augRequestRepository")
public class AugRequestRepositoryImpl extends GenericRepositoryImpl<AugRequest, Serializable> implements
		AugRequestRepository {

	public AugRequestRepositoryImpl() {
		super(AugRequest.class);
	}

	@Override
	public List<AugRequestDto> findAllAugRequest() {
		Query query = getCurrentSession().getNamedQuery("SEARCH_ALL_REQUEST");
		List<AugRequestDto> results = query.list();
		return results;
	}

	@Override
	public AugRequestDto findAugRequestById(Integer id) {
		Query query = getCurrentSession().getNamedQuery("SEARCH_REQUEST_BY_ID");
		query.setParameter("ID", id);
		List<AugRequestDto> result = query.list();
		AugRequestDto app = result.get(0);
		return app;
	}

	@Override
	public AugRequestDto findAugRequestByIdTest(Integer id) {
		Query query = getCurrentSession().getNamedQuery("SEARCH_REQUEST_BY_ID_TEST");
		query.setParameter("ID", id);
		List<AugRequestDto> result = query.list();
		AugRequestDto app = result.get(0);
		return app;
	}

	@Override
	public List<AugRequestDto> getJobcaseCode() {
		Query query = getCurrentSession().getNamedQuery("GET_JOBCASE_CODE");
		List<AugRequestDto> results = query.list();
		return results;
	}

}
