package com.swagat.BookApp_SB_AWSRDS;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@Autowired
	private IBookService bookService;
	
	@PostMapping("/addbook")
	public ResponseEntity<BookEntity> addabook(@RequestBody BookEntity book){
		return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addBook(book));
	}
	
	@DeleteMapping("deletebook/{bookId}")
	public ResponseEntity<BookEntity> deleteaBook(@PathVariable("bookId") Integer bookId){
		return ResponseEntity.status(HttpStatus.OK)
				.body(bookService.deleteBook(bookId));
	}
	
	@GetMapping("/books")
	public ResponseEntity<List<BookEntity>> viewBooks(){
		return ResponseEntity.ok(bookService.getBooks());
	}
}
