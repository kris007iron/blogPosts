package com.graphqljava.example.blogPosts;

import java.util.Arrays;
import java.util.List;

public record Article(Long id, String title, String content, String publishDate) {
    private static final List<Article> articles = Arrays.asList(
            new Article(1L, "Article 1", "Content of article 1", "2021-01-01"),
            new Article(2L, "Article 2", "Content of article 2", "2021-01-02"),
            new Article(3L, "Article 3", "Content of article 3", "2021-01-03")
    );

    public static Article getById(Long id) {
        return articles.stream().filter(article -> article.id().equals(id)).findFirst().orElse(null);
    }
}