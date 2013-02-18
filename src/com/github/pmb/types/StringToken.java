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
	
	public Token demote() {
		return new StringToken("\"" + text.replaceAll("\"", "\"\"") + "\"");
	}
	
	public Token add(FloatToken f) {
		return new StringToken(text + ((StringToken)f).text);
	}
	
	public Token sub(FloatToken f) {
		return new StringToken(text.replaceAll(((StringToken)f).text, ""));
	}
	
	public Token mul(FloatToken f) {
		return add(f);
	}
	
	public Token div(FloatToken f) {
		return sub(f);
	}
	
	public Token pow(FloatToken f) {
		if(f.getClass() == StringToken.class) throw new MachineException();
		String s = "";
		int lim = (int)f.value;
		for(int i = 0; i < lim; i++) s += text;
		return new StringToken(s);
	}
}
