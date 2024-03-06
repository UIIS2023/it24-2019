package model;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {
	private Position start;
	private Position end;
	// private boolean selected;

	

	public Line(Position startPoint, Position endPoint,Color color) {
		super(startPoint, color);
		this.start = startPoint;
		this.end = endPoint;
	}
	@Override
	public Line getCopy() {
		return new Line(getStartPoint(), getEndPoint(), getEdgeColor());
	}
	
	@Override
	public void changeAtribute(Shape shape) {
		Line line = (Line)shape;
		setStartPoint(line.getStartPoint());
		setEndPoint(line.getEndPoint());
		setEdgeColor(line.getEdgeColor());
	}
	
	
	public double length() {
		return start.distance(end);
	}
	
	@Override
	public boolean contains(Position p) {
		if ((start.distance(p) + end.distance(p)) - this.length() <= 0.05) {
			return true;
		} else {
			return false;

		}
	}

	public boolean equals(Object obj) {
		if (obj instanceof Line) {
			Line pomocna = (Line) obj;
			if (this.start.equals(pomocna.getStartPoint()) && this.end.equals(pomocna.getEndPoint())) {
				return true;
			} else {
				return false;
			}
		} else
			return false;
	}

	public Position getStartPoint() {
		return this.start;
	}

	public void setStartPoint(Position startPoint) {
		this.start = startPoint;
	}

	public Position getEndPoint() {
		return this.end;
	}

	public void setEndPoint(Position endPoint) {
		this.end = endPoint;
	}

	/*public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}*/

	public String toString() {
		
		return "Line "  + start + " - " + end + ", Edge Color = " + getEdgeColor().toString().substring(14); 
		
	}
	@Override
	public String logo() {
		
		return "Line" + DILIM + 
				start.getX()+ DILIM + 
				start.getY()+ DILIM + 
				end.getX()+ DILIM + 
				end.getY()+ DILIM +  
				getEdgeColor().toString().substring(14); 
		
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getEdgeColor());
		g.drawLine(this.getStartPoint().getX(),this.getStartPoint().getY(), this.getEndPoint().getX(), this.getEndPoint().getY());
		
		
	 }
	
	@Override
	public void drawSelectMark(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(this.start.getX()-3, this.start.getY()-3, 6, 6);
		g.drawRect(this.end.getX()-3,this.end.getY()-3,6,6);
		g.drawRect((this.start.getX()+this.end.getX())/2-3, 
				(this.start.getY()+this.end.getY())/2-3, 6, 6);
	}

	@Override
	public void moveBy(int dx, int dy) {
		 start.changePosition(dx, dy);
		 end.changePosition(dx, dy);
		
	}
	
	public static Shape formObjectFromLogo(String[] data) {
		
		int x1 = Integer.parseInt(data[2]);
		int y1 = Integer.parseInt(data[3]);
		int x2 = Integer.parseInt(data[4]);
		int y2 = Integer.parseInt(data[5]);
		Color edge  = LogoLine.convertColorNotation(data[6]);	
		
		return new Line(new Position(x1,y1), new Position(x2,y2), edge);
		
		
	}



	
	
	
   
}
	
	
			
	
