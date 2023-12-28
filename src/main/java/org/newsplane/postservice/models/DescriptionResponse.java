package org.newsplane.postservice.models;

import java.util.Set;

import org.newsplane.postservice.entities.Competency;
import org.newsplane.postservice.entities.Description;
import org.newsplane.postservice.entities.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class DescriptionResponse {
    private Long id;
    private String content;
    private Set<CompetencyResponse> competencies;
    private Post post;

    public DescriptionResponse(Description desc){
        id = desc.getId();
        content = desc.getContent();
        post = desc.getPost();
        desc.getCompetencies().forEach(x->{
            competencies.add(new CompetencyResponse(x));
        });
    }
}
