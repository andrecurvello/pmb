package com.github.pmb.types;

public class StackToken extends VarToken {

	private static final long serialVersionUID = 1L;

	//indirect cos different tokens must point to same stack.
	public Token read() {
		Token top = next();
		before(top.next());
		return top.inside;//from container token
	}
	
	public void write(Token t) {
		Token top = new Token(); //pointer reference
		top.inside = t;
		top.before(next());
		before(top);
	}

	Token advSub() {
		return inside.next();
	}
}
