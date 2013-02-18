package com.github.pmb.types;

public class VarToken extends Token {

	private static final long serialVersionUID = 1L;

	public Token read() {
		return next();
	}
	
	public void write(Token t) {
		super.before(t);
	}

	public void before() {
		throw new MachineException();//not a token linker
	}

	Token advSub() {
		return empty;
	}
	
	public void reset() {
		inside = empty;
	}

	public Token advance() {
		//inside is used as a presentation flag
		if(inside == empty) {
			return inside = next();
		} else {
			return inside = advSub();
		}
	}
	
	public int hashCode() {
		return ((Object)this).hashCode();
	}
}
