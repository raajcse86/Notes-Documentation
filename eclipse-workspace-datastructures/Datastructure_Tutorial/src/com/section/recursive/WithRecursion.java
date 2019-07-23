package com.section.recursive;

public class WithRecursion {

	static int sumRecursive(int n) {
		if(n == 1) return 1;
		return n+ sumRecursive(n-1);
	}
	
	
	public static void main(String[] args) {
		int n=5;
		System.out.println("Value "+sumRecursive(n));
	}
}
