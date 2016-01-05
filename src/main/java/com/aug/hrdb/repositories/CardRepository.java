package com.aug.hrdb.repositories;

import java.util.List;

import com.aug.hrdb.dto.CardDto;
import com.aug.hrdb.entities.Card;

public interface CardRepository extends GenericRepository<Card, Integer>{

	List<Card> findByCriteria(Card card);
	List<CardDto> searchCard(Integer id);

}
