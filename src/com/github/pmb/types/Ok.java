package com.github.pmb.types;

public class Ok extends Empty {
	
	private static final long serialVersionUID = 1L;

	public Token advance() {
		return this;
	}
	
	public void reset() {
		
	}
	
	public int id() {
		return 3;
	}
}
