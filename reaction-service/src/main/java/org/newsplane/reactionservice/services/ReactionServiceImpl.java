package org.newsplane.reactionservice.services;

import java.util.ArrayList;
import java.util.List;

import org.newsplane.reactionservice.entities.CommentReaction;
import org.newsplane.reactionservice.entities.FavoriteReaction;
import org.newsplane.reactionservice.entities.Reaction;
import org.newsplane.reactionservice.models.CommentRequest;
import org.newsplane.reactionservice.models.CommentResponse;
import org.newsplane.reactionservice.models.LikeRequest;
import org.newsplane.reactionservice.models.LikeResponse;
import org.newsplane.reactionservice.repositories.CommentReactionRepository;
import org.newsplane.reactionservice.repositories.FavoriteRepository;
import org.newsplane.reactionservice.repositories.ReactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReactionServiceImpl implements ReactionService{

    @Autowired
    CommentReactionRepository commentReactionRepository;

    @Autowired
    FavoriteRepository favoriteRepository;

    @Autowired
    ReactionRepository reactionRepository;

    @Override
    public LikeResponse LikePost(LikeRequest like) {
        //Check the the reaction already exist
        var reactions = reactionRepository.findByPostId(like.getPostId());
         
        if(reactions!=null){
            var currentLikeReaction = favoriteRepository.findById(like.getId()).get();
            if(currentLikeReaction!=null){
                if(currentLikeReaction.getFavory()==1){
                    reactions.removeReaction(currentLikeReaction);
                }else{
                    currentLikeReaction.setFavory(currentLikeReaction.getFavory()==1?0:1);
                    reactions.addLikeReaction(currentLikeReaction);
                }
            }
            else{
                FavoriteReaction newLikeReaction = new FavoriteReaction(null, 1, like.getUserId(), like.getPostId(), reactions);
                reactions.addLikeReaction(newLikeReaction);
            }
            return new LikeResponse(currentLikeReaction);
        }
        
        else{
            FavoriteReaction newLikeReaction = new FavoriteReaction(null, 1, like.getUserId(), like.getPostId(), null);
            var likeReact = favoriteRepository.save(newLikeReaction);
            Reaction reaction = new Reaction(null, like.getUserId(), like.getPostId(), List.of(likeReact), null);
            var react = reactionRepository.save(reaction);
            likeReact.setFavoriteReaction(react);
            return new LikeResponse(likeReact);
        }
    }


    @Override
    public CommentResponse CommentPost(CommentRequest cmt) {
        //check for the reaction of the post
        var reactions = reactionRepository.findByPostId(cmt.getPostId());
        if(reactions!=null){
            CommentReaction comment = new CommentReaction(null, cmt.getPostId(), cmt.getUserId(), cmt.getCommentContent(), reactions);
            var myComment = commentReactionRepository.save(comment);
            reactions.addCommentReaction(myComment);
            return new CommentResponse(myComment);
        }else{
            Reaction nReaction = new Reaction(null, cmt.getUserId(), cmt.getPostId(), null, new ArrayList<CommentReaction>());
            var currentReaction = reactionRepository.save(nReaction);
            CommentReaction currentComment = new CommentReaction(null, cmt.getPostId(), cmt.getUserId(), cmt.getCommentContent(), currentReaction);
            var nComment = commentReactionRepository.save(currentComment);
            //System.out.println(nComment.getId());
            currentReaction.addCommentReaction(nComment);
            return new CommentResponse(nComment);
        }
    }

    @Override
    public void DeletePostComment(Long id) {
        var elementToDelete = commentReactionRepository.findById(id);
        if(elementToDelete!=null)commentReactionRepository.deleteById(id);
    }
    
}
