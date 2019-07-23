package com.section.recursive.dp;

import java.util.HashMap;
import java.util.Map;

class Algorithm{
	
	Map<Integer, Integer> map ;
	
	
	public Algorithm() {
		this.map = new HashMap<>();
		this.map.put(0, 0);
		this.map.put(1, 1);
	}
	
	int naiveFibo(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		return naiveFibo(n-1) + naiveFibo(n-2);
	}
	
	
	int fibDP(int n) {
		if(this.map.containsKey(n)) return this.map.get(n);
		
		this.map.put(n-1, fibDP(n-1));
		this.map.put(n-2,fibDP(n-2));
		
		int calculateForGivenNumber = this.map.get(n-1) + this.map.get(n-2);
		
		this.map.put(n, calculateForGivenNumber);
		
		return calculateForGivenNumber;
		
	}
}


public class Fibonacci_DP_Example {
	
	public static void main(String[] args) {
		Algorithm algorithm = new Algorithm();
		System.out.println("Fibo "+algorithm.naiveFibo(1000));
		
		//System.out.println("Fibo "+algorithm.fibDP(1000));
	}

}
