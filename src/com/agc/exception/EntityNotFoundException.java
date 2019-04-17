package com.agc.exception;

public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public <T> EntityNotFoundException(Class<T> entity, String publicID) {
		super(entity.getSimpleName() + " with PublicID [" + publicID + "] not found");
	}

}
