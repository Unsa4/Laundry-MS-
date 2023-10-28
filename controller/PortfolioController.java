package com.example.laundry.controller;

import com.example.laundry.model.Portfolio;
import com.example.laundry.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PortfolioController {

    private final PortfolioService PortfolioService;

    @Autowired
    public PortfolioController(PortfolioService PortfolioService) {
        this.PortfolioService = PortfolioService;
    }

    @PostMapping("/Portfolios")
    public ResponseEntity<Portfolio> createPortfolio(@Valid @RequestBody Portfolio Portfolio) {
        Portfolio createdPortfolio = PortfolioService.savePortfolio(Portfolio);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPortfolio);
    }

    @GetMapping("/Portfolios")
    public ResponseEntity<List<Portfolio>> getAllPortfolios() {
        List<Portfolio> Portfolios = PortfolioService.getAllPortfolios();
        return ResponseEntity.ok(Portfolios);
    }

    @GetMapping("/Portfolios/{id}")
    public ResponseEntity<Optional<Portfolio>> getPortfolioById(@PathVariable(value = "id") Long id) {
        Optional<Portfolio> Portfolio = PortfolioService.getPortfolioById(String.valueOf(id));
        if (Portfolio.isPresent()) {
            return ResponseEntity.ok(Portfolio);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/Portfolios/{id}")
    public ResponseEntity<Portfolio> updatePortfolio(@PathVariable(value = "id") Long id, @RequestBody Portfolio PortfolioDetails) {
        Portfolio updatedPortfolio = PortfolioService.updatePortfolio(String.valueOf(id), PortfolioDetails);
        return ResponseEntity.ok(updatedPortfolio);
    }

    @DeleteMapping("/Portfolios/{id}")
    public ResponseEntity<Void> deletePortfolio(@PathVariable(value = "id") Long id) {
        PortfolioService.deletePortfolio(String.valueOf(id));
        return ResponseEntity.noContent().build();
    }
}
