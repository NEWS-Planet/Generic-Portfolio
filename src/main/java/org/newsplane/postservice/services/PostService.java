package org.newsplane.postservice.services;

import java.io.IOException;
import java.util.List;

import org.newsplane.postservice.entities.Illustration;
import org.newsplane.postservice.models.CompetencyRequest;
import org.newsplane.postservice.models.CompetencyResponse;
import org.newsplane.postservice.models.DescriptionRequest;
import org.newsplane.postservice.models.DescriptionResponse;
import org.newsplane.postservice.models.IllustrationRequest;
import org.newsplane.postservice.models.IllustrationResponse;
import org.newsplane.postservice.models.PostCategoryRequest;
import org.newsplane.postservice.models.PostCategoryResponse;
import org.newsplane.postservice.models.PostRequest;
import org.newsplane.postservice.models.PostResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface PostService {
    public ResponseEntity<String> uploadImage(MultipartFile file) throws IOException;
    public ResponseEntity<byte[]> getImage(IllustrationRequest illustration);
    public Illustration uploadVideo(MultipartFile file);
    public List<IllustrationResponse> getIllustrationsByPost(PostRequest post);

    public CompetencyResponse addCompetency(CompetencyRequest comp_req);
    public CompetencyResponse getCompetencyByName(String name);
    public List<CompetencyResponse> getAllCompetencies();
    public List<CompetencyResponse> getAllCompetenciesByCategory(PostCategoryRequest cat);

    public DescriptionResponse addDescription(DescriptionRequest req);
    public DescriptionResponse getDescriptionByPostId(Long id);

    public PostCategoryResponse addPostCategory(PostCategoryRequest post_cat);
    public PostCategoryResponse getPostCategoryByName(String name);
    public PostCategoryResponse getPostCategory(PostCategoryRequest post_cat);
    public List<PostCategoryResponse> getAllPostCategories();

    public PostResponse addPost(PostRequest post);
    public List<PostResponse> getAllPost();
    public List<PostResponse> getAllPostByPostCategory(PostCategoryRequest post_cat);
    public List<PostResponse> getAllPostByCompetencies(List<CompetencyRequest> compts);
}
