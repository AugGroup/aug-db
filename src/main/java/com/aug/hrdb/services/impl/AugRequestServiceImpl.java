package com.aug.hrdb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.AugRequestDto;
import com.aug.hrdb.entities.AugRequest;
import com.aug.hrdb.repositories.AugRequestRepository;
//import com.aug.hrdb.repositories.PositionRepository;
import com.aug.hrdb.services.AugRequestService;

/**
*
* @author Supannika Pattanodom
*/
@Service(value = "AugRequestService")
@Transactional
public class AugRequestServiceImpl implements AugRequestService {

	@Autowired
	AugRequestRepository augRequestRepository;

//	@Autowired
//	private PositionRepository positionRepository;

	@Override
	public AugRequest findById(Integer augRequestId) {
		return augRequestRepository.find(augRequestId);
	}

	@Override
	public void create(AugRequest augRequest) {
		augRequestRepository.create(augRequest);
	}

	@Override
	public void delete(AugRequest augRequest) {
		augRequestRepository.delete(augRequest);
	}

	@Override
	public void deleteById(Integer id) {
		augRequestRepository.deleteByApplicantId(id);

	}

	@Override
	public void update(AugRequest augRequest) {
		augRequestRepository.update(augRequest);
	}

	@Override
	public List<AugRequest> findAll() {
		List<AugRequest> augRequests = augRequestRepository.findAll();
		return augRequests;
	}

	@Override
	public List<AugRequestDto> findAllAugRequest() {
		List<AugRequestDto> augRequests = augRequestRepository
				.findAllAugRequest();
/*		for (AugRequestDto augRequest : augRequests) {
			String positionStr = positionRepository.findById(
					augRequest.getPositionRequest()).getPositionName();
			augRequest.setPositionStr(positionStr);
		}*/
		return augRequests;
	}

	@Override
	public AugRequestDto findAugRequestById(Integer id) {
		AugRequestDto augRequest = augRequestRepository.findAugRequestById(id);
/*		String positionStr = positionRepository.findById(id).getPositionName();
		augRequest.setPositionStr(positionStr);*/

		return augRequest;
	}

	
	/*--------------------For test SQLGrammaEception----------------------*/
	@Override
	public AugRequestDto findAugRequestByIdTest(Integer id) {
		AugRequestDto augRequest = augRequestRepository.findAugRequestByIdTest(id);
/*		String positionStr = positionRepository.findById(id).getPositionName();
		augRequest.setPositionStr(positionStr);*/

		return augRequest;
	}

}

