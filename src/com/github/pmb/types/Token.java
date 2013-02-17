package com.github.pmb.types;
import java.io.*;

public class Token implements Serializable {

	//WARNING! This whole package is very tightly coupled code.
	//There are many side effect dependancies.

	//All code is written for cooperative multitasking,
	//and is NOT reentrant (for speed and lower size.

	private static final long serialVersionUID = 1L;
	Token link = empty;
	Token inside = empty;//utility
	static Token empty = new Empty();
	static Token ok = new Ok();
	
	public Token read() {
		return inside;
	}
	
	public void write(Token t) {
		inside = t;
	}

	public Token advance() {
		throw new MachineException();
	}
	
	public Token getType() {
		return new TypeToken(this);
	}

	public void before(Token t) {
		link = t;
	}

	public Token next() {
		return link;
	}

	public int hashCode() {
		return inside.hashCode();
	}
	
	public Token index(Token i) {
		//index the type using i
		//TODO
		throw new MachineException();
	}
	
	public Token find(Token i) {
		//find within the type using i for search
		//TODO
		throw new MachineException();
	}
	
	public Token promote() {
		//promote the type string is lowest
		//TODO
		throw new MachineException();
	}
	
	public Token demote() {
		//demote the type towards string
		//TODO
		throw new MachineException();
	}
	
	public Token equal(Token t) {
		if(hashCode() != t.hashCode()) return empty;
		Class c = FloatToken.class;
		Class d = getClass();
		Class e = null;
		if(d == c && (e = t.getClass()) != c) return empty;
		if(d != c && e == c) return empty;
		return ok;
	}
}
