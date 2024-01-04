package com.example.portfolio.repositories;

import com.example.portfolio.entities.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillsRepository extends JpaRepository<Skills,Long> {
}
