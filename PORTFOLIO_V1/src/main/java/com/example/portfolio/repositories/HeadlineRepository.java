package com.example.portfolio.repositories;

import com.example.portfolio.entities.Headline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeadlineRepository extends JpaRepository<Headline,Long> {
}
