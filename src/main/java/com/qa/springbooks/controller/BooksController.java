package com.qa.springbooks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springbooks.domain.Books;
import com.qa.springbooks.service.BooksService;

@RestController
@RequestMapping("/books")
@CrossOrigin

public class BooksController {

	private BooksService service;

	@Autowired
	public BooksController(BooksService service) {
		this.service = service;

	}

	@GetMapping("/test")
	public String test() {
		return "Book Ratings TBC";

	}

	@PostMapping("/create")
	public ResponseEntity<Books> create(@RequestBody Books bk) {
		return new ResponseEntity<Books>(this.service.create(bk), HttpStatus.CREATED);

	}

	@GetMapping("/read")
	public ResponseEntity<List<Books>> read() {
		return new ResponseEntity<List<Books>>(this.service.read(), HttpStatus.OK);

	}

	@PutMapping("/replace/{id}")
	public ResponseEntity<Books> update(@PathVariable Long id, @RequestBody Books bk) {
		return new ResponseEntity<Books>(this.service.update(id, bk), HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {
		return new ResponseEntity<Boolean>(this.service.delete(id), HttpStatus.NO_CONTENT);

	}

}
