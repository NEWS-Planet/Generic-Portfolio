package org.newsplane.reactionservice.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Reaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long postId;


    @OneToMany(mappedBy = "favoriteReaction")
    private List<FavoriteReaction> favoriteReactions = new ArrayList<FavoriteReaction>();

    @OneToMany(mappedBy = "commentReaction")//, cascade = CascadeType.REMOVE
    private List<CommentReaction> commentReaction = new ArrayList<CommentReaction>();

    public void removeCommentReaction(CommentReaction cmt){
        commentReaction.remove(cmt);
    }

    public void addCommentReaction(CommentReaction cmt){
        commentReaction.add(cmt);
    }

    public void removeReaction(FavoriteReaction react){
        favoriteReactions.remove(react);
    }

    public void addLikeReaction(FavoriteReaction react){
        favoriteReactions.add(react);
    }
}
