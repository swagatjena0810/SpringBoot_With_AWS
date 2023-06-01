package com.RI._AdminModule.Exceptions;

public class CaseWorkerAlreadyExistsException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public CaseWorkerAlreadyExistsException(String msg) {
		super(msg);
	}
}
