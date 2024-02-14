package shapes;

public class Strict implements Shape {

  public Line createLine() {
    return new LineStrict();
  }
  
  public Rectangle createRectangle() {
    return new RectangleStrict();
  }
  
  public Circle createCircle() {
    return new CircleStrict();
  }

}
