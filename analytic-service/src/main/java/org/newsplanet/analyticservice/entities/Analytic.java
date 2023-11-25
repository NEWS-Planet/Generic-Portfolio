package org.newsplanet.analyticservice.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Analytic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "analyseCenter")
    private ProfileAnalytic profile;

    @OneToMany(mappedBy = "analyseCenter")
    private Set<PostAnalytic> posts = new HashSet<PostAnalytic>();

    private int postLikesNumber;
    private int postCommentsNumber;
    private int postVisitNumber;
    private int profileVisitNumber;

    public int PostNumber(){
        return posts.size();
    }

    public int likeNumber(){
        posts.forEach(x->{
            postLikesNumber += x.getLikeNumber();
        });
        return postLikesNumber;
    }
    
    public int commentNumber(){
        posts.forEach(x->{
            postCommentsNumber += x.getCommentNumber();
        });
        return postCommentsNumber;
    }

    public int postVisit(){
        posts.forEach(x->{
            postVisitNumber += x.getVisitNumber();
        });
        return postVisitNumber;
    }

    public int profileVisit(){
        return profile.getVisitNumber();
    } 
}
