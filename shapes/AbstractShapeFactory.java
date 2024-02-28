package shapes;

import java.awt.Color;

public interface AbstractShapeFactory {
  public Line createLine(double x0, double y0, double x1, double y1, Color c);
  public Rectangle createRectangle(double x0, double y0, double x1, double y1, Color c);
  public Circle createCircle(double cx, double cy, double rad, Color c);
  public Groups createGroups(Shape s1, Shape s2);
  public void addShapeInGroup(Groups group, Shape s);
  public void removeShapeInGroup(Groups group, Shape s);
}
