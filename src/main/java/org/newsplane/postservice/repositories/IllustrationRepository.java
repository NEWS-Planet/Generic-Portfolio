package org.newsplane.postservice.repositories;

import org.newsplane.postservice.entities.Illustration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IllustrationRepository extends JpaRepository<Illustration, Long>{
    public Illustration findByFilename(String name);
}
