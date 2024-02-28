package shapes;

import java.awt.Graphics2D;
import java.util.List;
import java.util.ArrayList;

public class GroupShape implements Groups {
	
	private List<Shape> groups;
	
	public GroupShape(Shape s1, Shape s2) {
		this.groups = new ArrayList<Shape>();
	}

	@Override
	public void draw(Graphics2D screen) {
		for (Shape s : groups) {
			s.draw(screen);
		}
	}

	@Override
	public void add(Shape shape) {
		if (shape == null) {
			throw new AssertionError();
		}
		if (this.groups.contains(shape)) {
			throw new AssertionError();
		}
		this.groups.add(shape);
	}

	@Override
	public void remove(Shape shape) {
		if (shape == null) {
			throw new AssertionError();
		}
		if (!this.groups.contains(shape)) {
			throw new AssertionError();
		}
		this.groups.remove(shape);
	}

	@Override
	public Shape getShapeAtIndex(int index) {
		if (index >= this.groups.size()) {
			throw new AssertionError();
		}
		if (index < 0) {
			throw new AssertionError();
		}
		return this.groups.get(index);
	}

}
