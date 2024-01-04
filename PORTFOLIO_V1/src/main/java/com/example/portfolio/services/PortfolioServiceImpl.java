package com.example.portfolio.services;

import com.example.portfolio.entities.Portfolio;
import com.example.portfolio.entities.Skills;
import com.example.portfolio.repositories.PortfolioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import java.util.Optional;

@Service
public class PortfolioServiceImpl implements PortfolioService{

    @Autowired
    PortfolioRepository portfolioRepository;

    @Override
    public Portfolio add(Portfolio portfolio) {
        Portfolio index = new Portfolio();
        index.setHeadline(portfolio.getHeadline());
        index.setEducationList(portfolio.getEducationList());
        index.setSkillsList(portfolio.getSkillsList());
        index.setProjectsList(portfolio.getProjectsList());
        index.setProfessionnalExpList(portfolio.getProfessionnalExpList());


        portfolioRepository.save(index);
        return index;
    }

    @Override
    public Portfolio getPortfolio(Long id) {
        Optional<Portfolio> optionalPortfolio=portfolioRepository.findById(id);
        if(optionalPortfolio.isPresent()){
            return optionalPortfolio.get();
        }else{
            throw new EntityNotFoundException("Portfolio with id="+id+" not found");
        }

    }
}
