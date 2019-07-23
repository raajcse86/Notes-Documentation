package com.section.generics.part1;

import java.util.Arrays;
import java.util.List;

public class Example9_UpperBoundWildCard{

	public static double sum(List<? extends Number> list) {
		double sum=0.0;
		
		//if u try to add to the list u will get error, as it does not know what kind of data type will come at the run time.
		//list.add(new Integer(10));
		//when u read u have iterate with the dataType after extends -so we can read.
		for(Number d: list) {
			sum = sum +d.doubleValue();
		}
		System.out.println("Sum is "+sum);
		return sum;
		
	}
	
	
	public static void main(String[] args) {
		sum(Arrays.asList(10,20,20,50));
	}
	
	
}
