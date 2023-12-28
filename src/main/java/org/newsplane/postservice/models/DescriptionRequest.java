package org.newsplane.postservice.models;

import java.util.Set;

import org.newsplane.postservice.entities.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class DescriptionRequest {
    private String content;
    private Set<CompetencyRequest> competencies;
    private Post post;
}
