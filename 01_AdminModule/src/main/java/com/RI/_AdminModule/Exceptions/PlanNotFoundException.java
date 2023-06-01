package com.RI._AdminModule.Exceptions;

public class PlanNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	public PlanNotFoundException(String msg) {
		super(msg);
	}
}
