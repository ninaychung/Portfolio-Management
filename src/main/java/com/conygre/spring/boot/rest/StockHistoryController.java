package com.conygre.spring.boot.rest;

import com.conygre.spring.boot.services.StockHistoryService;
import com.conygre.spring.boot.entities.StockHistory;
import io.swagger.annotations.ApiOperation;
//import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/stocksHistory")
@CrossOrigin // allows requests from all domains
public class StockHistoryController {

    private static Logger logger = LogManager.getLogger(StockHistoryController.class);

    @Autowired
    private StockHistoryService service;

    @ApiOperation(value = "findAll", nickname = "findAll")
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<StockHistory> findAll() {
        logger.info("managed to call a Get request for findAll");
        return service.getStocksHistory();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public StockHistory getStockHistoryById(@PathVariable("id") Integer id) {
        return service.getStockHistoryById(id);
    }

    @RequestMapping(method=RequestMethod.GET, value="/404/{id}")
    public ResponseEntity<StockHistory> getByIdWith404(@PathVariable("id") Integer id) {
        StockHistory StockHistory = service.getStockHistoryById(id);
        if (StockHistory == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(StockHistory, HttpStatus.OK);
        }
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteStockHistory(@PathVariable("id") Integer id) {
        service.deleteStockHistory(id);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteStockHistory(@RequestBody StockHistory StockHistory) {
        service.deleteStockHistory(StockHistory);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addStockHistory(@RequestBody StockHistory StockHistory) {
        service.addNewStockHistory(StockHistory);
    }

}
