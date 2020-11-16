package com.example.service.author;

import com.example.model.Author;
import com.example.repositories.elasticsearch2.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public Iterable<Author> findAll() {
		return authorRepository.findAll();
	}

	@Override
	public Optional<Author> findById(Long id) {
		return authorRepository.findById(id);
	}

	@Override
	public void save(Author entity) {
		authorRepository.save(entity);
	}

	@Override
	public void delete(Author entity) {
		authorRepository.delete(entity);

	}

	@Override
	public void deleteById(Long id) {
		authorRepository.deleteById(id);

	}

	@Override
	public Page<Author> findByName(String name, Pageable pageable) {
		return authorRepository.findByName(name, pageable);
	}
}
