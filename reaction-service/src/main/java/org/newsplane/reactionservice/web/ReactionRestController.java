package org.newsplane.reactionservice.web;
import org.newsplane.reactionservice.models.CommentRequest;
import org.newsplane.reactionservice.models.CommentResponse;
import org.newsplane.reactionservice.models.LikeRequest;
import org.newsplane.reactionservice.models.LikeResponse;
import org.newsplane.reactionservice.services.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reaction")
public class ReactionRestController {
    @Autowired
    ReactionService reactionService;

    @PostMapping("comment-post")
    public CommentResponse postComment(@RequestBody CommentRequest comment){
        return reactionService.CommentPost(comment);
    }

    @GetMapping("delete-post/{id}")
    public void deletePost(@PathVariable("id") Long id){
        reactionService.DeletePostComment(id);
    }

    @PostMapping
    public LikeResponse likePost(@RequestBody LikeRequest like){
        return reactionService.LikePost(like);
    }
}
