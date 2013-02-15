package com.github.pmb;

public class EmptyToken extends Token {
	
	public void write(Token t) {
		throw new MachineException();
	}
	
	public void before(Token t) {
		throw new MachineException();
	}
	
	public void auxWrite(Token t) {
		throw new MachineException();
	}
}
