package com.github.pmb.types;

public class PassiveToken extends Token {

	private static final long serialVersionUID = 1L;

	public void eval() {
		//all literal except procs
		e.write(this);
	}
	
	public void parse() {
		//all literal except procs
		e.write(this);
	}
	
	public int hashCode() {
		return ((Object)this).hashCode();
	}
	
	public int id() {
		return 4;
	}
}
