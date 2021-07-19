package com.qa.springbooks.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.springbooks.domain.Books;
import com.qa.springbooks.repo.BooksRepo;

@Service
public class BooksService {

	private BooksRepo repo;

	public BooksService(BooksRepo repo) {
		this.repo = repo;

	}

	public Books create(Books bk) {
		return this.repo.saveAndFlush(bk);

	}

	public List<Books> read() {
		return this.repo.findAll();

	}

	public Books update(Long id, Books newBk) {
		Books existing = this.repo.getById(id);
		existing.setName(newBk.getName());
		existing.setAuthor(newBk.getAuthor());
		existing.setYearPublished(newBk.getYearPublished());
		existing.setGenre(newBk.getGenre());
		existing.setRating(newBk.getRating());

		Books updated = this.repo.save(existing);
		return updated;

	}

	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);

	}

}
