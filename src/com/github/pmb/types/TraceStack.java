package com.github.pmb.types;

public class TraceStack extends ExpressionStack {

	private static final long serialVersionUID = 1L;
	
	//state management dual
	public void restore() {
		//TODO
		//catch management
	}
	
	void closure() {
		saver.read();//end catch
	}

	public int id() {
		return 11;
	}
}
