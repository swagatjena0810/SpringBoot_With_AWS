package com.swagat.BookApp_SB_AWSRDS;

import java.util.List;

public interface IBookService {
	public BookEntity addBook(BookEntity book);
	public BookEntity deleteBook(Integer bookId);
	public List<BookEntity> getBooks();

}
