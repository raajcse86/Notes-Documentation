package com.section.recursive;

public class WithoutRecursion {

	
	
	public static void main(String[] args) {
		
		int n= 5;
		int result= 0;
		

		for(int i=1;i<=n;i++) {
			result = result +i;
		}
		
		
		System.out.println("Result is "+result);
		
	}
}
