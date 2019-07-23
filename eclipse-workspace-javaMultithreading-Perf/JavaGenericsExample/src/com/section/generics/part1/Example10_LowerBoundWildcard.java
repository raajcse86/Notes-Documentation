package com.section.generics.part1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Example10_LowerBoundWildcard {

	
	
	public static void show(List<? super Number> list) {
		
		//u cann add to the list.
		list.add(new Float(1));
		
		//u cannot read u , cannot put the data type after super.
		//here we can iterated as Objects. so we cannot read a specific type.
		for(Object o:list) {
			System.out.println(o);
		}
		
		
	}
	
	
	public static void main(String[] args) {
		List<Number> numlist = new ArrayList<>();
		List<Object> objlist = new ArrayList<>();
		
		//List<? super Integer> list = numlist;
		
		List<? super Integer> list = objlist;
		
		
		List<Serializable> list2 = new ArrayList<>();
		list2.add("Raj");
		list2.add("sekar");
		show(list2);
		
		
	}
}
