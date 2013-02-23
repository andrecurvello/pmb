package com.github.pmb.types;

public class Empty extends PassiveToken {
	
	private static final long serialVersionUID = 1L;

	public Token read() {
		return empty;
	}
	
	public void write(Token t) {
		throw new MachineException();
	}
	
	public void before(Token t) {
		throw new MachineException();
	}
	
	public int id() {
		return 0;
	}
}
