package com.bnppf.df.cardgame.springtype.repository;

import com.bnppf.df.cardgame.springtype.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Cardrepository extends JpaRepository<Card, Integer> {
}

