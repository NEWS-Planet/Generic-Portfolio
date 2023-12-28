package org.newsplane.postservice.models;

import org.newsplane.postservice.entities.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data @AllArgsConstructor @Builder
public class IllustrationRequest {
    public Post post;
    public String filename;
}
