package org.newsplane.reactionservice.models;

import org.newsplane.reactionservice.entities.CommentReaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class CommentResponse {
    private Long id;
    private Long postId;
    private Long userId;
    private String commentContent;

    public CommentResponse(CommentReaction cmt){
        id = cmt.getId();
        postId = cmt.getPostId();
        userId = cmt.getUserId();
        commentContent = cmt.getCommentContent();
    }
}
