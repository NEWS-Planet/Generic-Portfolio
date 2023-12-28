package org.newsplane.postservice.models;

import org.newsplane.postservice.entities.Competency;
import org.newsplane.postservice.entities.PostCategory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class CompetencyResponse {
    private Long id;
    private String competancyName;
    private String competencyDescription;
    private PostCategory postCategory;

    public CompetencyResponse(Competency comp){
        id = comp.getId();
        competancyName = comp.getCompetencyName();
        competencyDescription = comp.getCompetencyDescription();
        postCategory = comp.getPostCategory();
    }
}
