package com.section1.array;

public class ReverseArray_InPlace {
	
	public static void main(String[] args) {
		int[] intArray = {10};
		int startIndex = 0;
		int endIndex = intArray.length-1;
		while(endIndex > startIndex) {
			swap(intArray,startIndex,endIndex);
			startIndex++;
			endIndex--;
		}
		System.out.println("Array after reverse is ");
		for(int i:intArray) {
			System.out.println(i);
		}
		
		
	}

	private static void swap(int[] intArray, int startIndex, int endIndex) {
		int t = intArray[startIndex];
		intArray[startIndex] = intArray[endIndex];
		intArray[endIndex]= t;
		
		
	}

}
