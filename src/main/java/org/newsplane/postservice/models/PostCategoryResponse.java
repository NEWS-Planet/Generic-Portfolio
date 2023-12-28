package org.newsplane.postservice.models;

import java.util.HashSet;
import java.util.Set;

import org.newsplane.postservice.entities.Competency;
import org.newsplane.postservice.entities.PostCategory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class PostCategoryResponse {
    private Long id;
    private String categoryName;
    private Set<CompetencyResponse> competencies = new HashSet<CompetencyResponse>();

    public PostCategoryResponse(PostCategory postCat){
        id = postCat.getId();
        categoryName = postCat.getCategoryName();
        
        postCat.getCompetencies().forEach(x->{
            var c = new CompetencyResponse(x);
            this.competencies.add(c);
        });
    }
}
