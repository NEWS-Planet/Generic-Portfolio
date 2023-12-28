package org.newsplane.postservice.models;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class PostCategoryRequest {
    private String categoryName;
    private Set<CompetencyRequest> competencies = new HashSet<CompetencyRequest>();
}
