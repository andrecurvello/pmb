package com.github.pmb;

public class TableToken extends StackToken {
	
	public Token read() {
		return inside;
	}
	
	public void write(Token t) {
		inside = t;
	}
	
	public Token auxRead() {
		return empty;
	}
	
	public void auxWrite(Token t) {
		throw new MachineException();
	}

}
