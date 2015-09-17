package com.aug.hrdb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aug.hrdb.dto.RewardDto;
import com.aug.hrdb.repositories.RewardRepository;

@Service("rewardDtoService")
@Transactional
public class RewardDtoService {

		@Autowired private RewardRepository rewardRepository;
		public List<RewardDto> searchReward(Integer id){
			return rewardRepository.searchReward(id);
		}
}
