package com.github.pmb.types;

public class TableToken extends StackToken {

	private static final long serialVersionUID = 1L;

	public Token read() {
		Token t = super.read();
		remove(t);
		return t;
	}
	
	public void write(Token t) {
		super.write(t);
		insert(t);
	}

	Token[] bucket = new StackToken[16];
	Token[] reverse = new StackToken[16];
	
	public TableToken() {
		for(int i = 0; i < 16; i++) {
			bucket[i] = new StackToken();
			reverse[i] = new StackToken();
		}
	}

	public Token advance() {
		empty.inside = inside;//get the pre-pointer
		return super.advance();
	}
	
	void insert(Token t) {
		bucket[hash(t)].write(t);
		//and reverse lookup
		Token ta = t.next();
		if(ta != empty)
			reverse[hash(ta)].write(t);
	}

	Token where(Token t, boolean back) {
		if(back) {
			return reverse[hash(t.next())];
		} else {
			return bucket[hash(t)];
		}
	}

	Token find(Token t, boolean back) {
		Token ta = where(t, back);
		Token i;
		ta.reset();
		while((i = ta.advance()) != empty && (back?i.inside.next():i.inside) != t);
		if(i != empty) {
			if(empty.inside != empty) {
				empty.inside.before(i);
				ta.before(i);
			}
			empty.inside = ta;
			return i.inside;
		} else {
			empty.inside = ta;
			return empty;
		}
	}

	void remove(Token t) {
		if(find(t, true) != empty)
			empty.inside.before(empty.inside.next());//drop
		find(t, false);
		empty.inside.before(empty.inside.next());//drop
	}
	
	int hash(Token t) {
		int h = t.hashCode();
		return (h ^ (h >> 4) ^ (h >> 8) ^ (h >> 12)) & 15;
	}
}
