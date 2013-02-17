package com.github.pmb.types;

public class StackCursor extends Token {

	public Token read() {
		if(inside == empty) {
			inside = next();
		} else {
			inside = inside.next();
		}
		return inside.read();
	}
	
	public void write(Token t) {
		throw new MachineException();
	}
	
	public int hashCode() {
		return ((Object)this).hashCode();
	}
}
