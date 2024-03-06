package model;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape {

	
	
	public Point(int x, int y) {
		super(new Position(x,y), Color.blue);
		
	}
	@Override
	public Point getCopy() {
		return new Point(getPosition().getX(), getPosition().getY(), getEdgeColor());
	}
	
	@Override
	public void changeAtribute(Shape shape) {
		Point point = (Point)shape;
		setPosition(point.getPosition());
		setEdgeColor(point.getEdgeColor());
	}


	public Point(int x, int y, Color color) {
		super(new Position(x,y), color);
		
	}


	public int getX() {
		return getPosition().getX();
	}

	public void setX(int x) {
		getPosition().setX(x);
	}

	public int getY() {
		return getPosition().getY();
	}

	public void setY(int y) {
		getPosition().setY(y);
	}



	public double distance(Point p) {
		double dx = this.getX() - p.getX();
		double dy = this.getY() - p.getY();
		double d = Math.sqrt(dx * dx + dy * dy);
		return d;
	}

	public boolean contains(Position p) 
	{
		
		return getPosition().distance(p) <= 3 ;
		
		
	}

	public String toString() {
		return "Point, (" + getX() + "," + getY() + ")";
	}
	
	@Override
	public String logo() {
		return "Point" + DILIM + 
				getX() + DILIM + 
				getY() + DILIM +
				getEdgeColor().toString().substring(14);
	}


	public boolean equals(Object obj) {
		
		if (obj instanceof Point) {
			Point point = (Point) obj;
			return getX() == point.getX() && getY() == point.getY() ;

		} else
			return false;
	}

	@Override
	public void draw(Graphics g) {
		Circle point =  new Circle(getPosition(), 3, getEdgeColor(), getEdgeColor());
		g.setColor(getEdgeColor());
		point.draw(g);
		
	}
	
	@Override
	public void drawSelectMark(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(getX() - 5, getY() - 5, 10, 10);
	}

	@Override
	public void moveBy(int dx, int dy) {
		
		setX(getX()+ dx);
		setY(getY()+ dy);

	}
	
	public static Shape formObjectFromLogo(String[] data) {
			
		int x = Integer.parseInt(data[2]);
		int y = Integer.parseInt(data[3]);
	
		Color edge  = LogoLine.convertColorNotation(data[4]);		
		return new Point(x,y, edge);
			
	}
	
	

	

}
