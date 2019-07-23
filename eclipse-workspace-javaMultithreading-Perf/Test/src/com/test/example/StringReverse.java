package com.test.example;

import java.util.ArrayList;
import java.util.List;

public class StringReverse {

	
	public static void main(String[] args) {
//		String str = "tamil";
//		char[] chArry = str.toCharArray();
//		char[] newchArry = new char[chArry.length];
//		for(int i=0,j=chArry.length-1;i<chArry.length;i++,j--) {
//			newchArry[i] = chArry[j];
//		}
//		
//		String newString = new String(newchArry);
//		System.out.println("New String is "+newString);
		
		//new StringReverse().returnPairOfElements();
		//new StringReverse().returnSubArray();
		
		new StringReverse().findMax();
	}
	
	//This is like pair of elements whose sum is equal to given number
	private void returnPairOfElements() {
		int[] intArr = new int[] {2,6,8,12,3,9,12};
		int sum = 15;
		
		for(int i=0;i<intArr.length;i++) {
			for(int j=i+1;j<intArr.length;j++) {
				if(intArr[i] + intArr[j] == sum) {
					
					System.out.println("The elements are "+intArr[i]+","+intArr[j]);
				}
			}
		}
	}
	
	
	//This is like find continous elements whose sum is equal to given number
		private void returnSubArray() {
			int[] intArr = new int[] {2,4,1,1,2,9,12};
			int inputNumber = 8;
			int sum = 0;
			for(int i=0;i<intArr.length;i++) {
				sum = intArr[i];
				for(int j=i+1;j<intArr.length;j++) {
					sum = sum+intArr[j];
					if(sum == inputNumber) {
						List<Integer> tempList = new ArrayList<>();
						for(int k=i;k<=j;k++) {
							tempList.add(intArr[k]);
						}
						System.out.println("The elements are "+tempList.toString());
						
					}
				}
			}
		}
		
	//method to find the second largest number in an array.
		private void findMax() {
			int[] a = new int[] {2,4,300,1,20,9,12};
			int firstMax = a[0];
			int secondMax = a[1];
			if(firstMax < secondMax) {
				firstMax = a[1];
				secondMax = a[0];
			}
			for(int i=2;i<a.length;i++) {
				if(a[i] > firstMax && a[i] >secondMax) {
					secondMax = firstMax;
					firstMax = a[i];
				}else if(a[i] < firstMax && a[i] > secondMax) {
					secondMax = a[i];
				}
				
			}
			System.out.println("First Max "+firstMax);
			System.out.println("Second Max "+secondMax);
			
			
		}
	
}
