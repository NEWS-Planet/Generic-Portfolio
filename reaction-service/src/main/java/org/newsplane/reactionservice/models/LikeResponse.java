package org.newsplane.reactionservice.models;

import org.newsplane.reactionservice.entities.FavoriteReaction;

//import org.newsplane.reactionservice.entities.LikeReaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class LikeResponse {
    private Long id;
    private Long postId;
    private Long userId;
    private int like;

    public LikeResponse(FavoriteReaction like){
        id = like.getId();
        postId = like.getPostId();
        userId = like.getUserId();
        this.like = like.getFavory();
    }
}
