package shapes;
import java.awt.Graphics2D;

public interface Shape {
	public void Accept(ShapeVisitor shapeVisitor);
}
