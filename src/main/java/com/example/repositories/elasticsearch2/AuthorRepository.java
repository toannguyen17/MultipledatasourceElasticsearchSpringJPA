package com.example.repositories.elasticsearch2;

import com.example.model.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface AuthorRepository extends ElasticsearchRepository<Author, Long> {
	Page<Author> findByName(String name, Pageable pageable);
}
