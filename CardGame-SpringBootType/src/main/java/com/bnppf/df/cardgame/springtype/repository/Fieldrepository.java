package com.bnppf.df.cardgame.springtype.repository;

import com.bnppf.df.cardgame.springtype.model.Field;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Fieldrepository extends JpaRepository<Field, Integer> {
}
