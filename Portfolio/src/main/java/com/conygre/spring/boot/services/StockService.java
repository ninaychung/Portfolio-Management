package com.conygre.spring.boot.services;

import com.conygre.spring.boot.entities.Stock;

public interface StockService {
    Iterable<Stock> getStocks();

    Stock getStockById(Integer id);

    Stock addNewStock(Stock stock);

    void deleteStock(Integer id);

    void deleteStock(Stock stock);

    Stock updateStock(Stock stock);
}