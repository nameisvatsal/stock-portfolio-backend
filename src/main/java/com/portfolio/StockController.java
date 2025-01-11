package com.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
@CrossOrigin(origins = {"http://localhost:3000", "https://st4rduststock.netlify.app"})
public class StockController {

    @Autowired
    private StockRepository stockRepository;

    @PostMapping
    public Stock addStock(@RequestBody Stock stock) {
        System.out.println("Received stock: " + stock); // Debug log
        return stockRepository.save(stock);
    }

    @PutMapping("/{ticker}")
    public Stock updateStock(@PathVariable String ticker, @RequestBody Stock stock) {
        if (!stockRepository.existsById(ticker)) {
            throw new RuntimeException("Stock not found");
        }
        return stockRepository.save(stock);
    }

    @DeleteMapping("/{ticker}")
    public void deleteStock(@PathVariable String ticker) {
        stockRepository.deleteById(ticker);
    }

    @GetMapping
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @GetMapping("/{ticker}")
    public Stock getStockByTicker(@PathVariable String ticker) {
        return stockRepository.findById(ticker).orElseThrow(() -> new RuntimeException("Stock not found"));
    }

    @GetMapping("/test")
    public String testConnection() {
        return "API is working!";
    }
}
