package com.github.pmb.types;

public class VarToken extends Token {
	
	public Token read() {
		return inside.read();
	}
	
	public void write(Token t) {
		inside.write(t);
	}

}
