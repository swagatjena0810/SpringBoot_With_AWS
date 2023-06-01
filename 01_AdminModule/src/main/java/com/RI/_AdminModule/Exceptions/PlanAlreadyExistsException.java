package com.RI._AdminModule.Exceptions;

public class PlanAlreadyExistsException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PlanAlreadyExistsException(String msg) {
		super(msg);
	}
}
