package com.section.generics.part1;

class Person implements Comparable<Person>{
	private String name;
	
	Person(String name){
		this.name = name;
	}

	@Override
	public int compareTo(Person o) {
		return o.name.compareTo(this.name);
	}
	
	@Override
	public java.lang.String toString() {
		return this.name;
	}
}


public class Example6_BoundedParameters {

	public static <T extends Comparable<T>> T calculateMin(T t1, T t2){
		
		if(t1.compareTo(t2) < 0) {
			return t1;
		}
		return t2;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("Min value  "+calculateMin('M', 'A'));
		
		
		System.out.println("Min value  "+calculateMin("Dhoni", "Virat"));
		
		System.out.println("Min value  "+calculateMin(2000, 3000));
		
		
		System.out.println("Min value  "+calculateMin(new Person("Rahul"), new Person("Sanjay")));
		
	}
	
}
