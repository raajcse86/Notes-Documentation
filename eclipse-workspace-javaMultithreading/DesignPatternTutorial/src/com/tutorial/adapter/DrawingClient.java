package com.tutorial.adapter;

import java.util.ArrayList;
import java.util.List;

interface Shape{
	void draw();
	void resize();
	void description();
	
}

class Circle implements Shape{
	@Override
	public void description() {
		System.out.println("Circle object");
		
	}
	@Override
	public void draw() {
		System.out.println("Drawing Circle.");
		
	}
	@Override
	public void resize() {
		System.out.println("Resizing Circle.");
		
	}
}

class Rectangle implements Shape{
	@Override
	public void description() {
		System.out.println("Rectangle object");
		
	}
	@Override
	public void draw() {
		System.out.println("Drawing Rectangle.");
		
	}
	@Override
	public void resize() {
		System.out.println("Resizing Rectangle.");
		
	}
}

class Drawing {

	List<Shape> shapes = new ArrayList<>();
	
	void addShapes(Shape shape){
		shapes.add(shape);
		
	}
	
	public void drawAllShapes() {
		for(Shape shape:shapes) {
			shape.draw();
		}
	}
	
	public void resizeAllShapes() {
		for(Shape shape:shapes) {
			shape.resize();
		}
	}

}
public class DrawingClient{
	public static void main(String[] args) {
		Drawing drawing = new Drawing();
		drawing.addShapes(new Rectangle());
		drawing.addShapes(new Circle());
		drawing.drawAllShapes();
		
	}
}


