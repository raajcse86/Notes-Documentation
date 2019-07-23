package com.tutorial.atomicoperation;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceExample {

	
	
	public static void main(String[] args) {
		String oldName = "oldname";
		String newName = "newname";
		
		AtomicReference<String> atomicReference = new AtomicReference<String>(oldName);
		
		//atomicReference.set("unexpected name");
		
		if(atomicReference.compareAndSet(oldName, newName)) {
			System.out.println("New value is "+atomicReference.get());
		}else {
			System.out.println("Nothing has happened");
		}
	}
}
