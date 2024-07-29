package com.graphqljava.example.blogPosts.repositories;

import com.graphqljava.example.blogPosts.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByTags_Name(String tagName);
}