package org.newsplane.postservice.services;


import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.newsplane.postservice.entities.Competency;
import org.newsplane.postservice.entities.Description;
import org.newsplane.postservice.entities.Illustration;
import org.newsplane.postservice.entities.Post;
import org.newsplane.postservice.entities.PostCategory;
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
import org.newsplane.postservice.repositories.CompetencyRepository;
import org.newsplane.postservice.repositories.DescriptionRepository;
import org.newsplane.postservice.repositories.IllustrationRepository;
import org.newsplane.postservice.repositories.PostCategoryRepository;
import org.newsplane.postservice.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    IllustrationRepository illustrationRepository;

    @Autowired
    CompetencyRepository competencyRepository;

    @Autowired
    PostCategoryRepository postCategoryRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    DescriptionRepository descriptionRepository;

    @Value("${spring.servlet.multipart.location}")
    private String uploadDir;

    @Override
    public ResponseEntity<String> uploadImage(MultipartFile file) {
        //check if the file is empty
        if(file.isEmpty()){
            return ResponseEntity.badRequest().body("Please select a file to upload.");
        }

        //Check file file extension
        String originalFilename = file.getOriginalFilename();
        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
        List<String> allowedExtensions = Arrays.asList(".jpg", ".jpeg", ".png", ".gif");

        if(!allowedExtensions.contains(fileExtension.toLowerCase())){
            return ResponseEntity.badRequest().body("Invalid file extension. Allowed extensions are: " + String.join(", ", allowedExtensions));
        }
        //assets/images/illustrations/
        Path filePath = Paths.get(uploadDir, originalFilename);//Integer.toString(originalFilename.hashCode())
        try {
            Files.write(filePath, file.getBytes());
            var illustration = Illustration.builder().filename(filePath.getFileName().toString()).build();
            illustrationRepository.save(illustration);
            return ResponseEntity.ok("File uploaded successfully.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed.");
        }
    }

    @Override
    public Illustration uploadVideo(MultipartFile file) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'uploadVideo'");
    }

    @Override
    public List<IllustrationResponse> getIllustrationsByPost(PostRequest post) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIllustrationsByPost'");
    }

    @Override
    public CompetencyResponse addCompetency(CompetencyRequest comp_req) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addCompetency'");
    }

    @Override
    public CompetencyResponse getCompetencyByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCompetencyByName'");
    }

    @Override
    public List<CompetencyResponse> getAllCompetencies() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllCompetencies'");
    }

    @Override
    public List<CompetencyResponse> getAllCompetenciesByCategory(PostCategoryRequest cat) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllCompetenciesByCategory'");
    }

    @Override
    public DescriptionResponse addDescription(DescriptionRequest req) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addDescription'");
    }

    @Override
    public DescriptionResponse getDescriptionByPostId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDescriptionByPostId'");
    }

    PostCategory t = new PostCategory();
    @Override
    public PostCategoryResponse addPostCategory(PostCategoryRequest post_cat) {
        //Creation of the post category.
        PostCategory postCat = PostCategory.builder()
        .categoryName(post_cat.getCategoryName())
        .competencies(null)
        .build();//We first initialized competency by null.
        var isPost_cat_exist = postCategoryRepository.findByCategoryName(post_cat.getCategoryName());
        if(isPost_cat_exist==null){
            t = postCategoryRepository.save(postCat);
        }else{
            t = isPost_cat_exist;
        }

        //then we created the competencies.
        Set<Competency> comp = new HashSet<Competency>();
        post_cat.getCompetencies().forEach(x->{
            var isCompetencyExist = competencyRepository.findByCompetencyName(x.getCompetencyName());
            if(isCompetencyExist == null){
                var currentComp = Competency.builder()
                .competencyName(x.getCompetencyName())
                .competencyDescription(x.getCompetencyDescription())
                .postCategory(t)
                .desc(null)
                .build();
                competencyRepository.save(currentComp);
                comp.add(currentComp);
            }
        });
        //we attribute them to the post category.
        t.setCompetencies(comp);
        
        //We save our post category.
        postCategoryRepository.save(t);
        //We return 
        return new PostCategoryResponse(t);
    }

    @Override
    public PostCategoryResponse getPostCategoryByName(String name) {
        PostCategory element = postCategoryRepository.findByCategoryName(name);
        Set<Competency> competencies = new HashSet<Competency>();
        if(element!=null){
            var compts = competencyRepository.findByPostCategoryId(element.getId());
            competencies = compts;
        }
        Set<CompetencyResponse> comp_rep = new HashSet<CompetencyResponse>();
        competencies.forEach(x->{
            comp_rep.add(new CompetencyResponse(x));
        });
        PostCategoryResponse postRep = new PostCategoryResponse(element.getId(), name, comp_rep);
        return postRep;
    }

    @Override
    public PostCategoryResponse getPostCategory(PostCategoryRequest post_cat) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPostCategory'");
    }

    @Override
    public List<PostCategoryResponse> getAllPostCategories() {
        var my_post_cat = postCategoryRepository.findAll();
        List<PostCategoryResponse> post_rep = new ArrayList<PostCategoryResponse>();
        my_post_cat.forEach(x->{
            post_rep.add(getPostCategoryByName(x.getCategoryName()));
        });
        return post_rep;
    }

    @Override
    public PostResponse addPost(PostRequest post) {
        var p = new Post();
        var my_post = postRepository.save(p);
        //Set the title
        my_post.setPostTitle(post.getPostTitle());

        //Set the post category
        var my_post_cat = postCategoryRepository.findByCategoryName(post.getPostCategory().getCategoryName());
        my_post.setPostCategory(my_post_cat);

        //Get illustrations
        post.getIllustrations().forEach(x->{
            var cp = illustrationRepository.findByFilename(x.getFilename());
            if(cp!=null){
                cp.setPost(my_post);
                my_post.getIllustrations().add(cp);
            }
        });

        //Description
        var desc = Description.builder()
        .content(post.getDescription().getContent())
        .post(my_post)
        .competencies(new HashSet<Competency>())
        .build();
        var my_desc = descriptionRepository.save(desc);

        //Retrive Competencies
        post.getDescription().getCompetencies().forEach(x->{
            var current_comp = competencyRepository.findByCompetencyName(x.getCompetencyName());
            my_desc.getCompetencies().add(current_comp);
        });

        //Save description
        my_post.setDescription(my_desc);

        return new PostResponse(my_post);
    }

    @Override
    public List<PostResponse> getAllPost() {
        var allPost = postRepository.findAll();
        List<PostResponse> all_my_post = new ArrayList<PostResponse>();
        allPost.forEach(x->{
            all_my_post.add(new PostResponse(x));
        });
        return all_my_post;
    }

    @Override
    public List<PostResponse> getAllPostByPostCategory(PostCategoryRequest post_cat) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllPostByPostCategory'");
    }

    @Override
    public List<PostResponse> getAllPostByCompetencies(List<CompetencyRequest> compts) {
        List<PostResponse> my_pos = new ArrayList<PostResponse>();
        compts.forEach(x->{
            var current_comp = competencyRepository.findByCompetencyName(x.getCompetencyName());
            if(current_comp.getPostCategory()!=null){
                PostCategory post_cat = postCategoryRepository.findById(current_comp.getPostCategory().getId()).get();
                post_cat.getPost().forEach(i->{
                    if(i.getDescription().getCompetencies().contains(x)){
                        my_pos.add(new PostResponse(i));
                    }
                });
            }
        });
        return my_pos;
    }

    @Override
    public ResponseEntity<byte[]> getImage(IllustrationRequest illustrationReq) {
        try{
            var ele = illustrationRepository.findByFilename(illustrationReq.getFilename());
            if(ele!=null){
                Path imagePtah = Paths.get(uploadDir, ele.filename);
                byte[] imageByte = Files.readAllBytes(imagePtah);

                //HttpHeaders headers = new HttpHeaders();
                //headers.setContentType(MediaType.IMAGE_JPEG);
                return new ResponseEntity<>(imageByte, HttpStatus.OK);
            }else{
                return ResponseEntity.notFound().build();
            }
        }
        catch(IOException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
