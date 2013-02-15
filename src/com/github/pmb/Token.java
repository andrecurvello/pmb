package com.github.pmb;

public class Token {
	Token inside = empty;
	Token link = empty;
	static Token empty = new EmptyToken();
	
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
	
	public int hashCode() {
		return inside.hashCode();
	}
}
