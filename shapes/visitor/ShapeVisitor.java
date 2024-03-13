package shapes.visitor;

public interface ShapeVisitor {
  public void VisitStrictLine(ShapeVisitor shapeVisitor);
  public void VisitStrictRectangle(ShapeVisitor shapeVisitor);
  public void VisitStrictCircle(ShapeVisitor shapeVisitor);
  public void VisitGroupShape(ShapeVisitor shapeVisitor);
  public void VisitHandLine(ShapeVisitor shapeVisitor);
  public void VisitHandRectangle(ShapeVisitor shapeVisitor);
  public void VisitHandCircle(ShapeVisitor shapeVisitor);
}
