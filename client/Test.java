package client;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.awt.Color;
import java.util.*;

import shapes.*;
import shapes.hand.Hand;
import shapes.strict.Strict;
import shapes.strict.StrictCircle;
import shapes.strict.StrictLine;
import shapes.strict.StrictRectangle;
import viewer.GraphicViewer;

@SuppressWarnings("unused")
public class Test {
	public static java.util.List<Shape> getStrictDemo() {
		AbstractShapeFactory d = new Strict();
		java.util.List<Shape> ls=new ArrayList<Shape>();
		ls.add(d.createLine(0, 500, 800, 500, Color.GREEN));
		ls.add(d.createLine(300, 0, 0, 300, Color.YELLOW));
		
		ls.add(d.createLine(30, 300, 180, 200, Color.BLUE));
		ls.add(d.createLine(330, 300, 180, 200, Color.BLUE));
		ls.add(d.createRectangle(30, 300,330, 500, Color.RED));

		double sunX = 600;
		double sunY = 120;
		double sunRad = 60; 
		ls.add(d.createCircle(sunX, sunY, sunRad, Color.BLACK));
		int sunRay = 20;
		for (int i=0; i<sunRay; ++i) {
			double tau=i*2*Math.PI/sunRay;
			ls.add(d.createLine(sunX+(sunRad+5)*Math.cos(tau),
				sunY-(sunRad+5)*Math.sin(tau),  
				sunX+(1.5*sunRad+5)*Math.cos(tau),
				sunY-(1.5*sunRad+5)*Math.sin(tau),
				Color.BLACK));
		}

		double manX=600;
		double manY=450;
		ls.add(d.createLine(manX, manY-70, manX-40, manY-110, Color.RED));
		ls.add(d.createLine(manX, manY-70, manX+40, manY-110, Color.RED));
		ls.add(d.createCircle(manX, manY-120, 20, Color.GRAY));
		ls.add(d.createLine(manX, manY, manX, manY-100, Color.BLUE));
		ls.add(d.createLine(manX, manY, manX-20, manY+50, Color.BLACK));
		ls.add(d.createLine(manX, manY, manX+20, manY+50, Color.BLACK));		

		return ls;
	}
	
	public static java.util.List<Shape> getHandDemo() {
		AbstractShapeFactory d = new Hand();
		java.util.List<Shape> ls=new ArrayList<Shape>();
		ls.add(d.createLine(0, 500, 800, 500, Color.GREEN));
		ls.add(d.createLine(300, 0, 0, 300, Color.YELLOW));
		
		ls.add(d.createLine(30, 300, 180, 200, Color.BLUE));
		ls.add(d.createLine(330, 300, 180, 200, Color.BLUE));
		ls.add(d.createRectangle(30, 300,330, 500, Color.RED));

		double sunX = 600;
		double sunY = 120;
		double sunRad = 60; 
		ls.add(d.createCircle(sunX, sunY, sunRad, Color.BLACK));
		int sunRay = 20;
		for (int i=0; i<sunRay; ++i) {
			double tau=i*2*Math.PI/sunRay;
			ls.add(d.createLine(sunX+(sunRad+5)*Math.cos(tau),
				sunY-(sunRad+5)*Math.sin(tau),  
				sunX+(1.5*sunRad+5)*Math.cos(tau),
				sunY-(1.5*sunRad+5)*Math.sin(tau),
				Color.BLACK));
		}

		double manX=600;
		double manY=450;
		ls.add(d.createLine(manX, manY-70, manX-40, manY-110, Color.RED));
		ls.add(d.createLine(manX, manY-70, manX+40, manY-110, Color.RED));
		ls.add(d.createCircle(manX, manY-120, 20, Color.GRAY));
		ls.add(d.createLine(manX, manY, manX, manY-100, Color.BLUE));
		ls.add(d.createLine(manX, manY, manX-20, manY+50, Color.BLACK));
		ls.add(d.createLine(manX, manY, manX+20, manY+50, Color.BLACK));		

		return ls;
	}
	
	public static java.util.List<Shape> getGroupsDemo() {
		AbstractShapeFactory d = new Strict();
		java.util.List<Shape> ls=new ArrayList<Shape>();
		ls.add(d.createLine(0, 500, 800, 500, Color.GREEN));
		ls.add(d.createLine(300, 0, 0, 300, Color.YELLOW));
		
		ls.add(d.createLine(30, 300, 180, 200, Color.BLUE));
		ls.add(d.createLine(330, 300, 180, 200, Color.BLUE));
		ls.add(d.createRectangle(30, 300,330, 500, Color.RED));

		double sunX = 600;
		double sunY = 120;
		double sunRad = 60; 
		ls.add(d.createCircle(sunX, sunY, sunRad, Color.BLACK));
		int sunRay = 20;
		for (int i=0; i<sunRay; ++i) {
			double tau=i*2*Math.PI/sunRay;
			ls.add(d.createLine(sunX+(sunRad+5)*Math.cos(tau),
				sunY-(sunRad+5)*Math.sin(tau),  
				sunX+(1.5*sunRad+5)*Math.cos(tau),
				sunY-(1.5*sunRad+5)*Math.sin(tau),
				Color.BLACK));
		}

		double manX=600;
		double manY=450;
		ls.add(d.createLine(manX, manY-70, manX-40, manY-110, Color.RED));
		ls.add(d.createLine(manX, manY-70, manX+40, manY-110, Color.RED));
		ls.add(d.createCircle(manX, manY-120, 20, Color.GRAY));
		ls.add(d.createLine(manX, manY, manX, manY-100, Color.BLUE));
		ls.add(d.createLine(manX, manY, manX-20, manY+50, Color.BLACK));
		ls.add(d.createLine(manX, manY, manX+20, manY+50, Color.BLACK));		

		return ls;
	}
	
	public static void main(String[] args)  {
		GraphicViewer gv = new GraphicViewer();
		java.util.List<Shape> demo=getStrictDemo();
		gv.draw(demo);
	}
}
