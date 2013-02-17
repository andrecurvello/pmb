package com.github.pmb.types;

public class FloatToken extends VarToken {

	private static final long serialVersionUID = 1L;
	float value;
	
	public FloatToken(float f) {
		link = this;//adv fix
		value = f;
	}

	public FloatToken() {
		new FloatToken(0.0F);
	}

	public Token read() {
		return this;
	}
	
	public void write(Token t) {
		throw new MachineException();
	}

	public Token next() {
		return this;//adv fix
	}
}
