package shapes;

public class Hand implements Shape {

  public Line createLine() {
    return new HandLine();
  }
  
  public Rectangle createRectangle() {
    return new HandRectangle();
  }
  
  public Circle createCircle() {
    return new HandCircle();
  }

}
