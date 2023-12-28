package org.newsplane.postservice.models;

import org.newsplane.postservice.entities.PostCategory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class CompetencyRequest {
    private String competencyName;
    private PostCategory postCategory;
    private String competencyDescription;
}
