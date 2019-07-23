package com.tutorial.adapter;

interface GeometryShapes{
	double area();
	double perimeter();
	void drawShape();
	
}

class Triangle implements GeometryShapes{
	private double a = 1.0;
	private double b = 2.0;
	private double c = 3.0;
	
	@Override
	public double area() {
		return a*b*c;
	}
	
	@Override
	public double perimeter() {
		return a+b+c;
	}
	
	@Override
	public void drawShape() {
		System.out.println("Drawing Triangle with area "+area()+" perimeter "+perimeter());
		
	}
	
}

class Rhombus implements GeometryShapes{
	private double a = 1.0;
	private double b = 2.0;
	
	@Override
	public double area() {
		return a*b;
	}
	
	@Override
	public double perimeter() {
		return a+b;
	}
	
	@Override
	public void drawShape() {
		System.out.println("Drawing Rhombus with area "+area()+" perimeter "+perimeter());
		
	}
	
}

public class DrawingGeometryShapesClient {

	
	public static void main(String[] args) {
		
	}
}
