package org.newsplanet.analyticservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class PostAnalytic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long postId;
    private int reactionNumber;
    private int commentNumber;
    private int likeNumber;
    private int visitNumber;

    @ManyToOne
    @JoinColumn(name = "analyseGenId")
    private Analytic analyseCenter;

    public double postLikeAverage(){
        return likeNumber / analyseCenter.getPostLikesNumber();
    }

    public double postCommentAverage(){
        return commentNumber / analyseCenter.commentNumber();
    }

    public double postVisitAverage(){
        return visitNumber / analyseCenter.getPostVisitNumber();
    }
}
