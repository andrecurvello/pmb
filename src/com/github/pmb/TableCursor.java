package com.github.pmb;

public class TableCursor extends StackCursor {
	StackToken[] bucket = new StackToken[16];
	StackToken[] reverse = new StackToken[16];
	
	TableCursor() {
		for(int i = 0; i < 16; i++) {
			bucket[i] = new StackToken();
			reverse[i] = new StackToken();
		}
	}
	
	void insert(Token t) {
		bucket[hash(t)].write(t);
		//and reverse lookup
		Token r = t.next();
		if(r != empty)
			reverse[hash(r)].write(t);
	}
	
	void remove(Token t) {
		StackToken b = bucket[hash(t)];
		Token at = b.inside.link;
		if(at.inside == t) {
			b.read();
			return;
		}
		Token then = at.link; 
		while(then.inside != t && at != empty) {
			at = then;
			then = then.link;
		}
		at.link = then.link;//quick and simple-ish erase
	}
	
	int hash(Token t) {
		int h = t.hashCode();
		return (h ^ (h >> 4) ^ (h >> 8) ^ (h >> 12)) & 15;
	}
}
