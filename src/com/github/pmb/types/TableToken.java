package com.github.pmb.types;

public class TableToken extends StackToken {
	
	public TableToken() {
		inside = new TableCursor();
	}
	
	public Token read() {
		Token t = super.read();
		((TableCursor)inside).remove(t);
		return t;
	}
	
	public void write(Token t) {
		super.write(t);
		((TableCursor)inside).insert(t);
	}

}
