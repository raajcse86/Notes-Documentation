package com.section.reflection.part1;

import java.lang.reflect.Field;

public class Example1 {

	class Student{
		public String name;
		public  int id;
		
	}
	
	
	
	
	public static void main(String[] args) {
		Class<Student> c = Student.class;
		System.out.println(c.getName());
		
		Field[] fields = c.getFields();
		
		for(Field f:fields) {
			System.out.println(f.getName());
		}
		
		
	}
}
