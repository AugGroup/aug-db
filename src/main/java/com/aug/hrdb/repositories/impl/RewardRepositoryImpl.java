package com.aug.hrdb.repositories.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.dto.RewardDto;
import com.aug.hrdb.entities.Reward;
import com.aug.hrdb.repositories.RewardRepository;
import com.mysql.jdbc.StringUtils;


@Repository("RewardDao")
public class RewardRepositoryImpl extends GenericRepositoryImpl<Reward, Integer> implements RewardRepository {

	
	public RewardRepositoryImpl(){
		super(Reward.class);
	}


	@Override
	public List<Reward> findByCriteria(Reward reward) {
		Criteria c = getCurrentSession().createCriteria(Reward.class);
		if (!StringUtils.isNullOrEmpty(reward.getName())) {
			c.add(Restrictions.like("name", "%" + reward.getName() + "%"));
		}
		return c.list();
	}

	@Override
	public Reward deleteById(Integer id) {
		Reward reward =(Reward)getCurrentSession().load(Reward.class, id);
		getCurrentSession().delete(reward);
		return reward;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RewardDto> searchReward(Integer id) {
		Query nameQuery = getCurrentSession().getNamedQuery("searchReward").setInteger("empId" ,id);
			List<RewardDto> rewardDto = nameQuery.list();
			return rewardDto;
	}
	
	
}
