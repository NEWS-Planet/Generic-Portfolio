package org.newsplane.reactionservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class LikeRequest {
    private Long id;
    private Long postId;
    private Long userId;
    private boolean like;
}
