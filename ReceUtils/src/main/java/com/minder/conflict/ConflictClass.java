package com.minder.conflict;

public class ConflictClass implements Conflictable {

	@Override
	public void doConflict() {
		System.out.println("I am a conflict!");
		System.out.println("Dustin Pine");
	}

	@Override
	public int lucas() {
		return 10;
	}
	
}
