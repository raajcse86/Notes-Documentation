package com.section.generics.part1;

class GenericMethod2{
	
	public <T> void showArray(T[] array){
		for(T item:array) {
			System.out.println(item+" ->");
		}
	}
	
}

public class Example5_GenericMethod2 {
	
	public static void main(String[] args) {
		Integer[] intArray = {10,20,30,40};
		new GenericMethod2().showArray(intArray);
		
		String[] strArray = {"Raj", "Dhoni", "Virat", "Rohit"};
		new GenericMethod2().showArray(strArray);
		
		
	}
}
