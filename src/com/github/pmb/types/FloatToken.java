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
	
	public int hashcode() {
		return Float.floatToRawIntBits(value);
	}
	
	public Token demote() {
		return new StringToken(String.valueOf(value));
	}
	
	public int id() {
		return 2;
	}
	
	/* TODO
	public Token add(FloatToken f) {
		return new FloatToken(value + f.value);
	}
	
	public Token sub(FloatToken f) {
		return new FloatToken(value - f.value);
	}
	
	public Token mul(FloatToken f) {
		return new FloatToken(value * f.value);
	}
	
	public Token div(FloatToken f) {
		return new FloatToken(value / f.value);
	}
	
	public Token pow(FloatToken f) {
		return new FloatToken((float)Math.pow(value, f.value));
	} */
}
