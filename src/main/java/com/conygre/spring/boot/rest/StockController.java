package com.conygre.spring.boot.rest;

import com.conygre.spring.boot.services.StockService;
import com.conygre.spring.boot.entities.Stock;
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
@RequestMapping("/api/stocks")
@CrossOrigin // allows requests from all domains
public class StockController {

    private static Logger logger = LogManager.getLogger(StockController.class);

    @Autowired
    private StockService service;

    @ApiOperation(value = "findAll", nickname = "findAll")
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Stock> findAll() {
        logger.info("managed to call a Get request for findAll");
        return service.getStocks();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Stock getStockById(@PathVariable("id") Integer id) {
        return service.getStockById(id);
    }

    @RequestMapping(method=RequestMethod.GET, value="/404/{id}")
    public ResponseEntity<Stock> getByIdWith404(@PathVariable("id") Integer id) {
        Stock stock = service.getStockById(id);
        if (stock == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(stock, HttpStatus.OK);
        }
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteStock(@PathVariable("id") Integer id) {
        service.deleteStock(id);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteStock(@RequestBody Stock stock) {
        service.deleteStock(stock);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addStock(@RequestBody Stock stock) {
        service.addNewStock(stock);
    }

}
