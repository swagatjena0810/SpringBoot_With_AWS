package com.RI._AdminModule.Exceptions;

public class CaseworkerNotFoundException  extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public CaseworkerNotFoundException(String msg) {
		super(msg);
	}

}
