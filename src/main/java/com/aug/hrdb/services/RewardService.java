package com.aug.hrdb.services;

import java.util.List;

import com.aug.hrdb.dto.RewardDto;
import com.aug.hrdb.entities.Reward;

public interface RewardService {

  List<Reward> findAll();

  void create(Reward reward);

  void update(Reward reward);

  void delete(Reward reward);

  Reward findById(Integer id);

  void deleteById(Integer id);

  List<Reward> findByCriteria(Reward reward);

  List<RewardDto> searchReward(Integer id);

}