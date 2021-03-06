package com.rock.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.rock.spring.model.Book;
import com.rock.spring.service.BookService;

@CrossOrigin("*")
@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	// Get all books
	@GetMapping("/api/book")
	public ResponseEntity<List<Book>> list() {
		List<Book> list = bookService.getAll();
		return ResponseEntity.ok().body(list);
	}

	// Save book
	@PostMapping("/api/book")
	public ResponseEntity<?> save(@RequestBody Book book) {
		long id = bookService.saveBook(book);
		return ResponseEntity.ok().body("Book Creater with id " + id);
	}

	// Get book
	@GetMapping("/api/book/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") long id) {
		Book book = bookService.getBook(id);
		return ResponseEntity.ok().body(book);
	}
	
	// update book
	@PutMapping("/api/book/{id}")
	public ResponseEntity<?> updateBook(@PathVariable("id") long id, @RequestBody Book book){
		bookService.update(id, book);
		return ResponseEntity.ok().body("Book has been Updated")	;
	}
	
	// delete book
	@DeleteMapping("/api/book/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable("id") long id){
		bookService.delete(id);
		return ResponseEntity.ok().body("Book has been deleted");
	}
}
