package com.example.portfolio.repositories;

import com.example.portfolio.entities.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectsRepository extends JpaRepository<Projects,Long> {
}
