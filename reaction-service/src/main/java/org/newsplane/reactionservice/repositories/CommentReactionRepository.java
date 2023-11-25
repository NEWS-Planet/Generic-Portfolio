package org.newsplane.reactionservice.repositories;

import org.newsplane.reactionservice.entities.CommentReaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentReactionRepository extends JpaRepository<CommentReaction, Long>{
    
}
