package org.newsplane.postservice.repositories;

import java.util.Set;

import org.newsplane.postservice.entities.Competency;
import org.newsplane.postservice.entities.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetencyRepository extends JpaRepository<Competency, Long>{
    public Competency findByCompetencyName(String name);

    @Query("SELECT c FROM Competency c WHERE c.postCategory.id = :postCategoryId")
    public Set<Competency> findByPostCategoryId(@Param("postCategoryId")Long postCategoryId);

    public Set<Competency> findByPostCategory(PostCategory postCat);
}
