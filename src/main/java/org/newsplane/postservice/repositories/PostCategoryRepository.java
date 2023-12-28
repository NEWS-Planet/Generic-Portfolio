package org.newsplane.postservice.repositories;

import org.newsplane.postservice.entities.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostCategoryRepository extends JpaRepository<PostCategory, Long>{
    public PostCategory findByCategoryName(String name);
}
