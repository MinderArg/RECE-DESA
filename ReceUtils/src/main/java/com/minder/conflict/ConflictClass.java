package com.minder.conflict;

public class ConflictClass implements Conflictable {

	@Override
	public void doConflict() {
		System.out.println("I am still a conflict!");
		System.out.println("Dustin Pine");
	}

	@Override
	public void doTheDanny() {
		System.out.println("Doing the danny!");
	}

	@Override
	public int lucas() {
		return 10;
	}
	
}
