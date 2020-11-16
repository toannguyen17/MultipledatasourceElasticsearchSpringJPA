package com.example.repositories.elasticsearch1;

import com.example.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticleRepository extends ElasticsearchRepository<Article, Long> {
	Page<Article> findByAuthorsName(String name, Pageable pageable);
	Page<Article> findByTitle(String name, Pageable pageable);
}
