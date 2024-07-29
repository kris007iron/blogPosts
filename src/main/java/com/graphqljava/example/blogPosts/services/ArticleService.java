package com.graphqljava.example.blogPosts.services;

import com.graphqljava.example.blogPosts.repositories.ArticleRepository;
import com.graphqljava.example.blogPosts.models.Article;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.graphqljava.example.blogPosts.exceptions.ResourceNotFoundException;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Article getArticleById(Long id) {
        return articleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Article", "id", id, "Article not found"));
    }

    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    public Article updateArticle(Long id, Article updatedArticle) {
        Article article = getArticleById(id);
        article.setTitle(updatedArticle.getTitle());
        article.setContent(updatedArticle.getContent());
        article.setPublishDate(updatedArticle.getPublishDate());
        return articleRepository.save(article);
    }
}
