package com.github.pmb.types;

public class ExpressionStack extends StackToken {

	private static final long serialVersionUID = 1L;
	StackToken saver = new StackToken();
	
	public Token read() {
		if(next() == saver.next().inside) closure();
		return super.read();
	}
	
	//state management dual
	public void save() {
		saver.write(next());
	}
	
	public void restore() {
		before(saver.read());
	}
	
	void closure() {
		throw new MachineException();//stack under
	}

	public int id() {
		return 1;
	}
}
