package com.example.service.acticle;

import com.example.model.Article;
import com.example.service.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArticleService extends IService<Article> {
	Page<Article> findByTitle(String name, Pageable pageable);
}
