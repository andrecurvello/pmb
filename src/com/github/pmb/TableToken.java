package com.github.pmb;

public class TableToken extends StackToken {
	
	class TableHandler extends Token {
		//TODO
	}
	
	public TableToken() {
		inside = new TableHandler();
	}
	
	public Token read() {
		return inside;
	}
	
	public void write(Token t) {
		inside = t;
	}
	
	public Token next() {
		return link;
	}
	
	public void before(Token t) {
		link = t;
	}
	
	public Token auxRead() {
		return empty;
	}
	
	public void auxWrite(Token t) {
		throw new MachineException();
	}

}
