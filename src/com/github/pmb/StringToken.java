package com.github.pmb;

public class StringToken extends Token {
	String text;
	
	public StringToken(String s) {
		text = s.intern();
		inside = empty;
	}
	
	public StringToken(StringToken t) {
		text = t.text;
		inside = t.inside;
	}

	public Token read() {
		return new StringToken(this);
	}
	
	public void write(Token t) {
		throw new MachineException();
	}
	
	public Token auxRead() {
		return inside;
	}
	
	public void auxWrite(Token t) {
		inside = t;
	}
	
	public int hashCode() {
		return text.hashCode();
	}
}
