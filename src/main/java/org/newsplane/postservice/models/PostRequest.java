package org.newsplane.postservice.models;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class PostRequest {
    private String postTitle;
    private Set<IllustrationRequest> illustrations = new HashSet<IllustrationRequest>();
    private PostCategoryRequest postCategory;
    private DescriptionRequest description;
}
