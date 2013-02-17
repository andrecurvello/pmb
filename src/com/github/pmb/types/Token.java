package com.github.pmb.types;
import java.io.*;

public class Token implements Serializable {

	private static final long serialVersionUID = 1L;
	Token inside = empty;
	Token link = empty;
	static Token empty = new EmptyToken();
	
	public Token read() {
		return inside;
	}
	
	public void write(Token t) {
		inside = t;
	}
	
	public Token next() {
		return link;
	}
	
	public void before(Token t) {
		link = t;
	}
	
	public Token auxRead() {
		return empty;
	}
	
	public void auxWrite(Token t) {
		throw new MachineException();
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
}
