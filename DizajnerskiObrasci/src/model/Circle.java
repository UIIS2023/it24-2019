package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Circle extends SurfaceShape {

	private static final long serialVersionUID = 1L;
	private int radius;
	// private boolean selected;

	

	public Circle(Position center, int radius, Color outerColor, Color innerColor) {
		super(center, outerColor, innerColor);

		setRadius(radius);
	}
	@Override
	public Circle getCopy(){
		return new Circle(getPosition(), getRadius(), getEdgeColor(), getInnerColor());
	}
	
	@Override
	public void changeAtribute(Shape shape) {
		Circle circle = (Circle)shape;
		setCenter(circle.getCenter());
		setRadius(circle.getRadius());
		setInnerColor(circle.getInnerColor());
		setEdgeColor(circle.getEdgeColor());
	}

	public Position getCenter() {
		return getPosition();
	}

	public void setCenter(Position center) {
		setPosition(center);
	}

	public int getRadius() {
		return radius;
	}

	// metosa baca izuzetak ako prosledimo npr negativan radisu
	public void setRadius(int radius) {
		if (radius > 0) {
			this.radius = radius;
		} else {
			throw new NumberFormatException("Radius has to be a value greater than 0!");
		}
	}

	/*
	 * public boolean isSelected() { return selected; }
	 * 
	 * public void setSelected(boolean selected) { this.selected = selected; }
	 */

	public double area() {
		return radius * radius * Math.PI;
	}
	
	

	// primer za overload
	@Override
	public boolean contains(Position p) {
		return getCenter().distance(p) <= this.radius;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			Circle pomocna = (Circle) obj;
			if (getCenter().equals(pomocna.getCenter()) && this.radius == pomocna.getRadius()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}


	public String toString() {
	
		return "Circle " + getCenter() + ",R=" + radius  + ",Edge Color=" + getEdgeColor().toString().substring(14)
				+ ",Inner Color=" + getInnerColor().toString().substring(14) ;

	}
	@Override
	public String logo() {
		
		return "Circle"+ DILIM + 
				getCenter().getX() + DILIM + 
				getCenter().getY() + DILIM + 
				radius  + DILIM + 
				getEdgeColor().toString().substring(14) + DILIM +
				getInnerColor().toString().substring(14);

	}


	@Override
	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		
		g.fillOval(getCenter().getX() - this.radius + 1, getCenter().getY() - this.radius + 1, this.radius * 2 - 2,
				this.radius * 2 - 2);
	}

	@Override
	public void draw(Graphics g) {
		
		Graphics2D g2 = (Graphics2D)g ;
		g2.setColor(getEdgeColor());
		g2.setStroke(new BasicStroke(2));
		g2.drawOval(getCenter().getX() - this.radius, getCenter().getY() - this.radius, this.radius * 2,
				this.radius * 2);
		fill(g);
		
	}
	
	@Override
	public void drawSelectMark(Graphics g) {
		
		g.setColor(Color.BLUE);
		g.drawRect(getCenter().getX() - 3, getCenter().getY() - 3, 6, 6);
		g.drawRect(getCenter().getX() + this.radius - 3, getCenter().getY() - 3, 6, 6);// desni kv
		g.drawRect(getCenter().getX() - this.radius - 3, getCenter().getY() - 3, 6, 6);// levi kv
		g.drawRect(getCenter().getX() - 3, getCenter().getY() - this.radius - 3, 6, 6);// gornji kv
		g.drawRect(getCenter().getX() - 3, getCenter().getY() + this.radius - 3, 6, 6);// donji kv
		
	}

	@Override
	public void moveBy(int dx, int dy) {
		getCenter().changePosition(dx,dy);

	}
	
	public static Shape formObjectFromLogo(String[] data) {
		
		int x = Integer.parseInt(data[2]);
		int y = Integer.parseInt(data[3]);
		int R = Integer.parseInt(data[4]);
		Color edge  = LogoLine.convertColorNotation(data[5]);
		Color inner = LogoLine.convertColorNotation(data[6]);
		
		return new Circle(new Position(x,y), R, edge, inner);
		
		
	}

	
}
