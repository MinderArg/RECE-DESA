package com.minder.conflict;

public class ConflictClass implements Conflictable {

	@Override
	public void doConflict() {
		System.out.println("I am still a conflict!");
	}

	@Override
	public void doTheDanny() {
		System.out.println("Doing the danny!");
	}
	
}
