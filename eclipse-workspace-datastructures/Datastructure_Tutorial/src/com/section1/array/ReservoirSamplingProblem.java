package com.section1.array;

import java.util.Random;

public class ReservoirSamplingProblem {

	
	public static void main(String[] args) {
		int[] intArray = {};
		
		Random random = new Random();
		int k=5;
		int[] reservoir = new int[k];
		
		for(int i=0;i<k;i++) {
			reservoir[i] = intArray[i];
		}
		
		for(int i=k+1;i<intArray.length;i++) {
			int j = random.nextInt(i)+1;
			if(j < k) {
				reservoir[j] = intArray[i];
			}
		}
		
		
		for(int i=0;i<reservoir.length;i++) {
			System.out.println(reservoir[i]+" ");
		}
		
		
	}
}
