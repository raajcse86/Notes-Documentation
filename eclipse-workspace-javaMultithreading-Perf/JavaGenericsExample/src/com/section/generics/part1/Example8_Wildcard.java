package com.section.generics.part1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Example8_Wildcard {

	
	public static void main(String[] args) {
		Collection<String> c1 = new ArrayList<>();
		//Collection<String> c1 = new LinkedList<>();
		//Collection<Object> c2 = c1;
		Collection<?> c3 = c1;
		
		
		List<Integer> inttList = new ArrayList<>();
		List<Double> doubList = new ArrayList<>();
		//List<? extends Number> genList = inttList;
		//List<? extends Number> genList = doubList;
		
	}
}
