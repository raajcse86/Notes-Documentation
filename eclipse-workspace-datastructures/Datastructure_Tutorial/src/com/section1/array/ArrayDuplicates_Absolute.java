package com.section1.array;

public class ArrayDuplicates_Absolute {

	
	public static void main(String[] args) {
		int[] intArray = {2,3,1,2,4,3,1,4,5};
		
		for(int i=0;i<intArray.length;i++) {
			int nextIndex = Math.abs(intArray[i]);
			int value = intArray[nextIndex];
			if(value>0) {
				intArray[nextIndex] = -value;
			}else {
				System.out.println("Repitition number is "+intArray[i]);
			}
			
		}
		
		
	}
}
