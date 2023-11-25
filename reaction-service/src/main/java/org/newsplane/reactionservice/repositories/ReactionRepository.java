package org.newsplane.reactionservice.repositories;

import org.newsplane.reactionservice.entities.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactionRepository extends JpaRepository<Reaction, Long> {
    public Reaction deleteByPostId(Long postId);
    public Reaction findByPostId(Long postId);
}
