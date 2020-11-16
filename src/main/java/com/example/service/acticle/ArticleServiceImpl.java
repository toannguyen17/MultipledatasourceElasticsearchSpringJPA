package com.example.service.acticle;

import com.example.model.Article;
import com.example.model.Author;
import com.example.repositories.elasticsearch1.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleRepository articleRepository;

	@Override
	public Iterable<Article> findAll() {
		return articleRepository.findAll();
	}

	@Override
	public Optional<Article> findById(Long id) {
		return articleRepository.findById(id);
	}

	@Override
	public void save(Article entity) {
		articleRepository.save(entity);
	}

	@Override
	public void delete(Article entity) {
		articleRepository.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		articleRepository.deleteById(id);
	}

	@Override
	public Page<Article> findByTitle(String name, Pageable pageable) {
		return articleRepository.findByTitle(name, pageable);
	}
}
