package shapes;

public interface Groups extends Shape {
	
	void add(Shape shape);
	
	void remove(Shape shape);
	
	Shape getShapeAtIndex(int index);
}
