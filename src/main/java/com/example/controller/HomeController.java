package com.example.controller;

import com.example.model.Article;
import com.example.model.Author;
import com.example.service.acticle.ArticleService;
import com.example.service.author.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
	@Autowired
	private AuthorService authorService;

	@Autowired
	private ArticleService articleService;

	@GetMapping
	public String doGetHome() {
		Author author1 = new Author("Rambabu Posa");
		Author author2 = new Author("Rambabu Posa 2");
		Author author3 = new Author("Toan");
		authorService.save(author1);
		authorService.save(author2);
		authorService.save(author3);

		Page<Author> authors = authorService.findByName("Rambabu", PageRequest.of(0, 10));

		Article article1 = new Article("Elasticsearch Basics", author1, author2);
		Article article2 = new Article("Elasticsearch Basics 2", author1, author2);
		articleService.save(article1);
		articleService.save(article2);

		Page<Article> articles = articleService.findByTitle("Elasticsearch Basics", PageRequest.of(0, 10));

		authors.forEach(x -> System.out.println(x));
		return "";
	}
}
