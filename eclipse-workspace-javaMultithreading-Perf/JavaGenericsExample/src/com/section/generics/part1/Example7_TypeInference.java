package com.section.generics.part1;

import java.util.ArrayList;
import java.util.List;

class Bucket<T>{
	private T item;
	
	public T getItem(){
		return this.item;
	}
	
	public void setItem(T item) {
		this.item = item;
	}
	
}

public class Example7_TypeInference {

	public static <T> void addStore(T t, List<Bucket<T>> list) {
		//because of type inference we do not want to specify the type in the Bucket.
		Bucket<T> bucket = new Bucket<>();
		//this is called type inference, from the left hand side it get to know about the type.
		bucket.setItem(t);
		list.add(bucket);
		System.out.println("-- "+t.toString()+" .. added to the list");
		
	}
	
	
	public static void main(String[] args) {
		List<Bucket<String>> list = new ArrayList<>();
		addStore("Raj", list);
		
		//this is called type witness - it will pass this string in place of T in the method.
		Example7_TypeInference.<String>addStore("Test", list);
		
		
	}
	
	
}
