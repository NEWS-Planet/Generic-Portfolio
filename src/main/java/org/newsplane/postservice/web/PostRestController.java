package org.newsplane.postservice.web;

import java.io.IOException;
import java.util.List;

import org.newsplane.postservice.models.PostCategoryRequest;
import org.newsplane.postservice.models.PostCategoryResponse;
import org.newsplane.postservice.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/post")
public class PostRestController {
    @Autowired
    PostService postService;

    @PostMapping("/upload-image")
    public ResponseEntity<String> UplodaImage(@RequestParam("file") MultipartFile file) throws IOException{
        return postService.uploadImage(file);
    }

    @PostMapping("/add-post-category")
    public PostCategoryResponse addPostCategory(@RequestBody PostCategoryRequest postCatReq){
        return postService.addPostCategory(postCatReq);
    }

    @GetMapping("/get-category/{name}")
    public PostCategoryResponse getPostCategoryByName(@PathVariable("name") String name){
        return postService.getPostCategoryByName(name);
    }

    @GetMapping("/get-all-post-category")
    public List<PostCategoryResponse> getAllPostCatResponse(){
        return postService.getAllPostCategories();
    }
}
