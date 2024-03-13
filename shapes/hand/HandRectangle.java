package shapes.hand;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import shapes.Rectangle;

public class HandRectangle implements Rectangle {

	private double x0, y0, x1, y1;
	private Color c;
	
	public HandRectangle(double x0, double y0, double x1, double y1, Color c) {
		this.x0 = x0; this.y0 = y0;
		this.x1 = x1; this.y1 = y1;
		this.c = c;
	}

	@Override
	public void draw(Graphics2D screen) {
		screen.setColor(c);
		screen.draw(new Rectangle2D.Double(x0, y0, x1-x0, y1-y0));
	}

	@Override
	public double getWidth() {
		return Math.abs(x1-x0);
	}

	@Override
	public double getHeight() {
		return Math.abs(y1-y0);
	}

	@Override
	public void Accept(ShapeVisitor shapeVisitor) {
		shape.VisitHandRectangle(this);
	}
}
