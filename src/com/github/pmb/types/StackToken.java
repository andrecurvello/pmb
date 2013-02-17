package com.github.pmb.types;

public class StackToken extends Token {
	
	public StackToken() {
		inside = new StackCursor();
	}

	//double indirect cos different tokens must point to same stack.
	public Token read() {
		Token stack = inside;
		Token top = stack.next();
		stack.before(top.next());
		return top.read();//from container token
	}
	
	public void write(Token t) {
		(t = new Token()).write(t);
		t.before(inside.next());
		inside.before(t);
	}

}
