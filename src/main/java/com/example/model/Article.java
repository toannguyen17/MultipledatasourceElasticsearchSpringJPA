package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Document(indexName = "posts")
public class Article {
	@Id
	private String id;

	private String title;

	@Field(type = FieldType.Nested, includeInParent = true)
	private List<Author> authors;

	public Article(){
	}

	public Article(String title, Author... authors) {
		this.title = title;
		this.authors = Arrays.asList(authors);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
}
