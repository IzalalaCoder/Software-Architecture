package shapes;
import java.awt.Graphics2D;


import shapes.visitor.ShapeVisitor;

public interface Shape {
	public void Accept(ShapeVisitor shapeVisitor);
}
