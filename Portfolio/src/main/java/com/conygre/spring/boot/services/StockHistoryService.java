package com.conygre.spring.boot.services;

import com.conygre.spring.boot.entities.StockHistory;

public interface StockHistoryService {
    Iterable<StockHistory> getStocksHistory();

    StockHistory getStockHistoryById(Integer id);

    StockHistory addNewStockHistory(StockHistory stockHistory);

    void deleteStockHistory(Integer id);

    void deleteStockHistory(StockHistory stockHistory);

    StockHistory updateStockHistory(StockHistory stockHistory);
}