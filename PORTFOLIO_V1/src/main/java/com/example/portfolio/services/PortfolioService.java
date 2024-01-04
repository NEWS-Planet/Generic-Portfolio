package com.example.portfolio.services;

import com.example.portfolio.entities.Portfolio;

public interface PortfolioService {

    public Portfolio add(Portfolio portfolio);

    public Portfolio getPortfolio(Long id);
}
