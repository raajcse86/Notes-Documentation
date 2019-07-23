package com.section.common.problems;

public class ContinousSubArrayFromGivenArray {

	public static void main(String[] args) {
		 findSubArray(new int[]{42, 15, 12, 8, 6, 32}, 26);
		 
	}

	private static void findSubArray(int[] inputArray, int givenElement) {
		int sum =0;
		for(int i=0;i<inputArray.length;i++) {
			sum = inputArray[i];
			for(int j=i+1; j<inputArray.length;j++) {
				sum = sum + inputArray[j];
				if(sum == givenElement ) {
					for(int k=i;k<=j;k++) {
						System.out.println(inputArray[k]+ " ");
					}
					System.out.println("\n");
				}else if(sum < givenElement) {
					continue;
				}else if(sum > givenElement) {
					break;
				}
			
			}
			
			
		}
	}
}
