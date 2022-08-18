package com.conygre.spring.boot.repos;

import com.conygre.spring.boot.entities.Stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

	public Optional<Stock> findById(Integer id);

	//public void updateStock(Integer newQuantity);
}
