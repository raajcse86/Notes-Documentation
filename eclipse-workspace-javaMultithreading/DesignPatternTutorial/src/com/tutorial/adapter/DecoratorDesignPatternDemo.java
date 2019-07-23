package com.tutorial.adapter;


enum Color {
    RED,
    GREEN,
    BLUE,
    YELLOW,
    WHITE,
    BLACK,
    ORANGE,
    MAROON
}


enum LineStyle {
      SOLID,
      DASH,
      DOT,
      DOUBLE_DASH,
      DASH_SPACE
}



abstract class ShapeDecorator implements Shape {
      protected Shape decoratedShape;
      public ShapeDecorator(Shape decoratedShape) {
            super();
            this.decoratedShape = decoratedShape;
      }
}

class FillColorDecorator extends ShapeDecorator {
    protected Color color;
    public FillColorDecorator(Shape decoratedShape, Color color) {
          super(decoratedShape);
          this.color = color;
    }
    @Override
    public void draw() {
          decoratedShape.draw();
          System.out.println("Fill Color: " + color);
    }
    // no change in the functionality
    // we can add in the functionality if we like. there is no restriction
    // except we need to maintain the structure of the Shape APIs
    @Override
    public void resize() {
    decoratedShape.resize();
    }
    @Override
    public void description() {
     decoratedShape.description();
    }
    
}

class LineColorDecorator extends ShapeDecorator {
    protected Color color;
    public LineColorDecorator(Shape decoratedShape, Color color) {
    super(decoratedShape);
    this.color = color;
    }
    @Override
    public void draw() {
    decoratedShape.draw();
    System.out.println("Line Color: " + color);
    }
    // no change in the functionality
    @Override
    public void resize() {
    decoratedShape.resize();
    }
    @Override
    public void description() {
    	decoratedShape.description();
    }
}

class LineThinknessDecorator extends ShapeDecorator {
    protected double thickness;
    public LineThinknessDecorator(Shape decoratedShape, double thickness) {
              super(decoratedShape);
              this.thickness = thickness;
    }
    @Override
    public void draw() {
              decoratedShape.draw();
              System.out.println("Line thickness: " + thickness);
    }
    // no change in the functionality
    @Override
    public void resize() {
    decoratedShape.resize();
    }
    @Override
    public void description() {
    decoratedShape.description();
    }
}
class LineStyleDecorator extends ShapeDecorator {
    protected LineStyle style;
    public LineStyleDecorator(Shape decoratedShape, LineStyle style) {
    super(decoratedShape);
    this.style = style;
    }
    @Override
    public void draw() {
    decoratedShape.draw();
    System.out.println("Line Style: " + style);
    }
    // no change in the functionality
    @Override
    public void resize() {
    decoratedShape.resize();
    }
    @Override
    public void description() {
   decoratedShape.description();
    }
}


public class DecoratorDesignPatternDemo {
	
	public static void main(String[] args) {
		System.out.println("Creating Simple Shape Objects...");
        Shape rectangle = new Rectangle();
        Shape circle = new Circle();
        System.out.println("Drawing Simple Shape Objects...");
        rectangle.draw();
        System.out.println();
        circle.draw();
        System.out.println();
        System.out.println("Creating Decorated Circle with Red Color, Blue Lines in dash pattern and thickness of 2 ...");
        Shape circle1 = new FillColorDecorator(new LineColorDecorator(new LineStyleDecorator(
        new LineThinknessDecorator(new Circle(), 2.0d), LineStyle.DASH), Color.BLUE), Color.RED);
        circle1.draw();
        System.out.println();
        // order of decorator is also not much important here since all are unique functionalities.
        // we can also do this nesting of functionalities in separate statements.
        System.out.println("creating object with similar functionalities in separate statements.");
        Circle c = new Circle();
        LineThinknessDecorator lt = new LineThinknessDecorator(c, 2.0d);
        LineStyleDecorator ls = new LineStyleDecorator(lt, LineStyle.DASH);
        LineColorDecorator lc = new LineColorDecorator(ls, Color.BLUE);
        FillColorDecorator fc = new FillColorDecorator(lc, Color.RED);
        Shape circle3 = fc;
        circle3.draw();
        System.out.println();
        System.out.println("Creating Decorated Circle with Green Color, Black Lines ...");
        Shape circle2 = new FillColorDecorator(new LineColorDecorator(new Circle(), Color.BLACK), Color.GREEN);
        circle2.draw();
        System.out.println();
        System.out.println("Creating Decorated Rectange with Yellow Color, Red Lines in double dash pattern...");
        Shape rectangle1 = new FillColorDecorator(new LineColorDecorator(new Rectangle(), Color.RED), Color.YELLOW);
        rectangle1.draw();
        System.out.println();
	}

}
