package com.infotek.trivial.aplication.exceptions;

public class CategoriaNotFoundException extends RuntimeException {
   
	private static final long serialVersionUID = 1L;

	public CategoriaNotFoundException(String message) {
        super(message);
    }
}
