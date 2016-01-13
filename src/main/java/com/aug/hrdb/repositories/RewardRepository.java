package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.dto.RewardDto;
import com.aug.hrdb.entities.Reward;

public interface RewardRepository extends GenericRepository<Reward, Integer> {

  List<Reward> findByCriteria(Reward reward);

  List<RewardDto> searchReward(Integer id);

}