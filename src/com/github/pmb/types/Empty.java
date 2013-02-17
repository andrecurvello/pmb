package com.github.pmb.types;

public class Empty extends Token {
	
	private static final long serialVersionUID = 1L;

	public void write(Token t) {
		throw new MachineException();
	}
}
