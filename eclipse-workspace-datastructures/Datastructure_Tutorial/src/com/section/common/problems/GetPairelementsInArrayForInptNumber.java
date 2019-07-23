package com.section.common.problems;

import java.util.Arrays;

public class GetPairelementsInArrayForInptNumber {

	
	public static void main(String[] args) {
		int inputElment = 10;
		int[] inputArray = new int[] {4, 6, 5, -10, 8, 5, 20};
		System.out.println("The given input element is "+inputElment);
		
		 //findThePairs(inputArray, inputElment);
		 
		 findNthPairOpt(inputArray, inputElment);
	}

	
	//the time complexity is O(N^2), as we are iterating through two for loops.
	private static void findThePairs(int[] inputArray, int inputElement) {
		for(int i=0;i<inputArray.length;i++) {
			for(int j=1;j<inputArray.length;j++) {
				
				if(inputArray[i] + inputArray[j] == inputElement) {
					System.out.println("Pair are "+inputArray[i]+","+inputArray[j]);
				}
				
			}
		}
		
	}
	
	//Here the time complexity is O(NlogN), only prerequsiite is Array should be sorted.
	private static void findNthPairOpt(int[] inputArray, int element) {
		Arrays.sort(inputArray);
		
		int i = 0;
		int  j= inputArray.length-1;
		
		
		while(i < j) {
			if(inputArray[i] + inputArray[j] == element) {
				System.out.println("Pairs are "+inputArray[i]+ ","+inputArray[j]);
				i++;
				j--;
			}else if(inputArray[i] + inputArray[j] < element) {
				i++;
				//j--;
			}else if(inputArray[i] + inputArray[j] > element) {
				j--;
				//i++;
			}
		
		}
		
	}
	
	
	
}
