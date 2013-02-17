package com.github.pmb.types;

public class Empty extends Token {
	
	private static final long serialVersionUID = 1L;

	public Token read() {
		return advance();
	}
	
	public void write(Token t) {
		throw new MachineException();
	}
	
	public void before(Token t) {
		throw new MachineException();
	}
	
	public Token advance() {
		return empty;
	}
}
