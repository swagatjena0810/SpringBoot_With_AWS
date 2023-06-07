package com.swagat.BookApp_SB_AWSRDS;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements IBookService{
	
	@Autowired
	private BookRepository bookRepo;
	
	
	@Override
	public BookEntity addBook(BookEntity book) {
		// TODO Auto-generated method stub
		
		return this.bookRepo.save(book);
	}

	@Override
	public BookEntity deleteBook(Integer bookId)  {
		Optional<BookEntity> op=this.bookRepo.findById(bookId);
		if(op.isPresent()) {
			bookRepo.deleteById(bookId);
			return op.get();
		}
		else {
			throw new BookIdNotFoundException("Book not found");
		}
	}

	@Override
	public List<BookEntity> getBooks() {
		return bookRepo.findAll();
	}

}
