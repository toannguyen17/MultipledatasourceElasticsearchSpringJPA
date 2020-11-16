package com.example.service.author;

import com.example.model.Author;
import com.example.service.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AuthorService extends IService<Author> {
	Page<Author> findByName(String name, Pageable pageable);
}
