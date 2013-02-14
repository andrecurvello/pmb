package com.github.pmb;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.screen.*;
import com.googlecode.lanterna.terminal.Terminal.*;

public class PMB {

	static Screen focus = TerminalFacade.createScreen(TerminalFacade.createSwingTerminal());
	
	public static void main(String[] args) {
		Key k;
		focus.startScreen();
		focus.putString(2, 2, "hello world", Color.MAGENTA, Color.CYAN);
		focus.refresh();
		while(true) {
			while((k = focus.readInput()) == null) Thread.yield();
			if(k.getCharacter() == 'A') return;
		}
		//focus.stopScreen();
	}
	
}
