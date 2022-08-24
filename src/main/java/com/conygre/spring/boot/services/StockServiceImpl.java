package com.conygre.spring.boot.services;




import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conygre.spring.boot.repos.StockRepository;
import com.conygre.spring.boot.entities.Stock;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository dao;

    private static final Logger logger = LogManager.getLogger(StockServiceImpl.class);




    /*
     * (non-Javadoc)
     *
     * @see com.conygre.spring.boot.services.IStockService#getCatalog()
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public Iterable<Stock> getStocks() {
        logger.info("getting the stocks");
        // create a UnitOfWork (that contains an entity manager)
        // start the tx in the unit of work
        return dao.findAll(); // pass in the unit of work

        // when all done, commit the unit of work
    }

    @Override
    public Stock getStockById(Integer id) {
        Optional<Stock> stockOptional =  dao.findById(id);
        if (stockOptional.isPresent()) {
            return stockOptional.get();
        }
        else return null;


    }

    @Override
    public Stock addNewStock(Stock stock) {
        stock.setId(0); // assume it is not in the db
        return dao.save(stock);
    }

    @Override
    public Stock updateStock(Stock stock) {
        return dao.save(stock);
    }

    @Override
    public void deleteStock(Integer id) {
//        Stock toBeDeleted = dao.findByTicker(ticker);
//        deleteStock(toBeDeleted);

    }

    @Override
    public void deleteStock(Stock stock) {
        dao.delete(stock);
    }
}
