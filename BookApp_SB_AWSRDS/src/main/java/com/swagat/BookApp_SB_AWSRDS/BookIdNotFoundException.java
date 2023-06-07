package com.swagat.BookApp_SB_AWSRDS;

public class BookIdNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BookIdNotFoundException(String msg) {
		super(msg);
	}

}
