package shapes.visitor;

public class DrawVisitor implements ShapeVisitor {

    public void VisitStrictLine(StrictLine strictLine);
  public void VisitStrictRectangle(StrictRectangle strictRectangle);
  public void VisitStrictCircle(StrictCircle strictCircle);
  public void VisitGroups(Groups groups);
  public void VisitHandLine(HandLine handLine);
  public void VisitHandRectangle(HandRectangle handRectangle);
  public void VisitHandCircle(HandCircle handCircle);
  
}
