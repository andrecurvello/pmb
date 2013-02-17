package com.github.pmb.types;

public class StringToken extends FloatToken {

	private static final long serialVersionUID = 1L;
	String text;
	
	public StringToken(String s) {
		text = s.intern();
	}

	public Token advance() {
		if((int)value >= text.length()) {
			value = 0.0F;
			return empty;
		}
		Token s = new StringToken(String.valueOf(text.charAt((int)value)));
		value = value + 1.0F;
		return s;
	}
	
	public int hashCode() {
		return text.hashCode();
	}
}
