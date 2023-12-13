package org.newsplane.reactionservice.repositories;

import org.newsplane.reactionservice.entities.FavoriteReaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface FavoriteRepository extends JpaRepository<FavoriteReaction, Long>{
    public List<FavoriteReaction> findByPostId(Long postId);
    public List<FavoriteReaction> findByUserId(Long userId);
}
