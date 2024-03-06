package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

// extends-prosirujemo klasu circle,samo jednom klasom mozemo prosiriti, klasa Donut nasledjuje sve sto ima Circle plus joj dodajemo jos 
public class Donut extends Circle {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int innerRadius;
	
	public Donut(Position center, int radius, int innerRadius,Color outerColor, Color innerColor) {
		super(center, radius, outerColor, innerColor);
		setInnerRadius(innerRadius);
		
	}
	
	public Donut getCopy() {
		return new Donut(getPosition(), getRadius(), getInnerRadius(), getEdgeColor(), getInnerColor());
	}
	
	@Override
	public void changeAtribute(Shape shape) {
		Donut donut = (Donut)shape;
		setPosition(donut.getPosition());
		setInnerRadius(donut.getInnerRadius());
		setRadius(donut.getRadius());
		setInnerColor(donut.getInnerColor());
		setEdgeColor(donut.getEdgeColor());
	}
	
	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		if (innerRadius > 0) {
			this.innerRadius = innerRadius;
		} else {
			throw new NumberFormatException("Inner radius has to be a value greater than 0!");
		}
	}

	public String toString() {
		return "Donut " + getCenter() + ", R1 = " + getRadius() + 
				", R2 = "  + innerRadius  + ", Edge Color = " + getEdgeColor().toString().substring(14)
				+  ", Inner Color=" + getInnerColor().toString().substring(14) ;
	}
	@Override
	public String logo() {
		return "Donut" + DILIM + 
				getCenter().getX() + DILIM + 
				getCenter().getY() + DILIM + 
				getRadius() + DILIM +
				innerRadius  + DILIM + 
				getEdgeColor().toString().substring(14) + DILIM + 
				getInnerColor().toString().substring(14);
	}



	public double area() {
		return super.area() - this.innerRadius * this.innerRadius * Math.PI;
	}


	public boolean equals(Object obj) {
		if (obj instanceof Donut) {
			Donut pomocna = (Donut) obj;
			
			if (this.getCenter().equals(pomocna.getCenter()) && this.getRadius() == pomocna.getRadius()
					&& this.getInnerRadius() == pomocna.getInnerRadius()) {
				return true;
			} else
				return false;
		}
		return false;
	}

	@Override
	public boolean contains(Position p) {
		double dFromCenter = this.getCenter().distance(p);
		return super.contains(p) && dFromCenter > innerRadius;
	}
	
	@Override
	public void draw(Graphics g) {
		
	    super.draw(g);
	    g.setColor(getEdgeColor());
		g.drawOval(this.getCenter().getX()-this.getInnerRadius(), this.getCenter().getY()-this.getInnerRadius(),this.getInnerRadius()*2,this.getInnerRadius()*2);
		
		
	}
	
	@Override
	public void drawSelectMark(Graphics g) {
		
		super.drawSelectMark(g);
		
	}
	
	public void fill(Graphics g) {
		
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(getEdgeColor());
		
		int radius = innerRadius;
		g2.drawOval(getCenter().getX()- radius , getCenter().getY()-radius, radius*2, radius*2);
		
		radius = getRadius();
		g2.drawOval(getCenter().getX()- radius , getCenter().getY()-radius, radius*2, radius*2);
		
		g2.setStroke(new BasicStroke(2));
        
		g2.setColor(getInnerColor());
	
		for(radius = innerRadius + 1 ; radius < getRadius() ; radius++) {
			g2.drawOval(getCenter().getX()- radius , getCenter().getY()-radius, radius*2, radius*2);
			
			
		}
	}
	
	public static Shape formObjectFromLogo(String[] data) {
		
		int x = Integer.parseInt(data[2]);
		int y = Integer.parseInt(data[3]);
		int R1 = Integer.parseInt(data[4]);
		int R2 = Integer.parseInt(data[5]);
		Color edge  = LogoLine.convertColorNotation(data[6]);
		Color inner = LogoLine.convertColorNotation(data[7]);
		
		return new Donut(new Position(x,y), R1, R2, edge, inner);
		
		
		
	}

	
}
