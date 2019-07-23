package com.tutorial.adapter;

//Need to write an adapter so that Drawing class can call drawAllShapes and in turn it will be able
//to draw geometry shapes also.
//Two different interface, have to make both of them compatible with each other.
//Like Drawing, in case if there are any other class on the other side which holds all the operation.
//then we can decide which way to mould.
//As already holds the entire stuff, we will write an adapter which will adapt or compatible to  Drawing class.
//Write an adapter class which implements Shape, and it contains GemoetryShape interface as Drawing class already holds all the shapes.

//Object Adapter Pattern
//In this approach, we will use the Java composition, and our adapter contains the source object. 
//The composition is used as a reference to the wrapped class within the adapter. 
//In this approach, we create an adapter class that implements the target ( Shape in this case) 
//and references the adaptee — GeometricShape in this case. 
//We implement all of the required methods of the target (Shape) and 
//do the necessary conversion to fulfill our requirement.

class GeometryShapeAdapter implements Shape{
	private GeometryShapes geometryShapes;
	
	public GeometryShapeAdapter(GeometryShapes geometryShapes) {
		this.geometryShapes = geometryShapes;
	}
	
	@Override
	public void draw() {
		geometryShapes.drawShape();
	}
	
	@Override
	public void description() {
		if(geometryShapes instanceof Triangle) {
			System.out.println("Triangle Object");
		}else if (geometryShapes instanceof Rhombus) {
			System.out.println("Rhombus Object");
		}
		
	}
	
	@Override
	public void resize() {
		if(geometryShapes instanceof Triangle) {
			System.out.println("Resize not possible for Triangle");
		}else if(geometryShapes instanceof Rhombus) {
			System.out.println("Resize not possible for Rhombus");
		}
	}
		
	
}



public class AdapterDesignPatternDemo {

	
	public static void main(String[] args) {
		Drawing drawingShape = new Drawing();
		drawingShape.addShapes(new Circle());
		drawingShape.addShapes(new GeometryShapeAdapter(new Triangle()));
		drawingShape.addShapes(new GeometryShapeAdapter(new Rhombus()));
		
		
		drawingShape.drawAllShapes();
		
	}
}
