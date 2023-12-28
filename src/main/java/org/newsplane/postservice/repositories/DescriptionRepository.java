package org.newsplane.postservice.repositories;

import org.newsplane.postservice.entities.Description;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescriptionRepository extends JpaRepository<Description, Long>{
    
}
