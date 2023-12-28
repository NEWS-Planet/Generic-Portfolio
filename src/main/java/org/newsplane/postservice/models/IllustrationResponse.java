package org.newsplane.postservice.models;

import org.newsplane.postservice.entities.Illustration;
import org.newsplane.postservice.entities.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class IllustrationResponse {
    public Long id;
    public String filename;
    public Post post;
    
    public IllustrationResponse(Illustration illustration){
        id = illustration.getId();
        filename = illustration.getFilename();
        post = illustration.getPost();
    }
}
