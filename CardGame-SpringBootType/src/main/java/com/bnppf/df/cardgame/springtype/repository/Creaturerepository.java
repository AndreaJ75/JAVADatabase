package com.bnppf.df.cardgame.springtype.repository;

import com.bnppf.df.cardgame.springtype.model.Creature;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Creaturerepository extends JpaRepository<Creature, Integer> {
}
