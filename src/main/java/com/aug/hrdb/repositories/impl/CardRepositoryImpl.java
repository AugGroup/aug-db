package com.aug.hrdb.repositories.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.aug.hrdb.dto.CardDto;
import com.aug.hrdb.entities.Card;
import com.aug.hrdb.repositories.CardRepository;
import com.mysql.jdbc.StringUtils;

@Repository(value = "cardRepository")
public class CardRepositoryImpl extends GenericRepositoryImpl<Card, Integer> implements CardRepository{

	public CardRepositoryImpl() {
		super(Card.class);
	}

	@Override
	public List<Card> findByCriteria(Card card) {
		Criteria c = getCurrentSession().createCriteria(Card.class);
		if (!StringUtils.isNullOrEmpty(card.getCard_no())) {
			c.add(Restrictions.like("card_no", "%" + card.getCard_no() + "%"));
		}

		return c.list();

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CardDto> searchCard(Integer id){
		Query nameQuery = getCurrentSession().getNamedQuery("searchCard").setInteger("empId" ,id);
		List<CardDto> cardDto = nameQuery.list();

		return cardDto;

	}

}
