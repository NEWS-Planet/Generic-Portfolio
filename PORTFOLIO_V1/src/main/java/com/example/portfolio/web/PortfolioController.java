package com.example.portfolio.web;

import com.example.portfolio.entities.Portfolio;
import com.example.portfolio.services.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/portfolio")
public class PortfolioController {

    @Autowired
    PortfolioService portfolioService;
    @PostMapping("/add")
    public Portfolio addportfolio(@RequestBody Portfolio portfolio){
        return portfolioService.add(portfolio);
    }
    //----------------------------
    @GetMapping("/{id}")
    public Portfolio getportfolio(@PathVariable("id") Long id){
        return portfolioService.getPortfolio(id);
    }




}
