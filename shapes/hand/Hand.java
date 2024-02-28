package shapes.hand;

import java.awt.Color;

import shapes.Circle;
import shapes.AbstractShapeFactory;
import shapes.GroupShape;
import shapes.Groups;
import shapes.Line;
import shapes.Rectangle;
import shapes.Shape;

public class Hand implements AbstractShapeFactory {
	
	@Override
	public Line createLine(double x0, double y0, double x1, double y1, Color c) {
		return new HandLine(x0, y0, x1, y1, c);
	}
		  
	@Override
	public Rectangle createRectangle(double x0, double y0, double x1, double y1, Color c) {
		return new HandRectangle(x0, y0, x1, y1, c);
	}
		  
	@Override
	public Circle createCircle(double cx, double cy, double rad, Color c) {
		return new HandCircle(cx, cy, rad, c);
	}

	@Override
	public Groups createGroups(Shape s1, Shape s2) {
		return new GroupShape(s1, s2);
	}
	
	@Override
	public void addShapeInGroup(Groups group, Shape s) {
		group.add(s);
	}
	  
	@Override
	public void removeShapeInGroup(Groups group, Shape s) {
		group.remove(s);
	}

}
