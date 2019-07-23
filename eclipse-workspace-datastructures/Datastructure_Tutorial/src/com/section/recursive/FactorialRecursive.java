package com.section.recursive;

public class FactorialRecursive {

	static int factorial(int n) {
		if (n==1) return 1;
		return n * factorial(n-1);
	}
	
	public static void main(String[] args) {

		int n=30;
		System.out.println("Factorial value "+factorial(n));
		
		
		
	}
}
