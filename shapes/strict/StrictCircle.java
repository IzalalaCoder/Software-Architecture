package shapes.strict;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import shapes.Circle;

public class StrictCircle implements Circle {

	private double cx, cy, rad;
	private Color c;
	
	public StrictCircle(double cx, double cy, double rad, Color c) {
		this.cx = cx; this.cy = cy; this.rad = rad;
		this.c = c;
	}
	
	// Méthodes propres à Circle :
	@Override
	public double getRadius() { return rad; }
	
	// Méthode de rendu :
	@Override
	public void draw(Graphics2D screen) {
		screen.setColor(c);
		screen.draw(new Ellipse2D.Double(cx-rad, cy-rad, rad*2, rad*2));
	}
}
