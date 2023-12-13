package org.newsplane.reactionservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class CommentRequest {
    private Long postId;
    private Long userId;
    private String commentContent;
}
