package org.newsplane.postservice.repositories;

import org.newsplane.postservice.entities.Post;
import org.newsplane.postservice.entities.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>{
    public Post findByPostCategory(PostCategory post_cat);
}
