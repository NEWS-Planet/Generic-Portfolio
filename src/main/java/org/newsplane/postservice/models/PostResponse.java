package org.newsplane.postservice.models;

import java.util.HashSet;
import java.util.Set;

import org.newsplane.postservice.entities.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class PostResponse {
    private Long id;
    private String postTitle;
    private Set<IllustrationResponse> illustrations = new HashSet<IllustrationResponse>();
    private PostCategoryResponse postCategory;
    private DescriptionResponse description;

    public PostResponse(Post post){
        id = post.getId();
        postTitle = post.getPostTitle();
        post.getIllustrations().forEach(x->{
            illustrations.add(new IllustrationResponse(x));
        });
        postCategory = new PostCategoryResponse(post.getPostCategory());
        description = new DescriptionResponse(post.getDescription());
    }
}
