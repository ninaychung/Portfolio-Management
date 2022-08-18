package com.conygre.spring.boot.repos;

import com.conygre.spring.boot.entities.Stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, String> {

	public Iterable<Stock> findByTicker(String ticker);
}
