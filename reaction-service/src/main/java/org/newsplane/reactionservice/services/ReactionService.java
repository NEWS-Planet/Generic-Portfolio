package org.newsplane.reactionservice.services;

import org.newsplane.reactionservice.models.CommentRequest;
import org.newsplane.reactionservice.models.CommentResponse;
import org.newsplane.reactionservice.models.LikeRequest;
import org.newsplane.reactionservice.models.LikeResponse;

public interface ReactionService {
    public LikeResponse LikePost(LikeRequest like);
    public CommentResponse CommentPost(CommentRequest cmt);
    public void DeletePostComment(Long id);
}
