package com.github.pmb.types;
import java.io.*;

public class Token implements Serializable {

	//WARNING! This whole package is very tightly coupled code.
	//There are many side effect dependencies.

	//All code is written for cooperative multitasking,
	//and is NOT reentrant (for speed and lower size).

	private static final long serialVersionUID = 1L;
	Token link = empty;
	Token inside = empty;//utility
	static Token empty = new Empty();
	static Token ok = new Ok();
	static ExpressionStack e = new ExpressionStack();
	static TraceStack r = new TraceStack();
	static StackToken pri = new StackToken();//precedence chain
	
	//interpreter/compiler dual /* Active */
	public void eval() {
		e.write(read());
	}
	
	public void parse() {
		e.write(read());
	}
	
	//getter/setter dual
	public Token read() {
		return inside;
	}
	
	public void write(Token t) {
		inside = t;
	}
	
	//enumerator dual
	public void reset() {
		throw new MachineException();
	}

	public Token advance() {
		throw new MachineException();
	}

	//queueing dual
	public void before(Token t) {
		link = t;
	}

	public Token next() {
		return link;
	}
	
	//equality dual
	public Token getType() {
		return new TypeToken(this);
	}

	public int hashCode() {
		return inside.hashCode();
	}
	
	//association dual
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
	
	//representation dual
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
	
	//dispatcher speeder
	public int id() {
		return 8;
	}
	
	/* TODO
	public Token equal(Token t) {
		if(getClass() != t.getClass()) return empty;
		if(hashCode() != t.hashCode()) return empty;
		return ok;
	} */
}
