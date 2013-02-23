package com.github.pmb.types;

public class TypeToken extends VarToken {

	private static final long serialVersionUID = 1L;

	public TypeToken(Token token) {
		before(token);
	}
	
	public Token read() {
		return this;
	}
	
	public void write(Token t) {
		throw new MachineException();
	}
	
	public Token next() {
		return this;
	}
	
	public int hashCode() {
		return next().getClass().hashCode();
	}
	
	public int id() {
		return 9;
	}
}
