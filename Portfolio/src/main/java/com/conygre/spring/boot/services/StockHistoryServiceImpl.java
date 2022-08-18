package com.conygre.spring.boot.services;




import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conygre.spring.boot.repos.StockHistoryRepository;
import com.conygre.spring.boot.entities.StockHistory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StockHistoryServiceImpl implements StockHistoryService {

    @Autowired
    private StockHistoryRepository dao;

    private static final Logger logger = LogManager.getLogger(StockHistoryServiceImpl.class);




    /*
     * (non-Javadoc)
     *
     * @see com.conygre.spring.boot.services.IStockHistoryService#getCatalog()
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public Iterable<StockHistory> getStocksHistory() {
        logger.info("getting the StockHistorys");
        // create a UnitOfWork (that contains an entity manager)
        // start the tx in the unit of work
        return dao.findAll(); // pass in the unit of work

        // when all done, commit the unit of work
    }

    @Override
    public StockHistory getStockHistoryById(Integer id) {
//        Optional<StockHistory> StockHistoryOptional =  dao.findByTicker(ticker);
//        if (StockHistoryOptional.isPresent()) {
//            return StockHistoryOptional.get();
//        }
//        else return null;

        return null;
    }

    @Override
    public StockHistory addNewStockHistory(StockHistory stockHistory) {
        stockHistory.setId(0); // assume it is not in the db
        return dao.save(stockHistory);
    }

    @Override
    public StockHistory updateStockHistory(StockHistory stockHistory) {
        return dao.save(stockHistory);
    }

    @Override
    public void deleteStockHistory(Integer id) {
//        StockHistory toBeDeleted = dao.findByTicker(ticker).get();
//        deleteStockHistory(toBeDeleted);

    }

    @Override
    public void deleteStockHistory(StockHistory stockHistory) {
        dao.delete(stockHistory);
    }
}
