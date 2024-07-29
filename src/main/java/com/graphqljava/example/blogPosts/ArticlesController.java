package com.graphqljava.example.blogPosts;

import com.graphqljava.example.blogPosts.Article;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ArticlesController {
    @QueryMapping
    public Article articleById(@Argument Long id) {
        return Article.getById(id);
    }
}
