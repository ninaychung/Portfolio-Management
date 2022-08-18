package com.conygre.spring.boot.repos;

import com.conygre.spring.boot.entities.StockHistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockHistoryRepository extends JpaRepository<StockHistory, Integer> {

    public Optional<StockHistory> findById(Integer id);
}
