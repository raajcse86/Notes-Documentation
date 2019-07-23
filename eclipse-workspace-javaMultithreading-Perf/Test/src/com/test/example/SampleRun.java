package com.test.example;

import java.math.BigInteger;

public class SampleRun {
	
	
	public static void main(String[] args) {
		 BigInteger tempResult = BigInteger.ONE;
		 Long n = 100l;
		 
         for (long i = n; i > 0; i--) {
             tempResult = tempResult.multiply(new BigInteger((Long.toString(i))));
             System.out.println("After iteration +"+i+" value is "+tempResult);
         }
         
         System.out.println("Facorial value "+tempResult);
	}

}
