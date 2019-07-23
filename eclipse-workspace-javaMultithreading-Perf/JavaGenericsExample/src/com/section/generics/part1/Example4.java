package com.section.generics.part1;

class GenericMethod{
	
	public <T> void showItem(T t) {
		System.out.println("The item is "+t.toString());
	}
	
	
	public <T> T getItem(T t) {
		return t;
	}
	
	
	
}


public class Example4 {
	
	public static void main(String[] args) {
		GenericMethod genericMethod = new GenericMethod();
		genericMethod.showItem("Rajasekar");
		
		genericMethod.showItem(45);
		
		
		genericMethod.showItem('H');
		
		
		System.out.println("Get value "+genericMethod.getItem("Dhoni").toString());
		
	}

}
