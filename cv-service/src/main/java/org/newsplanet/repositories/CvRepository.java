package org.newsplanet.repositories;

import org.newsplanet.entities.Cv;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvRepository extends JpaRepository<Cv, Long>{
    
}
