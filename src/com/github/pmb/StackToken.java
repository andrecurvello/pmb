package com.github.pmb;

public class StackToken extends Token {

	//double indirect cos different tokens must point to same stack.
	public Token read() {
		Token stack = inside;
		Token top = stack.next();
		stack.before(top.next());
		return top;
	}
	
	public void write(Token t) {
		t.before(inside.next());
		inside.before(t);
	}
	
	//hash of stack individuality not content.
}
