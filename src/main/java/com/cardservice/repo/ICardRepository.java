package com.cardservice.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cardservice.model.Card;

@Repository
public interface ICardRepository extends CrudRepository<Card, Long> {
	Card findByCardNo(Long cardNo);
}
